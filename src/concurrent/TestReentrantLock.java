package concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/18
 * Time:21:47
 */
public class TestReentrantLock {

	public static void  main(String[] args) throws InterruptedException {
		 Thread t=new Thread(()-> {LockSupport.park(); System.out.println("exit");});
		 t.start();
		Thread.sleep(1000);
		LockSupport.unpark(t);
	}
}
