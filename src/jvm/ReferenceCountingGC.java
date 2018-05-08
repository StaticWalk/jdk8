package jvm;

/**
 * Created by xiongxiaoyu
 * Data:2018/5/6
 * Time:15:11
 *
 * 引用技术算法的缺陷
 *
 */
public class ReferenceCountingGC {

	public Object instance = null;

	private static final int _1MB = 1024*1024;

	//用来站点内存，方便GC日志中能看清楚是否被回收过
	private byte[] bigSize =new byte[2 * _1MB];


	public static void main(String[] args) {
		ReferenceCountingGC a=new ReferenceCountingGC();
		a.testGC();
	}

	public  void testGC(){
		ReferenceCountingGC objA=new ReferenceCountingGC();
		ReferenceCountingGC objB=new ReferenceCountingGC();
		objA.instance=objB;
		objB.instance=objA;
		objA=null;
		objB=null;
		System.gc();
	}
}
