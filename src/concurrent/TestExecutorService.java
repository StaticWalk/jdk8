package concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiongxiaoyu
 * Data:2019/3/8
 * Time:19:23
 */
public class TestExecutorService {


	public static void main(String[] args) {


//		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//
//		)







//		ExecutorService cachedThreadPool = newCachedThreadPool();
//		for (int i = 0; i < 10; i++) {
//			final int index = i;
//			try {
//				Thread.sleep(index * 1000);
//			}
//			catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//
//			cachedThreadPool.execute(new Runnable() {
//
//				@Override
//				public void run() {
//					System.out.println(index + Thread.currentThread().getName());
//				}
//			});
//		}


//		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//		for (int i = 0; i < 10; i++) {
//			final int index = i;
//			fixedThreadPool.execute(new Runnable() {
//				@Override
//				public void run() {
//					try {
//						System.out.println(index);
//						Thread.sleep(2000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			});
//		}


		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("delay 3 seconds");
			}
		},0, 3, TimeUnit.SECONDS);
	}


}
