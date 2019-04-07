package concurrent;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/17
 * Time:15:55
 */
public class TestConsumer {
	public static void main(String[] args) throws InterruptedException {
		MyBlockingQueue<String> queue=new MyBlockingQueue<>(10);
		for (int i = 0; i < 5; i++) {
			new Producer(String.valueOf(i),queue).start();
			new Consumer(String.valueOf(i),queue).start();
		}
		Thread.sleep(3000);
//		new Producer(queue).start();
//		new Consumer(queue).start();
	}
}

//典型的生产者/消费者协助队列
class MyBlockingQueue<E>{
	private Queue<E> queue=null;
	private int limit;
	public MyBlockingQueue(int limit){
		this.limit=limit;
		queue=new ArrayDeque<>(limit);
	}
	//生产者添加资源使用
	public synchronized void  put(E e) throws InterruptedException{
		while (queue.size()==limit){
			wait();
		}
		queue.add(e);
		System.out.println("producer "+Thread.currentThread().getName());
		notifyAll();
	}
	//消费者消耗资源使用
	public synchronized E take() throws InterruptedException{
		while (queue.isEmpty()){
			wait();
		}
		E e=queue.poll();
		notifyAll();
		System.out.println("consumer " + Thread.currentThread().getName());

		return e;
	}
	public synchronized int size() throws InterruptedException{
		return queue.size();
	}

}

class Producer extends Thread{
	MyBlockingQueue<String> queue;
	public Producer(String name,MyBlockingQueue queue){
		this.setName(name);
		this.queue=queue;
	}
	 @Override
	 public void run() {
		 try{

		 	while (true){
				Thread.sleep((int)(Math.random()*1000));

				String task=String.valueOf(Math.random());
		 		queue.put(task);
//				System.out.println("Producer " + getName()+",produce size"+ queue.size());

			}
		 } catch (InterruptedException e) {
			 e.printStackTrace();
		 }
	 }
 }

class Consumer extends Thread{
	MyBlockingQueue<String> queue;
	public Consumer(String name,MyBlockingQueue queue){
		this.setName(name);
		this.queue=queue;
	}
	@Override
	public void run() {
		try{
			while (true){
				Thread.sleep((int)(Math.random()*1000));
				queue.take();
//				System.out.println("Consumer " + getName()+",consume size"+ queue.size());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

