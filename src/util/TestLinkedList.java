package util;

import java.util.LinkedList;

/**
 * Created by xiongxiaoyu
 * Data:2018/3/24
 * Time:15:45
 *
 *
 * LinkedList基于双向链表，课用做栈、队列、双端队列，非线程安全的，用于单线程。
 *		变成线程安全List list=Collections.synchronizedList(new LinkedList(...));
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class TestLinkedList {
	public static void main(String[] args) {
		LinkedList<String> list=new LinkedList<String>();
		list.add("sasa");
	}
}
