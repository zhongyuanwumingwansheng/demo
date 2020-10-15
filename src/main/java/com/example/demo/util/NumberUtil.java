package com.example.demo.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.mahout.cf.taste.impl.model.MemoryIDMigrator;

public class NumberUtil {
    public static Long characterToLong(String srcText){
        if(!StringUtils.isBlank(srcText)){

        }
        MemoryIDMigrator thing2long = new MemoryIDMigrator();
        Long longText = thing2long.toLongID(srcText);
        return longText;
    }
}
