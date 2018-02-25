package com.enfernuz.quik.lua.rpc.events.api;

import com.google.common.base.MoreObjects;
import com.google.protobuf.ByteString;
import qlua.events.QluaEvents;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public final class QluaEvent {

    private final QluaEvents.EventType type;
    private final ByteString data;

    public static QluaEvent create(final QluaEvents.EventType type, final ByteString data) {

        requireNonNull(type, "The argument 'type' must not be null.");
        return new QluaEvent(type, data);
    }

    public static QluaEvent create(final QluaEvents.EventType type) {
        return create(type, null);
    }

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
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof QluaEvent) ) {
            return false;
        } else {
            final QluaEvent other = (QluaEvent) o;
            return Objects.equals(type, other.type) && Objects.equals(data, other.data);
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
