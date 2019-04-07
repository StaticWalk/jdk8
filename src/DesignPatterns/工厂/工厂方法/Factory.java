package DesignPatterns.工厂.工厂方法;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/27
 * Time:21:11
 */
 interface FactoryBMW {
	BMW createBMW();
}

 class FactoryBMW320 implements FactoryBMW{

	@Override
	public BMW320 createBMW() {
		return new BMW320();
	}

}
 class FactoryBMW523 implements FactoryBMW {
	@Override
	public BMW523 createBMW() {
		return new BMW523();
	}
}
