package DesignPatterns.适配器;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/28
 * Time:13:13
 */
public class Adaper implements DB {

	private GB gb;

	public Adaper(GB gb) {
		this.gb = gb;
	}

	@Override
	public void powerWithTwoRound() {
		gb.powerWithThreeRound();
	}
}
