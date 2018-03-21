package com.enfernuz.quik.lua.rpc.api;

import com.enfernuz.quik.lua.rpc.api.security.Securable;
import com.enfernuz.quik.lua.rpc.io.Gateway;

/**
 * Компонент <b>Шлюз удалённого вызова процедур</b>, удовлетворяющий следующим критериям:
 * <ul>
 *     <li>1. является {@link Gateway шлюзом}</li>
 *     <li>2. способен выполнять удалённый вызов процедур к API QLua терминала QUIK</li>
 *     <li>3. поддерживает различные механизмы защиты передачи данных</li>
 * </ul>
 */
public interface RpcGateway extends RemoteProcedureCaller, Gateway, Securable {
}
