package DesignPatterns.工厂.工厂方法;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/27
 * Time:21:12
 */
public class Customer {


	public static void main(String[] args) {
		FactoryBMW320 factoryBMW320 = new FactoryBMW320();
		BMW320 bmw320 = factoryBMW320.createBMW();

		FactoryBMW523 factoryBMW523 = new FactoryBMW523();
		BMW523 bmw523 = factoryBMW523.createBMW();

	}
}
