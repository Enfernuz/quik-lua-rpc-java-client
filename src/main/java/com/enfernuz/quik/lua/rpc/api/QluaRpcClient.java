package com.enfernuz.quik.lua.rpc.api;

import com.enfernuz.quik.lua.rpc.io.Gateway;
import qlua.rpc.*;
import qlua.rpc.bit.*;
import qlua.rpc.datasource.*;

import java.util.Set;

/**
 * @throws RpcClientException if there is an error occurred while making the remote procedure call
 * @throws NullPointerException if the {@code args} argument is {@code null}
 */
public interface QluaRpcClient extends Gateway {

    /**
     *
     * @param args
     * @return
     */
    AddColumn.Result AddColumn(AddColumn.Request args);

    /**
     *
     * @param args
     * @return
     */
    AddLabel.Result AddLabel(AddLabel.Request args);

    /**
     *
     * @return
     */
    AllocTable.Result AllocTable();

    /**
     *
     * @param args
     * @return
     */
    CalcBuySell.Result CalcBuySell(CalcBuySell.Request args);

    /**
     *
     * @param args
     * @return
     */
    CancelParamRequest.Result CancelParamRequest(CancelParamRequest.Request args);

    /**
     *
     * @param args
     * @return
     */
    Clear.Result Clear(Clear.Request args);

    /**
     *
     * @param args
     * @return
     */
    CreateWindow.Result CreateWindow(CreateWindow.Request args);

    /**
     *
     * @param args
     * @return
     */
    DelAllLabels.Result DelAllLabels(DelAllLabels.Request args);

    /**
     *
     * @param args
     * @return
     */
    DeleteRow.Result DeleteRow(DeleteRow.Request args);

    /**
     *
     * @param args
     * @return
     */
    DelLabel.Result DelLabel(DelLabel.Request args);

    /**
     *
     * @param args
     * @return
     */
    DestroyTable.Result DestroyTable(DestroyTable.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetBuySellInfo.Result getBuySellInfo(GetBuySellInfo.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetBuySellInfoEx.Result getBuySellInfoEx(GetBuySellInfoEx.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetCandlesByIndex.Result getCandlesByIndex(GetCandlesByIndex.Result args);

    /**
     *
     * @param args
     * @return
     */
    GetCell.Result GetCell(GetCell.Result args);

    /**
     *
     * @return
     */
    GetClassesList.Result getClassesList();

    /**
     *
     * @param args
     * @return
     */
    GetClassInfo.Result getClassInfo(GetClassInfo.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetClassSecurities.Result getClassSecurities(GetClassSecurities.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetDepo.Result getDepo(GetDepo.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetDepoEx.Result getDepoEx(GetDepoEx.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetFuturesHolding.Result getFuturesHolding(GetFuturesHolding.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetFuturesLimit.Result getFuturesLimit(GetFuturesLimit.Request args);

    /**
     *
     * @param args
     * @return

     */
    GetInfoParam.Result getInfoParam(GetInfoParam.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetItem.Result getItem(GetItem.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetLabelParams.Result GetLabelParams(GetLabelParams.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetLinesCount.Result getLinesCount(GetLinesCount.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetMoney.Result getMoney(GetMoney.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetMoneyEx.Result getMoneyEx(GetMoneyEx.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetNumberOf.Result getNumberOf(GetNumberOf.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetNumCandles.Result getNumCandles(GetNumCandles.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetOrderByNumber.Result getOrderByNumber(GetOrderByNumber.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetParamEx.Result getParamEx(GetParamEx.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetParamEx2.Result getParamEx2(GetParamEx2.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetPortfolioInfo.Result getPortfolioInfo(GetPortfolioInfo.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetPortfolioInfoEx.Result getPortfolioInfoEx(GetPortfolioInfoEx.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetQuoteLevel2.Result getQuoteLevel2(GetQuoteLevel2.Request args);

    /**
     *
     * @return
     */
    GetScriptPath.Result getScriptPath();

    /**
     *
     * @param args
     * @return
     */
    GetSecurityInfo.Result getSecurityInfo(GetSecurityInfo.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetTableSize.Result GetTableSize(GetTableSize.Request args);

    /**
     *
     * @return
     */
    GetTradeDate.Result getTradeDate();

    /**
     *
     * @param args
     * @return
     */
    GetWindowCaption.Result GetWindowCaption(GetWindowCaption.Request args);

    /**
     *
     * @param args
     * @return
     */
    GetWindowRect.Result GetWindowRect(GetWindowRect.Request args);

    /**
     *
     * @return
     */
    GetWorkingFolder.Result getWorkingFolder();

    /**
     *
     * @param args
     * @return
     */
    Highlight.Result Highlight(Highlight.Request args);

    /**
     *
     * @param args
     * @return
     */
    InsertRow.Result InsertRow(InsertRow.Request args);

    /**
     *
     * @return
     */
    IsConnected.Result isConnected();

    /**
     *
     * @param args
     * @return
     */
    IsSubscribedLevelIIQuotes.Result IsSubscribedLevelIIQuotes(IsSubscribedLevelIIQuotes.Request args);

    /**
     *
     * @param args
     * @return
     */
    IsWindowClosed.Result IsWindowClosed(IsWindowClosed.Request args);

    /**
     *
     * @param args
     * @return
     */
    Message.Result message(Message.Request args);

    /**
     *
     * @param args
     * @return
     */
    ParamRequest.Result ParamRequest(ParamRequest.Request args);

    /**
     *
     * @param args
     * @return
     */
    void PrintDbgStr(PrintDbgStr.Request args);

    /**
     *
     * @param args
     * @return
     */
    RGB.Result RGB(RGB.Request args);

    /**
     *
     * @param args
     * @return
     */
    SearchItems.Result SearchItems(SearchItems.Request args);

    /**
     *
     * @param args
     * @return
     */
    SendTransaction.Result sendTransaction(SendTransaction.Request args);

    /**
     *
     * @param args
     * @return
     */
    SetCell.Result SetCell(SetCell.Request args);

    /**
     *
     * @param args
     * @return
     */
    SetColor.Result SetColor(SetColor.Request args);

    /**
     *
     * @param args
     * @return
     */
    SetLabelParams.Result SetLabelParams(SetLabelParams.Request args);

    /**
     *
     * @param args
     * @return
     */
    SetSelectedRow.Result SetSelectedRow(SetSelectedRow.Request args);

    /**
     *
     * @param args
     * @return
     */
    SetTableNotificationCallback.Result SetTableNotificationCallback(SetTableNotificationCallback.Request args);

    /**
     *
     * @param args
     * @return
     */
    SetWindowCaption.Result SetWindowCaption(SetWindowCaption.Request args);

    /**
     *
     * @param args
     * @return
     */
    SetWindowPos.Result SetWindowPos(SetWindowPos.Request args);

    /**
     *
     * @param args
     * @return
     */
    Sleep.Result sleep(Sleep.Request args);

    /**
     *
     * @param args
     * @return
     */
    SubscribeLevelIIQuotes.Result SubscribeLevelIIQuotes(SubscribeLevelIIQuotes.Request args);

    /**
     *
     * @param args
     * @return
     */
    UnsubscribeLevelIIQuotes.Result UnsubscribeLevelIIQuotes(UnsubscribeLevelIIQuotes.Request args);

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
