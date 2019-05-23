package DesignPatterns.原型;

/**
 * Created by xiongxiaoyu
 * Data:2019/4/13
 * Time:10:54
 *
 * 原型模式创建对象比new性能好得多，clone是一个本地方法，操作内存二进制流，复制大对象性能明显
 * 需要重复创建相似对象使用
 * 不会使用类构造方法，clone(),会无视访问权限
 * 单例和原型是冲突的
 *
 */
public class Client {

	static class Prototype implements Cloneable{
		@Override
		public Prototype clone(){
			Prototype prototype = null;
			try {
				prototype = (Prototype) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return prototype;
		}
	}

	static class ConcretePrototype extends Prototype{
		public void show(){
			System.out.println("this is ProtoType");
		}
	}

	public static void main(String[] args) {
		ConcretePrototype cp = new ConcretePrototype();
		for (int i = 0; i < 10; i++) {
			ConcretePrototype concretePrototype  = (ConcretePrototype) cp.clone();
			concretePrototype.show();
		}
	}

}
