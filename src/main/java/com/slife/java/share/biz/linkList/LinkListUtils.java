package com.slife.java.share.biz.linkList;

import com.alibaba.fastjson.JSON;
import com.slife.java.share.biz.linkList.dto.SingleLinkedList;
import com.slife.java.share.biz.linkList.dto.SingleLinkedList.Node;

import lombok.extern.slf4j.Slf4j;

/**
 * 链表使用的一些常见的案例
 *
 * @author xujiali
 * @since 2019年2月13日 下午2:46:19
 */
@Slf4j
public class LinkListUtils {

    /**
     * 初始化 含有10000个节点的单链表
     *
     * @return 初始化的单链表
     * @param count 链表的长度
     */
    public static SingleLinkedList init(int count) {
        SingleLinkedList list = new SingleLinkedList();
        for (int i = 0; i < count; i++) {
            list.add(i + 1);
        }
        log.info("初始化的单链表：{}，长度为：{}", JSON.toJSON(list.toArray()), list.size());
        return list;
    }

    /**
     * 单链表反转<br/>
     * <p>
     * 原有的链表为：1->2->3->4->5->6->7->8->9 <br/>
     * 反转之后的结果为： 9->8->7->6->5->4->3->2->1
     * </p>
     *
     * @param count 链表的长度
     * @return 反转的结果
     */
    public static SingleLinkedList revert(int count) {
        SingleLinkedList list = init(count);
        log.info("下标为3的数据为：{}", list.get(3));
        return SingleLinkedList.revert(list);
    }

    /**
     * 创建有环的单链表
     *
     * @param count 单链表的个数
     * @param pos 第pos位置是环开始和结尾
     * @return 单链表
     */
    public static SingleLinkedList circle(int count, int pos) {
        SingleLinkedList list = new SingleLinkedList();
        SingleLinkedList.Node posNode = new Node();
        for (int i = 0; i < count; i++) {
            SingleLinkedList.Node node = new Node();
            node.setItem(i + 1);
            if (i == count - 1) {
                node.setNext(posNode);
            } else {
                node.setNext(null);

            }
            list.add(node);
            if (i == pos) {
                posNode = node;
            }
        }
        return list;
    }
}
