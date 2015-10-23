package com.redditgdx.vang.test.login;

import com.redditgdx.vang.main.login.Login;

import net.dean.jraw.RedditClient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Hashtable;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by xeng on 10/23/15.
 */



public class TestLogin {

    private static final Login login = new Login();


    @Test
    public void testLogIn(){

        RedditClient c = login.logInNow();


        assertNotNull(c);

        assertTrue(c.me().getFullName() != null);
    }
}
