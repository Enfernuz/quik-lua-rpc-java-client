package com.enfernuz.quik.lua.rpc.api.events;

import com.google.common.base.MoreObjects;
import com.google.protobuf.ByteString;
import qlua.events.QluaEvents;

import java.util.Objects;

public final class QluaEvent {

    private final QluaEvents.EventType type;
    private final ByteString data;

    private QluaEvent(final QluaEvents.EventType type, final ByteString data) {

        this.type = type;
        this.data = data;
    }

    public QluaEvents.EventType getType() {
        return type;
    }

    public ByteString getData() {
        return data;
    }

    @Override
    public boolean equals(final Object obj) {

        if (obj == this) {
            return true;
        } else if (obj == null) {
            return true;
        } else if (obj instanceof QluaEvent) {
            final QluaEvent other = (QluaEvent) obj;
            return Objects.equals(type, other.type) && Objects.equals(data, other.data);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, data);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("type", type)
                .add("data", data)
                .toString();
    }
}
