import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int numOfLines = Integer.parseInt(scan.nextLine());
		int[] stack = new int[numOfLines];
		int size = 0;
		
		for (int i = 0; i < numOfLines; i++) {
			String line = scan.next();
			if (line.equals("push")) {
				stack[size] = scan.nextInt();
				size++;
			} 
			else if (line.equals("pop")) {
				if (size == 0)
					sb.append("-1\n");
				else {
					sb.append(stack[size - 1]+"\n");
					stack[size - 1] = 0;
					size--;
				}
			} 
			else if (line.equals("size")) {
				sb.append(size+"\n");
			} 
			else if (line.equals("empty")) {
				if (size == 0)
					sb.append("1\n");
				else
					sb.append("0\n");
			} 
			else if (line.equals("top")) {
				if (size == 0)
					sb.append("-1\n");
				else
					sb.append(stack[size -1]+"\n");
			}
		}
		System.out.println(sb);
	}
}
