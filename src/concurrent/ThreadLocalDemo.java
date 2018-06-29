package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xiongxiaoyu
 * Data:2018/6/29
 * Time:16:49
 *
 * ThreadLocal为解决多线程程序的并发问题提供了一种新思路
 * 			  目的是为了解决多线程访问时的共享问题
 *
 */
public class ThreadLocalDemo {
	public static void main(String[] args) throws InterruptedException {
		int threads = 3;
		CountDownLatch countDownLatch = new CountDownLatch(threads);
		InnerClass innerClass = new InnerClass();
		for(int i = 1; i <= threads; i++) {
			new Thread(() -> {
				for(int j = 0; j < 4; j++) {
					innerClass.add(String.valueOf(j));
					innerClass.print();
				}
				innerClass.set("hello world");
				countDownLatch.countDown();
			}, "thread - " + i).start();
		}
		countDownLatch.await();
	}
	private static class InnerClass {
		public void add(String newStr) {
			StringBuilder str = Counter.counter.get();
			Counter.counter.set(str.append(newStr));
		}
		public void print() {
			System.out.printf("Thread name:%s , ThreadLocal hashcode:%s, Instance hashcode:%s, Value:%s\n",
					Thread.currentThread().getName(),
					Counter.counter.hashCode(),
					Counter.counter.get().hashCode(),
					Counter.counter.get().toString());
		}
		public void set(String words) {
			Counter.counter.set(new StringBuilder(words));
			System.out.printf("Set, Thread name:%s , ThreadLocal hashcode:%s,  Instance hashcode:%s, Value:%s\n",
					Thread.currentThread().getName(),
					Counter.counter.hashCode(),
					Counter.counter.get().hashCode(),
					Counter.counter.get().toString());
		}
	}
	private static class Counter {
		private static ThreadLocal<StringBuilder> counter = new ThreadLocal<StringBuilder>() {
			@Override
			protected StringBuilder initialValue() {
				return new StringBuilder();
			}
		};
	}
}