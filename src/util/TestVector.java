package util;

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
 */
public class TestVector {
}
