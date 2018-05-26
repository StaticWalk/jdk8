
/**
 * Created by xiongxiaoyu
 * Data:2018/5/23
 * Time:20:56
 */
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {//注意while处理多个case
			int x=in.nextInt();
			int[][]  a = new int[100][];
			for(int i=0;i<x;i++)
			{
				 a[i][0] = in.nextInt();
				 a[i][1] = in.nextInt();
				 a[i][2] = in.nextInt();
				 a[i][3] = in.nextInt();
			}
			for(int i=0;i<x;i++){
				int t=a[i][1]+2*a[i][2]+3*a[i][3];
				if(t<6*a[i][0]){
					System.out.println("NO");
				}

				else{
					if(t%6>3){
						System.out.println("NO");
					}
					else{
						System.out.println("YES");
					}
				}
			}
		}
	}
}