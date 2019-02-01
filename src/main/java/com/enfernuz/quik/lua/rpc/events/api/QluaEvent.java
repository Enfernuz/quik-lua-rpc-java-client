package com.enfernuz.quik.lua.rpc.events.api;

import com.google.common.base.MoreObjects;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

public final class QluaEvent {

    private final EventType type;
    private final byte[] data;

    /**
     * Создаёт экземпляр события API QLua терминала QUIK с заданным типом и данными.
     *
     * @param type  тип события
     * @param data  данные события
     * @return экземпляр события API QLua терминала QUIK с заданным типом и данными
     * @throws NullPointerException если заданный тип события является null
     */
    public static QluaEvent create(@NonNull final EventType type, final byte[] data) {
        return new QluaEvent(type, data == null ? null : data.clone());
    }

    /**
     * Создаёт экземпляр события API QLua терминала QUIK с заданным типом.
     *
     * @param type  тип события
     * @return экземпляр события API QLua терминала QUIK
     */
    public static QluaEvent create(final EventType type) {
        return create(type, null);
    }

    private QluaEvent(final EventType type, final byte[] data) {

        this.type = type;
        this.data = data;
    }

    /**
     * Получает тип события.
     *
     * @return тип события
     */
    public EventType getType() {
        return type;
    }

    /**
     * Получает данные события.
     *
     * @return данные события
     */
    public byte[] getData() {
        return data == null ? null : data.clone();
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof QluaEvent) ) {
            return false;
        } else {
            final QluaEvent other = (QluaEvent) o;
            return Objects.equals(type, other.type) && Arrays.equals(data, other.data);
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

    public enum EventType {

        ON_CLOSE,
        ON_STOP,
        ON_FIRM,
        ON_ALL_TRADE,
        ON_TRADE,
        ON_ORDER,
        ON_ACCOUNT_BALANCE,
        ON_FUTURES_LIMIT_CHANGE,
        ON_FUTURES_LIMIT_DELETE,
        ON_FUTURES_CLIENT_HOLDING,
        ON_MONEY_LIMIT,
        ON_MONEY_LIMIT_DELETE,
        ON_DEPO_LIMIT,
        ON_DEPO_LIMIT_DELETE,
        ON_ACCOUNT_POSITION,
        ON_NEG_DEAL,
        ON_NEG_TRADE,
        ON_STOP_ORDER,
        ON_TRANS_REPLY,
        ON_PARAM,
        ON_QUOTE,
        ON_DISCONNECTED,
        ON_CONNECTED,
        ON_CLEAN_UP,
        ON_DATA_SOURCE_UPDATE;
    }
}
