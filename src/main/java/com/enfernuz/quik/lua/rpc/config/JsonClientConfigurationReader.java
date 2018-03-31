package com.enfernuz.quik.lua.rpc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;

/**
 * Компонент, десериализующий конфигурацию клиента RPC-сервиса <b>quik-lua-rpc</b> из файла в формате JSON.
 *
 * @see <a href="https://github.com/Enfernuz/quik-lua-rpc">quik-lua-rpc</a>
 * @see <a https://www.json.org">JSON</a>
 */
public enum JsonClientConfigurationReader implements ObjectReader<ClientConfiguration> {

    /**
     * Экземпляр компонента, десериализующий конфигурацию клиента RPC-сервиса <b>quik-lua-rpc</b> из файла
     * в формате JSON.
     */
    INSTANCE;

    private final ObjectMapper objectMapper;

    private JsonClientConfigurationReader() {

        final SimpleModule module = new SimpleModule();
        module.addDeserializer(SimpleClientConfiguration.class, new SimpleClientConfigurationJsonDeserializer());

        this.objectMapper = new ObjectMapper().registerModule(module);
    }

    @Override
    public ClientConfiguration read(final File file) throws IOException {
        return objectMapper.readValue(file, SimpleClientConfiguration.class);
    }
}
