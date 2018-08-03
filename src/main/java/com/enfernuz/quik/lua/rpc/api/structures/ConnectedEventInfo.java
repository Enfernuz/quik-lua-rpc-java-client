package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.Value;

@Value
public class ConnectedEventInfo {

    int flag;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("flag", flag)
                .toString();
    }
}
