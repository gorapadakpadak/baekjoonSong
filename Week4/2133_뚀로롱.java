package com.company;
import java.io.*;
import java.util.*;


public class Main {
    public static int n;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        n=scan.nextInt();
        int dp[]=new int[35];
        dp[0]=1;
        dp[2]=3;
        for(int i=4; i<=n;i++){
            dp[i]=dp[i-2]*3;
            for(int j=4;j<=i;j+=2){
                dp[i]+=dp[i-j]*2;
            }
        }
        System.out.print(dp[n]);
    }
}


