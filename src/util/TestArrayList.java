package util;

/**
 * Created by xiongxiaoyu
 * Data:2018/3/21
 * Time:21:48
 *
 *
 *	动态数组，容量自动增长,类似于c语言动态内存申请。非线程安全，只能用于单线程，
 *	多线程通过Collection.synchronizedList(List l)返回一个线程安全的ArrayList类，
 *		或者使用concurrent并发包下的CopyOnWriteArrayList类。
 *	Serializable接口，支持序列化，能序列化传输；RandomAccess接口，支持通过下标序号
 *		的快速随机访问；Cloneable接口，能被克隆。
 *
 *
 *	Collection定义的API:
 * 	boolean 	add(E object),addAll(Collection<? extends E> collection),
 * 			contains(O o),retainAll(~),containsAll(Collection<?> collection),
 * 	 		equals(O o),isEmpty(),remove(O o),removeAll(~);
 *	int 		 hashCode(),size();
 * 	void 	     clear();
 *	Object[] 	 toArray();
 *	<T> T[] 	 toArray(T[] array);
 *	Iterator<E>  iterator();

 *	AbstractCollection中定义的API:
 *	void  		add(int location,E Object)
 *	boolean 	addAll(int location,Collection<? extends E> collection)
 *	E			get(int location),remove(int location),set(int location,E object)
 *	int 		lastIndexOf(O o),indexOf(O o),
 *	List<E>		subList(int start,int end)
 *	ListIterator<E>		listIterator(int location),listIterator(),
 *
 * 	ArrayList新增API:
 * 	Object  clone()
 * 	void    ensureCapacity(int minimumCapacity),trimToSize(),
 * 			removeRange(int fromIndex,int toIndex)
 *******************
 *
 * 	void grow(int minCapacity),容量增长，minCapacity是最小需要扩容，
 * 	1.容量x1.5;	2.判断够不够minCapacity，不够取minCapacity;	3.对比MAX_ARRAY_SIZE(Integer.MAX_VALUE-8)
 * 			,hugeCapacity()检查溢出，返回MAX或者Integer.MAX_VALUE;
 * 		4.Array.copyOf(),<T> T[] copyOf(T[] original, int newLength)
 *
 * 	void trimToSize(),缩小容量,调整当前容量为实际元素个数
 *
 *
 *
 */
public class TestArrayList {

	public static void main(String[] args) {
//		ArrayList() a=new ArrayList();
	}

}
