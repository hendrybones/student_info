package com.pluralsight.calcengine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void lowerStringTest(){
        assertEquals(4,new Main().lowerString("xxhixx"));
        assertEquals(3,new Main().lowerString("xhixhix"));
        assertEquals(0,new Main().lowerString("hi"));


    }
    @Test
    public void StringCount(){
        assertEquals(2,new Main().StringCheck("catcowcat","cat"));

    }
    @Test
    public  void triangleBlockTest(){
        assertEquals(0,new Main().triangleBlock(0));
        assertEquals(1,new Main().triangleBlock(1));

    }
    @Test
    public void parenthesisTest(){
        assertEquals("(abc)",new Main().parenthesis("xyz(abc)123","(abc)"));
        assertEquals("(hello)",new Main().parenthesis("x(hello)","(hello)"));
        assertEquals("(xy)",new Main().parenthesis("(xy)1","(xy)"));
    }
    @Test
    public void identicalCharTest(){
        assertEquals("hel*lo",new Main().StrCount("hello"));
    }


}