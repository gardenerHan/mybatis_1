package com.ifox.hgx.mybatis;

import org.junit.Test;

public class Test_1 {

    @Test
    public void testHashCode(){
        int index = "book".hashCode() ;


        System.out.println(index);
        String result = Integer.toBinaryString(index);
        System.out.println(result+" : "+result.length());

        System.out.println(Integer.toBinaryString(16-1));



    }
}
