package util;


/**
 * ArrayDeque是一个双端队列，支持首尾两端的操作
 * ArrayDeque不是线程安全的，不能存取null元素，系统通过某位置是否为null来判断元素的存在
 * transient关键字 短暂的,在实现了Serializable接口的类中
 * 	   ，在不需要序列化的属性前添加，该属性不会被序列化。@TransientTest.java
 * 	LinkedList内部实现使用了node节点链接前后元素(长处在于中间节点的增删操作为o(1))
 * 	vector方法加了synchronized修饰(同步，将带来性能的损耗)，Stack继承了vector
 * 	ArrayDeque底层是单纯的数字操作，性能更强，但是无同步处理，存在并发问题。
 *	allocateElements(),最大容量扩容，巧妙运用二进制移位，全程只有一个变量。
 *  doubleCapacity(),容量翻倍，再来一组相同数据接在尾部。
 *  isEmpty(),size(),pollFirst(),pollLast():
 *  arraydeque实现双端队列用了循环数组,存在tail<head的情况，要用&(elements.length-1)转正值
 *  length必须是2的幂指数，当tail<head，取(tail-head)补码&(elements.length-1)可求得size
 *	addLast()在tail=length-1的时候会扩容，"elements[tail] = e"可以执行
 */

public class TestArrayDeque {


}
