package com.executorservice;

import com.executorservice.task.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolConcept3 {

    public static void main(String[] args) {
        int numberOfCpuCores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfCpuCores);

        for (int i = 0; i < 100; i++) {//100 task, 16 thread(number of cores)
           Task task = new Task();
           executorService.submit(task);
        }

        String mainMethodThread = Thread.currentThread().getName();
        System.out.println("mainMethodThread = " + mainMethodThread);
    }
}
