package com.SecureMessage.demo.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util. LinkedList;
import java.util.List;
import java.util.Random;
// note the generated list index 0 means get 1s row
@Component
public class GenerateQueryListUtil {

    final int postAdd = 20;
    final int oneCounts = 3;
    public List<List<Integer>> getList(int index){
        List<List<Integer>> res = new  LinkedList<>();
        
        List<Integer> origin = new  LinkedList<>();
        for (int i = 0 ; i < index-1 ; i++){
            origin.add(0);
        }
        origin.add(1); // for index
        postAddZero(origin);
        List<Integer> b = randomList(oneCounts, origin.size());
        List<Integer> c = randomList(oneCounts, origin.size());
        List<Integer> d = ListXor(origin,b,c);

        res.add(origin);
        res.add(b);
        res.add(c);res.add(d);


        return res;
    }
    public List<List<Integer>> convertToRow(List<List<Integer>> t){
        List<List<Integer>> res = new ArrayList<>(); // 0100011 - > {2,6,7}
        for (int i = 0 ; i < t.size(); i++){
            res.add(new ArrayList<>());
        }
        for (int i = 0 ; i < t.size(); i++){
            List<Integer> temp = t.get(i);
            int indexcounter = 1;
            for (int j = 0 ; j < temp.size(); j++){
                if (temp.get(j) == 1){
                    res.get(i).add(indexcounter);
                }
                indexcounter++;
            }

        }
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
