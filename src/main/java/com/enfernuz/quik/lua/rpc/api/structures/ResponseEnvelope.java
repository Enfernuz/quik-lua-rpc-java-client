package com.enfernuz.quik.lua.rpc.api.structures;

import com.enfernuz.quik.lua.rpc.api.ServiceError;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.ResponseEnvelopeJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@JsonDeserialize(using = ResponseEnvelopeJsonDeserializer.class)
@Value
public class ResponseEnvelope {

    ServiceError error;
    byte[] result;

    public static ResponseEnvelope withError(@NonNull final ServiceError error) {
        return new ResponseEnvelope(error, null);
    }

    public static ResponseEnvelope withResult(@NonNull final byte[] result) {
        return new ResponseEnvelope(null, result);
    }

    private ResponseEnvelope(final ServiceError error, final byte[] result) {
        this.error = error;
        this.result = result;
    }

    @Contract(pure = true)
    public ServiceError getError() {
        return error;
    }

    // not making a defensive copy for the sake of performance
    @Contract(pure = true)
    public byte[] getResult() {
        return result;
    }

    @NotNull
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("error", error)
                .add("result", result)
                .toString();
    }
}
