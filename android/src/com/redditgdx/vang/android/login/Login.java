package com.redditgdx.vang.android.login;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkException;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.http.oauth.OAuthException;

/**
 * Created by xeng on 10/21/15.
 */
public class Login {

    //For now, we use a test user. No dealing with tokens, prompting users, etc.
    //private SecretInfoFetcher infoFetcher;
    //private Hashtable<String, String> credentials;

    public Login(){


    }


    public RedditClient logInNow() {

        //First, we fetch the login info.
       // infoFetcher = new SecretInfoFetcher();

        //Then we store it in a Hashtable.
       // try {
       //     credentials = infoFetcher.getValues();
       // } catch (Exception e) {
       //     System.out.println("Could not load in credentials.");
       //     System.out.println(e.getMessage());
       // }


        UserAgent myUserAgent = UserAgent.of("desktop", "com.redditgdx.vang", "0.1", "habnpam");
        RedditClient reddit = new RedditClient(myUserAgent);

        String name = "obonnodo";
        String pass = "password123";
        String id = "CB_juXf-MhGNjw";
        String secret = "hLzbAj4Bst1IraT9kVhYRCRTwGA";
        Credentials credentials = Credentials.script(name, pass, id, secret);


        try {
            OAuthData authData = reddit.getOAuthHelper().easyAuth(credentials);
            reddit.authenticate(authData);
            return reddit;
        }catch(NetworkException  | OAuthException e){



            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("IT WAS A DIFFERENT EXCEPTION");
        }




        return null;


    }
}
