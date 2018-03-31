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
 * 整体结构，节点数组Node<K,V>[] table + 链表 Node<K,V> p + 红黑树,数组下标通过i = (n - 1) & hash获得。
 * put()方法:转入putVal(int hash,K key,V value,boolean onlyIfAbsent,boolean evict),key.hashCode()返回int
 * 		2进制32位带符号-2147483648到2147483648，但是HashMap扩容前的数组初始大小16位,hash()"扰动函数"通过
 * 		(n-1)&hash来确定table数组下标。
 *
 *
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
