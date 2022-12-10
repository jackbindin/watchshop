package com.example.watchshop.utils;

import java.util.ArrayList;

public class WatchUtilImpl implements WatchUtil{
    public ArrayList<Integer> parseStringIds(ArrayList<String> watchIdStrings){
        ArrayList<Integer> watchIds = new ArrayList<>();
        try {
            for (String idString:watchIdStrings){
                watchIds.add(Integer.parseInt(idString));
            }
        }catch (NumberFormatException e){
            throw new NumberFormatException("Error parsing watch ids from json");
        }
        return watchIds;
    }
}
