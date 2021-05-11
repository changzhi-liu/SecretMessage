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
    public static int getIntevalIndex(Long sender, Long receiver) {
        if (sender == 1 && receiver ==2){
            return 0;
        } else if (sender == 2 && receiver ==1){
            return 1;
        } else if (sender == 1 && receiver ==3){
            return 2;
        } else if (sender == 3 && receiver ==1){
            return 3;
        } else if(sender == 2 && receiver ==3){
            return 4;
        } else if(sender == 3 && receiver ==2){
            return 5;
        }
        return -1;
    }
    public static int getIntevalStartingIndex(int interval) {
        if (interval == 0){
            return 0;
        } else if (interval == 1){
            return 50;
        } else if (interval == 2){
            return 100;
        } else if (interval ==3){
            return 150;
        } else if(interval == 4){
            return 200;
        } else if(interval == 5){
            return 250;
        }
        return -1;
    }

}
