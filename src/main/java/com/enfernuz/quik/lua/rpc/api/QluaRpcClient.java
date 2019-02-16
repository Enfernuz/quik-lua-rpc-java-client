package com.enfernuz.quik.lua.rpc.api;

import com.enfernuz.quik.lua.rpc.api.messages.*;
import com.enfernuz.quik.lua.rpc.api.messages.bit.*;
import com.enfernuz.quik.lua.rpc.api.messages.datasource.*;
import com.enfernuz.quik.lua.rpc.api.security.Securable;
import com.enfernuz.quik.lua.rpc.api.messages.GetCandlesByIndex;
import com.enfernuz.quik.lua.rpc.api.structures.*;
import com.enfernuz.quik.lua.rpc.io.Gateway;

import java.util.Map;

/**
 * Компонент, представляющий собой Java-обёртку над API QLua терминала QUIK.
 *
 * @throws ClientRpcException в случае возникновения ошибки при удалённом вызове процедуры на стороне клиента
 * @throws ServiceRpcException в случае возникновения ошибки при удалённом вызове процедуры на стороне RPC-сервиса
 * @throws NullPointerException если аргумент {@code request} является null
 */
public interface QluaRpcClient extends Gateway, Securable {

    int qlua_AddColumn(AddColumn.Args args);

    Integer qlua_AddLabel(String chartTag, Map<String, String> labelParams);

    int qlua_AllocTable();

    CalcBuySell.Result qlua_CalcBuySell(CalcBuySell.Args args);

    boolean qlua_CancelParamRequest(CancelParamRequest.Args args);

    boolean qlua_Clear(int tId);

    int qlua_CreateWindow(int tId);

    boolean qlua_DelAllLabels(String chartTag);

    boolean qlua_DeleteRow(DeleteRow.Args args);

    boolean qlua_DelLabel(String chartTag, int labelId);

    boolean qlua_DestroyTable(int tId);

    GetBuySellInfo.BuySellInfo qlua_getBuySellInfo(GetBuySellInfo.Args args);

    GetBuySellInfoEx.BuySellInfoEx qlua_getBuySellInfoEx(GetBuySellInfoEx.Args args);

    GetCandlesByIndex.Result qlua_getCandlesByIndex(GetCandlesByIndex.Args args);

    GetCell.Result qlua_GetCell(GetCell.Args args);

    String qlua_getClassesList();

    ClassInfo qlua_getClassInfo(String classCode);

    String qlua_getClassSecurities(String classCode);

    Depo qlua_getDepo(GetDepo.Args args);

    DepoLimit qlua_getDepoEx(GetDepoEx.Args args);

    FuturesClientHolding qlua_getFuturesHolding(GetFuturesHolding.Args args);

    FuturesLimit qlua_getFuturesLimit(GetFuturesLimit.Args args);

    String qlua_getInfoParam(String paramName);

    Map<String, String> qlua_getItem(String tableName, int index);

    Map<String, String> qlua_GetLabelParams(String chartTag, int labelId);

    int qlua_getLinesCount(String tag);

    Money qlua_getMoney(GetMoney.Args args);

    MoneyLimit qlua_getMoneyEx(GetMoneyEx.Args args);

    int qlua_getNumberOf(String tableName);

    int qlua_getNumCandles(String tag);

    GetOrderByNumber.Result qlua_getOrderByNumber(String classCode, long orderId);

    GetParamEx.ParamEx qlua_getParamEx(GetParamEx.Args args);

    GetParamEx2.ParamEx2 qlua_getParamEx2(GetParamEx2.Args args);

    PortfolioInfo qlua_getPortfolioInfo(GetPortfolioInfo.Args args);

    GetPortfolioInfoEx.Result qlua_getPortfolioInfoEx(GetPortfolioInfoEx.Args args);

    GetQuoteLevel2.Result qlua_getQuoteLevel2(GetQuoteLevel2.Args args);

    String qlua_getScriptPath();

    Security qlua_getSecurityInfo(GetSecurityInfo.Args args);

    GetTableSize.TableSize qlua_GetTableSize(int tId);

    GetTradeDate.TradeDate qlua_getTradeDate();

    String qlua_GetWindowCaption(int tId);

    GetWindowRect.WindowRect qlua_GetWindowRect(int tId);

    String qlua_getWorkingFolder();

    boolean qlua_Highlight(Highlight.Args args);

    int qlua_InsertRow(InsertRow.Args args);

    int qlua_isConnected();

    boolean qlua_IsSubscribedLevelIIQuotes(IsSubscribedLevel2Quotes.Args args);

    Boolean qlua_IsWindowClosed(int tId);

    Integer qlua_message(String message, Message.IconType iconType);

    Integer qlua_message(final String message);

    boolean qlua_ParamRequest(ParamRequest.Args args);

    void qlua_PrintDbgStr(String s);

    int qlua_RGB(RGB.Args args);

    SearchItems.Result qlua_SearchItems(SearchItems.Args args);

    String qlua_sendTransaction(SendTransaction.Args args);

    boolean qlua_SetCell(SetCell.Args args);

    boolean qlua_SetColor(SetColor.Args args);

    boolean qlua_SetLabelParams(String chartTag, int labelId, Map<String, String> labelParams);

    SetSelectedRow.Result qlua_SetSelectedRow(SetSelectedRow.Args args);

    SetTableNotificationCallback.Result qlua_SetTableNotificationCallback(int tId, String fCbDef);

    boolean qlua_SetWindowCaption(int tId, String str);

    boolean qlua_SetWindowPos(SetWindowPos.Args args);

    Long qlua_sleep(long time);

    boolean qlua_SubscribeLevelIIQuotes(SubscribeLevel2Quotes.Args args);

    boolean qlua_UnsubscribeLevelIIQuotes(UnsubscribeLevel2Quotes.Args args);

    /**
     * Вызывает QLua-функцию <em>bit.band</em> с указанными аргументами.
     * <p>Числа с плавающей точкой нужно преобразовать с помощью {@link Double#doubleToRawLongBits(double)} или
     * {@link Float#floatToRawIntBits(float)}. В этом случае, результат вызова <em>bit.band</em> нужно преобразовать обратно в
     * число с плавающей точкой с помощью {@link Double#longBitsToDouble(long)} или {@link Float#intBitsToFloat(int)}.</p>
     * <br/>
     * <b>Внимание!</b> В Java эквивалентом вызова функции <em>bit.band</em> будет использование оператора <b>&</b>:
     * <br/>
     * <code>result = x1 & x2 & ...</code>
     * @param x1 число x1
     * @param x2 число x2
     * @param xi остальные числа, опционально
     * @return результат вызова QLua-функции <em>bit.band</em> с указанными аргументами
     */
    long bit_band(long x1, long x2, long... xi);

    /**
     * Вызывает QLua-функцию <em>bit.bnot</em> с указанным аргументом.
     * <p>Числа с плавающей точкой нужно преобразовать с помощью {@link Double#doubleToRawLongBits(double)} или
     * {@link Float#floatToRawIntBits(float)}. В этом случае, результат вызова <em>bit.bnot</em> нужно преобразовать обратно в
     * число с плавающей точкой с помощью {@link Long# Double#longBitsToDouble(long)} или {@link Float#intBitsToFloat(int)}.</p>
     * <br/>
     * <b>Внимание!</b> В Java эквивалентом вызова функции <em>bit.bnot</em> будет использование оператора <b>~</b>:
     * <br/>
     * <code>result = ~x;</code>
     * @param x число x
     * @return результат вызова QLua-функции <em>bit.bnot</em> с указанным аргументом
     */
    long bit_bnot(long x);

    /**
     * Вызывает QLua-функцию <em>bit.bor</em> с указанными аргументами.
     * <p>Числа с плавающей точкой нужно преобразовать с помощью {@link Double#doubleToRawLongBits(double)} или
     * {@link Float#floatToRawIntBits(float)}. В этом случае, результат вызова <em>bit.bor</em> нужно преобразовать обратно в
     * число с плавающей точкой с помощью {@link Double#longBitsToDouble(long)} или {@link Float#intBitsToFloat(int)}.</p>
     * <br/>
     * <b>Внимание!</b> В Java эквивалентом вызова функции <em>bit.bor</em> будет использование оператора <b>|</b>:
     * <br/>
     * <code>result = x1 | x2 | ...</code>
     * @param x1 число x1
     * @param x2 число x2
     * @param xi остальные числа, опционально
     * @return результат вызова QLua-функции <em>bit.bor</em> с указанными аргументами
     */
    long bit_bor(long x1, long x2, long... xi);

    /**
     * Вызывает QLua-функцию <em>bit.bxor</em> с указанными аргументами.
     * <p>Числа с плавающей точкой нужно преобразовать с помощью {@link Double#doubleToRawLongBits(double)} или
     * {@link Float#floatToRawIntBits(float)}. В этом случае, результат вызова <em>bit.bxor</em> нужно преобразовать обратно в
     * число с плавающей точкой с помощью {@link Double#longBitsToDouble(long)} или {@link Float#intBitsToFloat(int)}.</p>
     * <br/>
     * <b>Внимание!</b> В Java эквивалентом вызова функции <em>bit.bxor</em> будет использование оператора <b>^</b>:
     * <br/>
     * <code>result = x1 ^ x2 ^ ...</code>
     * @param x1 число x1
     * @param x2 число x2
     * @param xi остальные числа, опционально
     * @return результат вызова QLua-функции <em>bit.bxor</em> с указанными аргументами
     */
    long bit_bxor(long x1, long x2, long... xi);

    String bit_tohex(ToHex.Args args);

    /**
     * Вызывает QLua-функцию <em>bit.test</em> с указанными аргументами.
     * <p>Числа с плавающей точкой нужно преобразовать с помощью {@link Double#doubleToRawLongBits(double)} или
     * {@link Float#floatToRawIntBits(float)}.</p>
     * <br/>
     * <b>Внимание!</b> В Java эквивалентом вызова функции <em>bit.test</em> будет использование следующей конструкции:
     * <br/>
     * <code>
     *     boolean result = ((x & (1L << n)) != 0L);
     * </code>
     * @param x число x
     * @param n индекс тестируемого бита в битовом представлении числа x
     * @return результат вызова QLua-функции <em>bit.test</em> с указанными аргументами
     */
    boolean bit_test(long x, int n);

    String datasource_C(C.Args args);

    boolean datasource_Close(String datasourceUUID);

    CreateDataSource.Result datasource_CreateDataSource(CreateDataSource.Args args);

    String datasource_H(H.Args args);

    String datasource_L(L.Args args);

    String datasource_O(O.Args args);

    boolean datasource_SetEmptyCallback(String datasourceUUID);

    boolean datasource_SetUpdateCallback(SetUpdateCallback.Args args);

    int datasource_Size(Size.Args args);

    DataSourceTime datasource_T(T.Args args);

    String datasource_V(V.Args args);
}
