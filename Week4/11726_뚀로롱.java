package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%10007;
        }
        System.out.print(dp[n]);
    }

}


