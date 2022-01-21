import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] numArray = new int[N];
		int[] dpAsc = new int[N];
		int[] dpDesc = new int[N];
		for (int i = 0; i < N; i++) {
			numArray[i] = scan.nextInt();
		}
		for (int i = 0; i < N; i++) {
			dpAsc[i] = 1;
			for (int j = 0; j < i; j++) {
				if (numArray[j] < numArray[i] && dpAsc[i] < dpAsc[j] + 1) {
					dpAsc[i] = dpAsc[j] + 1;
				}
			}
		}
			
		for (int i = N - 1; i >= 0; i--) {
			dpDesc[i] = 1;
			for (int j = N - 1; j > i; j--) {
				if (numArray[j] < numArray[i] && dpDesc[i] < dpDesc[j] + 1) {
					dpDesc[i] = dpDesc[j] + 1;
				}
			}
		}
		int maxSum = 0;
		for (int i = 0; i < N; i++) {
			if (dpAsc[i] + dpDesc[i] - 1 > maxSum)
				maxSum = dpAsc[i] + dpDesc[i] - 1;
		}
		System.out.println(maxSum);
	}
}
