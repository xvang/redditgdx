package com.redditgdx.vang.android;

import net.dean.jraw.RedditClient;
import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import net.dean.jraw.paginators.Sorting;
import net.dean.jraw.paginators.SubredditPaginator;
import net.dean.jraw.paginators.TimePeriod;

/**
 * Every PageView will have a RedditPackage object passed in.
 * The RedditPackage object contains all the necessary info
 * to render a page.
 *
 * For now, the only thing needed is the subreddit object.
 * It seems redundant to wrap the subreddit in another class,
 * but hopefully it will be easier to add more stuff  if I need
 * more than just the subreddit.
 */
public class RedditPackage {


    public String subredditName;
    public SubredditPaginator sp;


    public Sorting sort;
    public TimePeriod timePeriod;
    public int limit;
    public Listing<Submission> subredditList;

    public RedditPackage(){

        limit = 25;
    }


    public void generateSubredditSearch(RedditClient r) throws Exception{

        sp = new SubredditPaginator(r);
        sp.setLimit(limit);
        sp.setTimePeriod(timePeriod);
        sp.setSubreddit(subredditName);
        sp.setSorting(sort);



        sp.next(true);
        subredditList = sp.getCurrentListing();


        //If the subreddit does not exist, then when we try to get the url of the first
        //post, an error will trigger the exception.
        sp.getCurrentListing().get(0).getUrl();
    }


}
