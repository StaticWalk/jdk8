package util;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * Created by xiongxiaoyu on 2018/3/13.
 *
 * 抽象对象不能实例化（Java规范规定）
 * 继承实现一个抽象类，要先根据自己要求实现其中的自定义方法
 * iterator(),size(),如果需要用到添加，必须重写add()方法
 *
 * Object类常用方法
 *  native registerNatives()
 *  Class<?> getClass()
 *  int hashCode()
 *  boolean equals(Objecy obj)
 *  toString(){getClass().getName() + "@" + Integer.toHexString(hashCode()); }
 *  notify() if the current thread is not the owner of this object's monitor
 *  wait(long time,int nanos)
 */
public class TestAbstracCollection {

	//匿名内部类（实质是创建了一个AbstractCollection的子类）
	AbstractCollection abstractCollection=new AbstractCollection() {
		@Override
		public Iterator iterator() {
			return null;
		}
		@Override
		public int size() {
			return 0;
		}
	};
	public static void main(String[] args) {
		TestAbstracCollection testAbstracCollection=new TestAbstracCollection();
		System.out.println(testAbstracCollection.abstractCollection.size());
//		testAbstracCollection.abstractCollection.add("99");
//		System.out.println(testAbstracCollection.abstractCollection.contains("00"));
	}
}
