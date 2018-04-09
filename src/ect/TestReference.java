package ect;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/9
 * Time:19:47
 *
 *
 * ————Reference
 * Java引用体系，常见的StrongReference强引用类型A a=new A(),jvm gc的时候会检查对象十分存在强引用
 * 		如果存在根对象对其有传递的强引用，就不会对其进行回收，不会抛内存不足OutOfMemoryError,
 *	还包括SoftReference，WeakReference，PhantomReference，FinalReference ，引入的目的是jvm在gc的
 *		时候依据类型不同采取不同的回收逻辑，可以把引用看称是对对象的一层包装，在内存缓存、资源释放、
 *		对象可达性事件处理的场景会使用。(Reference指引用对象本身，Referent指引用对象)
 *   对象可达性判断
 */
public class TestReference
{
}
