import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		long[] dpArray = new long[N + 1];
		dpArray[0] = 0;
		dpArray[1] = 1;
		for (int i = 2; i <= N; i++) {
			dpArray[i] = dpArray[i - 1] + dpArray[i - 2];
		}
		System.out.println(dpArray[N]);
	}
}
