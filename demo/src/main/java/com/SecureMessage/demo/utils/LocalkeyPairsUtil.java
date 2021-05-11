package com.SecureMessage.demo.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LocalkeyPairsUtil implements Serializable {

    private static LocalkeyPairsUtil instance = new LocalkeyPairsUtil();
    String keyLocal = "src/main/resources/keys.txt";
    //string[] 0 is my key, 1 is sharedkey
    Map<Long, String[]> keyPairs = new HashMap<>();

    private LocalkeyPairsUtil() {
    }

    public void printAllKeys(){
        for (Map.Entry<Long, String[]> entry : keyPairs.entrySet()) {
            Long friendsId = entry.getKey();
            String[] value = entry.getValue();
            System.out.println("my public key is : " + value[0]);
            System.out.println("my friends " + friendsId + "shared key with me is : " + value[0]);
        }
    }

    public void printKeys(Long friendsId){
        String[] value = keyPairs.get(friendsId);
        System.out.println("my public key is : "+ value[0]);
        System.out.println("my friends " + friendsId + "shared key with me is : "+ value[0]);
    }

    public static LocalkeyPairsUtil getInstance(){
        return instance;
    }
    public Map<Long, String[]> readFromFile(){
        try {
            FileInputStream fis = new FileInputStream(keyLocal);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Map<Long, String[]> res = (Map<Long, String[]>)ois.readObject();
            ois.close();
            return res;
//            System.out.println("The Object was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    };

    public void writeToFile(){
        try {

            FileOutputStream fileOut = new FileOutputStream(keyLocal);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(keyPairs);
            objectOut.close();
//            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public String getSharedKey(Long id){
        if (keyPairs.size() == 0) {
            keyPairs = readFromFile();
        }

        if (keyPairs.containsKey(id)) {
            return keyPairs.get(id)[1];
        }
        return null;
    }
    public String getMyPrivateKey(Long id){
        if (keyPairs.size() == 0) {
            keyPairs = readFromFile();
        }
        if (keyPairs.containsKey(id)) {
            return keyPairs.get(id)[0];
        }
        return null;
    }
    public void putMyPrivateKey(Long id, String key){
        String[] keys = new String[2];
        keys[0] = key;
        keyPairs.put(id, keys);

        writeToFile();
        //todo for lose device situation, need to read from map then modify;

    }
    public void putSharedKey(Long id, String key) {
        String[] keys = keyPairs.get(id);
        keys[1] = key;
        keyPairs.put(id, keys);

        writeToFile();
    }
    public static void main(String[] args) {
        LocalkeyPairsUtil ada = LocalkeyPairsUtil.getInstance();

        System.out.println(ada.getMyPrivateKey(2L));
        System.out.println(ada.getMyPrivateKey(3L));
        ada.putMyPrivateKey(3L, "ada");
        ada.printKeys(3L);
        ada.putSharedKey(3L, "adashared");
        System.out.println(ada.getSharedKey(3L));
        ada.printAllKeys();

    }
}
