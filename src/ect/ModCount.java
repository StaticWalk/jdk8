package ect;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by xiongxiaoyu
 * Data:2018/3/22
 * Time:22:39
 *
 *
 * modify count修改次数，记录ArrayList,LinkedList,HashMap等非线程安全类的内部增删改实现
 * ArrayList的remove(int index),remove(O o),remove(int fromIndex,int toIndex),add会
 * 		修改掉modCount的值
 * ArrayList实现的hasNext(),return cursor!=size();当remove()后cursor=1,size()=0,外部陷
 * 		入死循环，next()中引入modCount通过checkForComodification，判断满足i>=size,
 * 		抛出ConcurrentModificationException()。
 *
 *
 * 非线程安全的集合操作中，避免一个线程正在迭代遍历被另外的线程修改这个列表的结构，引入了
 * 		ConcurrentModificationException。异常原因和解决办法：
 * 1.异常出现的原因：调用list.remove()方法导致modCount和expectedModCount的值不一致。
 * 2.单线程下的解决办法：使用迭代器自带的iterator.remove()删除元素
 * 3.多线程下的解决办法：@RunWithThreads.java
 */
public class ModCount {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			Integer integer = iterator.next();
			if(integer==10)
//				list.remove(integer);   //注意这个地方
				iterator.remove();
		}

	}
}
