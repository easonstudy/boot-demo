package com.guo.bootcanal.web;

import com.alibaba.otter.canal.common.CanalLifeCycle;
import com.alibaba.otter.canal.server.CanalServer;

/**
 * 详情查看.
 * https://github.com/alibaba/canal/wiki/DevGuide
 */
public class TestCanal {

    private static Object lock = new Object();

    public static void main(String[] args) {
        //CanalLifeCycle;
        // CanalEventParser;
        // CanalEventSink;
        // CanalEventStore
        // CanalInstance
        // CanalHAController;
        //CanalServer
        System.out.println(Integer.bitCount(5));
        try {
            hello();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hello() {
        try {
            int i = 4/0;
        } catch (Exception e) {
            //e.printStackTrace();
            throw new TestException("错误:" , e.getMessage());
        }
    }

}
