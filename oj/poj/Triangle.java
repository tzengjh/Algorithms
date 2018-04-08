/*
* @Author: tzengjh
* @Date:   2018-04-08 19:48:51
* @Last Modified by:   a
* @Last Modified time: 2018-04-08 20:40:45
*/
/**
 * Peking University JudgeOnline
 * Prob.ID: 1163
 * Description
 * 7
 * 3   8
 * 8   1   0
 * 2   7   4   4
 * 4   5   2   6   5
 * (Figure 1)
 * Figure 1 shows a number triangle. Write a program that calculates the highest sum of numbers passed on a route
 * that starts at the top and ends somewhere on the base.
 * Each step can go either diagonally down to the left or diagonally down to the right.
 *
 * Input
 * Your program is to read from standard input. The first line contains one integer N: the number of rows in the triangle.
 * The following N lines describe the data of the triangle. The number of rows in the triangle is > 1 but <= 100.
 * The numbers in the triangle, all integers, are between 0 and 99.
 * Output
 * Your program is to write to standard output. The highest sum is written as an integer.
 */
import java.util.Scanner;
import java.lang.Math;

public class Triangle{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[][] tri = new int[N][N];
        for(int i = 0; i < N; i ++)
            for(int j = 0; j <= i; j ++)
                tri[i][j] = scan.nextInt();

        int[][] max = new int[N][N];
        for(int i = 0; i < N; i ++)
            max[N-1][i] = tri[N-1][i];
        for(int i = N-2; i >= 0; i --)
            for(int j = 0; j <= i; j ++)
                max[i][j] = tri[i][j] + Math.max(max[i+1][j], max[i+1][j+1]);

        System.out.println(max[0][0]);
        scan.close();
    }
}
