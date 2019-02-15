package com.slife.java.share.biz.linkList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.slife.java.share.biz.linkList.dto.SingleLinkedList;

import lombok.extern.slf4j.Slf4j;

/**
 * 链表的测试类
 *
 * @author xujiali
 * @since 2019年2月13日 下午4:36:24
 */
@Slf4j
public class LinkListTest {

    @Test
    public void query() {
        LinkedList initialList = CommonLinkList.getLinkedList();

        // 通过Iterator遍历LinkedList
        CommonLinkList.iteratorLinkedListThruIterator(initialList);

        // 通过快速随机访问遍历LinkedList
        CommonLinkList.iteratorLinkedListThruForeach(initialList);

        // 通过for循环的变种来访问遍历LinkedList
        CommonLinkList.iteratorThroughFor2(initialList);

        // 通过PollFirst()遍历LinkedList
        CommonLinkList.iteratorThroughPollFirst(initialList);

        // 通过PollLast()遍历LinkedList
        CommonLinkList.iteratorThroughPollLast(initialList);

        // 通过removeFirst()遍历LinkedList
        CommonLinkList.iteratorThroughRemoveFirst(initialList);

        // 通过removeLast()遍历LinkedList
        CommonLinkList.iteratorThroughRemoveLast(initialList);

    }

    @Test
    public void init() {
        SingleLinkedList list = LinkListUtils.init(10);
        int i = 0;
        for (SingleLinkedList.Node x = list.getFirst(); x != null; x = x.getNext()) {
            log.info("第{}位置的node信息，item:{},next{}", i++, x.getItem(), JSON.toJSON(x.getNext()));
        }
    }

    @Test
    public void revert() {
        int count = 10;
        SingleLinkedList result = LinkListUtils.revert(10);
        log.info("单链表反转：{}", JSON.toJSON(result.toArray()));
    }

    @Test
    public void set() {
        Set<String> list = new HashSet<>();
        boolean result = list.add("1");
        log.info("result:{}", result);
        result = list.add("2");
        log.info("result:{}", result);
        result = list.add("2");
        log.info("result:{}", result);
    }

    @Test
    public void circle() {
        // 有环的单链表，创建的时候会报错：StackOverflowError
        SingleLinkedList circle = LinkListUtils.circle(10, 4);
        int i = 0;
        for (SingleLinkedList.Node x = circle.getFirst(); x != null; x = x.getNext()) {
            log.info("第{}位置的node信息，item:{},next{}", i++, x.getItem(), JSON.toJSON(x.getNext()));
            if (i > 10) {
                break;
            }
        }
        boolean result = SingleLinkedList.isExistCircleBySet(circle);
        log.info("set方法判断链表是否有环：{}", result);
        result = SingleLinkedList.isExistCircle(circle);
        log.info("快慢指针方法判断链表是否有环：{}", result);
    }

    @Test
    public void remove() {
        SingleLinkedList list = LinkListUtils.init(10);
        int i = 0;
        for (SingleLinkedList.Node x = list.getFirst(); x != null; x = x.getNext()) {
            log.info("第{}位置的node信息，item:{},next{}", i++, x.getItem(), JSON.toJSON(x.getNext()));
        }
        log.info("###################删除数据为1的链表###################");
        list.remove(1);
        i = 0;
        for (SingleLinkedList.Node x = list.getFirst(); x != null; x = x.getNext()) {
            log.info("第{}位置的node信息，item:{},next{}", i++, x.getItem(), JSON.toJSON(x.getNext()));
        }
        log.info("###################删除数据为5的链表###################");
        list.remove(5);
        i = 0;
        for (SingleLinkedList.Node x = list.getFirst(); x != null; x = x.getNext()) {
            log.info("第{}位置的node信息，item:{},next{}", i++, x.getItem(), JSON.toJSON(x.getNext()));
        }
    }

    @Test
    public void merge() {
        SingleLinkedList list = new SingleLinkedList();
        int count = 5;
        for (int i = 0; i < count; i++) {
            list.add((i + 1) * 2);
        }
        log.info("第一个有序链表为：{}", JSON.toJSON(list.getFirst()));
        SingleLinkedList list2 = new SingleLinkedList();
        for (int i = 0; i < count; i++) {
            list2.add(i * 2 + 1);
        }
        log.info("第二个有序链表为：{}", JSON.toJSON(list2.getFirst()));
        SingleLinkedList.Node result = SingleLinkedList.merge(list.getFirst(), list2.getFirst());
        log.info("两个链表合并后有序链表为：{}", JSON.toJSON(result));
    }

    @Test
    public void removeLast() {
        int count = 10;
        int n = 5;
        SingleLinkedList list = LinkListUtils.init(10);
        SingleLinkedList.Node head = SingleLinkedList.removeLast(list.getFirst(), n);
        log.info("链表删除倒数第{}个之后的链表为：{}", n, JSON.toJSON(head));
    }
}
