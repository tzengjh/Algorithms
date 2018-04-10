/*
* @Author: tzengjh
* @Date:   2018-04-10 10:04:14
* @Last Modified by:   tzengjh
* @Last Modified time: 2018-04-10 11:29:29
*/
import java.util.Scanner;
import java.lang.Integer;

public class Dijkstra{

    public static int[] shortPaths(int vertex, int[][] graph){
        if(graph == null || graph.length == 0 || graph[0] == null || graph[0].length == 0 || vertex < 0 || vertex >= graph.length)
            throw new IllegalArgumentException();
        int N = graph.length;
        int[] minDist = new int[N];
        boolean[] visited = new boolean[N];
        for(int i = 0; i < N; i++)
            minDist[i] = Integer.MAX_VALUE;
        minDist[vertex] = 0;
        for(int i = 0; i < N; i++){
            int index = findMinAndUnvisited(minDist, visited);
            if(index == -1) break;
            visited[index] = true;
            for(int j = 0; j < N; j++){
                if(graph[index][j] != 0 && minDist[index] + graph[index][j] < minDist[j])
                    minDist[j] = minDist[index] + graph[index][j];
            }
        }
        return minDist;
    }

    private static int findMinAndUnvisited(int[] dis, boolean[] visited){
        int index = -1;
        boolean flag = false;
        for(int i = 0; i < dis.length; i++){
            if(!flag){
                if(!visited[i]){
                    index = i;
                    flag = true;
                }
            }else{
                if(!visited[i] && dis[i] < dis[index])
                    index = i;
            }
        }
        return index;
    }


    public static void main(String[] args){
        int[][] graph = {{0,3,5,7,0},
                         {3,0,4,2,0},
                         {5,4,0,5,4},
                         {7,2,5,0,6},
                         {0,0,4,6,0}};
        for(int i = 0; i < graph.length; i++){
            int[] minDist = shortPaths(i, graph);
            System.out.println("Minimal distance of " + i + " to other nodes.");
            for(int j = 0; j < minDist.length; j++)
                System.out.print(minDist[j] + " ");
            System.out.println();
        }
    }
}
