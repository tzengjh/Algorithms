/**
 * Longest increasing subsequence
 * find the longest increasing subsequence of array
 */

import java.util.Scanner;

public class LIS{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] a = new int[N];
        for(int i = 0; i < N; i ++)
            a[i] = scan.nextInt();
        int[] d = new int[N];
        int maxLen = 1;
        for(int i = 0; i < N; i ++){
            d[i] = 1;
            for(int j = 0; j < i; j ++){
                if(a[j] <= a[i] && d[j] + 1 > d[i])
                    d[i] = d[j] + 1;
            }
            if(d[i] > maxLen) maxLen = d[i];
        }
        System.out.println(maxLen);
        scan.close();
    }
}
