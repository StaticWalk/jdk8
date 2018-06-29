package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xiongxiaoyu
 * Data:2018/6/29
 * Time:16:49
 *
 * ThreadLocal为解决多线程程序的并发问题提供了一种新思路
 * 			  目的是为了解决多线程访问时的共享问题   ?? 错误的理解
 *
 * ThreadLocal 适用于每个线程需要自己独立的实例且该实例需要在多个方法中被使用，也即变量在线程间隔离而在方法或类间共享的场景。
 *
 * ThreadLocal维护线程和实例的映射  1.线程的增删需要保证线程安全 2.映射回收/内存泄漏问题
 * Thread来维护ThreadLocal和实例的映射    不存在锁的问题，映射带来的内存回收问题
 * 		ThreadLocalMap 中的Entry是弱引用，当无强引用指向ThreadLocal会被自动回收
 * 		与 HashMap 不同的是，ThreadLocalMap 的每个 Entry 都是一个对 键 的弱引用，这一点从super(k)可看出。另外，每个 Entry 都包含了一个对 值 的强引用。
 * 		当 ThreadLocal 变量被回收后，该映射的键变为 null，该 Entry 无法被移除。从而使得实例被该 Entry 引用而无法被回收造成内存泄漏。
 * 	注：Entry虽然是弱引用，但它是 ThreadLocal 类型的弱引用（也即上文所述它是对 键 的弱引用），而非具体实例的的弱引用，所以无法避免具体实例相关的内存泄漏。
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
		private static ThreadLocal<StringBuilder> counter = ThreadLocal.withInitial(() -> new StringBuilder());
	}
}