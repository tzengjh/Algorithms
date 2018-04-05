/*
* @Author: tzengjh
* @Date:   2018-04-04 23:57:21
* @Last Modified by:   tzengjh
* @Last Modified time: 2018-04-05 13:37:11
*/

/**
 * Description
 * The input contains N natural (i.e. positive integer) numbers ( N <= 10000 ).
 * Each of that numbers is not greater than 15000.
 * This numbers are not necessarily different (so it may happen that two or more of them will be equal).
 * Your task is to choose a few of given numbers ( 1 <= few <= N ) so that the sum of chosen numbers is
 * multiple for N (i.e. N * k = (sum of chosen numbers) for some natural number k).
 *
 * Input
 * The first line of the input contains the single number N. Each of next N lines contains one number from the given set.
 *
 * Output
 * In case your program decides that the target set of numbers can not be found it should print to the output the single number 0.
 * Otherwise it should print the number of the chosen numbers in the first line followed by the chosen numbers themselves
 * (on a separate line each) in arbitrary order.
 * If there are more than one set of numbers with required properties you should print to the output only one
 * (preferably your favorite) of them.
 *
 * Sample Input
 * 5
 * 1
 * 2
 * 3
 * 4
 * 1
 * Sample Output
 * 2
 * 2
 * 3
 *
 * Source(http://poj.org/problem?id=2356)
 * Ural Collegiate Programming Contest 1999
 */
import java.util.Scanner;

public class FindAMultiple{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] a = new int[N];
        int[] s = new int[N + 1];
        int[] h = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = scan.nextInt();
            s[i + 1] = (s[i] + a[i]) % N;     // not use s[0], s[i] is (the sum of a[0]...a[i - 1]) % N
        }
        scan.close();
        int lo = 0, hi = 0;
        for(int i = 1; i < N + 1; i++){
            if(s[i] == 0){
                lo = 0;
                hi = i - 1;
                break;
            }else if(h[s[i]] != 0){
                lo = h[s[i]];  // s[i] - s[j]  = K * N ==> (s[i] - s[j]) % N = 0 ==> s[i] % N = s[j] % N
                hi = i - 1;    // get the subset [i + 1, j]
                break;
            }else h[s[i]] = i;
        }
        System.out.println(hi - lo + 1);
        for(int i = lo; i <= hi; i ++)
            System.out.println(a[i]);
    }
}
