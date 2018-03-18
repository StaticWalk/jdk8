package util;


/**
 * ArrayDeque是一个双端队列，支持首尾两端的操作
 * ArrayDeque不是线程安全的，不能存取null元素，系统通过某位置是否为null来判断元素的存在
 * transient关键字 短暂的,在实现了Serializable接口的类中
 * 		，在不需要序列化的属性前添加，该属性不会被序列化。@TransientTest.java
 *	allocateElements(),最大容量扩容，巧妙运用二进制移位，全程只有一个变量。
 *
 *
 */

public class TestArrayDeque {



}
