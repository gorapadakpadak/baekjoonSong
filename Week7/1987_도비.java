import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int x = scan.nextInt();
			if (x == 2) {
				answer++;
			}
			for (int j = 2; j < x; j++) {
				if (x % j == 0) {
					break;
				}
				if (j == x - 1) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
