package concurrent;

/**
 * Created by xiongxiaoyu
 * Data:2019/1/17
 * Time:16:04
 *
 *
 * 学习java的线程池
 *
 * ThreadPoolExecutor.java
 *
 */
public class TestThreadPool {

	public static void main(String[] args) {
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 200, TimeUnit.MILLISECONDS,
//				new ArrayBlockingQueue<Runnable>(2));
//
//		for (int i = 0; i < 4; i++) {
//			MyTask myTask = new MyTask(i);
//			executor.execute(myTask);
//			System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
//					executor.getQueue().size() + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
//		}
//		executor.shutdown();

		System.out.println((-1)<<29);
	}

}

class MyTask implements Runnable {
	private int taskNum;

	public MyTask(int num) {
		this.taskNum = num;
	}

	@Override
	public void run() {
		System.out.println("正在执行task " + taskNum);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task " + taskNum + "执行完毕");
	}

}