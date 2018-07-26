package com.spring.utility.impl;


import com.spring.utility.Utility;

public class UtilityImpl implements Utility {
    @Override
    public boolean hasItemInArray(String item, String... items) {
        for(String singleItem:items)
            if(singleItem.equals(item)) return true;
        return false;
    }

    @Override
    public boolean isStartWithAnything(String item, String... items) {
        for(String singleItem:items)
            if(item.startsWith(singleItem)) return true;
        return false;
    }
}
