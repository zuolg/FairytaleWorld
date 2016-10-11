package com.z.andutil.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadWorker {
    static ExecutorService executorService;


    public static int net_pool_size = 10;

    /**
     * 线程池里跑runnable
     *
     * @param runnable
     * @return
     */
    public static Future<?> executeRunalle(Runnable runnable) {
        if (executorService == null) {
            executorService = Executors.newFixedThreadPool(net_pool_size);
        }
        return executorService.submit(runnable);
    }

    public static Future execuse( final Task task) {
        //显示进度条

        Future future = executeRunalle(new Runnable() {
            @Override
            public void run() {
                try {
                    task.doInBackground();
                } catch (Exception e) {
                    task.transfer(null, Task.TRANSFER_DOERROR);
                    return;
                }
                task.transfer(null, Task.TRANSFER_DOUI);
            }
        });
        return future;
    }

}
