package com.example.demo.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.mahout.cf.taste.impl.model.MemoryIDMigrator;

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
}
