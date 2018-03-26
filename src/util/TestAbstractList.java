package util;

import java.util.AbstractList;

/**
 * Created by xiongxiaoyu on 2018/3/14.
 *
 * AbstractColltion抽象类本身以及被继承的时候，都有一个protected无参构造器
 * add(),remove(),set()的调用，抛出UnsupportedOperationException()
 * 实现了一个私有类Itr
 *
 */
public class TestAbstractList {
	public static void main(String[] args) {
		AbstractList al=new AbstractList() {
			@Override
			public Object get(int index) {
				return null;
			}

			@Override
			public int size() {
				return 0;
			}
		};


	}
}
