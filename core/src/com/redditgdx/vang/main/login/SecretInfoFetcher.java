package com.redditgdx.vang.main.login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;

/**
 * For the time being, fetching the login stuff is handled here.
 * the login info is stored in a .properties file.
 */
public class SecretInfoFetcher {



    public Hashtable<String, String> getValues() {
        Hashtable<String, String> returnTable = null;
        try {
            Properties prop = new Properties();
            String propFileName = "secret.properties";
            returnTable = new Hashtable<String, String>();


            InputStream inputStream = new FileInputStream(propFileName);

            prop.load(inputStream);

            returnTable.put("access", prop.getProperty("access"));
            returnTable.put("refresh", prop.getProperty("refresh"));
            returnTable.put("secret", prop.getProperty("secret"));
            returnTable.put("name", prop.getProperty("name"));
            returnTable.put("uri", prop.getProperty("uri"));

            inputStream.close();

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        return returnTable;
    }
}
