package com.executorservice.fixedThreadPool;

import com.executorservice.task.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolConcept2_es {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {//100 task, 10 thread in 1 pool
           Task task = new Task();
           executorService.submit(task);
        }

        String mainMethodThread = Thread.currentThread().getName();
        System.out.println("mainMethodThread = " + mainMethodThread);
    }
}
