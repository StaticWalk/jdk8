package util;


import java.util.*;
/**
 * Created by xiongxiaoyu
 * Data:2018/3/24
 * Time:15:45
 *
 *
 * ArrayList 优点是集合的快速随机访问，缺点是根据位置索引操作元素速度慢，位置越小越慢
 * LinkedList 执行元素操作的时候高效，但是随机访问的时候差于ArrayList
 *
 *
 * LinkedList基于双向链表，课用做栈、队列、双端队列，非线程安全的，用于单线程。
 *		变成线程安全List list=Collections.synchronizedList(new LinkedList(...));
 *
 *
 *
 *
 */
public class TestLinkedList {


	//DoubleLoopLinkedList
	public static void main(String[] args) {


		LinkedList list=new LinkedList();

		Collection collection = new ArrayList();
		collection.add("One");
		collection.add("Two");
		collection.add("Three");

		// append the collection in the LinkedList
		list.addAll(collection);

		// print the new list
		System.out.println("LinkedList:" + list);





//		Node n1=new Node("n1");
//		Node n2=new Node("n2");
//		Node n3=new Node("n3");
//		//构造一个双向链表
//		n1.next=n2;
//		n1.previous=n3;
//
//		n2.next = n3;
//		n2.previous = n1;
//
//		n3.next = n1;
//		n3.previous = n2;
//
//		// 插入一个元素 n4,放在 n1 和 n2 之间
//		Node n4 = new Node("n4");
//		n1.next = n4;
//		n4.previous = n1;
//		n4.next = n2;
//		n2.previous = n4;
//
//
//		// 删除元素 n2
//		n4.next = n3;
//		n3.previous = n4;
//		n2.next = null;
//		n2.previous = null;

	}

// 		static class Node {
//
//		public Node previous;
//		public Node next;
//		public String data;
//		public Node(String data){
//			super();
//			this.data=data;
//		}
//	}
}
