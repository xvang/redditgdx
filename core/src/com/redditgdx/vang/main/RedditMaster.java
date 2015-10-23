package com.redditgdx.vang.main;

import com.redditgdx.vang.main.login.Login;

import net.dean.jraw.RedditClient;

/**
 * All interactions with JReddit will be done in here.
 * fetch login info, Login, etc.
 */
public class RedditMaster {



    RedditClient r;
    private Login login;


    public RedditMaster(){


        login = new Login();

        r = login.logInNow();

    }




}
