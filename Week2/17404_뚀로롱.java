package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static int[][] cost,dp;
    public static int pmax,ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        cost=new int[n][3]; //i번째 집을 j번째 색갈로 칠할때 드는 비용 받는 배열
        dp=new int[n][3]; //dp[i][j] 0번째 부터 i번째 집까지 칠할때 들어가는 비용 (최솟값 & i색은 j)
        for(int i=0;i<n;i++){
            //나는 양방향 연결리스트로 하려고 했는데 이거 그냥 이차원배열 만들면 됐다
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                int x = Integer.parseInt(st.nextToken());
                cost[i][j]=x;
            }
        }
        //비용 각각 일단 cost 배열에 저장
        pmax=1000*n+1; //0번째 집을 정해진 색이 아닌 다른 색으로 칠할때의 초기값
        ans=1000001;
        for(int k=0;k<3;k++){
            for(int i=0;i<3;i++) {
                if(i==k) dp[0][i]=cost[0][i];
                else dp[0][i]=pmax;
                //안 같을때는 i까지 최소비용(dp[0][m])을 pmax로 설정
            }//첫번째 집 색칠하는 경우의 수
            for(int i=1;i<n;i++){
                //i번째 집 0,1,2경우에 따른 총 비용 (이전 비용중 최솟값 골라서 더하기)
                dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+cost[i][0];
                dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+cost[i][1];
                dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+cost[i][2];
            }
            for(int i=0;i<3;i++){
                if(i==k) continue;
                ans=Math.min(ans,dp[n-1][i]);//마지막 집을 i로 칠한 값 중 작은 값
            }
        }
        System.out.print(ans);


    }
}