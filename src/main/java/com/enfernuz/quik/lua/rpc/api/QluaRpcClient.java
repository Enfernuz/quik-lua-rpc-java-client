package com.enfernuz.quik.lua.rpc.api;

import com.enfernuz.quik.lua.rpc.api.messages.*;
import com.enfernuz.quik.lua.rpc.api.messages.bit.*;
import com.enfernuz.quik.lua.rpc.api.messages.datasource.*;
import com.enfernuz.quik.lua.rpc.api.security.Securable;
import com.enfernuz.quik.lua.rpc.api.messages.GetCandlesByIndex;
import com.enfernuz.quik.lua.rpc.io.Gateway;

/**
 * Компонент, представляющий собой Java-обёртку над API QLua терминала QUIK.
 *
 * @throws ClientRpcException в случае возникновения ошибки при удалённом вызове процедуры на стороне клиента
 * @throws ServiceRpcException в случае возникновения ошибки при удалённом вызове процедуры на стороне RPC-сервиса
 * @throws NullPointerException если аргумент {@code request} является null
 */
public interface QluaRpcClient extends Gateway, Securable {

    /**
     *
     * @param request
     * @return
     */
    int qlua_AddColumn(AddColumn.Request request);

    /**
     *
     * @param request
     * @return
     */
    int qlua_AddLabel(AddLabel.Request request);

    /**
     *
     * @return
     */
    int qlua_AllocTable();

    /**
     *
     * @param request
     * @return
     */
    CalcBuySell.Result qlua_CalcBuySell(CalcBuySell.Request request);

    /**
     *
     * @param request
     * @return
     */
    boolean qlua_CancelParamRequest(CancelParamRequest.Request request);

    /**
     *
     * @param request
     * @return
     */
    boolean qlua_Clear(Clear.Request request);

    /**
     *
     * @param request
     * @return
     */
    int qlua_CreateWindow(CreateWindow.Request request);

    /**
     *
     * @param request
     * @return
     */
    boolean qlua_DelAllLabels(DelAllLabels.Request request);

    /**
     *
     * @param request
     * @return
     */
    boolean qlua_DeleteRow(DeleteRow.Request request);

    /**
     *
     * @param request
     * @return
     */
    boolean qlua_DelLabel(DelLabel.Request request);

    /**
     *
     * @param request
     * @return
     */
    boolean qlua_DestroyTable(DestroyTable.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetBuySellInfo.Result qlua_getBuySellInfo(GetBuySellInfo.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetBuySellInfoEx.Result qlua_getBuySellInfoEx(GetBuySellInfoEx.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetCandlesByIndex.Result qlua_getCandlesByIndex(GetCandlesByIndex.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetCell.Result qlua_GetCell(GetCell.Result request);

    /**
     *
     * @return
     */
    GetClassesList.Result qlua_getClassesList();

    /**
     *
     * @param request
     * @return
     */
    GetClassInfo.Result qlua_getClassInfo(GetClassInfo.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetClassSecurities.Result qlua_getClassSecurities(GetClassSecurities.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetDepo.Result qlua_getDepo(GetDepo.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetDepoEx.Result qlua_getDepoEx(GetDepoEx.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetFuturesHolding.Result qlua_getFuturesHolding(GetFuturesHolding.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetFuturesLimit.Result qlua_getFuturesLimit(GetFuturesLimit.Request request);

    /**
     *
     * @param request
     * @return

     */
    GetInfoParam.Result qlua_getInfoParam(GetInfoParam.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetItem.Result qlua_getItem(GetItem.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetLabelParams.Result qlua_GetLabelParams(GetLabelParams.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetLinesCount.Result qlua_getLinesCount(GetLinesCount.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetMoney.Result qlua_getMoney(GetMoney.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetMoneyEx.Result qlua_getMoneyEx(GetMoneyEx.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetNumberOf.Result qlua_getNumberOf(GetNumberOf.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetNumCandles.Result qlua_getNumCandles(GetNumCandles.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetOrderByNumber.Result qlua_getOrderByNumber(GetOrderByNumber.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetParamEx.Result qlua_getParamEx(GetParamEx.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetParamEx2.Result qlua_getParamEx2(GetParamEx2.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetPortfolioInfo.Result qlua_getPortfolioInfo(GetPortfolioInfo.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetPortfolioInfoEx.Result qlua_getPortfolioInfoEx(GetPortfolioInfoEx.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetQuoteLevel2.Result qlua_getQuoteLevel2(GetQuoteLevel2.Request request);

    /**
     *
     * @return
     */
    GetScriptPath.Result qlua_getScriptPath();

    /**
     *
     * @param request
     * @return
     */
    GetSecurityInfo.Result qlua_getSecurityInfo(GetSecurityInfo.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetTableSize.Result qlua_GetTableSize(GetTableSize.Request request);

    /**
     *
     * @return
     */
    GetTradeDate.Result qlua_getTradeDate();

    /**
     *
     * @param request
     * @return
     */
    GetWindowCaption.Result qlua_GetWindowCaption(GetWindowCaption.Request request);

    /**
     *
     * @param request
     * @return
     */
    GetWindowRect.Result qlua_GetWindowRect(GetWindowRect.Request request);

    /**
     *
     * @return
     */
    GetWorkingFolder.Result qlua_getWorkingFolder();

    /**
     *
     * @param request
     * @return
     */
    Highlight.Result qlua_Highlight(Highlight.Request request);

    /**
     *
     * @param request
     * @return
     */
    InsertRow.Result qlua_InsertRow(InsertRow.Request request);

    /**
     *
     * @return
     */
    IsConnected.Result qlua_isConnected();

    /**
     *
     * @param request
     * @return
     */
    IsSubscribedLevel2Quotes.Result qlua_IsSubscribedLevelIIQuotes(IsSubscribedLevel2Quotes.Request request);

    /**
     *
     * @param request
     * @return
     */
    IsWindowClosed.Result qlua_IsWindowClosed(IsWindowClosed.Request request);

    /**
     *
     * @param request
     * @return
     */
    Message.Result qlua_message(Message.Request request);

    /**
     *
     * @param request
     * @return
     */
    ParamRequest.Result qlua_ParamRequest(ParamRequest.Request request);

    /**
     *
     * @param request
     * @return
     */
    PrintDbgStr.Result qlua_PrintDbgStr(PrintDbgStr.Request request);

    /**
     *
     * @param request
     * @return
     */
    RGB.Result qlua_RGB(RGB.Request request);

    /**
     *
     * @param request
     * @return
     */
    SearchItems.Result qlua_SearchItems(SearchItems.Request request);

    /**
     *
     * @param request
     * @return
     */
    SendTransaction.Result qlua_sendTransaction(SendTransaction.Request request);

    /**
     *
     * @param request
     * @return
     */
    SetCell.Result qlua_SetCell(SetCell.Request request);

    /**
     *
     * @param request
     * @return
     */
    SetColor.Result qlua_SetColor(SetColor.Request request);

    /**
     *
     * @param request
     * @return
     */
    SetLabelParams.Result qlua_SetLabelParams(SetLabelParams.Request request);

    /**
     *
     * @param request
     * @return
     */
    SetSelectedRow.Result qlua_SetSelectedRow(SetSelectedRow.Request request);

    /**
     *
     * @param request
     * @return
     */
    SetTableNotificationCallback.Result qlua_SetTableNotificationCallback(SetTableNotificationCallback.Request request);

    /**
     *
     * @param request
     * @return
     */
    SetWindowCaption.Result qlua_SetWindowCaption(SetWindowCaption.Request request);

    /**
     *
     * @param request
     * @return
     */
    SetWindowPos.Result qlua_SetWindowPos(SetWindowPos.Request request);

    /**
     *
     * @param request
     * @return
     */
    Sleep.Result qlua_sleep(Sleep.Request request);

    /**
     *
     * @param request
     * @return
     */
    SubscribeLevel2Quotes.Result qlua_SubscribeLevelIIQuotes(SubscribeLevel2Quotes.Request request);

    /**
     *
     * @param request
     * @return
     */
    UnsubscribeLevel2Quotes.Result qlua_UnsubscribeLevelIIQuotes(UnsubscribeLevel2Quotes.Request request);

    /**
     *
     * @param request
     * @return
     */
    BAnd.Result bit_band(BAnd.Request request);

    /**
     *
     * @param request
     * @return
     */
    BNot.Result bit_bnot(BNot.Request request);

    /**
     *
     * @param request
     * @return
     */
    BOr.Result bit_bor(BOr.Request request);

    /**
     *
     * @param request
     * @return
     */
    BXor.Result bit_bxor(BXor.Request request);

    /**
     *
     * @param request
     * @return
     */
    ToHex.Result bit_tohex(ToHex.Request request);

    /**
     *
     * @param request
     * @return
     */
    C.Result datasource_C(C.Request request);

    /**
     *
     * @param request
     * @return
     */
    Close.Result datasource_Close(Close.Request request);

    /**
     *
     * @param request
     * @return
     */
    CreateDataSource.Result datasource_CreateDataSource(CreateDataSource.Request request);

    /**
     *
     * @param request
     * @return
     */
    H.Result datasource_H(H.Request request);

    /**
     *
     * @param request
     * @return
     */
    L.Result datasource_L(L.Request request);

    /**
     *
     * @param request
     * @return
     */
    O.Result datasource_O(O.Request request);

    /**
     *
     * @param request
     * @return
     */
    SetEmptyCallback.Result datasource_SetEmptyCallback(SetEmptyCallback.Request request);

    /**
     *
     * @param request
     * @return
     */
    SetUpdateCallback.Result datasource_SetUpdateCallback(SetUpdateCallback.Request request);

    /**
     *
     * @param request
     * @return
     */
    Size.Result datasource_Size(Size.Request request);

    /**
     *
     * @param request
     * @return
     */
    T.Result datasource_T(T.Request request);

    /**
     *
     * @param request
     * @return
     */
    V.Result datasource_V(V.Request request);
}
