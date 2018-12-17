package jvm;

/**
 * Created by xiongxiaoyu
 * Data:2018/5/30
 * Time:21:00
 *
 *
 * <clinit>是编译器自动收集类中的所有类变量的赋值动作和静态语句块(static{})中语句合并产生的。
 *
 * <clinit>()类构造器方法不同于实例构造器的<init>()
 * 		它自己会自动调用父类<clinit>()构造器子后再调用子类自身的
 *
 * 	父类的static{}块中的内容先于子类中的变量赋值操作
 *
 */
public class Clinit {

	public static void main(String[] args) {
		System.out.println(Sub.B);
	}

	static class Sub extends Parent{
		public static int B=A;
	}

	static class Parent{
		public static int A=1;
		static {
			A=3;
		}

	}


}


