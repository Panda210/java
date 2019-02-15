package com.slife.java.share.biz.linkList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import lombok.extern.slf4j.Slf4j;

/**
 * 链表的基础知识
 *
 * @author xujiali
 * @since 2019年2月13日 下午3:11:19
 */
@Slf4j
public class CommonLinkList {

    public static LinkedList initial() {
        LinkedList list = new LinkedList();
        log.info("采用addLast添加数据：");
        for (int i = 0; i < 100000; i++) {
            list.addLast(i);
        }
        log.info("采用addFirst添加数据");
        for (int i = 0; i < 100000; i++) {
            list.addFirst(i);
        }
        list.getFirst();
        list.get(1);
        list.size();
        list.element();
        list.remove(1);

        list.toArray();
        return list;
    }

    /**
     * 初始化
     *
     * @return 初始化链表结果
     */
    public static LinkedList getLinkedList() {
        LinkedList llist = new LinkedList();
        for (int i = 0; i < 100000; i++) {
            llist.addLast(i);
        }
        return llist;
    }

    /**
     * 通过快迭代器遍历LinkedList
     */
    public static void iteratorLinkedListThruIterator(LinkedList<Integer> list) {
        if (list == null) {
            return;
        }

        // 记录开始时间
        long start = System.currentTimeMillis();

        for (Iterator iter = list.iterator(); iter.hasNext();) {
            iter.next();
        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        log.info("iteratorLinkedListThruIterator：" + interval + " ms");
    }

    /**
     * 通过快速随机访问遍历LinkedList
     */
    public static void iteratorLinkedListThruForeach(LinkedList<Integer> list) {
        if (list == null) {
            return;
        }

        // 记录开始时间
        long start = System.currentTimeMillis();

        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i);
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        log.info("iteratorLinkedListThruForeach：" + interval + " ms");
    }

    /**
     * 通过另外一种for循环来遍历LinkedList
     */
    public static void iteratorThroughFor2(LinkedList<Integer> list) {
        if (list == null) {
            return;
        }

        // 记录开始时间
        long start = System.currentTimeMillis();

        for (Integer record : list) {
            // record就是循坏遍历的结果
        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        log.info("iteratorThroughFor2：" + interval + " ms");
    }

    /**
     * 通过pollFirst()来遍历LinkedList
     */
    public static void iteratorThroughPollFirst(LinkedList<Integer> list) {
        if (list == null) {
            return;
        }

        // 记录开始时间
        long start = System.currentTimeMillis();
        while (list.pollFirst() != null) {
        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        log.info("iteratorThroughPollFirst：" + interval + " ms");
    }

    /**
     * 通过pollLast()来遍历LinkedList
     */
    public static void iteratorThroughPollLast(LinkedList<Integer> list) {
        if (list == null) {
            return;
        }

        // 记录开始时间
        long start = System.currentTimeMillis();
        while (list.pollLast() != null) {
        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        log.info("iteratorThroughPollLast：" + interval + " ms");
    }

    /**
     * 通过removeFirst()来遍历LinkedList
     */
    public static void iteratorThroughRemoveFirst(LinkedList<Integer> list) {
        if (list == null) {
            return;
        }

        // 记录开始时间
        long start = System.currentTimeMillis();
        try {
            while (list.removeFirst() != null) {
            }
        } catch (NoSuchElementException e) {
        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        log.info("iteratorThroughRemoveFirst：" + interval + " ms");
    }

    /**
     * 通过removeLast()来遍历LinkedList
     */
    public static void iteratorThroughRemoveLast(LinkedList<Integer> list) {
        if (list == null) {
            return;
        }

        // 记录开始时间
        long start = System.currentTimeMillis();
        try {
            while (list.removeLast() != null) {
            }
        } catch (NoSuchElementException e) {
        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        log.info("iteratorThroughRemoveLast：" + interval + " ms");
    }
}
