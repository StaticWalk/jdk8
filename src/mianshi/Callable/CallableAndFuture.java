package mianshi.Callable;

import java.util.concurrent.*;

/**
 * Created by xiongxiaoyu
 * Data:2019/3/17
 * Time:15:46
 */
public class CallableAndFuture {


	public static class CallableTest implements Callable<String>{

		@Override
		public String call() throws Exception {
			Thread.sleep(10000);
			return "Hello";
		}
	}


	public static class CallableTestA implements Callable<String>{

		@Override
		public String call() throws Exception {

			return "HelloA";
		}
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {


		//会阻塞线程 最后给出一个返回值结果0
		ExecutorService service =Executors.newFixedThreadPool(5);

		Future<String> future = service.submit(new CallableTest());
		Future<String> futureA = service.submit(new CallableTestA());

		System.out.println(future.get());
		System.out.println(futureA.get());
	}


}
