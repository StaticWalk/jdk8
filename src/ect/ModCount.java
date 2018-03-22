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
 *
 *
 *
 *
 *
 */
public class ModCount {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			Integer integer = iterator.next();
			if(integer==10)
				list.remove(integer);   //注意这个地方
		}

	}
}
