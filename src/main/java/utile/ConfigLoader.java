package utile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private Properties prop;//creea un obiect de tip Propeties

    public ConfigLoader(String propFile) {//constructor care ne da calea fisierului
        prop = new Properties();

        try (FileInputStream inputStream = new FileInputStream(propFile)) {//facem intializarea fisierul de proprietati
            prop.load(inputStream);


        } catch (IOException e) {
            throw new RuntimeException("Fisierul de proprietati nu a fost gasit in locatia" + propFile);
        }


    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }
}

