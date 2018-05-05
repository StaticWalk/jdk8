package jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by xiongxiaoyu
 * Data:2018/5/5
 * Time:21:08
 *
 * 使用unsafe分配本机内存
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 *
 */
public class DirectMemoryOOM {
	private static final int _1MB = 1024*1024;

	public static void main(String[] args) throws IllegalAccessException {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe=(Unsafe)unsafeField.get(null);
		while (true){
			unsafe.allocateMemory(_1MB);
		}

	}
}
