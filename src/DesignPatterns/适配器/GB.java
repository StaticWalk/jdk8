package DesignPatterns.适配器;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/28
 * Time:13:10
 */
interface GB {
	void powerWithThreeRound();
}

class GBSocket implements GB {

		@Override
		public void powerWithThreeRound() {
			System.out.println("使用三项圆头的插孔供电");
		}
}
