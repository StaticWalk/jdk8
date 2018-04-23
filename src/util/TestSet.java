package util;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/16
 * Time:20:35
 *
 *
 * treeSet:
 *  TreeSet是基于 TreeMap 的 NavigableSet 实现。使用元素的自然顺序对元素进行排序，
 *  或者根据创建 set 时提供的 Comparator 进行排序，具体取决于使用的构造方法。这句
 *  话什么意思呢？就是说，跟HashSet底层是一个HashMap来维护类似，TreeSet的底层实现
 *  就是一个TreeMap，自然也就具备了对元素排序的功能。
 *
 *
 */
public class TestSet {

	public static void main(String[] args) {
		System.out.println(solution(3,8));
		System.out.println(solution(4,8));
		System.out.println(solution(5,8));
		System.out.println(solution(6,8));
		System.out.println(solution(7,8));
	}

	static int solution(int h,int len){
		return (h << 1) - (h << 8)&(len-1);
	}
}
