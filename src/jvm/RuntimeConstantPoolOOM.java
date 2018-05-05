package jvm;

/**
 * Created by xiongxiaoyu
 * Data:2018/5/5
 * Time:15:27
 *
 * 运行时常量池异常导致的内存溢出异常
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 */
public class RuntimeConstantPoolOOM {


	//在永久代VM中运行会出现OOM，jdk1.7之后只会一直while循环
//	public static void main(String[] args) {
//		//使用List保持常量池的引用，避免Full GC回收行为
//		List<String> list=new ArrayList<>();
//		//10M的PermSize足够在integer范围产生OOM
//		int i=0;
//		while (true){
//			list.add(String.valueOf(i++).intern());
//		}
//	}



	//jdk1.7后，intern()不会把首次遇见的字符串实例复制到方法区永久代中，只在常量池中记录首次出现的实例引用，
	// 		而StringBuffer创建的对象实例会在Java堆上。
	// 		调用intern()返回的引用和StringBuffer创建的字符串实例是同一个。
	public static void main(String[] args) {
		String str1=new StringBuilder("计算器").append("软件").toString();
		String str2=new StringBuilder("ja").append("va").toString();
		System.out.println(str1.intern()==str1);
		System.out.println(str2.intern()==str2);
	}

}
