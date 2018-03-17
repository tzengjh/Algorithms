import java.util.Scanner;

public class BigMultiply{

	public static String multiply(String a, String b){
		char[] char1 = a.toCharArray();
		char[] char2 = b.toCharArray();

		int[] num1 = new int[char1.length];
		int[] num2 = new int[char2.length];
		int[] mul = new int[char1.length + char2.length];

		for(int i = 0; i < char1.length; i++)
			num1[char1.length - i - 1] = char1[i] - '0';
		for(int i = 0; i < char2.length; i++)
			num2[char2.length - i - 1] = char2[i] - '0';

		for(int i = 0; i < num1.length; i++)
			for(int j = 0; j < num2.length; j++)
				mul[i + j] += num1[i] * num2[j];

		for(int i = 0; i < mul.length - 1; i++){
			if(mul[i] / 10 > 0){
				mul[i + 1] += mul[i] / 10;
				mul[i] = mul[i] % 10; 
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = mul.length - 1; i >= 0; i--){
			if(sb.length() != 0)
				sb.append(mul[i]);
			else if(mul[i] != 0)
				sb.append(mul[i]);
		}

		return sb.toString();
	}


	public static void main(String[] args) {
        System.out.println("-----输入两个大数------");
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.next();
        String num2 = scanner.next();
        String result = multiply(num1, num2);
        System.out.println("相乘结果为："+result);
        scanner.close();
	}
}