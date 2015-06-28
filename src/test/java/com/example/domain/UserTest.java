package com.example.domain;

import junit.framework.TestCase;

/**
 * Created by Masaya on 15/06/28.
 */
public class UserTest extends TestCase {
    public void test() {
        User user = new User(1, "test Test", "address");
        assertEquals(new Integer(1), user.getUserId());
        assertEquals("test Test", user.getUserName());
        assertEquals("address", user.getUserAddress());
    }

}