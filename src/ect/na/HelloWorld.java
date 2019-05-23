package ect.na;

import java.util.concurrent.*;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/13
 * Time:16:37
 */
public class HelloWorld {
//	public native void displayHelloWorld();//所有native关键词修饰的都是对本地的声明
//	static {
//		System.loadLibrary("hello");//载入本地库
//	}
//	public static void main(String[] args) {
//		new HelloWorld().displayHelloWorld();
//	}

	public static void main(String[] args) {

		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5,10, 10,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(5),new MyTF());


	}

	static class MyTF implements ThreadFactory{



		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread();
			return t;
		}
	}


}
