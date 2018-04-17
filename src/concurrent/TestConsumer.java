package concurrent;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/17
 * Time:15:55
 */
public class TestConsumer {
	public static void main(String[] args) {
		MyBlockingQueue<String> queue=new MyBlockingQueue<>(10);
		new Producer(queue).start();
		new Consumer(queue).start();
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
		notifyAll();
	}
	//消费者消耗资源使用
	public synchronized E take() throws InterruptedException{
		while (queue.isEmpty()){
			wait();
		}
		E e=queue.poll();
		notifyAll();
		return e;
	}
}

 class Producer extends Thread{
	MyBlockingQueue<String> queue;
	public Producer(MyBlockingQueue queue){
		this.queue=queue;
	}
	 @Override
	 public void run() {
		 int num=0;
		 try{
		 	while (true){
		 		String task=String.valueOf(num);
		 		queue.put(task);
				System.out.println("produce task"+ task);
				num++;
				Thread.sleep((int)(Math.random()*1000));

			}
		 } catch (InterruptedException e) {
			 e.printStackTrace();
		 }
	 }
 }

 class Consumer extends Thread{
	MyBlockingQueue<String> queue;
	public Consumer(MyBlockingQueue queue){
		this.queue=queue;
	}
	@Override
	public void run() {
		try{
			while (true){
				String task=queue.take();
				System.out.println("consume task"+ task);
				Thread.sleep((int)(Math.random()*1000));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

