import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		final int goodByeDay = N + 1;
		int currentDay = 1;
		int endDay;
		int max = 0;
		int[] timeArray = new int[N + 1];
		int[] payArray = new int[N + 1];
		int[] maxArray = new int[N + 2];
		for (int i = 1; i <= N; i++) {
			timeArray[i] = scan.nextInt();
			payArray[i] = scan.nextInt();
		}

		for (int i = N; i > 0; i--) {
			if (i + timeArray[i] > N + 1) {
				maxArray[i] = maxArray[i + 1];
			} 
			else {
				maxArray[i] = Math.max(maxArray[i + 1], maxArray[i + timeArray[i]] + payArray[i]);
			}
		}
		System.out.println(maxArray[1]);
	}
}
