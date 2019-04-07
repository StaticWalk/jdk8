package DesignPatterns.适配器;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/28
 * Time:13:14
 */
public class Test {

	public static void main(String[] args) {
		GBSocket gb = new GBSocket();
		Adaper adaper = new Adaper(gb);

		Hotel hotel = new Hotel(adaper);
		hotel.charge();
	}
}
