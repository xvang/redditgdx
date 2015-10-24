package com.redditgdx.vang.main;

import net.dean.jraw.models.Subreddit;

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


    public Subreddit subreddit;

    public RedditPackage(){


    }


}
