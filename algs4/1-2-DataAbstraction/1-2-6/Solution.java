public class Solution{

    public static boolean isCircularRotation(String a, String b){
        return a.length() == b.length() && ((a+a).substring(1, 2*a.length() - 1).indexOf(b)) != -1;
    }


    public static void main(String[] args){
        String a = "ACTGACG";
        String b = "TGACGAC";
        System.out.print(a + " is circular rotation of " + b + ":" + isCircularRotation(a,b));
    }
}
