import java.lang.Integer;
import java.util.Scanner;

public class Paint{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] lines = line.trim().split("\\s+");
		int M = Integer.parseInt(lines[0]);
		int N = Integer.parseInt(lines[1]);
		System.out.println("Using function:" + pFunction(M, N));
		System.out.println("Using subtraction recursion:" + subR(M, N));
		System.out.println("Using addition recursion:" + addR(M, N));
	}

	// 1) S(N, M) = M(M-1)^(N-1) - S(N-1, M)
	public static int subR(int M, int N){
		if(N < 0 || M < 0)
			throw new IllegalArgumentException();
		if(N == 0)
			return 0;
		if(N == 1)
			return M;
		if(N == 2)
			return M*(M - 1);
		return M*pow(M-1, N-1) - subR(M, N-1);
	}

	// 2) f(n) = (-1)^n*(m-1) + (m-1)^n (n >= 2)
	public static int pFunction(int M, int N){
		if(N < 0 || M < 0)
			throw new IllegalArgumentException();
		if(N == 0)
			return 0;
		if(N == 1)
			return M;
		return pow(-1, N) * (M - 1) + pow(M - 1, N);
	}

	public static int addR(int M, int N){
		if(N < 0 || M < 0)
			throw new IllegalArgumentException();
		if(N == 0)
			return 0;
		if(N == 1)
			return M;
		if(N == 2)
			return M*(M - 1);
		if(N == 3)
			return M*(M - 1)*(M - 2);
		return (M-2) * addR(M, N-1) + (M-1)* addR(M, N-2);
	}

	public static int pow(int M, int N){
		int m = 1;
		for(int i = 0; i < N; i ++)
			m *= M;
		return m;
	}

}