package com.example.user.myapplication;

/**
 * Created by user on 2018/4/8.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by hjki3 on 4/2/2018.
 */

public class WinJudgmentJUnit {
    private WinJudgment win;
    @Before public void setUp(){
        win=new WinJudgment();
    }
    @After public void tearDown(){
        win=null;
    }
    @Test
    public void testGetPlay(){
        assertEquals("win", win.winner(1,3));
        assertEquals("lose", win.winner(1,2));
        assertEquals("draw", win.winner(1,1));
        assertEquals("win", win.winner(2,1));
        assertEquals("lose", win.winner(2,3));
        assertEquals("draw", win.winner(2,2));
        assertEquals("win", win.winner(3,2));
        assertEquals("lose", win.winner(3,1));
        assertEquals("draw",win.winner(3,3));
    }
}