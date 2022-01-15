import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numOfTest = Integer.parseInt(scan.nextLine());
		String[] testCaseArray = new String[numOfTest];
		for (int i = 0; i < numOfTest; i++) {
			testCaseArray[i] = scan.nextLine();
		}
		for (int i = 0; i < numOfTest; i++) {
			String[] splitWord = testCaseArray[i].split(" ");
			for (int j = 0; j < splitWord.length; j++) {
				int wordSize = splitWord[j].length()-1;
				String newWord = "";
				while(wordSize>=0) {
					newWord += splitWord[j].charAt(wordSize--);
				}
				System.out.print(newWord+" ");
			}
			System.out.println();
		}
	}
}
