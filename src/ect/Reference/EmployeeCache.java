package ect.Reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Hashtable;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/10
 * Time:20:52
 */
public class EmployeeCache {
	static private EmployeeCache cache;// 一个Cache实例
	private Hashtable employeeRefs;// 用于Chche内容的存储
	private ReferenceQueue q;// 垃圾Reference的队列

	// 继承SoftReference，使得每一个实例都具有可识别的标识。
	// 并且该标识与其在HashMap内的key相同。
	private class EmployeeRef extends SoftReference {
		private String _key = "";

		public EmployeeRef(Employee em, ReferenceQueue q) {
			super(em, q);
			_key = em.getID();
		}
	}

	// 构建一个缓存器实例
	private EmployeeCache() {
		employeeRefs = new Hashtable();
		q = new ReferenceQueue();
	}

	// 取得缓存器实例
	public static EmployeeCache getInstance() {
		if (cache == null) {
			cache = new EmployeeCache();
		}
		return cache;
	}

	// 以软引用的方式对一个Employee对象的实例进行引用并保存该引用
	private void cacheEmployee(Employee em) {
		cleanCache();// 清除垃圾引用
		EmployeeRef ref = new EmployeeRef(em, q);
		employeeRefs.put(em.getID(), ref);
	}

	// 依据所指定的ID号，重新获取相应Employee对象的实例
	public Employee getEmployee(String ID) {
		Employee em = null;
		// 缓存中是否有该Employee实例的软引用，如果有，从软引用中取得。
		if (employeeRefs.containsKey(ID)) {
			EmployeeRef ref = (EmployeeRef) employeeRefs.get(ID);
			em = (Employee) ref.get();
		}
		// 如果没有软引用，或者从软引用中得到的实例是null，重新构建一个实例，
		// 并保存对这个新建实例的软引用
		if (em == null) {
			em = new Employee(ID);
			System.out.println("Retrieve From EmployeeInfoCenter. ID=" + ID);
			this.cacheEmployee(em);
		}
		return em;
	}

	// 清除那些所软引用的Employee对象已经被回收的EmployeeRef对象
	private void cleanCache() {
		EmployeeRef ref = null;
		while ((ref = (EmployeeRef) q.poll()) != null) {
			employeeRefs.remove(ref._key);
		}
	}

	// 清除Cache内的全部内容
	public void clearCache() {
		cleanCache();
		employeeRefs.clear();
		System.gc();
		System.runFinalization();
	}
}
