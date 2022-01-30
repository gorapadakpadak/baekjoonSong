import java.util.*;

public class Main {
	static char candyColor[][];

	public static void swap(int x1, int y1, int x2, int y2) {
		char tmp = candyColor[x1][y1];
		candyColor[x1][y1] = candyColor[x2][y2];
		candyColor[x2][y2] = tmp;
	}

	public static int check(char[][] candyColor) {
		int length = candyColor.length;
		int answer = 1;
		for (int i = 0; i < length; i++) {
			int count = 1;
			for (int j = 1; j < length; j++) {
				if (candyColor[i][j] == candyColor[i][j - 1]) {
					count += 1;
				} else {
					count = 1;
				}
				if (answer < count)
					answer = count;
			}
			count = 1;
			for (int j = 1; j < length; j++) {
				if (candyColor[j][i] == candyColor[j - 1][i]) {
					count += 1;
				} else {
					count = 1;
				}
				if (answer < count)
					answer = count;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		candyColor = new char[N][N];
		for(int i = 0; i < N; i++) {
			String tmp = scan.next();
			for(int j = 0; j < N; j++) {
				candyColor[i][j] = tmp.charAt(j);
			}
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j + 1 < N) {
					swap(i, j, i, j + 1);
					int temp = check(candyColor);
				}
				if (i + 1 < N) {
					swap(i, j, i + 1, j);
					int temp = check(candyColor);
					if (answer < temp) {
						answer = temp;
					}
					swap(i, j, i + 1, j);
				}
			}
		}
		System.out.println(answer);
	}
}
