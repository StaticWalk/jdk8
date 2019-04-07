package DesignPatterns.工厂.抽象工厂;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/27
 * Time:21:45
 */
public class Customer {

	public static void main(String[] args){
		//生产宝马320系列配件
		FactoryBMW320 factoryBMW320 = new FactoryBMW320();
		factoryBMW320.createEngine();
		factoryBMW320.createAircondition();

		//生产宝马523系列配件
		FactoryBMW523 factoryBMW523 = new FactoryBMW523();
		factoryBMW320.createEngine();
		factoryBMW320.createAircondition();
	}

}
