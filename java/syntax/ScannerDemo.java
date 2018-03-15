import java.util.Scanner;

class ScannerDemo{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double sum = 0;
		int num = 0;
		while(scan.hasNextDouble()){
			sum += scan.nextDouble();
			num += 1;
		}
		System.out.println("sum is " + sum);
		System.out.println("aver is " + (sum / num));
		scan.close();
	}
}