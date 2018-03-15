package util;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by xiongxiaoyu on 2018/3/14.
 * 使用::方法引用, 类名::方法名(不含括号)
 * person -> person.getAge() , Person::getAge 两者等效
 *
 */
public class TestConsumer {
	public static void main(String[] args) {
		Consumer<Integer> consumer=System.out::println;
		consumer.accept(1);
		consumer.accept(96);
		//use function,you always need one return value.
		//Function<T,R>T表示传入类型，R表示返回类型
		Function<Integer,Integer> function = x->{
			System.out.println("x:"+x);
			return x;
		};
		function.apply(100);
	}
}
