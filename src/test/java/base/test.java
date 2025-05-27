package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class test {
    public static void main(String[] args) throws IOException {

        File file = new File("src/test/java/config/staging.properties");
        InputStream inputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(inputStream);
        properties.getProperty("baseUrl");
        System.out.println( properties.getProperty("baseUrl"));
    }
}
