package util;

import java.util.*;

/**
 * Created by xiongxiaoyu
 * Data:2018/3/24
 * Time:13:58
 *
 *
 * 基于数组实现，动态数组容量能自动增长；多数方法加入了同步语句，相对线程安全可用于多线程环境
 * 		实际使用中不是线程安全的，在迭代中调用元素操作的方法实质操作的iterator中的方法，是不
 * 		能进行synchronized同步的。
 * 大体上和ArrayList差不多，多数方法加入了synchronized同步语句来同步线程，但仍然引入modCount
 * 		来避免迭代的时候线程交替操作元素，Vector中元素的处理分为是否为null，其中允许元素为null
 *
 *
 * 测试vector四种遍历方法的效率
 * Iterator > RandomAccess > For2 > Enumeration
 * 其中的Enumeration早于Iterator出现，方法：boolean hasMoreElements(),Object nextElement()
 *		Enumeration迭代器只能遍历Vector、Hashtable这种古老的集合，因此通常不要使用它，除非在某
 *		些极端情况下，不得不使用Enumeration，否则都应该选择Iterator迭代器。
 */
public class TestVector {

		public static void main(String[] args) {
		         Vector vec= new Vector();
		         for (int i=0; i<100000; i++)
		             vec.add(i);
		         iteratorThroughRandomAccess(vec) ;
		         iteratorThroughIterator(vec) ;
		         iteratorThroughFor2(vec) ;
		         iteratorThroughEnumeration(vec) ;
		     }

		     //判断容器类型是否实现了RandomAccess
	     private static void isRandomAccessSupported(List list) {
	         if (list instanceof RandomAccess) {
		             System.out.println("RandomAccess implemented!");
		         } else {
		             System.out.println("RandomAccess not implemented!");
		         }
		     }

		     //通过索引值去遍历
	     public static void iteratorThroughRandomAccess(List list) {
			 long startTime;
	         long endTime;
	         startTime = System.currentTimeMillis();
	         for (int i=0; i<list.size(); i++) {
		             list.get(i);
		         }
	         endTime = System.currentTimeMillis();
	         long interval = endTime - startTime;
	         System.out.println("iteratorThroughRandomAccess：" + interval+" ms");
	     }

	     	//迭代器遍历
	     public static void iteratorThroughIterator(List list) {
			 long startTime;
	         long endTime;
	         startTime = System.currentTimeMillis();
	         for(Iterator iter = list.iterator(); iter.hasNext(); )
	         { iter.next(); }
	         endTime = System.currentTimeMillis();
	         long interval = endTime - startTime;
	         System.out.println("iteratorThroughIterator：" + interval+" ms");
	     }

	     public static void iteratorThroughFor2(List list) {
			 long startTime;
	         long endTime;
	         startTime = System.currentTimeMillis();
	         for(Object obj:list);
	         endTime = System.currentTimeMillis();
	         long interval = endTime - startTime;
	         System.out.println("iteratorThroughFor2：" + interval+" ms");
	     }

	     public static void iteratorThroughEnumeration(Vector vec) {
			 long startTime;
	         long endTime;
	         startTime = System.currentTimeMillis();
	         for(Enumeration enu = vec.elements(); enu.hasMoreElements(); ) {
		             enu.nextElement();
		         }
	         endTime = System.currentTimeMillis();
	         long interval = endTime - startTime;
	         System.out.println("iteratorThroughEnumeration：" + interval+" ms");
	     }
}
