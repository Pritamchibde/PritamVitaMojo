package common;

import java.io.*;
import java.util.Properties;

public class AppSetting {
        private Properties properties;
        private static AppSetting appSetting;

        private AppSetting() {
            BufferedReader reader;
            String propertyFilePath = "src/configs/Framework.properties";
            try {
                reader = new BufferedReader(new FileReader(propertyFilePath));
                properties = new Properties();
                try {
                    properties.load(reader);
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
            }
        }

        public static AppSetting getInstance( ) {
            if(appSetting == null) {
                appSetting = new AppSetting();
            }
            return appSetting;
        }

        public String getBaseUrl() {
            String url = properties.getProperty("url");
            if(url != null) return url;
            else throw new RuntimeException("url not specified in the Configuration.properties file.");
        }

        public String getName() {
            String name = properties.getProperty("name");
            if(name != null) return name;
            else throw new RuntimeException("name not specified in the Configuration.properties file.");
        }

    public String getEmail() {
        String email = properties.getProperty("email");
        if(email != null) return email;
        else throw new RuntimeException("email not specified in the Configuration.properties file.");
    }

    public String getPhoneNumber() {
        String phoneNumber = properties.getProperty("phoneNumber");
        if(phoneNumber != null) return phoneNumber;
        else throw new RuntimeException("phoneNumber not specified in the Configuration.properties file.");
    }

    public String getPassword() {
        String password = properties.getProperty("password");
        if(password != null) return password;
        else throw new RuntimeException("password not specified in the Configuration.properties file.");
    }
    public String getNodeUrlOfHub() {
        String nodeUrlOfHub = properties.getProperty("nodeUrlOfHub");
        if(nodeUrlOfHub != null) return nodeUrlOfHub;
        else throw new RuntimeException("user_Id not specified in the Configuration.properties file.");
    }

    public String getReportConfigPath(){
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }
}