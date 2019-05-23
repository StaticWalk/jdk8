package ect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiongxiaoyu
 * Data:2018/3/26
 * Time:22:09
 */
public class TestComparable {
		class Dog{
			public int age;
			public String name;
			public Dog(int age, String name) {
				super();
				this.age = age;
				this.name = name;
			}

			@Override
			public String toString() {
				return " \n Dog [age=" + age + ", name=" + name + "]";
			}
		}
		public static void main(String[] args) {
			List<Dog> list= new ArrayList<>();
			list.add(new TestComparable().new Dog(5, "DogA"));
			list.add(new TestComparable().new Dog(6, "DogB"));
			list.add(new TestComparable().new Dog(7, "DogC"));
//			Collections.sort(list, (o1, o2) -> o2.age - o1.age);
//			System.out.println("给狗狗按照年龄倒序："+list);
			Collections.sort(list, Comparator.comparing(o -> o.name));
			System.out.println("给狗狗按名字字母顺序排序："+list);
		}


//	class Apple {
//		public String color;
//		public int weight;
//		public Apple(String color, int weight) {
//			super();
//			this.color = color;
//			this.weight = weight;
//		}
//		public String toString() {
//			return "Apple [color=" + color + ", weight=" + weight + "]";
//		}
//	}
//
//	public static <T> List<List<T>> divider(Collection<T> datas, Comparator<? super T> c) {
//		List<List<T>> result = new ArrayList<>();
//		for (T t : datas) {
//			boolean isSameGroup = false;
//			for (int j = 0; j < result.size(); j++) {
//				if (c.compare(t, result.get(j).get(0)) == 0) {
//					isSameGroup = true;
//					result.get(j).add(t);
//					break;
//				}
//			}
//			if (!isSameGroup) {
//				List<T> innerList = new ArrayList<T>();
//				result.add(innerList);
//				innerList.add(t);
//			}
//		}
//		return result;
//	}
//
//	public static void main(String[] args) {
//		List<Apple> list = new ArrayList<>();
//		list.add(new TestComparable().new Apple("红", 205));
//		list.add(new TestComparable().new Apple("红", 131));
//		list.add(new TestComparable().new Apple("绿", 248));
//		list.add(new TestComparable().new Apple("绿", 153));
//		list.add(new TestComparable().new Apple("黄", 119));
//		list.add(new TestComparable().new Apple("黄", 224));
//		List<List<Apple>> byColors = divider(list, Comparator.comparing(o -> o.color));
//		System.out.println("按颜色分组" + byColors);
//		List<List<Apple>> byWeight = divider(list, (o1, o2) -> (o1.weight / 100 == o2.weight / 100) ? 0 : 1);
//		System.out.println("按重量级分组" + byWeight);
//	}
}
