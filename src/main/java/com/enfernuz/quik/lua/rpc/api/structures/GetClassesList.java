package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.Value;

public final class GetClassesList {

    public static enum Request { INSTANCE; }

    @Value
    public static class Result {

        String classesList;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("classes_list", classesList)
                    .toString();
        }
    }
}
