package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@Value
public class ConnectedEventInfo {

    private static final String FLAG = "flag";

    @JsonProperty(FLAG)
    @Getter(AccessLevel.NONE)
    boolean flag;

    @JsonCreator
    public static ConnectedEventInfo getInstance(@JsonProperty(value = FLAG, required = true) final boolean result) {
        return result ? InstanceHolder.TRUE : InstanceHolder.FALSE;
    }

    private ConnectedEventInfo(final boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag() {
        return flag;
    }

    @NotNull
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(FLAG, flag)
                .toString();
    }

    private static final class InstanceHolder {

        private static final ConnectedEventInfo TRUE = new ConnectedEventInfo(true);
        private static final ConnectedEventInfo FALSE = new ConnectedEventInfo(false);

        // sanity check
        static {
            assert TRUE.flag;
            assert !FALSE.flag;
        }
    }
}
