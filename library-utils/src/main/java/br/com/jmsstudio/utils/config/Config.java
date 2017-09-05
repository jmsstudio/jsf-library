package br.com.jmsstudio.utils.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private final String CONFIG_FILE_PATH = "/library-utils.properties";

    @Produces
    @Configuration
    @ApplicationScoped
    public Properties getProperties() throws IOException {
        InputStream inputStream = Config.class.getResourceAsStream(CONFIG_FILE_PATH);
        Properties properties = new Properties();
        properties.load(inputStream);

        return properties;
    }
}
