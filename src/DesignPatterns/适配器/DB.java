package DesignPatterns.适配器;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/28
 * Time:13:08
 */
//德标两空插座
 interface DB {
	void powerWithTwoRound();
}

class DBSocket implements DB {

	@Override
	public void powerWithTwoRound() {
		System.out.println("使用两项圆头的插孔供电");
	}
}