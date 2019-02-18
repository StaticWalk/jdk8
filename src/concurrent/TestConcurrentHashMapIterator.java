package concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/21
 * Time:19:13
 *
 *
 * transient 在实现了序列化的Serilizable接口，用于不需要序列化的属性前，这个属性就不会序列化到指定的目的地中
 *
 *HashMap不安全，多个线程同时put，hash的数组相同时，会造成闭环，在进行get的时候就会出现死循环
 *
 * ConcurrentHashMap  锁分离技术，将锁的粒度降低，使用多个锁来控制多个小的table
 * 高并发场景下性能优于HashMap很多
 *
 * 1.7采用了分段锁技术(对实现了ReentrantLock的segment加锁)
 * 	Segment数组(加锁的最小单位) + HashEntry数组(数组+链表)  需要进行两次hash
 * 	ssize数组大小  capHashEntry的数组大小  都是通过移位计算得到所以都是2的次方倍
 * 	segment实现了ReentrantLock，带有锁的功能
 * 	put：
 * 	第一次key的hash来定位segment的位置，segment未初始化，CAS进行赋值
 * 	第二次hash找到对应的HashEntry的位置，用到锁的特性(先tryLock()去获取锁，成功就插入，否则自旋trylock，超时就挂起)，数据放在链表的尾端
 *
 * 	get:
 * 	类似HashMap，两次hash后遍历链表，成功就返回，否则返回null
 *
 * 	size:
 * 	1.使用不加锁多次计算ConcurrentHashMap的size，最多三次，比较前两次的结果，结果一直就认为当前没有新元素加入
 * 	2.第一种方案失败后，对每个Segment加上锁，然后计算ConcurrentHashMap的size
 *
 *
 * 1.8后采用了CAS和Synchronized控制并发操作
 * Node数组+链表+红黑树   多线程并发扩容(对节点加Synchronized锁)
 * Node继承于HashMap中的Entry ，val和next都加上volatile1来保持可见性和禁止重排序，不能修改数据
 * put:
 * 1.如果没有初始化，调用InitTable()初始化CHM
 * 2.如果没有hash冲突直接CAS插入
 * 3.如果在进行扩容操作，先帮助扩容
 * 		helpTransfer()目的是多个线程帮助进行扩容，效率更高
 * 		ForwardingNode用来支持扩容操作
 * 		transfer()：将已处理结点和空结点标记ForwardingNode,并发遍历的时候遇到ForwardingNode标记就往后遍历
 *	 	？？？插入了原链表和倒序链表
 * 4.存在hash冲突的话，对node加锁保证线程安全，然后插入数据，链表的话放到队尾，红黑树就按红黑树结构插入
 * 5.检查树化阈值，大于8了就转化为红黑树结构
 *  	treeifyBin（）如果整个table的数量小于64，就扩容至原来的一倍，不转红黑树,因为在这个阈值扩容可以减少hash冲突，不必要转红黑树
 * 6.添加成功的话使用addCount()统计size，并检查是否需要扩容
 *
 * get:
 * 1.计算hash值，定位到该table索引位置，如果是首节点符合就返回
 * 2.如果遇到扩容的时候，会调用标志正在扩容节点ForwardingNode的find方法，查找该节点，匹配就返回
 * 3.以上都不符合的话，就往下遍历节点，匹配就返回，否则最后就返回null
 *
 * size:
 *
 * 从JDK1.7版本的ReentrantLock+Segment+HashEntry，到JDK1.8版本中synchronized+CAS+HashEntry+红黑树
 * 总结：
 * 1.JDK1.8的实现降低锁的粒度，JDK1.7版本锁的粒度是基于Segment的，包含多个HashEntry，而JDK1.8锁的粒度就是HashEntry（首节点）
 * 2.JDK1.8版本的数据结构变得更加简单，使得操作也更加清晰流畅，因为已经使用synchronized来进行同步，所以不需要分段锁的概念，也就不需要Segment这种数据结构了，由于粒度的降低，实现的复杂度也增加了
 * 3.JDK1.8使用红黑树来优化链表，基于长度很长的链表的遍历是一个很漫长的过程，而红黑树的遍历效率是很快的，代替一定阈值的链表，这样形成一个最佳拍档
 * 4.JDK1.8为什么使用内置锁synchronized来代替重入锁ReentrantLock，我觉得有以下几点
 *  	1.因为粒度降低了，在相对而言的低粒度加锁方式，synchronized并不比ReentrantLock差，
 *  	在粗粒度加锁中ReentrantLock可能通过Condition来控制各个低粒度的边界，更加的灵活，而在低粒度中，Condition的优势就没有了
 * 		2.JVM的开发团队从来都没有放弃synchronized，而且基于JVM的synchronized优化空间更大，使用内嵌的关键字比使用API更加自然
 * 		3.在大量的数据操作下，对于JVM的内存压力，基于API的ReentrantLock会开销更多的内存，虽然不是瓶颈，但是也是一个选择依据
 *
 */
public class TestConcurrentHashMapIterator {

	public static void test(){
		final ConcurrentHashMap<String,String> map=new ConcurrentHashMap<>();
		map.put("a","abstract");
		map.put("b","basic");
		new Thread(()->{
			for (Map.Entry<String,String> entry:map.entrySet()){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
					System.out.println(entry.getKey()+","+entry.getValue());
			}
		}).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
			map.put("c","call");
	}

	public static void main(String[] args) {
		test();
	}

}
