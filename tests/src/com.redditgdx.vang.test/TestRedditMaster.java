package com.redditgdx.vang.test;

import com.redditgdx.vang.main.RedditMaster;

import org.junit.Test;
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
 *
 */
public class TestRedditMaster {


    public static final RedditMaster r = new RedditMaster();




    @Test
    public void objectExists(){
        assertNotNull(r.r.me().getFullName());
    }


}
