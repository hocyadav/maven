package com.executorservice.fixedThreadPool;

import com.executorservice.task.Task;

public class ThreadPoolConcept2 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {//100 task, 100 thread
            Thread thread = new Thread(new Task());
            thread.start();
        }

        String mainMethodThread = Thread.currentThread().getName();
        System.out.println("mainMethodThread = " + mainMethodThread);
    }
}
