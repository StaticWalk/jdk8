package mianshi.Decorator;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/23
 * Time:16:15
 */

//concreteConmponent具体的组件
public class Teenager extends Person {

	public Teenager(){
		description = "Shopping List:";
	}

	@Override
	public double cost() {
		return 0;
	}
}
