package com.SecureMessage.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

@Component
public class GenerateXorWriteMessagesUtil {


    StringXorUtil stringXorUtil = new StringXorUtil();

    char[] choices = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    public List<String> generateThreeMessage(String input){
        int size= input.length();
        List<String> randoms = new ArrayList<>();
        randoms.add(randomGenerateSize(size));
        randoms.add(randomGenerateSize(size));
        randoms.add(stringXorUtil.twoStringXor(input, stringXorUtil.twoStringXor(randoms.get(0), randoms.get(1))));

        return randoms;
    }
    public List<String> convertInputs(String dbMessage, String newMessage){
        return generateThreeMessage(stringXorUtil.twoStringXor(dbMessage, newMessage));
    }
    public String randomGenerateSize(int size){
        StringBuffer res = new StringBuffer();
        Random rd = new Random();
        for (int i  =0 ; i < size; i++){
            int index = rd.nextInt(16);
            res.append(choices[index]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        StringXorUtil stringXorUtil = new StringXorUtil();
        GenerateXorWriteMessagesUtil ad = new GenerateXorWriteMessagesUtil();
        String dbMessage = "abcd";
        String wanted = "6246CAA2E46F653D7D919F01A87800A6";
        String secret = stringXorUtil.twoStringXor(wanted, dbMessage);
        List<String> t = ad.generateThreeMessage(secret);




        System.out.println(stringXorUtil.twoStringXor(t.get(0),stringXorUtil.twoStringXor(dbMessage, stringXorUtil.twoStringXor(t.get(1), t.get(2)))));
    }
}
