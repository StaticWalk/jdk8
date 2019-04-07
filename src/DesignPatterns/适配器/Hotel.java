package DesignPatterns.适配器;

/**
 * Created by xiongxiaoyu
 * Data:2019/2/28
 * Time:13:11
 */
public class Hotel {

	private DB db;


	public Hotel() {
	}

	public Hotel(DB db) {
		this.db = db;
	}

	public void setDb(DB db) {
		this.db = db;
	}

	public void charge(){
		db.powerWithTwoRound();
	}
}
