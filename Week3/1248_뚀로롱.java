package com.company;
import java.io.*;
import java.util.*;


public class Main {
    public static int n;
    public static int[] A;
    public static char[][] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        S = new char[n][n];
        char[] line = br.readLine().toCharArray();
        //n개의 수를 연속으로 더하는 방법은 n+(n-1)+...+1=n*(n+1)/2가지
        int limit=n*(n+1)/2;
        int r=0; int c=0;
        //S배열에 line을 한 문자씩 넣어줌
        for (int i = 0; i < limit; i++) {
            S[r][c]=line[i];
            c++;
            if(c==n){
                r++;
                c=r;
            }
        }
        backtracking(n - 1, 0);

    }

    //boolean형의 리턴을 통해 찾는 즉시 backtracking이 끝나도록 한다.
    private static boolean backtracking(int depth, int sum) {
        if (depth == -1) {
            //N개의 숫자를 모두 정했을 때 탈출
            for (int i = 0; i < n; ++i) {
                System.out.print(A[i] + " ");
            }
            return true;
        }
        for (int i = -10; i <= 10; ++i) {
            //S배열의 두 인덱스가 같을때가 A배열의 각 자리수의 부호가 들어가는
            if ((S[depth][depth]=='+' && i <= 0) || (S[depth][depth]=='-' && i >= 0) || (S[depth][depth]=='0' && i != 0))
                continue;
            boolean flag = true;
            //tempSum에 i를 -10부터 증가시키면서 계속 더해줌
            int tempSum = sum + i;
            //depth에 넣을 숫자를 찾는다
            for (int j = n - 1; j >= depth + 1; --j) {
                    //S[0][n-1] S[0][n-2] ...S[0][depth+1]...이런식으로 가로로 훑으면서 합계조건 확인
                if ((S[depth][j]=='+' && tempSum <= 0) || (S[depth][j]=='-' && tempSum >= 0) || (S[depth][j]=='0' && tempSum != 0)) {
                    flag = false;
                    break;
                }
                //이전에 선택됐던 수는 빼주면서 확인
                tempSum -= A[j];

            }
            if (flag) {
                A[depth] = i;
                if (backtracking(depth - 1, sum + i)) return true;
            }
        }
        return false;
    }
}


