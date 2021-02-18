package com.example.demo.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.mahout.cf.taste.impl.model.MemoryIDMigrator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class NumberUtil {
    public static Long characterToLong(String srcText){
        if(!StringUtils.isBlank(srcText)){

        }
        MemoryIDMigrator thing2long = new MemoryIDMigrator();
        Long longText = thing2long.toLongID(srcText);
        return longText;
    }

    public static void testDivision(){
        String str =     "   12 3   ";
        System.out.println(str);
        System.out.println(str.trim());
        List<Character> chars = new ArrayList<>();


        Math.pow(10,2);
        int i = 122/(int)Math.pow(10,2);
        System.out.println(i);
    }

    public static void testConvertNumber(){
        //String str = "-2147483649";
        String str = "99999999999999999";
        BigInteger bigInteger = new BigInteger(str);
        BigInteger intMax = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        BigInteger intMin = new BigInteger(String.valueOf(Integer.MIN_VALUE));
        str.substring(1);
        //int i = Integer.parseInt(str);
        System.out.println(bigInteger.intValue());
        if(bigInteger.compareTo(intMax)>0){
            System.out.println(Integer.MAX_VALUE);
        }
        if(bigInteger.compareTo(intMin)<0){
            System.out.println(Integer.MIN_VALUE);
        }
        int i = Integer.valueOf('0'+"");
        System.out.println(i);

        int[] height = new int[]{4,3,2,1,4};

        System.out.println(height.length);

    }

    public static void main(String[] args){
        NumberUtil.testConvertNumber();
    }
}
