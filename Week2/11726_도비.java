import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] dpArray = new int[N + 2];
		dpArray[1] = 1;
		dpArray[2] = 2;
		for (int i = 3; i <= N; i++) {
			dpArray[i] = dpArray[i - 1] + dpArray[i - 2];
			dpArray[i] %= 10007;
		}
		System.out.println(dpArray[N]);
	}
}
