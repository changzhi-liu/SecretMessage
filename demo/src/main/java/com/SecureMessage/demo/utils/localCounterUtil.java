package com.SecureMessage.demo.utils;

import java.util.HashMap;
import java.util.Map;

public class localCounterUtil {
    static int[] counters = new int[]{0,0,0,0,0,0};
    public static void increaseCounterByIndex(int index){

        counters[index] +=1;

    }
    public static int getByCounterByInterval(int interval){
        return counters[interval];
    }
}
