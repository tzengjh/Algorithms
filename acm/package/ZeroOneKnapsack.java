import java.util.Scanner;

public class ZeroOneKnapsack{

    /*
    * input: {N,C} = {5,10} {c,v} = {{4,9},{3,6},{5,1},{2,4},{5,1}}
    * output: 19
    */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int N = scan.nextInt();
            int C = scan.nextInt();
            int[] caps = new int[N];
            int[] values = new int[N];
            for(int i = 0; i < N; i++){
                caps[i] = scan.nextInt();
                values[i] = scan.nextInt();
            }
            int[][] maxValues = new int[N+1][C+1];
            // int[] maxValues = new int[C+1];
            for(int i = 1; i < N + 1; i++){
                for(int j = C; j > 0; j--){
                    maxValues[i][j] = j >= caps[i-1] ? Math.max(maxValues[i-1][j], maxValues[i-1][j-caps[i-1]] + values[i-1]) : maxValues[i-1][j];
                    // maxValues[j] = j >= caps[i-1] ? Math.max(maxValues[j], maxValues[j-caps[i-1]] + values[i-1]) : maxValues[j];
                }
            }
            System.out.println(maxValues[N][C]);

            // show which object is selected
            boolean[] isSelected = new boolean[N];
            int remains = C;
            for(int i = N; i >= 1; i--){
                if(maxValues[i][remains] > maxValues[i-1][remains]){
                    isSelected[i-1] = true;
                    remains -= caps[i-1]; // until maxValues[0][remains]
                }
            }
            for(int i = 0; i < N; i++)
                if(isSelected[i]){
                    System.out.print("1 ");
                }else{
                    System.out.print("0 ");
                }
            System.out.println();
        }
        scan.close();
    }
}
