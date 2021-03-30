package com.SecureMessage.demo;

import com.SecureMessage.demo.controller.GenerateQueryList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class GenerateQueryListTest {
    private GenerateQueryList gq = new GenerateQueryList();



    @Test
    public void testRandomList(){
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Integer> t = gq.randomList(3, 3);
            res.add(t);
            System.out.println(res);
        }
    }
    @Test
    public void testXorLists(){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(1);a.add(1);a.add(1);
        List<Integer> b = new ArrayList<>();
        b.add(1);b.add(0);b.add(1);
        List<Integer> c = new ArrayList<>();
        c.add(1);c.add(0);c.add(0);

        List<Integer> ans = new ArrayList<>();
        ans.add(1);ans.add(1);ans.add(0);
        res.add(a); res.add(b); res.add(c); res.add(ans);

        List<Integer> t = gq.ListXor(res.get(0), res.get(1), res.get(2));
        assert(t.equals(res.get(3)));

        List<List<Integer>> t2 = gq.convertToRow(res);
        List<Integer> first = arrayToList(new int[]{1,2,3});
        assert(t2.get(0).equals(first));
        List<Integer> second = arrayToList(new int[]{1,3});
        assert(t2.get(1).equals(second));
        List<Integer> third = arrayToList(new int[]{1});
        assert(t2.get(2).equals(third));
    }
    @Test
    public void generateList(){
        List<List<Integer>> res = gq.getList(5);
        System.out.println(res);
    }

    private List<Integer> arrayToList(int[] ada){
        List<Integer> res = new ArrayList<Integer>(ada.length);
        for (int i : ada)
        {
            res.add(i);
        }
        return res;
    }

}
