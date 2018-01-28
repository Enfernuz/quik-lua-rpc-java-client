package com.enfernuz.quik.lua.rpc.events.api;

import com.enfernuz.quik.lua.rpc.io.Gateway;

public interface QluaEventProcessor extends QluaEventHandlerRegistry, QluaEventSubscription, Gateway {

    // until there's no events left to process
    void process();

    // process up to maxEvents events
    void process(int maxEvents);
}
