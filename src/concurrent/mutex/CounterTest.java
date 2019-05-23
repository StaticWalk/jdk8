package concurrent.mutex;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xiongxiaoyu
 * Data:2019/4/10
 * Time:18:21
 */
public class CounterTest {

	static CountDownLatch cdl = new CountDownLatch(1000);
	static AtomicInteger ai = new AtomicInteger(0);
	static int x = 0;

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newFixedThreadPool(1000);
		for (int i = 0; i < 1000; i++) {
			exec.execute(new Runnable() {
				@Override
				public void run() {
//					System.out.println(ai.incrementAndGet());
					x++;
					cdl.countDown();
				}
			});
		}
		cdl.await();
//		System.out.println(ai.get());
		System.out.println(x);
		exec.shutdown();
	}







//	//公共变量
//	int count=0;
//	public static void main(String[] args){
//		//new一个实现Runnable的类
//		CounterTest test=new CounterTest();
//		MyRunnable myRunnable1=test.new MyRunnable();
//		//创建5个线程
//		for (int i = 0; i < 5; i++) {
//			new Thread(myRunnable1).start();
//		}
//	}
//	//创建一个实现Runnable的类
//	class MyRunnable implements Runnable{
//		public void run() {
//			while(true){
//				//锁住的是整个MyRunnable类
//				synchronized(this){
////				synchronized(MyRunnable.class){
//					if(count>=1000){
//						break;
//					}
//					System.out.println(Thread.currentThread().getName()+":count:"+(++count));
//					//测试时，线程更容易切换
//					Thread.yield();
//				}
//			}
//		}
//	}


}
