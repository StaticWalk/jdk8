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
 *  比较接口：
 * 	comparable：和具体类绑定的，“静态绑定”
 * 	comparator：“动态绑定”，更灵活
 *
 * TreeMap:
 *  一个有序的key-value集合，它是通过红黑树实现的,Map都是Key-Value集合
 *  基于红黑树，映射根据键的自然顺序进行排序，或根据创建映射时提供的Comparator进行排序，具体
 *  	取决于使用的构造方法
 *  containsKey,get,put,remove方法时间复杂度log(N)非同步，iterator方法返回的迭代器是fail-fast
 *  put()中如果发现没有自定义的comparator，使用默认的comparable比较器
 *  fixAfterInsertion(Entry<K,V> x)思路：
 *  1.while(x.parent.color == RED --)?循环   2.leftOrRight?  3.叔叔节点 == RED?  4.x.leftOrRight
 *  总结：1.根据key排序，以来比较器或重写Comparable接口，不需要key覆写hashCode方法和equals方法除重
 *  	2.TreeMap的查询、插入、删除效率均没有HashMap高，一般只有要对key排序时才使用TreeMap。
 *   	3.TreeMap的key不能为null，而HashMap的key可以为null
 *
 * TreeSet：
 * 	TreeSet和HashSet二者分别是基于TreeMap和HashMap实现，只是对应的节点中只有key，没有value
 *
 */
public class TestTree {
	public static void main(String[] args) {

	}
}
