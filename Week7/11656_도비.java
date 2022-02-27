import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String S = scan.next();
		String[] list = new String[S.length()];
    
		for (int i = 0; i < S.length(); i++) {
			list[i] = S.substring(i, S.length());
		}
		Arrays.sort(list);
		for (int i = 0; i < S.length(); i++) {
			System.out.println(list[i]);
		}
	}
}
