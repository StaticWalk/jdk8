package ect;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by xiongxiaoyu
 * Data:2018/3/27
 * Time:11:22
 *
 * java8 新特性(lambda,流API,,,)之一
 * lambda语法用来代替匿名内部类，() ->，使代码变简单、可读、减少了代码量
 * (int even, int odd) -> even + odd：lambda表达式内部变量名字通常短一些，放在一行，
 *  	这段代码中选用a、b或者x、y会比even、odd要好。
 * java8增加了包java.util.function来支持java的函数式编程。Predicate能向API添加逻辑。
 * lambda表达式和匿名内部类分析：
 * 		this关键字的指向：匿名类中的指向匿名类；lambda表达式中指向为包围该表达式的类。
 * 		java编译器将lambda表达式编译成类的私有方法,通过invokeDynamic字节码绑定.
 *
 */
public class TestLambda {

	public static void main(String[] args) {


		//1.用lambda实现Runnable
		//before java8
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("Before Java8, too much code for too little to do");
//			}
//		}).start();
//		//java8 lambda
//		new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();


		//2.对列表进行迭代
		// Java 8之后：
//		List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//		features.forEach(n -> System.out.println(n));
//		// 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
//		// 看起来像C++的作用域解析运算符
//		features.forEach(System.out::println);
//	}

		//3.使用lambda表达式和函数式接口Predicate   ????
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
//		System.out.println("Languages which starts with J :");
//		filter(languages, (str)->str.startsWith("J"));
//		System.out.println("Languages which ends with a ");
//		filter(languages, (str)->str.endsWith("a"));
//		System.out.println("Print all languages :");
//		filter(languages, (str)->true);
//		System.out.println("Print no language : ");
//		filter(languages, (str)->false);
//		System.out.println("Print language whose length greater than 4:");
//		filter(languages, (str)-> str.length() > 4);


		//4.用and()、or()和xor()逻辑函数来合并Predicate，
//		// 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
//		hh(languages);

		//5.将 x -> x*x lambda表达式传到 map() 方法，后者将其应用到流中的每一个元素。forEach()打印列表元素
//		List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//		costBeforeTax.stream().map((cost) -> (Integer)cost +(Integer)cost*(0.12)).forEach(System.out::println);


		//6.集合过滤  过滤掉字符串列表中字符长度小于4的,filter过滤获得的是一个新的列表，原列表还存在
//		List<String> filtered=languages.stream().filter(x->x.length()>4).collect(Collectors.toList());
//		System.out.printf("Original List : %s, filtered list : %s %n", languages, filtered);

//7.对列表每个元素运用函数：将字符串换成大写并用逗号链接起来(项目可用)，distinct()方法去重
//		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
//		String G7Countries = G7.stream().map(x -> x.toUpperCase()).distinct().collect(Collectors.joining(", "));
//		System.out.println(G7Countries);

		//8.处理集合元素的最大值、最小值、总和以及平均值
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : " + stats.getAverage());
	}

//		public static void filter(List<String> names, Predicate<String > condition) {
//			for(String name: names)  {
//				if(condition.test(name)) {
//					System.out.println(name + " ");
//				}
//			}
//		}
		//用lambda改写原方法
		public static void filter(List<String> names,Predicate<String> condition){
		names.stream().filter((name)->(condition.test(name))).forEach((name)->{
			System.out.println(name+" ");
		});
		}

		public static void hh(List<String> names){
			Predicate<String> startsWithJ = (n) -> n.startsWith("J");
			Predicate<String> fourLetterLong = (n) -> n.length() == 4;
			names.stream()
					.filter(startsWithJ.and(fourLetterLong))
					.forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));
		}

}
