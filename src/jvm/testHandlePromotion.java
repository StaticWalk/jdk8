package jvm;

/**
 * Created by xiongxiaoyu
 * Data:2018/5/20
 * Time:17:12
 *
 * 空间担保分配
 * VM args: -Xms20M  -Xmx20M  -Xmn10M  -XX:+PrintGCDetails   -XX:SurvivorRatio=8  -XX:-HandlePromotionFailure(jdk6后不在使用这个参数)
 *
 * JDK6后,规定：只要老年代的连续空间大于新生代对象总和或历次晋升的平均值大小，
 * 			就会Minor GC，否则Full GC
 */

public class testHandlePromotion {

	private static  final  int _1MB = 1024*1024;


	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte[] allocation1,allocation2,allocation3,allocation4,allocation5,allocation6,allocation7;
		allocation1 =new byte[2 * _1MB];
		allocation2 =new byte[2 * _1MB];
		allocation3 =new byte[2 * _1MB];
		allocation1 =null;
		allocation4 =new byte[2 * _1MB];
		allocation5 =new byte[2 * _1MB];
		allocation6 =new byte[2 * _1MB];
		allocation4 =null;
		allocation5 =null;
		allocation6 =null;
		allocation7 =new byte[2 * _1MB];
	}
}
