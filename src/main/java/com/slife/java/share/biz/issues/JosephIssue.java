package com.slife.java.share.biz.issues;

import java.util.ArrayList;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * 约瑟夫问题 <br/>
 * N个人围城一圈，从第一个开始报数，第M个人将被杀掉，如此往复，直到剩下一个人
 *
 * @author xujiali
 * @since 2019年2月13日 下午2:48:37
 */
@Slf4j
public class JosephIssue {

    /**
     * 初始化总人数的数据
     *
     * @param count 总人数
     * @return
     */
    public static int[] initial(int count) {
        int[] result = new int[count];
        if (count < 0) {
            return null;
        }
        log.info("initial总人数：{}", JSON.toJSON(result));
        return result;
    }

    /**
     * 采用数组的方式来实现约瑟夫问题的解法 <br/>
     * 1、每个人员初始存活标记为0，如果被杀死，则标记为1。 <br/>
     * 2、每次数数都是number + 1 - initialArray[index] 被杀死其实实际没有计数算入 <br/>
     * 3、时间复杂度为：O(n)
     *
     * @param count 总人数
     * @param doom 第doom个人杀死
     * @return 返回杀死的人的序号
     */
    public static ArrayList<String> josephByArray(int count, int doom) {
        long startTime = System.currentTimeMillis();
        ArrayList<String> result = new ArrayList<>();

        int[] initialArray = initial(count);
        // 人员报数序号
        int index = 0;
        // 存活人数
        int alive = count;
        // 计数
        int number = 0;

        if (null != initialArray) {
            while (alive > 0) {
                number = number + 1 - initialArray[index];

                if (number == doom) {
                    // 在计数到第doom个人的时候，存活人数减去1，计数清0，被杀掉的人值修改为1
                    alive--;
                    number = 0;
                    initialArray[index] = 1;
                    int killNumber = index + 1;
                    result.add("P" + killNumber);
                }

                // 报数序号后移 - 保证收尾相连
                index = (index + 1) % count;
            }
        }
        long endTime = System.currentTimeMillis();
        log.info("花费的时间：{}", endTime - startTime);
        return result;
    }

    /**
     * 采用数组的方式来实现约瑟夫问题的解法 <br/>
     * 1、 <br/>
     * 2、每次数数都是number + 1 - initialArray[index] 被杀死其实实际没有计数算入 <br/>
     * 3、时间复杂度为：O(n)
     *
     * @param count 总人数
     * @param doom 第doom个人杀死
     * @return 返回杀死的人的序号
     */
    public static ArrayList<String> josephByArray2(int count, int doom) {
        long startTime = System.currentTimeMillis();
        ArrayList<String> result = new ArrayList<>();

        int[] initialArray = new int[count];
        for (int i = 0; i < count; i++) {
            initialArray[i] = (i + 1) % count;
        }
        log.info("initialArray:{}", JSON.toJSON(initialArray));
        // 当前下标
        int curIndex = 0;
        // 前一个人的下标
        int preIndex = count - 1;
        // 存活人数
        int alive = count;
        // 计数
        int number = 0;

        if (null != initialArray) {
            while (alive > 0) {
                number++;

                if (number == doom) {
                    // 在计数到第doom个人的时候，存活人数减去1，计数清0，将删除的人员移除
                    alive--;
                    number = 0;
                    initialArray[preIndex] = initialArray[curIndex];
                    result.add("P" + initialArray[curIndex]);
                } else {
                    preIndex = curIndex;
                }

                curIndex = initialArray[curIndex];
                log.info("number:{},alive:{},preIndex:{},curIndex:{}", number, alive, preIndex, curIndex);
            }
        }
        long endTime = System.currentTimeMillis();
        log.info("花费的时间：{}", endTime - startTime);
        return result;
    }

}
