import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] heightArray = new int[9];
		int sum = 0;
		int notDwarf1 = 0, notDwarf2 = 0;
		for (int i = 0; i < 9; i++) {
			heightArray[i] = scan.nextInt();
			sum += heightArray[i];
		}
		Arrays.sort(heightArray);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < i; j++) {
				if (sum - (heightArray[i] + heightArray[j]) == 100) {
					notDwarf1 = i;
					notDwarf2 = j;
					break;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (i == notDwarf1 || i == notDwarf2)
				continue;
			System.out.println(heightArray[i]);
		}
	}
}
