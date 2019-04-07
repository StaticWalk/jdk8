package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/25
 * Time:11:08
 */
public class LockTest {


	public static void main(String[] args) throws InterruptedException {
		final Lock lock = new ReentrantLock();
		lock.lock();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.lockInterruptibly();

				} catch (InterruptedException e) {
					System.out.println("interrupted");
				}
			}
		});

		t1.start();
		t1.interrupt();
		Thread.sleep(1);



	}

}
