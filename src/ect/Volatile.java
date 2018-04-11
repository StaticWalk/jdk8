package ect;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/11
 * Time:21:52
 *
 * Java提供的一种稍弱的同步机制，用来确保将变量的更新操作通知到其他线程，保证了新值能立即同
 * 		步到主内存，使用前能立即刷新。变脸声明volatile后，编译器和运行是都会注意到该变量共享
 * volatile变量对所有线程立即可见，所做操作能立即反应到其他线程中，基于volatile的操作是线程安全的 ？？？？
 *
 */
public class Volatile {
}
