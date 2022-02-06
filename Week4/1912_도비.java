import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] numArray = new int[N];
		int[] dp = new int[N];
		
		for (int i = 0; i < N; i++) {
			numArray[i] = scan.nextInt();
		}
		int max = numArray[0];
		dp[0] = numArray[0];
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i - 1] + numArray[i], numArray[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
//알고리즘 강의에서 나왔던 내용과 유사
