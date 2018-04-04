/**
* 给定一个只包含'W'和'E'的字符串，找寻最佳划分位置使得划分位置
* 左侧的'W'和右侧的'E'的个数和最小。
* 输入：String
* 输出：划分位置 和
*/
import java.util.Scanner;

public class WE{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s = sc.nextLine();
			char[] cs = s.toCharArray();
			int sum = 0;
			for(int i = 0; i < cs.length; i ++)
				if(cs[i] == 'E')
					sum ++;
			boolean flag = false;
			int wsum = 0;
			int esum = 0;
			int loc = 0;
			for(int i = 0; i < cs.length; i ++){
				if(!flag){
					if(cs[i] == 'E'){
						sum --;
						loc = i + 1;
					}
					else{
						flag = true;
						wsum = 1;
						esum = 0;
					}
				}else{
					if(cs[i] == 'E')
						esum ++;
					else
						wsum ++;

					if(wsum == esum){
						flag = false;
						loc = i + 1;
					}
				}
			}
			System.out.println(loc + " " + sum);
		}	
		sc.close();	
	}
}