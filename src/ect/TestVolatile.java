package ect;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/11
 * Time:21:52
 *
 * JMM(Java Memory Model)规定，程序中的变量是放在内存中，当线程需要使用该变量的时候，需要把该变量
 * 		复制到该CPU所在的工作内存(高速缓存)中，从高速缓存拿到变量值，CPU修改后还到高速缓存中，程
 * 		序执行完后，内存再从高速缓存复制该变量的值。
 * JMM会出现，如果一个变量在多个CPU中都存在缓存（一般在多线程编程时才会出现），那么就可能存在缓存不一致的问题。
 * 硬件层面的解决方法：
 * 	1).通过在总线加LOCK#锁的方式:CPU和其他部件通信通过总线进行的，在总线加LOCK锁能阻塞其他CPU对其他部件的访问
 * 		(内存)，使得只能有一个CPU使用这个变量的内存。  ???相当于多CPU单线程，效率低下
 * 2).通过缓存一致性协议：缓存一致性协议。Intel的MESI协议，保证了每个缓存中使用的共享变量是一直的，核心思想：
 * 		当CPU写数据时，如果操作变量是共享变量(其他CPU也存在该变量副本)，会发出信号通知其他CPU将该变量的缓存行
 * 		置无效状态，因此其他CPU读取这个变量时，发现自己缓存中改缓存行是无效的，便再次从内存中读取。
 *
 * 并发编程三个概念(并发程序要想正确地执行，必须要保证原子性、可见性以及有序性)!!!
 *  1.原子性：一个操作或者多个操作 要么全部执行并且执行的过程不会被任何因素打断，要么就都不执行。
 *  (银行转账问题，32位的变量赋值)必须是原子操作。
 *  2.可见性：当多个线程访问同一个变量时，一个线程修改了这个变量的值，其他线程能够立即看得到修改的值。
 *		线程t1、t2，变量i=0、j，t1中i=+10，t2中j=i；t1中把i读取到自己的高速缓存并成功修改但未同步，t2拿i对j赋值
 *		时，i在内存中为0，j=0。t2不能及时看到t1对i的修改。
 *  3.有序性：即程序执行的顺序按照代码的先后顺序执行。指令重排序：处理器为了提高程序运行效率，可能会对输入代
 *  		码进行优化，它不保证程序中各个语句的执行先后顺序同代码中的顺序一致，但是它会保证程序最终执行结果
 *  		和代码顺序执行的结果是一致的，重排序时也会考虑指令之间的数据依赖性。
 *  		多线程中：指令重排序不会影响单个线程的执行，但是会影响到线程并发执行的正确性。
 *
 *  JMM(Java内存模型):JVM规范中试图定义一种Java内存模型来屏蔽各硬件平台和操作系统的内存访问差异，实现让Java程序
 *  		跨平台达到一致的内存访问效果。为了获得较好的执行性能，Java内存模型没有限制执行引擎使用处理器的寄存器
 *  		或者高速缓存来提升指令执行速度，也没有限制编译器对指令进行重排序。也就是说，在java内存模型中，也会存
 *  		在缓存一致性问题和指令重排序的问题。
 *  1.原子性：Java内存模型只保证了基本读取和赋值是原子性操作，如果要实现更大范围操作的原子性，可以通过synchronized
 *  	和Lock来实现
 *  2.可见性：一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内
 *  	存中读取新值。，通过synchronized和Lock也能够保证可见性，synchronized和Lock能保证同一时刻只有一个线程获
 *  	取锁然后执行同步代码，并且在释放锁之前会将对变量的修改刷新到主存当中。
 *  3.有序性：指令重排序不会影响单线程程序进行，会影响多线程程序并发执行的正确性，通过volatile关键字来保证一定的
 *  	“有序性”（具体原理在下一节讲述）。另外可以通过synchronized和Lock来保证有序性，很显然，synchronized和
 *  	Lock保证每个时刻是有一个线程执行同步代码，相当于是让线程顺序执行同步代码，自然就保证了有序性。
 *   JMM具有一些先天的“有序性”，不需要任何手段就能保证的有序性。
 *   称happens-before八原则：
 *   -程序次序规则：一个线程内，代码按照书写先后顺序执行(只能保证单线程)
 *   -锁定规则：一个unLock操作先行发生于后面对同一个锁的Lock操作
 *   -volatile变量规则：对一个变量的写操作必须发生在对这个变量的读操作
 *   -传递规则：A操作先于B操作，B操作先于C操作，A操作一定先于C操作
 *   -线程启动规则：Thread的start()方法先于线程的每一个动作
 *   -线程中断规则：对线程interrupt()方法的调用先行发生于被中断线程的代码检测到中断事件的发生
 *   -线程终结规则：线程中所有的操作都先行发生于线程的终止检测，我们可以通过Thread.join()方法结束、Thread.isAlive()的返回值手段检测到线程已经终止执行
 *   -对象终结规则：一个对象的初始化完成先行发生于他的finalize()方法的开始
 *
 *  volatile关键字：
 *  1）	(两层语义) 修饰共享变量(类的成员变量、类的静态成员变量)
 *  	1.保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
 *		2.禁止进行指令重排序
 *	修饰后的作用：1.使用volatile关键字会强制将修改的值立即写入主存；2.线程2修改变量时，会导致线程1工作内存中缓冲变量行无效；
 *		3.线程1的工作内存中缓存变量的缓存行无效，使用时需要再次去主存读取。
 *  2）原子性问题
 *  	volatile不能解决原子性问题，concurrent.atomic下封装了一些基本数据类型，可以保证是原子操作
 *  3）volatile禁止指令重排序：
 *		1.执行到volatile的读写操作时，该操作之前的更改已进行完毕，且对后面操作可见；其后操作未进行。
 *		2.指令优化时，不能改变含对volatile变量访问语句的执行顺序
 *  4）volatile的原理和实现机制：
 * (“观察加入volatile关键字和没有加入volatile关键字时所生成的汇编代码发现，加入volatile关键字时，会多出一个lock前缀指令”)
 *		lock前缀指令实际相当于一个内存屏障(又称内存栅栏)，内存屏障提哦那个三个功能：
 *		1.确保指令重排序时不会把他后面指令排到内存屏障之前的位置，也不会把前面的指令排到内存屏障的后面；即在执
 *		行到内存屏障这句指令时，在它前面的操作已经全部完成；
 *		2.它会强制将对缓存的修改操作立即写入主存；
 *		3.如果是写操作，它会导致其他CPU中对应的缓存行无效。
 *	5）关键字的运用场景
 *		synchronized防止多个线程执行同一段代码，会影响程序执行效率；volatile某些情况性能优于synchronized，
 *		volatile关键字是无法替代synchronized关键字的，因为volatile关键字无法保证操作的原子性。
 *	使用volatile条件(能保证原子性操作)：1.对变量的写操作不依赖于当前值  2.该变量没有包含在具有其他变量的不变式中
 *		1.状态标记量  2.double-check(双重检查的实现需要实现同步，通过volatile来实现) 延迟初始化，减少开销
 *
 *
 *
 * Java提供的一种稍弱的同步机制，用来确保将变量的更新操作通知到其他线程，保证了新值能立即同
 * 		步到主内存，使用前能立即刷新。变量声明volatile后，编译器和运行是都会注意到该变量共享
 * volatile变量对所有线程立即可见，所做操作能立即反应到其他线程中，基于volatile的操作是线程安全的 ？？？？
 *
 */
public class TestVolatile {

	public int inc = 0;

//	public volatile int  inc = 0;
	public void increase() {
		inc++;
	}

	/*使用synchronized修饰方法*/
//	public synchronized void increase() {
//		inc++;
//	}

	/*采用Lock*/
//	Lock lock = new ReentrantLock();
//	public  void increase() {
//		lock.lock();
//		try {
//			inc++;
//		} finally{
//			lock.unlock();
//		}
//	}

	/*采用AtomicInteger
	* atomic是利用CAS来实现原子性操作的（Compare And Swap），CAS实际上是利用处理器
	* 提供的CMPXCHG指令实现的，而处理器执行CMPXCHG指令是一个原子性操作。
	* */
//	public  AtomicInteger inc = new AtomicInteger();
//	public  void increase() {
//		inc.getAndIncrement();
//	}


	public static void main(String[] args) {
		final TestVolatile test = new TestVolatile();
		for(int i=0;i<10;i++){
			new Thread(()->{
					for(int j=0;j<1000;j++)
						test.increase();
				}
			).start();
		}

	//代码执行会被卡死  jstack查看线程状态
		while(Thread.activeCount()>0)  //保证前面的线程都执行完
			Thread.yield();
		System.out.println(test.inc+"  thread count:"+Thread.activeCount());
	}
}