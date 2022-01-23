import java.util.Scanner;

public class Main {
	public static int[] minList;
  
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		minList = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			minList[i] = i;
			for (int j = 1; j*j <= i; j++) {
				minList[i] = Math.min(minList[i], minList[i - j*j] + 1);
			}
		}
		System.out.println(minList[N]);
	}
}
