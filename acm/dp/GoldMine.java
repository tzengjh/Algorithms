/*
* @Author: ZengJinghong
* @Date:   2018-04-08 23:51:09
* @Last Modified by:   tzengjh
* @Last Modified time: 2018-04-09 00:32:36
*/
/**
 * 问题描述:
 * 有people个人和num个金矿,开采每个金矿都需要i_People个人,可以获得i_GetGold个金子,并且用过的人不可以重复使用,
 * 问从这num个金矿中最多可以得到多少个金子;
 *
 * 输入:
 * 输入第一行有两个数,第一个是用来开采金矿的总人数,第二个是总金矿数。
 * 输入文件的第2至n+1行每行有两个数,第i行的两个数分别表示第i-1个金矿需要的人数和可以得到的金子数。
 *
 * 输出:
 * 输出一个整数,表示能够得到的最大金子数。
 * 输入样例;
 * 100 5
 * 77 92
 * 22 22
 * 29 87
 * 50 46
 * 99 90
 * 输出样例
 * 133
 */

import java.util.Scanner;
import java.lang.Math;
public class GoldMine{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int people = scan.nextInt(), num = scan.nextInt();
        int[] ps = new int[num];
        int[] gs = new int[num];
        for(int i = 0; i < num; i++){
            ps[i] = scan.nextInt();
            gs[i] = scan.nextInt();
        }

        // dynamic programming
        int[] preResult = new int[people + 1];
        int[] result = new int[people + 1];  // contains peeple == 0
        for(int i = 0; i < num; i++){
            if(i == 0){
                for(int j = 0; j < people + 1; j++){
                    if(j >= ps[i])
                        result[j] = gs[i];
                    else
                        result[j] = 0;
                }
            }else{
                for(int j = 0; j < people + 1; j++){
                    if(j >= ps[i])
                        result[j] = Math.max(preResult[j - ps[i]] + gs[i], preResult[j]); // f(n,p) = max{f(n-1, p), f(n-1,p-ps[n]) + gs[n]}
                    else
                        result[j] = preResult[j];
                }
            }
            int[] temp = preResult;  // exchange
            preResult = result;
            result = temp;
        }
        System.out.println(preResult[people]);
        scan.close();
    }
}
