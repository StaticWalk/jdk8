package concurrent;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/16
 * Time:21:33
 */
public class TestHello {
	public static void main(String[] args) {



		//runnable也有可能是在等待os分配时间片
		//调用run 不会新开线程，只是调用了方法  当前线程只有main
//		HelloThread thread= new HelloThread();
//		thread.run();


		//start()会启动该线程，os会为这个线程分配资源 当前线程有thread和main
		HelloThread thread= new HelloThread();
		System.out.println(thread.getState());
//		thread.start();
	}
}
class HelloThread extends Thread{
	@Override
	public void run() {
		System.out.println("thread name :"+Thread.currentThread().getName()+"  state:"+Thread.currentThread().getState());
		System.out.println("hhh");
	}
}