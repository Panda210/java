package com.slife.java.share.biz.array;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;

/**
 * 数据实现的基本类
 *
 * @author xujiali
 * @since 2019年2月13日 下午3:14:42
 */
@Slf4j
public class CommonArray {

    /**
     * int[] 与 Integer[]数组的区别 </br>
     * int[5] 初始化没有具体数值，那么数组中每个值就是int类型的初始值0 </br>
     * Integer[5] 初始化没有具体数值，那么数组中每个值就是Integer类型的初始值null
     */
    public static void arrayInstance() {
        int[] array = new int[5];
        log.info("array.length = {}", array.length);
        for (int i = 0; i < array.length; i++) {
            log.info("array[{}] = {}", i, array[i]);
        }

        log.info("******************************");
        Integer[] arr = new Integer[5];
        log.info("arr.length = {}", arr.length);
        for (int i = 0; i < arr.length; i++) {
            log.info("arr[{}] = {}", i, arr[i]);
        }
    }

    /**
     * 数据的初始化，以及在超过默认大小之后自动扩容
     */
    public static void array() {
        // 初始化给定了控件大小，对应的内置元素数组elementData.length = 0
        ArrayList<String> t = new ArrayList<>(0);

        // 调用的是默认的构造器，内置元素数组elementData.length = 10
        ArrayList<String> a = new ArrayList<>();
        log.info("a.size:{}", a.size());

        a.add("test001");
        a.add("test002");
        a.add("test003");
        a.add("test004");
        a.add("test005");
        a.add("test006");
        a.add("test007");
        a.add("test008");
        a.add("test009");
        a.add("test010");

        // 在添加第11个数据的时候，原有构造的elementData的数据的不够了，会自动扩容到15，1.5倍的初始容量
        a.add("test011");
        log.info("a.size:{}", a.size());

        // 随机获取数据的复杂度为O(1)
        a.get(1);

        // 删除 -- 会将index+1之后的数据赋值到index的位置，并将最后一个置空便于GC收集
        a.remove(3);

        a.toArray();
    }
}
