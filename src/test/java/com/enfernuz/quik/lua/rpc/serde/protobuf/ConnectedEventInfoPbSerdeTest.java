package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.ConnectedEventInfo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import qlua.structs.QluaStructures;

@RunWith(Enclosed.class)
public class ConnectedEventInfoPbSerdeTest {

    public static class TrueResultConnectedEventInfoPbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.ConnectedEventInfo, ConnectedEventInfo> {

        @Override
        public @NotNull Deserializer<ConnectedEventInfo> getDeserializerUnderTest() {
            return ConnectedEventInfoPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public ConnectedEventInfo getTargetObject() {
            return ConnectedEventInfo.getInstance(true);
        }

        @NotNull
        @Override
        public QluaStructures.ConnectedEventInfo getTargetObjectAsPbMessage() {

            return QluaStructures.ConnectedEventInfo.newBuilder()
                    .setFlag(true)
                    .build();
        }
    }

    public static class FalseResultConnectedEventInfoPbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.ConnectedEventInfo, ConnectedEventInfo> {

        @Override
        public @NotNull Deserializer<ConnectedEventInfo> getDeserializerUnderTest() {
            return ConnectedEventInfoPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public ConnectedEventInfo getTargetObject() {
            return ConnectedEventInfo.getInstance(false);
        }

        @NotNull
        @Override
        public QluaStructures.ConnectedEventInfo getTargetObjectAsPbMessage() {

            return QluaStructures.ConnectedEventInfo.newBuilder()
                    .setFlag(false)
                    .build();
        }
    }
}
