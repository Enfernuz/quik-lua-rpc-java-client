package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import qlua.structs.QluaStructures;

@RunWith(Enclosed.class)
public class FirmPbSerdeTest {

    private static final String FIRM_ID = "1";
    private static final String FIRM_NAME = "2";
    private static final Integer STATUS = 3;
    private static final String EXCHANGE = "4";

    public static class FullArgsFirmPbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.Firm, Firm> {

        @Override
        public @NotNull Deserializer<Firm> getDeserializerUnderTest() {
            return FirmPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public Firm getTargetObject() {

            return Firm.builder()
                    .firmId(FIRM_ID)
                    .firmName(FIRM_NAME)
                    .status(STATUS)
                    .exchange(EXCHANGE)
                    .build();
        }

        @NotNull
        @Override
        public QluaStructures.Firm getTargetObjectAsPbMessage() {

            return QluaStructures.Firm.newBuilder()
                    .setFirmid(FIRM_ID)
                    .setFirmName(FIRM_NAME)
                    .setValueStatus(STATUS)
                    .setExchange(EXCHANGE)
                    .build();
        }
    }

    public static class OnlyRequiredArgsFirmPbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.Firm, Firm> {

        @Override
        public @NotNull Deserializer<Firm> getDeserializerUnderTest() {
            return FirmPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public Firm getTargetObject() {

            return Firm.builder()
                    .firmId(FIRM_ID)
                    .build();
        }

        @NotNull
        @Override
        public QluaStructures.Firm getTargetObjectAsPbMessage() {

            return QluaStructures.Firm.newBuilder()
                    .setFirmid(FIRM_ID)
                    .setNullStatus(true)
                    .build();
        }
    }
}
