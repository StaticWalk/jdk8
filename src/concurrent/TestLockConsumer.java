package concurrent;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/19
 * Time:15:44
 */
public class TestLockConsumer {
}

 class MyLockBlockingQueue<E> {
	private Queue<E> queue=null;
	private int limit;
	private Lock lock=new ReentrantLock();
	private Condition notFull=lock.newCondition();
	private Condition notEmpty=lock.newCondition();

	 public MyLockBlockingQueue(int limit) {
		 this.limit = limit;
	 }
	 public void put(E e) throws InterruptedException{
	 	lock.lockInterruptibly();
	 	try{
	 		while (queue.size()==limit){
	 			notFull.await();
			}
			queue.add(e);
	 		notEmpty.signal();
		}finally {
	 		lock.unlock();
		}
	 }

	 public E take() throws InterruptedException{
		 lock.lockInterruptibly();
		 try{
			 while (queue.isEmpty()){
				 notEmpty.await();
			 }
			 E e=queue.poll();
			 notFull.signal();
			 return e;
		 }finally {
			 lock.unlock();
		 }
	 }
 }


