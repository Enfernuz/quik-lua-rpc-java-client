package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Message;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum MessageRequestPbSerde implements Serde<Message.Request>, PbConverter<qlua.rpc.Message.Request, Message.Request> {

    INSTANCE;

    @Override
    public byte[] serialize(final Message.Request request) {

        return qlua.rpc.RPC.Request.newBuilder()
                .setTypeValue( RPC.ProcedureType.MESSAGE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Message.Request deserialize(final byte[] data) {

        final qlua.rpc.RPC.Request request = qlua.rpc.RPC.Request.parseFrom(data);
        assertEquals(request.getType(), RPC.ProcedureType.MESSAGE);

        return convertFromPb(
                qlua.rpc.Message.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public Message.Request convertFromPb(@NotNull final qlua.rpc.Message.Request request) {

        final qlua.rpc.Message.IconType pbIconType = request.getIconType();
        final Message.IconType iconType;
        switch (pbIconType) {
            case UNDEFINED:
                iconType = null;
                break;
            case INFO:
                iconType = Message.IconType.INFO;
                break;
            case WARNING:
                iconType = Message.IconType.WARNING;
                break;
            case ERROR:
                iconType = Message.IconType.ERROR;
                break;
            default:
                throw new IllegalArgumentException(String.format("Неизвестный IconType (тип иконки сообщения) для формата protobuf: '%s'.", pbIconType));
        }

        return new Message.Request(request.getMessage(), iconType);
    }

    @Override
    public qlua.rpc.Message.Request convertToPb(@NotNull final Message.Request request) {

        final Message.IconType iconType = request.getIconType();
        final qlua.rpc.Message.IconType pbIconType;
        switch (iconType) {
            case INFO:
                pbIconType = qlua.rpc.Message.IconType.INFO;
                break;
            case WARNING:
                pbIconType = qlua.rpc.Message.IconType.WARNING;
                break;
            case ERROR:
                pbIconType = qlua.rpc.Message.IconType.ERROR;
                break;
            default:
                throw new IllegalArgumentException(String.format("Неизвестный IconType (тип иконки сообщения): '%s'.", iconType));
        }

        return qlua.rpc.Message.Request.newBuilder()
                .setMessage( request.getMessage() )
                .setIconType(pbIconType)
                .build();
    }
}
