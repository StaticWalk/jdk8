package ect.Reference;

import java.util.WeakHashMap;

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


class CanonicalMapping {
	public static void main(String[] args) {
		int size = 1000;
		Key[] keys = new Key[size];
		WeakHashMap map = new WeakHashMap();
		for (int i = 0; i < 15; i++) {
			Key k = new Key(Integer.toString(i));
			Value v = new Value(Integer.toString(i));
//			System.out.println(Integer.toString(i));
			if (i % 3 == 0)
				keys[i] = k ;
			map.put(k, v);
		}
		System.gc();
	}
}


class Element {
private String ident;

public Element(String id) {
		ident = id;
		}

public String toString() {
		return ident;
		}

public int hashCode() {
		return ident.hashCode();
		}

public boolean equals(Object obj) {
		return obj instanceof Element && ident.equals(((Element) obj).ident);
		}

		//执行gc将对象从内存清除前的必要的清理工作
protected void finalize(){
		System.out.println("Finalizing "+getClass().getSimpleName()+" "+ident);
		}}

class Key extends Element{
	public Key(String id){
		super(id);
	}
}

class Value extends Element{
	public Value (String id){
		super(id);
	}
}
