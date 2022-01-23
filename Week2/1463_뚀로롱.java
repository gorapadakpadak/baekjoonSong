package com.company;
import java.io.*;
import java.util.*;
public class Main {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1로 만들기
        //dp를 배운지 오래돼서 낯설어서 구글링했습니당,,ㅜ
        //bottom-up
        int n = Integer.parseInt(br.readLine());
        //ex)n=10
        //dp[10]=dp[10/3]+1=dp[3]+1 x
        //dp[10]=dp[10/2]+1=dp[5]+1=dp[4]+1+1=dp[2]+1+1+1=dp[1]+1+1+1+1
        //dp[10]=dp[10-1]+1=dp[9]+1=dp[3]+1+1=dp[1]+1+1+1
        dp = new Integer[n + 1];
        dp[0] = dp[1] = 0;
        for(int i=2; i<=n;i++){
            dp[i]=dp[i-1]+1;
            //dp[i]에 i-1 연산한 경우 저장
            if(i%2==0){
                dp[i]=Math.min(dp[i],dp[i/2]+1);
                //2로 나누었을때와 1을 뺀 경우 비교
            }
            if(i%3==0){
                dp[i]=Math.min(dp[i],dp[i/3]+1);
                //3으로 나누었을때와 1을 뺀 경우 비교
                //if 따로 쓴 이유 : 2,3 둘다 나누어 떨어지는 6의 배수 처리
            }
        }
        System.out.print(dp[n]);

    }

    
}


