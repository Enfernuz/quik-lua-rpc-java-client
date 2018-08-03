package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.Value;

@Value
public class StopEventInfo {

    int signal;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("signal", signal)
                .toString();
    }
}
