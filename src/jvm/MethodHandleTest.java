package jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * Created by xiongxiaoyu
 * Data:2018/12/17
 * Time:15:56
 *
 *  Method Handle 基础用法演示
 */
public class MethodHandleTest {

	static class ClassA{
		public void println(String a){
			System.out.println(a);
		}
	}

	public static void main(String[] args) throws Throwable {
		Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();

		//不论obj最终是哪个实现类，下面这句都能够正确调用到println方法
		getPrintlnMN(obj).invoke("abcdefg");


	}

	private static MethodHandle getPrintlnMN(Object reveiver) throws Exception {

		//MethodType：代表“方法类型”包含了方法的返回值(methodType()的第一个参数)和具体参数(methodTYpe()第二个以及以后的参数)
		MethodType mt = MethodType.methodType(void.class,String.class);

		//lookup(）方法来自MethodHandles.lookup,这句的作用是在指定类中查找符合给定的方法名称、方法类型，并且符合调用权限的方法句柄
		//因为是调用虚方法，按照java语言的规制，方法的第一个参数是隐式的，代表该方法的接收者，也就是this所指对象，这个参数以前是
		//放在参数列表中进行传递的，而现在提供了bindTo()方法来完成这件事
		return lookup().findVirtual(reveiver.getClass(),"println",mt).bindTo(reveiver);
	}

}
