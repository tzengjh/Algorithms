/*
* @Author: tzengjh
* @Date:   2018-04-05 16:30:16
* @Last Modified by:   tzengjh
* @Last Modified time: 2018-04-11 13:19:10
*/
/**
 * Longest Common Substring
 */
import java.util.Scanner;
import java.lang.StringBuilder;

public class LCStr{

    private static String lcstr(String a, String b){
        int lena = a.length();
        int lenb = b.length();
        int[][] ls = new int[lena+1][lenb+1];
        int maxi = 0, maxj = 0;
        for(int i = 1; i <= lena; i++){
            for(int j = 1; j <= lenb; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    ls[i][j] = ls[i-1][j-1] + 1;
                    if(ls[i][j] > ls[maxi][maxj]){
                        maxi = i;
                        maxj = j;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = maxi, j = maxj;
        while(ls[i][j] > 0){
            sb.append(b.charAt(--j));
            i--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String s1 = scan.next();
            String s2 = scan.next();
            System.out.println(lcstr(s1, s2));
        }
        scan.close();
    }

}
