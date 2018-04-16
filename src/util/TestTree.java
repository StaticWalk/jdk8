package util;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/15
 * Time:22:21
 *
 * fail-fast快速失败机制，Java集合的一种错误检测机制，用于检测程序错误。多个线程对集合进行结构
 * 		上的改变操作时，有可能产生fail-fast机制。例如，两个线程线程1、线程2，线程1通过iterator
 * 		遍历集合中的元素，某个时刻线程2修改集合的结构(结构上面的修改，而不是简单的修改集合元素的
 * 		内容),程序就会抛出 ConcurrentModificationException 异常，从而产生fail-fast机制。
 *	    @FailFast.java
 *	    为提高这类迭代器的正确性而编写一个依赖于此异常的程序是错误的做法！！！
 * ConcurrentModificationException：当方法检测到对象的并发修改，但不允许这种修改时就抛出该异常
 * 		原来是modCount!=expectedModCount引发的啊，fail-fast解决办法同线程同步问题。
 *
 * TreeMap:
 *  一个有序的key-value集合，它是通过红黑树实现的,Map都是Key-Value集合
 *  基于红黑树，映射根据键的自然顺序进行排序，或根据创建映射时提供的Comparator进行排序，具体
 *  	取决于使用的构造方法
 *  containsKey,get,put,remove方法时间复杂度log(N)非同步，iterator方法返回的迭代器是fail-fast
 *
 *
 */
public class TestTree {
	public static void main(String[] args) {

	}
}
