package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CalcBuySell;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class CalcBuySellResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.CalcBuySell.Result, CalcBuySell.Result> {

    private static final int QTY = 1;
    private static final String COMISSION = "2";

    @Override
    public @NotNull Deserializer<CalcBuySell.Result> getDeserializerUnderTest() {
        return CalcBuySellResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public CalcBuySell.Result getTargetObject() {
        return new CalcBuySell.Result(QTY, COMISSION);
    }

    @NotNull
    @Override
    public qlua.rpc.CalcBuySell.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.CalcBuySell.Result.newBuilder()
                .setQty(QTY)
                .setComission(COMISSION)
                .build();
    }
}
