package com.enfernuz.quik.lua.rpc.api.structures;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.RemoteProcedureClassJsonSerde;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@Value
public class RequestEnvelope<T extends RemoteProcedure> {

    @JsonProperty("method")
    @JsonSerialize(using = RemoteProcedureClassJsonSerde.Serializer.class)
    Class<T> remoteProcedureClass;

    @JsonProperty("args")
    @JsonInclude(Include.NON_NULL)
    RpcArgs<T> args;

    public RequestEnvelope(@NonNull @NotNull final Class<T> remoteProcedureClass, final RpcArgs<T> args) {

        this.remoteProcedureClass = remoteProcedureClass;
        this.args = args;
    }

    @NotNull
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("remoteProcedureClass", remoteProcedureClass)
                .add("args", args)
                .toString();
    }
}
