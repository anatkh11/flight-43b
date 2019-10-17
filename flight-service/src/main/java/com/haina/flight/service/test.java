package com.haina.flight.service;

import org.springframework.expression.Operation;

import java.util.*;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("bbbbbbbbbbbbbb");
        list.add("c");
        list.add("d");
        list.add("e");
       /* for (String str :
                list) {
            if (!"c".equals(str)) {
                System.out.println(str);
            }
        }
        list.stream().filter(str -> !"c".equals(str)).forEach(System.out::println);
        list.stream().map(str -> str.length()).forEach(System.out::println);
        Optional<Integer> max = list.stream().map(str -> str.length()).max((a, b) -> a - b);
        if (max.isPresent()) {
            System.out.println(max.get());
        }

        Map<String, String> map = new HashMap<>();
        map.put("a", "v1");
        map.put("b", "v2");
        map.put("c", "v3");
        map.put("d", "v4");
        map.put("e", "v5");

        map.forEach((k, v) -> System.out.println("key:" + k + ",valut:" + v));*/

        List<Integer> l = new ArrayList<>();
        l.add(1234);
        l.add(11);
        l.add(44);
        l.add(32);
        l.add(22);
   /*     l.sort((a,b)->a-b);
        System.out.println(l);*/
    //collect或foreach等是一个终结方法，如果没哟终结方法，stream的方法是不会执行的
        //stream中的map filter，reduce等相当于组合出一个新的方法
        //终结方法相当于调用了之前组装出的新方法，入过没有终结方法，则组装的方法不会执行
        List<Integer> sortList = l.stream().sorted().collect(Collectors.toList());
        System.out.println("sortList,"+"sortList");
        System.out.println("list:"+l);
        list.stream().filter(str -> !str.startsWith("c")).map(str -> str.length()).forEach(System.out::println);

    }
}