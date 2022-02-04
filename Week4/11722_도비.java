import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] numArray = new int[N];
		int[] dp = new int[N];

		for (int i = 0; i < N; i++) {
			numArray[i] = scan.nextInt();
		}
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (numArray[i] < numArray[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int maxSum = 0;
		for (int i = 0; i < N; i++) {
			if (dp[i] > maxSum)
				maxSum = dp[i];
		}
		System.out.println(maxSum);
	}
}
