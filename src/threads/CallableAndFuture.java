package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/24
 * Time:15:20
 */
public class CallableAndFuture {


	public static class CallableTest implements Callable<String>{

		@Override
		public String call() throws Exception {
			return "Hello World";
		}
	}

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();

		Future<String> future = threadPool.submit(new CallableTest());

		try {
			System.out.println("waiting thread to finish");
			System.out.println(future.get());
		}catch (Exception e){
			e.printStackTrace();
		}


	}

}
