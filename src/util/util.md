Java容器分类
* Collection
    * List
        * ArrayList
        * LinkedList
        * Vector(了解，已过时)
    * Set
        * HashSet
            * LinkedHashSet
        * TreeSet
* Map            
     * HashMap  
        * LinkedHashMap
     * TreeMap
     * ConcurrentHashMap        
     * HashTable(了解，已过时)
     
list(集):可自由扩展的数组  
set(列表):没有重复元素的可以扩展数组     
map(映射):        
几乎所有的集合是基于数组实现，数组比任一集合都快，但集合提供更多的功能    

Arrays类，拥有一组static函数，专门用来操作array。 
equals()：比较两个array是否相等。array拥有相同元素个数，且所有对应元素两两相等   
fill()：将值填入array中   
sort()：用来对array进行排序    
binarySearch()：在排好序的array中寻找元素     
System.arraycopy()：array的复制    


https://blog.csdn.net/SpeedMe/article/details/22398395  

Collection接口的方法：add clear isEmpty contains iterator remove size toArray
iterator中的方法:hasNext remove next

* set：集合中元素不按照特定顺序排列，没有重复对象
    * HashSet:按照hash算法来存取集合中的对象，存取速度快   
    * TreeSet:实现了SortSet接口，能对集合中的对象排序   
    * LinkedHashSet：具有HashSet的查询速度，且内部使用链表维护元素的顺序(插入的次序)。于是在使用迭代器遍历Set时，结果会按元素插入的次序显示。
    
* list：元素以线性方式存储，集合中可以存放重复对象    
    * ArrayList(): 长度可以改变得数组。可以对元素进行随机的访问，向ArrayList()中插入与删除元素的速度慢。 
    * LinkedList(): 在实现中采用双向链表数据结构。插入和删除速度快，访问速度慢。    
    
* map:键对象和值对象映射的集合,通过“键”查找“值”    
    * HashMap:基于散列表的实现，可以通过构造器设置容量capacity和负载因子load factor，以调整容器的性能
    * LinkedHashMap: LinkedList + HashMap table数组的元素是双向链表，迭代遍历它时，取得“键值对”的顺序是插入次序/最近最少使用(LRU)的次序
    。比HashMap慢一点。链表维护内部次序，迭代访问更快。   
    * TreeMap：基于红黑树数据结构的实现。查看“键”或“键值对”时，它们会被排序(次序由Comparabel或Comparator决定)。TreeMap的特点是得到的结果是经过排序的。TreeMap是唯一的带有subMap()方法的Map，用来返回一个子树。     
    * WeakHashMap：弱键(weak key)Map，Map中使用的对象也被允许释放: 这是为解决特殊问题设计的。如果没有map之外的引用指向某个“键”，则此“键”可以被垃圾收集器回收。
    * IdentifyHashMap:使用==代替equals()对“键”作比较的hashmap。专为解决特殊问题而设计。
    
    
问题：
1.ArrayList和Vector的区别
共同点：    
* 这两个类都实现了List接口，都是有序的集合，底层是数组，可以按位置序号取出元素，元素可以为空和重复。
区别： 
* 同步性
    * ArrayList是非同步的，Vector是同步的(使用了Synchronized)
    * 当需要使用同步的ArrayList时，使用Collections.synchronizedList(list)返回一个可同步的list
    
* 扩容大小
    * Vector是2倍，ArrayList是1.5倍           
    
2.HashMap和HashTable的区别  
* 共同点     
    * 存储结构和实现基本相同，实现的Map接口
* 区别
    * 同步性
        * HashMap是非同步的，HashTable是同步的
        * 需要同步的HashMap时使用ConcurrentHashMap
    * 是否允许为null    
        * HashMap可以有null，HashTable不允许有null
    * contains方法    
        * HashTable有contains方法
        * HashMap去掉了contains，多了containsValue containsKey
    * 继承不同：
        * HashMap<K,V> extends AbstractMap<K,V>     
        * HashTable<K,V> extends Dictionary<K,V>
        
3.List和Map的区别
* 区别
    * 存储结构不同
        * List存储单列的集合
        * Map存储键值对的集合
    * 元素是否可以重复
        * List可以重复，Map的Key不能重复
    * 是否有序
        * List集合是有序的，Map集合无序
        
4.Set使用哪个方法区分重复？==还是equals  
两个都用到了，HashSet使用的是HashMap为底层支持，在HashMap中Key冲突时，Value新值会直接覆盖旧值，但
对Set来说value并没有用。HashMap中的实现用==来比较hash值，equals来比较Key的值。     

5.Collection和Collections的区别             
* Collection是集合的上级接口，继承它的有Set和List接口
* Collections是集合的工具类，提供了一系列的静态方法对集合的搜索、查找、同步等操作     

6.说出ArrayList,LinkedList的存储性能和特性    
* 一般来说ArrayList的元素的访问速度是要比LinkedList要快
* 一般来说LinkedList的增删速度是要比ArrayList要快的    

7.Enumeration和Iterator接口的区别  
Enumeration是旧版的迭代器，Iterator代替了它，更安全，当一个集合在被遍历的时候，它会阻止其他线程去修改集合。
(fail-fast机制)modCount!=expectedModCount引发的，抛出ConcurrentModificationException
* 区别
    * Iterator有fail-fast机制，比Enumeration更安全
    * Iterator能删除元素，Enumeration并不能删除元素
    
8.ListIterator有什么特点    
* ListIterator继承了Iterator接口，它用于遍历List集合的元素。
* ListIterator可以实现双向遍历,添加元素，设置元素

9.并发集合类是什么？
线程安全集合类，允许在迭代时修改集合。COpyOnWriteArrayList ConcurrentHashMap CopyOnWriteArraySet

10.Java中HashMap的key值要是为类对象则该类需要满足什么条件？
需要重写这个类的hashCode()方法和equals()方法。如果equals方法认定对象相同，那么这两者的hash值就应该相同。

11.ArrayList集合加入1万条数据，应该怎么提高效率
直接在初始化的时候就设置ArrayList的容量

12.Java集合框架相关的有哪些最好的实践
* 根据需要确定集合的类型。如果是单列的集合，我们考虑用Collection下的子接口ArrayList和Set。如果是映射，我们就考虑使用Map
* 确定完我们的集合类型，我们接下来确定使用该集合类型下的哪个子类~我认为可以简单分成几个步骤：
    * 是否需要同步
        * 去找线程安全的集合类使用
    * 迭代时是否需要有序(插入顺序有序)
        * 去找Linked双向列表结构的
    * 是否需要排序(自然顺序或者手动排序)
        * 去找Tree红黑树类型的(JDK1.8)
* 估算存放集合的数据量有多大，无论是List还是Map，它们实现动态增长，都是有性能消耗的。在初始集合的时候给出一个合理的容量会减少动态增长时的消耗~
* 使用泛型，避免在运行时出现ClassCastException
* 尽可能使用Collections工具类，或者获取只读、同步或空的集合，而非编写自己的实现。它将会提供代码重用性，它有着更好的稳定性和可维护性

