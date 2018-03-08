package container.thread;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * @author �
 * @date ����ʱ�䣺2018��3��8�� ����2:44:21
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
