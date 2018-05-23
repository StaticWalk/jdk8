package jvm;

/**
 * Created by xiongxiaoyu
 * Data:2018/5/19
 * Time:22:37
 *
 *
 * 新生代Minor GC
 * V M Args:-verbose:gc -Xms20M  -Xmx20M  -Xms10M  -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *  Java堆大小20M，不可扩展，新生代10M，老年代10M， Eden:Survivor=8
 *
 */

public class testAllocation {

	private static  final  int _1MB = 1024*1024;

	public static void main(String[] args) {
		byte[] allocation1,allocation2,allocation3,allocation4;

		allocation1 =new byte[2 * _1MB];
		allocation2 =new byte[2 * _1MB];
		allocation3 =new byte[2 * _1MB];
		allocation4 =new byte[2 * _1MB];//出现第一次Minor GC

	}

}
