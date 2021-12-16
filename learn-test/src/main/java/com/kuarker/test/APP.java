package com.kuarker.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-12-13
 **/
public class APP {
    public static void main(String[] args) throws Exception {

        ArrayList<String> list = new ArrayList<>();
        list.add("kk");
        list.get(0);

        Iterator<String> iterator = list.iterator();

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("kk");


        HashMap<String, String> map = new HashMap<>();
        map.put("hh", "hh");

        map.forEach((k, v) -> {

        });

        ConcurrentHashMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<>();
        stringStringConcurrentHashMap.computeIfAbsent("1", (k) -> {
            System.out.println("kk");
            return "q";
        });
        stringStringConcurrentHashMap.computeIfAbsent("1", (k) -> {
            System.out.println("qq");
            return "9";
        });
        stringStringConcurrentHashMap.computeIfAbsent("2", (k) -> {
            System.out.println("l");
            return "null";
        });
        stringStringConcurrentHashMap.computeIfAbsent("1", (k) -> {
            System.out.println(k);
            return k;
        });


        Queue<String> queue = new LinkedBlockingDeque<>(1);
        queue.add("kk");
        queue.peek();
        queue.add("22");

        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(20);

        String take = blockingQueue.take();


        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();

        reentrantLock.unlock();


        String a="a";
        String b="b";
        String ab=a+b;
        String ab1="a"+"b";
        String ab2="ab";
        String ab3="ab";

        System.out.println(ab==ab2); // false
        System.out.println(ab3==ab2); // true
        System.out.println(ab1==ab2); // true ab1 编译后直接变成 “ab”



    }

    public synchronized void go(Function<String, List> function) {
        List apply = function.apply("");
    }
}
