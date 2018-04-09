package util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiongxiaoyu
 * Data:2018/3/26
 * Time:13:19
 *
 *
 * Map是个接口存储<K,V>键值对，抽象出AbstractMap(实现了大部分Map中的API)便于其他类继承
 * NavigableMap接口继承SortedMap,有序，新增导航方法:"获取>=某个对象的键值对"
 * Map中的方法，Set<K> KeySet()保存key的set，Collection<V> values()保存value的Collection
 * 		Map.Entry是Map内部的一个接口，是一个键值对，通过Map.entrySet()来获取装Map.Entry的集合
 * AbstractMap继承Map，没有实现entrySet()方法仍是abstract修饰，继承AbstractMap需要实现entrySet()方法
 *		key可null，key同会被后面的覆盖，迭代器遍历Iterator<Map.Entry<K,V>> i = entrySet().iterator();
 *		没有实现put(K key, V value)方法，只抛出了个异常，继承类应overwrite这个方法。不支持add(),remove()
 *		V remove(Obj key),使用correctEntry保存查出来的要删除的Entry,oldValue获得删除key的value来返回
 * SortedMap接口继承Map，有序的键值对。排序方式：自然排序，指定比较器排序(Comparator)@TestComparator.java
 *		方法内部通过传递参数key操作。
 * NavigableMap继承SortedMap:
 * 1. 提供了操作键值对的方法：lowerEntry、floorEntry、cellingEntry和higherEntry方法分别返回小于、小于等
 * 		于、大于等于和大于给定键的键所关联的Map.Entry对象。
 * 2. 提供了操作键的方法：lowerKey、floorKey、cellingKey和higherKey方法分别返回小于、小于等于、大于等于
 * 		和大于给定键的键。
 * 3. 获取键值对的子集。
 *
 * HashMap：散列表，存储键值对，实现不同步非线程安全
 * 1.8中hashmap引入了红黑树(O(logN))优化查询和元素操作,
 * 整体结构，节点数组Node<K,V>[] table + 链表 Node<K,V> p + 红黑树(基于二叉树),数组下标通过i = (n - 1) & hash获得。
 * put()方法:转入putVal(int hash,K key,V value,boolean onlyIfAbsent,boolean evict),key.hashCode()返回int
 * 		2进制32位带符号-2147483648到2147483648，但是HashMap扩容前的数组初始大小16位,hash()"扰动函数"通过
 * 		(n-1)&hash来确定table数组下标。@Hash.java  @BinaryTree.java  @RedBlackTree.java
 *
 * IdentityHashMap：只有全等的key才会相等，当出现key-value冲突的时候，不是利用链表解决冲突而是继续计算下一个索引，
 * 		存在下一个有效索引的数组里面。 table[i]=key,table[i+1]=value  ????
 * 		该类实例化的时候，容量申请了Object [64],自带了hash(h,len):((h << 1) - (h << 8))&(len-1)
 *		capacity扩容操作中两处判断， Integer.highestOneBit(3*expMS),取二进制最高位其余位全部补0.方法是按位取或，
 *		最高位1右移移位然后与原数据取或，得到i是全1，return i - (i >>> 1)。<<<左移负数补1，<<左移负数补0，正数操作统一补0
 *		里面包含指定大小的Object[]数组，clear()就是把数组元素置null。put()中数组序号通过i=indexFor(h,tab.length)
 *		获得	，单一数组偶数项装key，下一位装value。resize()容量翻倍，原数组置null不够直接MAX原数组内容装入新数组中。
 *		操作中引入modCount来记录线程安全情况，出错抛出异常。
 *		equals() 1.o属于IdentityHashMap,containsMapping逐一比较 2.o属于Map,entrySet().equals(m.entrySet())返回
 *		true就可以  3. o == this
 *		重写equals方法，判定只有key值全等情况下才会判断key值相等。
 *
 * WeakHashMap:弱引用队列关联map数组中存储的数据，类似hashmap使用链表解决冲突问题。优势该类可以实现缓存，内存紧张时
 * 		可避免占用大量内存，销毁不用过时对象，较早释放空间。特点使用引用队列，把Entry对象和引用队列关联,Entry变弱引用
 *
 **/
public class TestMap {



	public static void main(String[] args) {
		Map map = new HashMap();
		map.put(null, null);
		map.put(null, 3);
		map.put("3", null);
		System.out.println(map.remove("3"));
	}
}
