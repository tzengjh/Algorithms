import java.util.Scanner;

public class MultipleKnapsack{
    /*
    * input: {N,C} = {5,13} {c,v,tn} = {{4,9,1},{3,6,2},{5,1,3},{2,4,5},{5,1,1}}
    * output: 27
    */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int N = scan.nextInt();
            int C = scan.nextInt();
            int[] caps = new int[N];
            int[] values = new int[N];
            int[] nums = new int[N];
            for(int i = 0; i < N; i++){
                caps[i] = scan.nextInt();
                values[i] = scan.nextInt();
                nums[i] = scan.nextInt();
            }
            // int[][] maxValues = new int[N+1][C+1];
            int[] maxValues = new int[C+1];
            for(int i = 1; i < N + 1; i++){
                for(int j = C; j > 0; j--){
                    for(int k = 1; k <= nums[i-1]; k++){
                        // maxValues[i][j] = maxValues[i-1][j];
                        // maxValues[i][j] = j >= k*caps[i-1] ? Math.max(maxValues[i][j], maxValues[i-1][j-k*caps[i-1]] + k*values[i-1]) : maxValues[i][j]; (k={1,..,nums[i-1]})
                        if(j >= k*caps[i-1]){
                            maxValues[j] =  Math.max(maxValues[j], maxValues[j-k*caps[i-1]] + k*values[i-1]);
                        }else{
                            break;
                        }

                    }
                }
            }
            System.out.println(maxValues[C]);
        }
        scan.close();
    }
}
