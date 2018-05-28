package jvm;

/**
 * Created by xiongxiaoyu
 * Data:2018/5/27
 * Time:21:32
 *
 * 三种被动使用类字段
 * 1.
 * 被动使用类字段
 * 通过子类引用父类的静态字段，不会导致子类初始化
 * 可以通过在args里面添加 -XX:TraceClassLoading 来触发子类的加载
 *
 * 2.通过数组定义来引用类不会触发此类的初始化
 *
 * 3.常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，不会触发定义常量的类的初始化
 * 		编译阶段中常量传播优先，先将HELLOWORLD的值存入到了常量池中
 *
 */
public class NotInitialization {

	public static void main(String[] args) {
		//1.
//		System.out.println(SubClass.value);

		//2.
//		SuperClass[]  a=new SuperClass[10];

//		3.
		System.out.println(ConstClass.HELLOWORLD);

	}

}

class SuperClass{
	static {
		System.out.println("SuperClass init!");
	}
	public  static int value=123;
}

class SubClass extends SuperClass{
	static {
		System.out.println("SubClass init!");
	}
}

class  ConstClass{
	static{
		System.out.println("ConstClass init!");
	}
	public static final String  HELLOWORLD="hello world";
}