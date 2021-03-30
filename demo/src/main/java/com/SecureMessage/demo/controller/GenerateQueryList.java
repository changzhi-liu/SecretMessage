package com.SecureMessage.demo.controller;

import java.util. LinkedList;
import java.util.List;
import java.util.Random;
// note the generated list index 0 means get 1s row
public class GenerateQueryList {

    final int postAdd = 20;
    public List<List<Integer>> getList(int index){
        List<List<Integer>> res = new  LinkedList<>();
        
        List<Integer> origin = new  LinkedList<>();
        for (int i = 0 ; i < index-1 ; i++){
            origin.add(0);
        }
        origin.add(1); // for index
        postAddZero(origin);
        List<Integer> b = randomList(3, origin.size());
        List<Integer> c = randomList(3, origin.size());
        List<Integer> d = ListXor(origin,b,c);

        res.add(origin);
        res.add(b);
        res.add(c);res.add(d);

        return res;
    }

    public void postAddZero(List<Integer> res){
        for (int i = 0; i < postAdd; i++) {
            res.add(0);
        }
    }
    public List<Integer> randomList(int countOfOne, int length){
        List<Integer> res = new  LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < length; i++){
            if (countOfOne > 0){
                int a = random.nextInt(2);
                res.add(a);
                if (a == 1) {
                    countOfOne--;
                }
            } else {
                res.add(0);
            }
        }
        return res;
    }

    public List<Integer> ListXor(List<Integer> A, List<Integer> B, List<Integer> C){
        List<Integer> res = new  LinkedList<>();
        for (int i = 0; i < A.size(); i++){
            int r = A.get(i)^B.get(i)^C.get(i);
            res.add(r);
        }
        return res;
    }
}
