package com.redditgdx.vang;

import com.redditgdx.vang.login.Login;
import com.redditgdx.vang.login.SecretInfoFetcher;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * All interactions with JReddit will be done in here.
 * fetch login info, Login, etc.
 */
public class RedditMaster {

    private SecretInfoFetcher infoFetcher;
    private Hashtable<String, String> credentials;

    private Login login;


    public RedditMaster(){

        //First, we fetch the login info.
        infoFetcher = new SecretInfoFetcher();

        //Then we store it in a Hashtable.
        try{
            credentials = infoFetcher.getValues();
        } catch(Exception e){
            System.out.println("Could not load in credentials.");
            System.out.println(e.getMessage());
        }


        //Then we login.

        Iterator<Map.Entry<String, String>> it = credentials.entrySet().iterator();


        for(Iterator<Map.Entry<String, String>> i = credentials.entrySet().iterator(); i.hasNext(); ){
            System.out.println(i.next().getValue());
        }


    }




}
