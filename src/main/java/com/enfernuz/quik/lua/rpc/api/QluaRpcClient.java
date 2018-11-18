package com.enfernuz.quik.lua.rpc.api;

import com.enfernuz.quik.lua.rpc.api.security.Securable;
import com.enfernuz.quik.lua.rpc.io.Gateway;
import qlua.rpc.*;
import qlua.rpc.bit.*;
import qlua.rpc.datasource.*;

import java.util.Set;

/**
 * Компонент, представляющий собой Java-обёртку над API QLua терминала QUIK.
 *
 * @throws RpcClientException в случае возникновения ошибки при удалённом вызове процедуры
 * @throws NullPointerException если аргумент {@code args} является {@code null}
 */
public interface QluaRpcClient extends Gateway, Securable {

    /**
     *
     * @param args
     * @return
     */
    AddColumn.Result qlua_AddColumn(AddColumn.Request args);

    /**
     *
     * @param args
     * @return
     */
    AddLabel.Result qlua_AddLabel(AddLabel.Request args);

    /**
     *
     * @return
     */
    AllocTable.Result qlua_AllocTable();

    /**
     *
     * @param args
     * @return
     */
    CalcBuySell.Result qlua_CalcBuySell(CalcBuySell.Request args);

    /**
     *
     * @param args
     * @return
     */
    CancelParamRequest.Result qlua_CancelParamRequest(CancelParamRequest.Request args);

    /**
     *
     * @param args
     * @return
     */
    Clear.Result qlua_Clear(Clear.Request args);

    /**
     *
     * @param args
     * @return
     */
    CreateWindow.Result qlua_CreateWindow(CreateWindow.Request args);

    /**
     *
     * @param args
     * @return
     */
    DelAllLabels.Result qlua_DelAllLabels(DelAllLabels.Request args);

    /**
     *
     * @param args
     * @return
     */
    DeleteRow.Result qlua_DeleteRow(DeleteRow.Request args);

    /**
     *
     * @param args
     * @return
     */
    DelLabel.Result qlua_DelLabel(DelLabel.Request args);

    /**
     *
     * @param args
     * @return
     */
    DestroyTable.Result qlua_DestroyTable(DestroyTable.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetBuySellInfo.Result qlua_getBuySellInfo(GetBuySellInfo.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetBuySellInfoEx.Result qlua_getBuySellInfoEx(GetBuySellInfoEx.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetCandlesByIndex.Result qlua_getCandlesByIndex(GetCandlesByIndex.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetCell.Result qlua_GetCell(GetCell.Request args);

    /**
     *
     * @return
     */
    GetClassesList.Result qlua_getClassesList();

    /**
     *
     * @param args
     * @return
     */
    GetClassInfo.Result qlua_getClassInfo(GetClassInfo.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetClassSecurities.Result qlua_getClassSecurities(GetClassSecurities.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetDepo.Result qlua_getDepo(GetDepo.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetDepoEx.Result qlua_getDepoEx(GetDepoEx.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetFuturesHolding.Result qlua_getFuturesHolding(GetFuturesHolding.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetFuturesLimit.Result qlua_getFuturesLimit(GetFuturesLimit.Request args);

    /**
     *
     * @param args
     * @return

     */
    GetInfoParam.Result qlua_getInfoParam(GetInfoParam.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetItem.Result qlua_getItem(GetItem.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetLabelParams.Result qlua_GetLabelParams(GetLabelParams.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetLinesCount.Result qlua_getLinesCount(GetLinesCount.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetMoney.Result qlua_getMoney(GetMoney.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetMoneyEx.Result qlua_getMoneyEx(GetMoneyEx.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetNumberOf.Result qlua_getNumberOf(GetNumberOf.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetNumCandles.Result qlua_getNumCandles(GetNumCandles.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetOrderByNumber.Result qlua_getOrderByNumber(GetOrderByNumber.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetParamEx.Result qlua_getParamEx(GetParamEx.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetParamEx2.Result qlua_getParamEx2(GetParamEx2.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetPortfolioInfo.Result qlua_getPortfolioInfo(GetPortfolioInfo.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetPortfolioInfoEx.Result qlua_getPortfolioInfoEx(GetPortfolioInfoEx.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetQuoteLevel2.Result qlua_getQuoteLevel2(GetQuoteLevel2.Request args);

    /**
     *
     * @return
     */
    GetScriptPath.Result qlua_getScriptPath();

    /**
     *
     * @param args
     * @return
     */
    GetSecurityInfo.Result qlua_getSecurityInfo(GetSecurityInfo.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetTableSize.Result qlua_GetTableSize(GetTableSize.Request args);

    /**
     *
     * @return
     */
    GetTradeDate.Result qlua_getTradeDate();

    /**
     *
     * @param args
     * @return
     */
    GetWindowCaption.Result qlua_GetWindowCaption(GetWindowCaption.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetWindowRect.Result qlua_GetWindowRect(GetWindowRect.Request args);

    /**
     *
     * @return
     */
    GetWorkingFolder.Result qlua_getWorkingFolder();

    /**
     *
     * @param args
     * @return
     */
    Highlight.Result qlua_Highlight(Highlight.Request args);

    /**
     *
     * @param args
     * @return
     */
    InsertRow.Result qlua_InsertRow(InsertRow.Request args);

    /**
     *
     * @return
     */
    IsConnected.Result qlua_isConnected();

    /**
     *
     * @param args
     * @return
     */
    IsSubscribedLevelIIQuotes.Result qlua_IsSubscribedLevelIIQuotes(IsSubscribedLevelIIQuotes.Request args);

    /**
     *
     * @param args
     * @return
     */
    IsWindowClosed.Result qlua_IsWindowClosed(IsWindowClosed.Request args);

    /**
     *
     * @param args
     * @return
     */
    Message.Result qlua_message(Message.Request args);

    /**
     *
     * @param args
     * @return
     */
    ParamRequest.Result qlua_ParamRequest(ParamRequest.Request args);

    /**
     *
     * @param args
     * @return
     */
    void qlua_PrintDbgStr(PrintDbgStr.Request args);

    /**
     *
     * @param args
     * @return
     */
    RGB.Result qlua_RGB(RGB.Request args);

    /**
     *
     * @param args
     * @return
     */
    SearchItems.Result qlua_SearchItems(SearchItems.Request args);

    /**
     *
     * @param args
     * @return
     */
    SendTransaction.Result qlua_sendTransaction(SendTransaction.Request args);

    /**
     *
     * @param args
     * @return
     */
    SetCell.Result qlua_SetCell(SetCell.Request args);

    /**
     *
     * @param args
     * @return
     */
    SetColor.Result qlua_SetColor(SetColor.Request args);

    /**
     *
     * @param args
     * @return
     */
    SetLabelParams.Result qlua_SetLabelParams(SetLabelParams.Request args);

    /**
     *
     * @param args
     * @return
     */
    SetSelectedRow.Result qlua_SetSelectedRow(SetSelectedRow.Request args);

    /**
     *
     * @param args
     * @return
     */
    SetTableNotificationCallback.Result qlua_SetTableNotificationCallback(SetTableNotificationCallback.Request args);

    /**
     *
     * @param args
     * @return
     */
    SetWindowCaption.Result qlua_SetWindowCaption(SetWindowCaption.Request args);

    /**
     *
     * @param args
     * @return
     */
    SetWindowPos.Result qlua_SetWindowPos(SetWindowPos.Request args);

    /**
     *
     * @param args
     * @return
     */
    Sleep.Result qlua_sleep(Sleep.Request args);

    /**
     *
     * @param args
     * @return
     */
    SubscribeLevelIIQuotes.Result qlua_SubscribeLevelIIQuotes(SubscribeLevelIIQuotes.Request args);

    /**
     *
     * @param args
     * @return
     */
    UnsubscribeLevelIIQuotes.Result qlua_UnsubscribeLevelIIQuotes(UnsubscribeLevelIIQuotes.Request args);

    /**
     *
     * @param args
     * @return
     */
    Band.Result bit_band(Band.Request args);

    /**
     *
     * @param args
     * @return
     */
    Bnot.Result bit_bnot(Bnot.Request args);

    /**
     *
     * @param args
     * @return
     */
    Bor.Result bit_bor(Bor.Request args);

    /**
     *
     * @param args
     * @return
     */
    Bxor.Result bit_bxor(Bxor.Request args);

    /**
     *
     * @param args
     * @return
     */
    Tohex.Result bit_tohex(Tohex.Request args);

    /**
     *
     * @param args
     * @return
     */
    C.Result datasource_C(C.Request args);

    /**
     *
     * @param args
     * @return
     */
    Close.Result datasource_Close(Close.Request args);

    /**
     *
     * @param args
     * @return
     */
    CreateDataSource.Result datasource_CreateDataSource(CreateDataSource.Request args);

    /**
     *
     * @param args
     * @return
     */
    H.Result datasource_H(H.Request args);

    /**
     *
     * @param args
     * @return
     */
    L.Result datasource_L(L.Request args);

    /**
     *
     * @param args
     * @return
     */
    O.Result datasource_O(O.Request args);

    /**
     *
     * @param args
     * @return
     */
    SetEmptyCallback.Result datasource_SetEmptyCallback(SetEmptyCallback.Request args);

    /**
     *
     * @param args
     * @return
     */
    SetUpdateCallback.Result datasource_SetUpdateCallback(SetUpdateCallback.Request args);

    /**
     *
     * @param args
     * @return
     */
    Size.Result datasource_Size(Size.Request args);

    /**
     *
     * @param args
     * @return
     */
    T.Result datasource_T(T.Request args);

    /**
     *
     * @param args
     * @return
     */
    V.Result datasource_V(V.Request args);

    public final class RpcClientException extends RuntimeException {

        public RpcClientException(final String message) {
            super(message);
        }

        public RpcClientException(final String message, final Throwable cause) {
            super(message, cause);
        }

        public RpcClientException(final Throwable cause) { super(cause); }

    }

}
