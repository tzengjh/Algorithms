/*
* @Author: a
* @Date:   2018-04-08 20:59:29
* @Last Modified by:   a
* @Last Modified time: 2018-04-08 21:27:09
*/
/**
 * walk to the top of n stairs takeing one step or two each time.
 * how many ways?
 */
import java.util.HashMap;
import java.util.Scanner;

public class Stairs{

    // memo algorithm
    public static int getClimbingWays(int n, HashMap<Integer, Integer> map){
        if(n <= 0) return 0;
        if(n == 1 || n == 2) return n;
        if(map.containsKey(n)){
            return map.get(n);
        }else{
            return getClimbingWays(n - 1, map) + getClimbingWays(n - 2, map);
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("----------memo algorithm----------");
        HashMap map = new HashMap<Integer, Integer>();
        for(int i = 1; i <= 10; i ++)
            System.out.println("Climbing ways of " + i + ": " + getClimbingWays(i, map));



        // dynamic programming
        System.out.println("----------dynamic programming----------");
        int a = 1;
        int b = 2;
        System.out.println("Boundary conditions: ");
        System.out.println("Climbing ways of 1: " + a);
        System.out.println("Climbing ways of 2: " + b);
        for(int i = 3; i <= 10; i ++){
            int temp = a + b;
            a = b;
            b = temp;
            System.out.println("Climbing ways of " + i + ": " + temp);
        }
        scan.close();
    }
}
