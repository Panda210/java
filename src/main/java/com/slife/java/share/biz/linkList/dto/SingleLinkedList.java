package com.slife.java.share.biz.linkList.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 单链表
 *
 * @author xujiali
 * @since 2019年2月14日 上午10:56:30
 */
@Slf4j
public class SingleLinkedList<E> {

    /**
     * 链表的长度
     */
    transient int     size = 0;

    /**
     * 头节点
     */
    transient Node<E> first;

    /**
     * 头节点位置
     */
    int               pos  = 0;

    public SingleLinkedList() {
        this.first = null;
    }

    @Data
    public static class Node<E> {
        E       item;
        Node<E> next;

        public Node() {

        }

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    /**
     * 返回链表的长度
     *
     * @return 长度
     */
    public int size() {
        return size;
    }

    /**
     * 获取头节点
     *
     * @return 头节点信息
     */
    public Node<E> getFirst() {
        return first;
    }

    public void setFirst(Node<E> first) {
        this.first = first;
    }

    /**
     * 单链表添加内容
     *
     * @param e 内容
     * @return 是否添加成功
     */
    public boolean add(E e) {
        Node<E> newNode = new Node(e, null);
        if (null == first) {
            first = newNode;
        } else {
            Node<E> temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * 单链表添加某个节点
     *
     * @param n 节点
     * @return 是否添加成功
     */
    public boolean add(Node n) {
        if (null == first) {
            first = n;
            size++;
            return true;
        }
        Node next = first;
        Node last = null;
        while (next != null) {
            last = next;
            next = next.next;
        }
        last.next = n;
        size++;
        return true;
    }

    /**
     * 获取index位置的数据
     *
     * @param index 下标
     * @return 数据
     */
    public E get(int index) {
        rangeCheck(index);
        return node(index).item;
    }

    /**
     * 超出范围描述
     *
     * @param index 索引
     * @return 描述语句
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /**
     * 判断是否超出范围
     *
     * @param index 下标索引
     */
    private void rangeCheck(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /**
     * 根据索引获取节点
     *
     * @param index 索引
     * @return 节点信息
     */
    Node<E> node(int index) {
        Node<E> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    /**
     * 单链表删除内容
     *
     * @param o 内容
     */
    public boolean remove(Object o) {
        Node<E> pre = null;
        if (null == o) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x, pre);
                    return true;
                }
                pre = x;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x, pre);
                    return true;
                }
                pre = x;
            }
        }
        return false;
    }

    /**
     * 删除链表节点
     *
     * @param x 需要删除的节点
     * @param pre 删除节点的前一个节点
     */
    void unlink(Node<E> x, Node<E> pre) {
        Node<E> next = x.next;
        // GC 处理x进行垃圾回收
        x.item = null;
        x.next = null;
        // 关联关系修改
        if (null == pre) {
            first = next;
        } else {
            pre.next = next;
        }
        size--;
    }

    /**
     * 获取数据的下标
     *
     * @param o 数据
     * @return 下标值
     */
    public int indexOf(Object o) {
        int index = 0;
        if (null == o) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    /**
     * 判断是否包含
     *
     * @param o 数据
     * @return 是否包含
     */
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * 解锁头节点
     *
     * @return 头节点信息
     */
    public E unlinkFirst() {
        E e = first.item;
        Node<E> temp = first;
        Node<E> next = first.next;
        temp.item = null;
        temp.next = null;
        first = next;
        size--;
        return e;
    }

    /**
     * 链表转成数组
     *
     * @return 数组
     */
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node node = first; node != null; node = node.next) {
            result[i++] = node.item;
        }
        return result;
    }

    /**
     * 单链表反转<br/>
     * <p>
     * 原有的链表为：1->2->3->4->5->6->7->8->9 <br/>
     * 反转之后的结果为： 9->8->7->6->5->4->3->2->1 <br/>
     * 时间复杂度：O(n)
     * </p>
     *
     * @return 反转的结果
     */
    public static SingleLinkedList revert(SingleLinkedList list) {
        if (null == list || null == list.first) {
            return null;
        }
        Node pre = null;
        Node cur = list.first;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        list.first = pre;
        return list;
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
        //        SingleLinkedList.Node preNode = list.getFirst();
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

    /**
     * 单链表环检测
     * <p>
     * 方法一：循环链表，将所有Node节点数据放到Set集合中，当插入数据的是否返回false，则说明有重复数据了
     * </p>
     *
     * @param list 单链表
     * @return 检测存在环则为true，否则为false
     */
    public static boolean isExistCircleBySet(SingleLinkedList list) {
        long startTime = System.currentTimeMillis();
        if (null == list || null == list.getFirst()) {
            return false;
        }
        Set nodeSet = new HashSet();
        boolean addResult = true;
        for (Node x = list.getFirst(); x != null; x = x.next) {
            addResult = nodeSet.add(x.item);
            if (!addResult) {
                // addResult=false，表示已经有重复的节点插入到set中，那么说明有环
                long endTime = System.currentTimeMillis();
                log.info("使用set方法判断是否有环的时间：{}", endTime - startTime);
                return true;
            }
        }

        return false;
    }

    /**
     * 单链表环检测
     * <p>
     * 方法二：快慢指针,快指针每次走两步，慢指针每次走一步，最后当快指针所指节点与慢指针所指向的节点出现一致，则认为有环。直到走到最终节点为止。
     * </p>
     *
     * @param list 单链表
     * @return 是否有环的结果
     */
    public static boolean isExistCircle(SingleLinkedList list) {
        long startTime = System.currentTimeMillis();
        if (null == list || null == list.getFirst()) {
            return false;
        }
        Node slow = list.getFirst();
        Node fast = list.getFirst().next;
        while (null != fast && null != fast.next && null != slow) {
            if (fast.item.equals(slow.item)) {
                long endTime = System.currentTimeMillis();
                log.info("使用快慢指针方法判断是否有环的时间：{}", endTime - startTime);
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    /**
     * 两个有序单链表进行合并
     *
     * @param listA 链表A
     * @param listB 链表B
     * @return 合并之后的链表
     */
    public static SingleLinkedList merge(SingleLinkedList result, SingleLinkedList listA, SingleLinkedList listB) {
        if (null == listA) {
            return listB;
        }
        if (null == listB) {
            return listA;
        }
        SingleLinkedList.Node p1 = listA.first;
        SingleLinkedList.Node p2 = listB.first;
        if (Integer.valueOf(p1.item.toString()) < Integer.valueOf(p2.item.toString())) {
            result.add(new Node(p1.item, null));
            listA.remove(p1.item);
            merge(result, listA, listB);
        } else {
            result.add(new Node(p2.item, null));
            listB.remove(p2.item);
            merge(result, listA, listB);
        }
        return result;
    }

    /**
     * 两个有序单链表进行合并
     *
     * @param p1 链表A的头节点
     * @param p2 链表B的头节点
     * @return 合并之后链表的头节点
     */
    public static SingleLinkedList.Node merge(SingleLinkedList.Node p1, SingleLinkedList.Node p2) {
        if (null == p1) {
            return p2;
        }
        if (null == p2) {
            return p1;
        }
        SingleLinkedList.Node result = null;
        if (Integer.valueOf(p1.item.toString()) < Integer.valueOf(p2.item.toString())) {
            result = p1;
            result.next = merge(p1.next, p2);
        } else {
            result = p2;
            result.next = merge(p1, p2.next);
        }
        return result;
    }

    /**
     * 删除链表倒数第n个结点
     * <p>
     * 要求n肯定是小于等于size<br/>
     * 快指针，先走n步，然后慢指针再走，当快指针走到最后的时候，慢指针所在的位置就是倒数第n个位置的前一个位置。<br/>
     * 快慢指针之间的间距为n
     * </p>
     *
     * @param n 倒数第n个节点 其实就是正数size-n个节点
     * @return 链表
     */
    public static SingleLinkedList.Node removeLast(SingleLinkedList.Node head, int n) {
        SingleLinkedList.Node fast = head;
        SingleLinkedList.Node slow = head;

        // 快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (null == fast) {
            head = head.next;
            return head;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }

}
