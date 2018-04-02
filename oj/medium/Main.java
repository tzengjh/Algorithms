
import java.util.Scanner;

public class Main{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int na = 0,nb = 0;
	    while(sc.hasNext()){
	    	na = sc.nextInt();
	    	int[] a = new int[na + 1];
	    	for(int i = 0; i < na + 1; i ++)
	    		a[i] = sc.nextInt();
	    	nb = sc.nextInt();
	    	int[] b = new int[nb + 1];
	    	for(int i = 0; i < nb + 1; i ++)
	    		b[i] = sc.nextInt();

	    	int i = 0;
	    	for(; i < nb + 1 && i < na + 1; i ++){
	    		if(i % 2 == 0){
	    			if(a[i] > b[i]){
	    				System.out.println(">");
	    				break;
	    			}
	    			if(a[i] < b[i]){
	    				System.out.println("<");
	    				break;
	    			}
	    		}else{
	    			if(a[i] > b[i]){
	    				System.out.println("<");
	    				break;
	    			}
	    			if(a[i] < b[i]){
	    				System.out.println(">");
	    				break;
	    			}
	    		}
	    	}

	    	if(nb == na && i == na + 1)
	    		System.out.println("=");
	    	else if(i == na + 1){
	    		if(i == 1){
	    			System.out.println("<");
	    		}else if(i % 2 == 0){
	    			System.out.println("<");
	    		}else{
	    			System.out.println(">");
	    		}
	    	}else if(i == nb + 1){
	    		if(i == 1){
	    			System.out.println(">");
	    		}else if(i % 2 == 0){
	    			System.out.println(">");
	    		}else{
	    			System.out.println("<");
	    		}
	    	}
	    }
	    sc.close();
	}
}
