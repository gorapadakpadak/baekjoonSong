package com.company;
import java.io.*;
import java.util.*;


public class Main {
    public static long[][] dp;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int k=scan.nextInt();
        dp=new long[201][201];
        for(int i=0;i<=n;i++){
            dp[1][i]=1;
        }
        for(int i=2;i<=k;i++){
            for(int j=0;j<=n;j++){
                for(int l=0;l<=j;l++){
                    dp[i][j]+=dp[i-1][j-l];
                    dp[i][j]%=1000000000;
                }
            }

        }
        System.out.print(dp[k][n]);

    }
}


