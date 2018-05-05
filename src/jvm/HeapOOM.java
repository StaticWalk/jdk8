package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiongxiaoyu
 * Data:2018/5/5
 * Time:11:06
 *
 *
 * 原文要求是先设置虚拟机启动参数，但是没有看懂！！
 * 	Java堆内存溢出异常测试
 * 	 Solution:	Run -> Edit Configurations -> VM Options 设置VM参数
 *  VM Args: -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 *
 */
public class HeapOOM {

	static class OOMObject{}

	public static void main(String[] args) {
		List<OOMObject> list=new ArrayList<>();
		while (true){
			list.add(new OOMObject());
		}
	}
}
