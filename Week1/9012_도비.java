import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();

		int numOfLines = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < numOfLines; i++) {
			String inputLine = scan.nextLine();
			String answer = "YES";
			for (int j = 0; j < inputLine.length(); j++) {
				char c = inputLine.charAt(j);
				if (c =='(') {
					stack.push(c);
				}
				else if (c == ')') {
					if (stack.isEmpty()) {
						answer = "NO";
						break;
					}
					else
						stack.pop();
				}
			}
			if (!stack.isEmpty())
				answer = "NO";
			System.out.println(answer);
			stack.clear();
		}
	}
}
