package ar.noxit.utils.properties;

import ar.noxit.exceptions.NoxitRuntimeException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertiesFileReader {

    public Properties readPropertiesFromFile(String file) {
        if (file == null) {
            throw new IllegalArgumentException("file no puede ser null");
        }

        URL url = Thread.currentThread().getContextClassLoader().getResource(file);
        InputStream openStream = null;

        try {
            openStream = url.openStream();

            Properties properties = new Properties();
            properties.load(openStream);

            return properties;
        } catch (Exception e) {
            throw new NoxitRuntimeException("excepcion leyendo las properties", e);
        } finally {
            try {
                if (openStream != null)
                    openStream.close();
            } catch (IOException e) {
                throw new NoxitRuntimeException("error cerrando el archivo", e);
            }
        }
    }
}
