/*
* @Author: tzengjh
* @Date:   2018-09-10 11:01:37
* @Last Modified by:   ZengJinghong
* @Last Modified time: 2018-09-10 11:12:27
*/
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Josephus{

    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<Integer>();
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        for(int i = 0; i < N; i++)
            queue.offer(i);

        int count = 0;
        while(queue.size() != 0){
            int temp = queue.poll();
            count ++;
            if(count == M){
                System.out.print(temp + " ");
                count = 0;
            }else{
                queue.offer(temp);
            }
        }
    }
}
