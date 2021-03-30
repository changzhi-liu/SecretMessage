package com.SecureMessage.demo.controller;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StringXor {
    public String twoStringXor(String str1, String str2) {
        byte b1[] = str1.getBytes();
        byte b2[] = str2.getBytes();
        byte longbytes[], shortbytes[];
        if (b1.length >= b2.length) {
            longbytes = b1;
            shortbytes = b2;
        } else {
            longbytes = b2;
            shortbytes = b1;
        }
        byte xorstr[] = new byte[longbytes.length];
        int i = 0;
        for (; i < shortbytes.length; i++) {
            xorstr[i] = (byte) (shortbytes[i] ^ longbytes[i]);
        }
        for (; i < longbytes.length; i++) {
            xorstr[i] = longbytes[i];
        }
        return new String(xorstr);
    }
    public String xorList(List<String> t){
        if (t.size() <= 1){
            return t.get(0);
        }
        String base = t.get(0);
        for (int i =1 ; i < t.size(); i++){
            base = twoStringXor(t.get(i), base);
        }
        return base;
    }

//    public static void main(String[] args) {
//        StringXor ad = new StringXor();
//        System.out.println(ad.twoStringXor("4S07DLVQdB9kIszXGleH",ad.twoStringXor("n7QdQ81h24m5OIshw0Yo", "4S07DLVQdB9kIszXGleH")));
//
//    }
}
