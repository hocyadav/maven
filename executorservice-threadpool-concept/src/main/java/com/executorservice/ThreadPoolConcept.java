package com.executorservice;

import com.executorservice.task.Task;

public class ThreadPoolConcept {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();
        String mainMethodThread = Thread.currentThread().getName();
        System.out.println("mainMethodThread = " + mainMethodThread);
    }
}
/*
mainMethodThread = main
taskThreadName = Thread-0

*/