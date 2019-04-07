package mianshi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiongxiaoyu
 * Data:2019/3/10
 * Time:14:54
 */
public class ThreadPoolRejectedStrategy {

	private static SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static void main(String[] args) {
		int corePoolSize = 1;
		int maximumPoolSize = 1;
		BlockingQueue queue = new ArrayBlockingQueue<Runnable>(1);
		ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize,  maximumPoolSize,
				0, TimeUnit.SECONDS, queue ) ;
		pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
		for(int i=0;i<10;i++){
			final int index = i;
			pool.submit(new Runnable(){

				@Override
				public void run() {
					log(Thread.currentThread().getName()+"begin run task :"+index);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					log(Thread.currentThread().getName()+" finish run  task :"+index);
				}

			});
		}

		log("main thread before sleep!!!");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log("before shutdown()");

		pool.shutdown();

		log("after shutdown(),pool.isTerminated=" + pool.isTerminated());
		try {
			pool.awaitTermination(1000L, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log("now,pool.isTerminated=" + pool.isTerminated());
	}

	protected static void log(String string) {
		System.out.println(sdf.format(new Date())+"  "+string);
	}

}