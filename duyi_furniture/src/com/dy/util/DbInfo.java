package com.dy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * 饿汉式
 * @author lz
 */
public class DbInfo {
    private static DbInfo dbInfo;
    /**
     * 定义实体类ConfigInfo对象
     */
    private ConfigInfo configInfo;

    private DbInfo(){
        configInfo = new ConfigInfo();
    }

    public static DbInfo getInstance(){
        if (dbInfo == null){
            dbInfo = new DbInfo();
        }
        return dbInfo;
    }
//    定义一个方法，用来获取到文件中的信息
    public ConfigInfo getProperties() throws URISyntaxException, IOException {
//        找到资源
        String path = DbInfo.class.getResource("/").toURI().getPath() + "db.properties";
//        创建file对象
        File file = new File(path);
//        创建输入流对象
        FileInputStream fis = new FileInputStream(file);
//        创建properties文件对象
        Properties properties = new Properties();
//        管理两者对象
        properties.load(fis);
        configInfo.setDriver(properties.getProperty("driver"));
        configInfo.setUrl(properties.getProperty("url"));
        configInfo.setUsername(properties.getProperty("username"));
        configInfo.setPassword(properties.getProperty("password"));
        return configInfo;
    }

    public class ConfigInfo {
        private String driver;
        private String url;
        private String username;
        private String password;

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
