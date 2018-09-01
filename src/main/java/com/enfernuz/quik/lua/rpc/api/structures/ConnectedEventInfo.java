package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Value
public class ConnectedEventInfo {

    @JsonProperty("flag")
    @Getter(AccessLevel.NONE)
    boolean flag;

    @JsonCreator
    public ConnectedEventInfo(@JsonProperty(value = "flag", required = true) final boolean flag) {
        this.flag = flag;
    }

    @Contract(pure = true)
    public boolean getFlag() {
        return flag;
    }

    @NotNull
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("flag", flag)
                .toString();
    }
}
