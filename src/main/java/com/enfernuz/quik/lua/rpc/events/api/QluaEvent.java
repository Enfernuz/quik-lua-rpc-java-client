package com.enfernuz.quik.lua.rpc.events.api;

import com.google.common.base.MoreObjects;
import com.google.protobuf.ByteString;
import qlua.events.QluaEvents;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Событие терминала QUIK в рамках API QLua.
 * <p/>
 * В QLua оповещения о событиях терминала QUIK приходят посредством функций обратного вызова (callbacks). Тип события и
 * его данные сериализуются RPC-сервисом на стороне терминала QUIK с помощью Google Protocol Buffers и передаются
 * клиентам.
 */
public class QluaEvent {

    private final QluaEvents.EventType type;
    private final ByteString data;

    /**
     * Создаёт экземпляр события API QLua терминала QUIK с заданным типом и данными,
     * сериализованными в байтовую строку с помощью Google Protocol Buffers.
     *
     * @param type  тип события
     * @param data  данные события, сериализованные в байтовую строку с помощью Google Protocol Buffers
     * @return экземпляр события API QLua терминала QUIK с заданным типом и данными, сериализованными в байтовую строку
     * с помощью Google Protocol Buffers
     * @throws NullPointerException если заданный тип события является null
     */
    public static QluaEvent create(final QluaEvents.EventType type, final ByteString data) {

        requireNonNull(type, "The argument 'type' must not be null.");
        return new QluaEvent(type, data);
    }

    /**
     * Создаёт экземпляр события API QLua терминала QUIK с заданным типом.
     *
     * @param type  тип события
     * @return экземпляр события API QLua терминала QUIK
     */
    public static QluaEvent create(final QluaEvents.EventType type) {
        return create(type, null);
    }

    private QluaEvent(final QluaEvents.EventType type, final ByteString data) {

        this.type = type;
        this.data = data;
    }

    /**
     * Получает тип события.
     *
     * @return тип события
     */
    public QluaEvents.EventType getType() {
        return type;
    }

    /**
     * Получает данные события, сериализованные в байтовую строку с помощью Google Protocol Buffers.
     *
     * @return данные события, сериализованные в байтовую строку с помощью Google Protocol Buffers
     */
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
