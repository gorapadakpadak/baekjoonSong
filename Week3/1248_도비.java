mport java.util.Scanner;

public class Main {
    static int N;
    static char[][] matrix;
    static int[] data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //N 입력
        matrix = new char[N][N]; //이차원배열생성
        String str = sc.next();
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                matrix[i][j] = str.charAt(idx++); //배열입력
            }
        }

        data = new int[N];
        solve(0);
    }

    private static void solve(int depth) {
        if (depth == N) {
            for (int i : data) {
                System.out.print(i + " "); //i 출력
            }
            System.out.println();
            System.exit(0); // 프로그램 종료
        }
        for (int i = -10; i <= 10; i++) {
            data[depth] = i;
            if (check(depth)) {
                solve(depth + 1); //check함수가 true로 나올 경우 solve
            }
        }
    }

    private static boolean check(int idx) {
        for (int i = 0; i <= idx; i++) {
            int sum = 0;
            for (int j = i; j <= idx; j++) {
                sum += data[j];
                if (matrix[i][j] != (sum == 0 ? '0' : (sum > 0 ? '+' : '-'))) { //sum이 0이면 0, 0보다 크면 + 작으면 -
                    return false;
                }
            }
        }
        return true;
    }
}
