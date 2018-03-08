package container.thread;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * @author 阮航
 * @date 创建时间：2018年3月8日 下午2:44:21
 * @version 1.0
 */
public class LockRace extends Thread {

	public synchronized void method1() {
        System.out.println("method1-----");
        method2();
    }

    public synchronized void method2() {
        System.out.println("method2-----");
        method3();
    }

    public synchronized void method3() {
        System.out.println("method3-----");
    }

    public static void main(String[] args) {
        final LockRace syncDubbo = new LockRace();
        new Thread(new Runnable() {
            @Override
            public void run() {
                syncDubbo.method1();
            }
        }).start();
    }
}
