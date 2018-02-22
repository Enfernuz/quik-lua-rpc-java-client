package com.enfernuz.quik.lua.rpc.application;

import com.enfernuz.quik.lua.rpc.api.security.zmq.*;
import com.enfernuz.quik.lua.rpc.api.zmq.ZmqTcpQluaRpcClient;
import com.enfernuz.quik.lua.rpc.api.zmq.impl.ZmqTcpQluaRpcClientImpl;
import com.enfernuz.quik.lua.rpc.events.api.QluaEventHandler;
import com.enfernuz.quik.lua.rpc.events.impl.ZmqTcpQluaEventProcessor;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.io.transport.SimpleNetworkAddress;
import qlua.events.QluaEvents;
import qlua.rpc.Message;
import qlua.structs.QluaStructures;

import java.util.concurrent.atomic.AtomicBoolean;

public class SubscriptionExampleApplication {

    public static void main(final String[] args) throws Exception {

        // this is just for the testing purposes for now

        final NetworkAddress networkAddress = new SimpleNetworkAddress("127.0.0.1", 5561);

        final CurveKey serverPublicKey = CurveKey.fromString("rq:rM>}U?@Lns47E1%kR.o@n%FcmmsL/@{H8]yf7");
        final CurveKey clientPublicKey = CurveKey.fromString("Yne@$w-vo<fVvi]a<NY6T1ed:M$fCG*[IaLV{hID");
        final CurveKey clientSecretKey = CurveKey.fromString("D:)Q[IlAW!ahhC2ac:9*A}h:p?([4%wOTJ%JR%cs");
        final CurveKeyPair clientKeyPair = new CurveKeyPair(clientPublicKey, clientSecretKey);
        final CurveCredentials curveCredentials = new SimpleCurveCredentials(serverPublicKey, clientKeyPair);

        final AuthContext authContext = AuthContext.none();//new SimpleAuthContext(curveCredentials);

        try (final ZmqTcpQluaEventProcessor eventProcessor = ZmqTcpQluaEventProcessor.newInstance(networkAddress, authContext)) {

            final AtomicBoolean isServiceStopped = new AtomicBoolean(false);

            eventProcessor.subscribeToEverything();
            eventProcessor.register(new QluaEventHandler() {
                @Override
                public void onClose() {
                    isServiceStopped.set(true);
                    System.out.println("ON CLOSE");
                }

                @Override
                public void onStop() {
                    isServiceStopped.set(true);
                    System.out.println("ON STOP");
                }

                @Override
                public void onConnected() {
                    System.out.println("ON CONNECTED");
                }

                @Override
                public void onDisconnected() {
                    System.out.println("ON DISCONNECTED");
                }

                @Override
                public void onInit() {
                    System.out.println("ON INIT");
                }

                @Override
                public void onFirm(QluaStructures.Firm firm) {
                    System.out.println("ON FIRM: " + firm);
                }

                @Override
                public void onAllTrade(QluaStructures.AllTrade allTrade) {
                    System.out.println("ON ALL_TRADE: " + allTrade);
                }

                @Override
                public void onTrade(QluaStructures.Trade trade) {
                    System.out.println("ON TRADE: " + trade);
                }

                @Override
                public void onOrder(QluaStructures.Order order) {
                    System.out.println("ON ORDER: " + order);
                }

                @Override
                public void onAccountBalance(QluaStructures.AccountBalance accountBalance) {
                    System.out.println("ON ACCOUNT_BALANCE: " + accountBalance);
                }

                @Override
                public void onFuturesLimitChange(QluaStructures.FuturesLimit futuresLimit) {
                    System.out.println("ON FUTURES_LIMIT_CHANGE: " + futuresLimit);
                }

                @Override
                public void onFuturesLimitDelete(QluaStructures.FuturesLimitDelete futuresLimitDelete) {
                    System.out.println("ON FUTURES_LIMIT_DELETE: " + futuresLimitDelete);
                }

                @Override
                public void onFuturesClientHolding(QluaStructures.FuturesClientHolding futuresClientHolding) {
                    System.out.println("ON FUTURES_CLIENT_HOLDING: " + futuresClientHolding);
                }

                @Override
                public void onMoneyLimit(QluaStructures.MoneyLimit moneyLimit) {
                    System.out.println("ON MONEY_LIMIT: " + moneyLimit);
                }

                @Override
                public void onMoneyLimitDelete(QluaStructures.MoneyLimitDelete moneyLimitDelete) {
                    System.out.println("ON MONEY_LIMIT_DELETE: " + moneyLimitDelete);
                }

                @Override
                public void onDepoLimit(QluaStructures.DepoLimit depoLimit) {
                    System.out.println("ON DEPO_LIMIT: " + depoLimit);
                }

                @Override
                public void onDepoLimitDelete(QluaStructures.DepoLimitDelete depoLimitDelete) {
                    System.out.println("ON DEPO_LIMIT_DELETE: " + depoLimitDelete);
                }

                @Override
                public void onAccountPosition(QluaStructures.AccountPosition accountPosition) {
                    System.out.println("ON ACCOUNT_POSITION: " + accountPosition);
                }

                @Override
                public void onNegDeal(QluaStructures.NegDeal negDeal) {
                    System.out.println("ON NEG_DEAL: " + negDeal);
                }

                @Override
                public void onNegTrade(QluaStructures.NegTrade negTrade) {
                    System.out.println("ON NEG_TRADE: " + negTrade);
                }

                @Override
                public void onStopOrder(QluaStructures.StopOrder stopOrder) {
                    System.out.println("ON STOP_ORDER: " + stopOrder);
                }

                @Override
                public void onTransReply(QluaStructures.Transaction transaction) {
                    System.out.println("ON TRANS_REPLY: " + transaction);
                }

                @Override
                public void onParam(QluaStructures.ParamEventInfo param) {
                    System.out.println("ON PARAM: " + param);
                }

                @Override
                public void onQuote(QluaStructures.QuoteEventInfo quote) {
                    System.out.println("ON QUOTE: " + quote);
                }

                @Override
                public void onCleanUp() {
                    System.out.println("ON CLEAN_UP");
                }
            });

            eventProcessor.open();

            while ( !isServiceStopped.get() ) {
                eventProcessor.process();
            }
        }
    }
}
