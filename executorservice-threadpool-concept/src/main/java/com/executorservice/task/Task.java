package com.executorservice.task;

public class Task implements Runnable {
    public void run() {
        String taskThreadName = Thread.currentThread().getName();
        System.out.println("taskThreadName = " + taskThreadName);
    }
}
