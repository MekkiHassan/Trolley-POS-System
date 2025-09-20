package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    // ---------------- Properties ----------------
    private static final Properties properties = new Properties();

    // ---------------- JSON ----------------
    private static JsonNode jsonNode;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // ---------------- Properties Methods ----------------
    public static void loadProperties(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
            System.out.println("✅ Properties file loaded successfully!");
        } catch (IOException e) {
            System.out.println("❌ Failed to load properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key, "Key not found!");
    }

    // ---------------- JSON Methods ----------------
    public static void loadJson(String filePath) {
        try {
            jsonNode = objectMapper.readTree(new File(filePath));
            System.out.println("✅ JSON file loaded successfully!");
        } catch (IOException e) {
            System.out.println("❌ Failed to load JSON file: " + e.getMessage());
        }
    }

    public static String getJsonValue(String jsonPath) {
        if (jsonNode == null) {
            return "JSON not loaded!";
        }
        try {
            String[] parts = jsonPath.split("\\.");
            JsonNode currentNode = jsonNode;

            for (String part : parts) {
                if (currentNode.has(part)) {
                    currentNode = currentNode.get(part);
                } else {
                    return "❌ Key '" + part + "' not found under: " + currentNode.toString();
                }
            }

            return currentNode.isValueNode() ? currentNode.asText() : currentNode.toString();

        } catch (Exception e) {
            return "❌ Error reading JSON path: " + e.getMessage();
        }
    }


}
