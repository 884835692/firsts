package com.ljh.firsts.job;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledExample {

    // @Scheduled(fixedRate = 5000)
    // 上一次开始执行时间点之后5秒再执行
    public void job1() {
        System.out.println(Thread.currentThread() + " now is " + LocalTime.now());
    }

    // @Scheduled(fixedDelay = 5000)
    // 上一次执行完毕时间点之后5秒再执行
    public void job2() {
        System.out.println(Thread.currentThread() + " now is " + LocalTime.now());
    }

    // @Scheduled(initialDelay = 1000, fixedRate = 5000)
    // 第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
    public void job3() {
        System.out.println( Thread.currentThread() + " now is " +  LocalTime.now());
    }

    @Scheduled(cron = "0/3 * * * * ?")
    // cron表达式
    public void job4() {
        System.out.println( Thread.currentThread() + " now is " + LocalTime.now());
    }
}