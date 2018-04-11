/*
* @Author: tzengjh
* @Date:   2018-04-05 16:30:16
* @Last Modified by:   tzengjh
* @Last Modified time: 2018-04-11 11:35:21
*/
/**
 * Longest Common Subsequence
 */
import java.util.Scanner;
import java.lang.StringBuilder;

public class LCS{

    private static String lcs(String a, String b){
        int lena = a.length();
        int lenb = b.length();
        int[][] ls = new int[lena+1][lenb+1];
        for(int i = 1; i <= lena; i++){
            for(int j = 1; j <= lenb; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    ls[i][j] = ls[i-1][j-1] + 1;
                }else{
                    ls[i][j] = ls[i-1][j] > ls[i][j-1] ? ls[i-1][j]:ls[i][j-1];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = lena, j = lenb;
        while(i > 0 && j > 0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                i--;
                j--;
                sb.append(a.charAt(i));
            }else if(ls[i][j] == ls[i-1][j]){  // control the direction
                i--;
            }else{
                j--;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String s1 = scan.next();
            String s2 = scan.next();
            System.out.println(lcs(s1, s2));
        }
        scan.close();
    }

}
