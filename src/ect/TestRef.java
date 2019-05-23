package ect;

/**
 * Created by xiongxiaoyu
 * Data:2019/4/12
 * Time:14:12
 */
public class TestRef {


	public static void main(String[] args) throws CloneNotSupportedException {

		Obj a = new Obj();
		Obj b = (Obj) a.clone();
		b.change();
		System.out.println(a.getaInt());
		System.out.println(b.getaInt());

	}



	static class Obj implements Cloneable{
		private int aInt = 0;

		public void change(){
			this.aInt = 1;
		}

		public int getaInt() {
			return aInt;
		}

		public void setaInt(int aInt) {
			this.aInt = aInt;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			Obj o = (Obj) super.clone();
			return o;
		}
	}

}
