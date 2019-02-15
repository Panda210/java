package com.slife.java.share.biz.issues;

import java.util.ArrayList;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * 约瑟夫问题的测试
 *
 * @author xujiali
 * @since 2019年2月13日 下午3:35:46
 */
@Slf4j
public class JosephTest {

    @Test
    public void initial() {
        int[] result = JosephIssue.initial(100);
        log.info("初始化总人数:{}", JSON.toJSON(result));
    }

    @Test
    public void josephByArray() {
        ArrayList<String> result = JosephIssue.josephByArray(100, 5);
        log.info("总人数100，每次杀第5个人，人员顺序：{}", JSON.toJSON(result));
    }

    @Test
    public void josephByArray2() {
        ArrayList<String> result = JosephIssue.josephByArray2(100, 5);
        log.info("总人数100，每次杀第5个人，人员顺序：{}", JSON.toJSON(result));
    }
}
