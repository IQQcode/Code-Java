package dahua;

/**
 * @Author: iqqcode
 * @Date: 2020-10-01 16:25
 * @Description: 有4个线程分别获取C、D、E、F盘的大小，第5个线程统计总大小
 */

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DiskMemory {
    // 记录磁盘的总大小
    private int totalSize;

    // 获取一个磁盘的大小，采用随机数生成
    public int getSize() {
        //加一是为了防止获取磁盘大小为0，不符合常理
        return (new Random().nextInt(3) + 1) * 100;
    }

    //统计磁盘空间的大小
    public synchronized void setSize(int size) {
        totalSize += size;
    }

    // 获得总磁盘空间的大小
    public int getTotalSize() {
        return totalSize;
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池，初始化大小为 4
        ExecutorService service = Executors.newFixedThreadPool(4);
        CountDownLatch countDownLatch = new CountDownLatch(4);
        DiskMemory diskMemory = new DiskMemory();
        for (int i = 0; i < 4; i++) {
            service.execute(() -> {
                int timer = new Random().nextInt(5);
                try {
                    Thread.sleep(timer * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int diskSize = diskMemory.getSize();
                System.out.printf("完成磁盘的统计任务,耗费%d秒. 磁盘大小为%d.\n", timer, diskSize);
                diskMemory.setSize(diskSize);

                // 任务完成，计数器减一
                countDownLatch.countDown();
                System.out.println("count num = " + countDownLatch.getCount());
            });
        }
        // 主线程一直被阻塞,直到count的计数器被置为0
        countDownLatch.await();
        System.out.printf("全部磁盘都统计完成,所有磁盘总大小为 " + ", 【 totalSize = " + diskMemory.getTotalSize() + " 】");
        service.shutdown();
    }
}
