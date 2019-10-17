package com.haina.flight;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

public class UtilTest {

    public static void main(String[] args) {
        String str = " ";
        test(str);
        List<String> list = new ArrayList<>();
        List<String> li = Lists.newArrayList();

        Map<String,String> map = new HashMap<>();
        map = Maps.newHashMap();
        if(CollectionUtils.isEmpty(list)){

        }
        String str1 = "a,b,c,e,f";
        String[] split = str.split(",");
        for(String a : split){
            System.out.println(a);
        }
        Iterable<String> sp = Splitter.on(",").split(str);
        Iterator<String> iterator = sp.iterator();
        while(iterator.hasNext()){

        }
    }
    public static void test(String str){
        if(StringUtils.isBlank(str)){
            System.out.println("str=null");

        }
    }
}
