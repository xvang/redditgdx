package com.redditgdx.vang.test.login;

import com.redditgdx.vang.main.login.SecretInfoFetcher;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;


/**
 * Created by xeng on 10/23/15.
 */
public class TestSecretInfoFetcher {



    private static final Vector<String> keys = new Vector<String>();;

    @BeforeClass
    public static void init(){
        keys.add("access");
        keys.add("refresh");
        keys.add("name");
        keys.add("secret");
        keys.add("uri");
    }

    @Test
    public void testGetValues(){

        //Create the object.
        SecretInfoFetcher info = new SecretInfoFetcher();

        //Call the main function of object.
        Hashtable<String, String> testHash = info.getValues();


        //Check if the returned value above is null.
        assertNotNull(testHash);


        assertTrue(testHash.size() == 5);


        //Check if the keys are correct.
        for (Map.Entry<String, String> entry : testHash.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            assertTrue(inArray(key));
            assertTrue(value != null);

        }


    }

    public boolean inArray(String key){

        boolean isInArray = false;
        for(int x = 0; x < keys.size(); x++){

            if (keys.get(x).equals(key)){
                isInArray = true;
                break;
            }
        }

        return isInArray;
    }


}
