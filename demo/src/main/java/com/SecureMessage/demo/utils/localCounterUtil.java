package com.SecureMessage.demo.utils;

import java.util.HashMap;
import java.util.Map;

public class localCounterUtil {
    Map<Long, Long> counterMap;

    public localCounterUtil() {
        if (counterMap == null) {
            this.counterMap = new HashMap<>();
//            counterMap.put(0, )
        }
    }
}
