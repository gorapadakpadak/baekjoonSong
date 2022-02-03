import java.io.*;
import java.util.*;

public class boj2225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		StringTokenizer st = new StringTokenizer(string, " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long dp[][] = new long[201][201];
		for (int i = 0; i <= 200; i++) {
			dp[i][0] = 1;
			dp[1][i] = 1;
		}
		for (int i = 1; i <= 200; i++) {
			dp[2][i] = i + 1;
		}
		for (int i = 3; i <= 200; i++) {
			for (int j = 1; j <= 200; j++) {
				for (int m = 0; m <= j; m++) {
					dp[i][j] += dp[i - 1][j - m] % 1000000000;
				}
			}
		}
		System.out.println(dp[K][N] % 1000000000);
	}
}
