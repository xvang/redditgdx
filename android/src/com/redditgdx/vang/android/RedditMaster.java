package com.redditgdx.vang.android;

import com.redditgdx.vang.android.login.Login;

import net.dean.jraw.RedditClient;
import net.dean.jraw.paginators.Sorting;
import net.dean.jraw.paginators.TimePeriod;

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



    public RedditPackage getAllTheInfo(String sub, String sort, String time, int limit){

        RedditPackage pack = new RedditPackage();

        //We don't HAVE to store the name of the sub within a RedditPackage object.
        //But I did it just in case.
        pack.subredditName = sub;

        pack.limit = limit;

        //The default sort is "hot"
        if (sort.toLowerCase().equals("top")){
            pack.sort = Sorting.TOP;
        }

        else if (sort.toLowerCase().equals("controversial")){
            pack.sort = Sorting.CONTROVERSIAL;
        }

        else if (sort.toLowerCase().equals("new")){
            pack.sort = Sorting.NEW;
        }

        else{
            pack.sort = Sorting.HOT;
        }


        //The default time period is "month"
        if (time.toLowerCase().equals("day")){
            pack.timePeriod = TimePeriod.DAY;
        }

        else if (time.toLowerCase().equals("month")){
            pack.timePeriod = TimePeriod.MONTH;
        }

        else if (time.toLowerCase().equals("all")){
            pack.timePeriod = TimePeriod.ALL;
        }

        else if (time.toLowerCase().equals("year")){
            pack.timePeriod = TimePeriod.YEAR;
        }

        else{
            pack.timePeriod = TimePeriod.MONTH;
        }

        try {
            //We generate the list of submissions.
            pack.generateSubredditSearch(r);
        }catch(Exception e){
            System.out.println("Subreddit does not exist! Check the spelling!");
        }

        return pack;
    }





}

