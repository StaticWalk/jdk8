package e;

import org.junit.Test;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by xiongxiaoyu
 * Data:2018/4/24
 * Time:20:50
 */
public class ShellDemo {

	public static String exec(String command) throws InterruptedException {
		String returnString = "";
		Process pro = null;
		Runtime runTime = Runtime.getRuntime();
		if (runTime == null) {
			System.err.println("Create runtime false!");
		}
		try {
			pro = runTime.exec(command);
			BufferedReader input = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			PrintWriter output = new PrintWriter(new OutputStreamWriter(pro.getOutputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				returnString = returnString + line + "\n";
			}
			input.close();
			output.close();
			pro.destroy();
		} catch (IOException ex) {
			Logger.getLogger(ShellDemo.class.getName()).log(Level.SEVERE, null, ex);
		}
		return returnString;
	}


	@Test
	public void test() throws Exception {
		System.out.println(exec("ls -al"));
	}


	public static void callShell(String shellString) {
		try {
			Process process = Runtime.getRuntime().exec(shellString);
			int exitValue = process.waitFor();
			if (0 != exitValue) {
				System.err.print("call shell failed. error code is :" + exitValue);
			}
		} catch (Throwable e) {
			System.err.print("call shell failed. " + e);
		}
	}

}
