/**
* 一队士兵在操场上排成一列，士兵总数为n，士兵按照队伍从前往后的顺序从1到n依次编号。
* 每个士兵有各自的身高，第i个士兵的身高为ai。士兵列队完毕后，将军走到队列的最前面。
* 因为身高不一，有些士兵可能被前面身高更高的挡住了，这样将军就看不到他们。
* 将军能看到某个士兵当且仅当他的身高严格大于他前面的所有士兵。
* 问将军一共能看到多少个士兵。
* 输入
* 第一行输入一个整数T（T＜=100），表示测试数据的组数。每组数据第一行输入一个数n（1=＜n＜=10000）表示士兵的个数，
* 第二行n个整数a1,a2,...,an（0=＜ai＜=1000000000），依次表示每一个士兵的身高。
* 输出
* 对于每组数据，输出一行，将军能看到的士兵数。
*/
import java.util.Scanner;

public class Soldiers{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int length = 0;
		int cur = 0, max = 0;
		int k = 0;
		for(int i = 0; i < N; i++){
			length = sc.nextInt();
			max = sc.nextInt();
			k= 1;
			for(int j = 1; j < length; j++){
				 cur = sc.nextInt();
				 if(cur > max){
				 	k++;
				 	max = cur;
				 }
			}
			System.out.println(k);
		}
	}
}