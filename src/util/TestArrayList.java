package util;

/**
 * Created by xiongxiaoyu
 * Data:2018/3/21
 * Time:21:48
 *
 *	动态数组，容量自动增长,类似于c语言动态内存申请。非线程安全，只能用于单线程，
 *	多线程通过Collection.synchronizedList(List l)返回一个线程安全的ArrayList类，
 *		或者使用concurrent并发包下的CopyOnWriteArrayList类。
 *	Serializable接口，支持序列化，能序列化传输；RandomAccess接口，支持通过下标序号
 *		的快速随机访问；Cloneable接口，能被克隆。
 *
 *
 *
 *
 *
 *
 *
 */
public class TestArrayList {

	public static void main(String[] args) {
//		ArrayList() a=new ArrayList();
	}

}
