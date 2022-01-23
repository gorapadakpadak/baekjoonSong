import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] dp = new int[N + 1][3];
		int[][] arr = new int[N + 1][3];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		int answer = 1000 * N + 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == i) {
					dp[1][j] = arr[1][j];
				} 
        else {
					dp[1][j] = 1000 * 1000 + 1;
				}
			}
			for (int k = 2; k < N + 1; k++) {
				dp[k][0] = Math.min(dp[k - 1][1], dp[k - 1][2]) + arr[k][0];
				dp[k][1] = Math.min(dp[k - 1][0], dp[k - 1][2]) + arr[k][1];
				dp[k][2] = Math.min(dp[k - 1][1], dp[k - 1][0]) + arr[k][2];
			}
			for (int m = 0; m < 3; m++) {
				if (m != i) {
					answer = Math.min(answer, dp[N][m]);
				}
			}
		}
		System.out.println(answer);

	}

}
