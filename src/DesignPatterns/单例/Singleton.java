package DesignPatterns.单例;

/**
 * Created by xiongxiaoyu
 * Data:2019/4/7
 * Time:18:40
 */
public class Singleton {

	//1.懒汉 线程不安全  (之后的都是线程安全的)
//	private static Singleton instance;
//	private Singleton() { }
//	public static Singleton getInstance(){
//		if (instance == null){
//			instance = new Singleton();
//		}
//		return instance;
//	}

	//2.懒汉 线程安全 必须加锁synchronized 会影响效率
//	private static Singleton instance;
//	private Singleton() { }
//	public static synchronized Singleton getInstance(){
//		if (instance == null){
//			instance = new Singleton();
//		}
//		return instance;
//	}

	//3.饿汉 容易产生垃圾对象
	// 通过类加载机制避免了多线程的同步问题 类加载时就实例化了
//	private static Singleton instance = new Singleton();
//	private Singleton() { }
//	public static Singleton getInstance(){
//			return instance;
//	}

	//4.双重锁/双重校验所 DCL double-checked locking
	//双锁机制 多线程下保持高性能
	//volatile禁止指令重排序 可见性
	//
//	private volatile static Singleton instance;
//	private Singleton() { }
//	public static Singleton getInstance(){
//	if(instance == null){
//		synchronized (Singleton.class) {
//			if (instance == null) {
	//1.分配对象空间 2.初始化对象 3.设置single指向内存空间
//				instance = new Singleton();
//			}
//			}
//		}
//		return instance;
//	}


	//5.静态内部类只会在被使用的时候才会被加载
	// 有双检锁的效果，而且可以延迟加载
	private static class SingletonHolder{
		private static final Singleton INSTANCE = new Singleton();
	}
	private Singleton() { }
	public static final Singleton getInstance(){
		return SingletonHolder.INSTANCE;
	}

	//6.枚举类型 不能Lazy初始化
//	public enum Singleton {
//		INSTANCE;
//		public void whateverMethod() {
//		}
//	}

}
