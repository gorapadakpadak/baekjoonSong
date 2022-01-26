import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] numArray;
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int depth) {
		if (depth > M) {
			for (int i = 1; i <= M; i++) {
				sb.append(numArray[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			numArray[depth] = i;
			dfs(depth + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		numArray = new int[M + 1];
		dfs(1);
		System.out.println(sb);
	}
}
