package com.enfernuz.quik.lua.rpc.serde;

import com.enfernuz.quik.lua.rpc.config.ClientConfiguration;
import com.enfernuz.quik.lua.rpc.serde.json.JsonSerdeModule;
import com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeModule;
import org.jetbrains.annotations.NotNull;

import static java.util.Objects.requireNonNull;

public class SerdeUtils {

    private SerdeUtils() {}

    @NotNull
    public static SerdeModule getSerdeModule(@NotNull final ClientConfiguration.SerdeProtocol serdeProtocol) {

        requireNonNull(serdeProtocol, "Аргумент 'serdeProtocol' не может быть null.");

        final SerdeModule serdeModule;
        switch (serdeProtocol) {
            case JSON:
                serdeModule = JsonSerdeModule.INSTANCE;
                break;
            case PROTOBUF:
                serdeModule = ProtobufSerdeModule.INSTANCE;
                break;
            default:
                throw new IllegalArgumentException(
                        String.format(
                                "Неподдерживаемый протокол сериализации/десериализации сообщений: %s.",
                                serdeProtocol
                        )
                );
        }
        return serdeModule;
    }
}
