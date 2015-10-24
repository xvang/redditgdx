package com.redditgdx.vang.main;

import com.redditgdx.vang.main.login.Login;

import net.dean.jraw.RedditClient;
import net.dean.jraw.models.Subreddit;

/**
 * All interactions with JReddit will be done in here.
 * fetch login info, Login, etc.
 */
public class RedditMaster {



    public RedditClient r;
    private Login login;


    public RedditMaster(){

        login = new Login();

        r = login.logInNow();

    }



    public RedditPackage getAllTheInfo(String sub){

        RedditPackage pack = new RedditPackage();

        pack.subreddit = r.getSubreddit(sub);


        return pack;
    }





}
