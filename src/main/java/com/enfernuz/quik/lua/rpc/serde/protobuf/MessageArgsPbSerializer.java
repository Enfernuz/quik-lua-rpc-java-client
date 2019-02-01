package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Message;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum MessageArgsPbSerializer implements Serializer<Message.Args>, ToPbConverter<Message.Args, qlua.rpc.Message.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final Message.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.Message.Args convert(@NotNull final Message.Args args) {

        final Message.IconType iconType = args.getIconType();
        final qlua.rpc.Message.IconType pbIconType;
        if (iconType == null) {
            pbIconType = qlua.rpc.Message.IconType.UNDEFINED;
        } else {
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
        }

        return qlua.rpc.Message.Args.newBuilder()
                .setMessage( args.getMessage() )
                .setIconType(pbIconType)
                .build();
    }
}
