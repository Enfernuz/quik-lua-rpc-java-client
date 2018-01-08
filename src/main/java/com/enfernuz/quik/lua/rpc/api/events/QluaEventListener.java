package com.enfernuz.quik.lua.rpc.api.events;

import java.util.Optional;

public interface QluaEventListener extends QluaEventSubscription {

    Optional<QluaEvent> poll();
}
