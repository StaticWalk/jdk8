ReentrantLock的公平锁和非公平锁都委托了AQS的acquire()获取    
静态内部类Syn实现了nonfairAcquire(),在静态内部类nonFairSyn中使用
默认 new nonFairSync()
RL公平锁的实现：
依靠AQS中维持了一个双向链表,数据结构Node,使用lock方法实质是在head结点后进行排队来保证公平
非公平：  
请求获取锁的线程会多次cas请求锁，而不是加入等待队列