package ect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xiongxiaoyu on 2018/3/14.
 */
public class convertTest {
	public static void main(String[] args) {
		List<String> collected = new ArrayList<>();
		collected.add("alpha");
		collected.add("beta");
		collected = collected.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());
		System.out.println(collected);
	}
}
