package ect;

/**
 * Created by xiongxiaoyu
 * Data:2018/3/30
 * Time:16:22
 *
 *
 * hash 散列函数，压缩映射，将任意长度的消息压缩到一个固定长度（远小于原长度）的消息摘要的函数。
 *
 * hashtable  散列表，存储键值对；函数都同步，是线程安全的；key value不能null
 *		put方法中的int index = (hash & 0x7FFFFFFF) % tab.length:
 *			&操作???-> hash不能超过Integer.MAX_VALUE 所以要取其最小的31个bit
 *		rehash()扩容后复制，Entry[]数组存放顺序会颠倒，不影响实际使用 Integer最大32位
 *
 *
 * HashTable和HashMap大同小异，区别：
 * 	1.Null Key,Null Value:HashMap K V均能null，拿第0号桶来装key=null(HashMap中null的hashCode=0)。
 * 			HashTable中K V不能为null，抛出NullPointerException异常。
 * 	2.容量大小：HashMap初始16，扩容就翻倍；HashTable初始11，0.75，扩容2n+1.
 * 		(当哈希表的大小为素数时，简单的取模哈希的结果会更均匀；HashMap通过(h = key.hashCode()) ^ (h >>> 16)
 * 			来减小hash冲突。但取模运算时，HashMap位运算效率远高于HashTable做除法)
 *  3.HashTable是线程安全的，Set也是Collections.synchronizedSet；HashMap不是线程安全的
 *  4.HashTable已淘汰不建议使用了，首选HashMap，多线程选ConcurrentHashMap
 *
 *
 */
public class Hash {
}
