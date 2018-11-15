package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetTradeDate;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetTradeDateResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetTradeDate.Result, GetTradeDate.Result> {

    private static final String DATE = "1";
    private static final int YEAR = 2;
    private static final int MONTH = 3;
    private static final int DAY = 4;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Override
    public @NotNull Deserializer<GetTradeDate.Result> getDeserializerUnderTest() {
        return GetTradeDateResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetTradeDate.Result getTargetObject() {

        final GetTradeDate.TradeDate tradeDate = GetTradeDate.TradeDate.builder()
                .date(DATE)
                .year(YEAR)
                .month(MONTH)
                .day(DAY)
                .build();

        return new GetTradeDate.Result(tradeDate);
    }

    @NotNull
    @Override
    public qlua.rpc.GetTradeDate.Result getTargetObjectAsPbMessage() {

        final qlua.rpc.GetTradeDate.TradeDate tradeDate = qlua.rpc.GetTradeDate.TradeDate.newBuilder()
                .setDate(DATE)
                .setYear(YEAR)
                .setMonth(MONTH)
                .setDay(DAY)
                .build();

        return qlua.rpc.GetTradeDate.Result.newBuilder()
                .setTradeDate(tradeDate)
                .build();
    }

    // TODO: really shouldn't be a responsibility of the deserializer
    @Test
    public void shouldFailOnUninitializedPbTradeDate() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(
                equalTo("Поле 'trade_date' экземпляра protobuf-представления qlua.rpc.GetTradeDate.Result не инициализировано.")
        );

        getDeserializerUnderTest().deserialize( qlua.rpc.GetTradeDate.Result.newBuilder().build().toByteArray() );
    }
}
