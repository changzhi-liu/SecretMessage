package com.SecureMessage.demo.utils;

public class LocalRowToSenderReceiverUtil {
    public static int[] getIndex(Long row){
        int[] res = new int[2];
        if (row >= 0 && row <=49){
            res[0] = 1;
            res[1] = 2;
        } else if (row >= 50 && row <=99){
            res[0] = 2;
            res[1] = 1;
        } else if (row >= 101 && row <=149){
            res[0] = 1;
            res[1] = 3;
        } else if (row >= 150 && row <=199){
            res[0] = 3;
            res[1] = 1;
        } else if (row >= 200 && row <=249){
            res[0] = 2;
            res[1] = 3;
        } else if (row >= 250 && row <=299){
            res[0] = 3;
            res[1] = 2;
        } else {
            return null;
        }
        return res;
    }
}
