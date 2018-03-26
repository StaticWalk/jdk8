package ect;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by xiongxiaoyu
 * Data:2018/3/23
 * Time:22:39
 *
 * 使用Vector情况不变，虽然它的方法使用了synchronized进行了同步，Vector继承的
 * 		AbstractList，通过Iterator容器不需要锁就能访问，而modCount是AbstractLost
 * 		成员变量，无锁就肯定会出现一个线程操作了元素，影响其他线程modCount和expectedModCount
 *		不等。
 *
 * 线程1中的expectedModCount值为0，虽然modCount不是volatile变量，不保证线程1一定看得到线程2
 * 			修改后的modCount的值，但是也有可能看得到线程2对modCount的修改，这样就有可能导致
 * 			线程1中比较expectedModCount和modCount不等，而抛出异常。
 *
 * 	1）在使用iterator迭代的时候使用synchronized或者Lock进行同步；
 *　2）使用并发容器CopyOnWriteArrayList代替ArrayList和Vector。
 */
public class RunWithThreads {

	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args)  {

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		Thread thread1 = new Thread(){
			public  void run() {
				Iterator<Integer> iterator = list.iterator();
				while(iterator.hasNext()){
					Integer integer = iterator.next();
					System.out.println(integer);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		};
		Thread thread2 = new Thread(){

			public  void run() {
				Iterator<Integer> iterator = list.iterator();
				while(iterator.hasNext()){
					Integer integer = iterator.next();
					if(integer==2)
						iterator.remove();//会修改线程2modCount和expectedModCount值为1
				}
			};
		};
		thread1.start();
		thread2.start();
	}
}
