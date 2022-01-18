package com.company;
import java.io.*;
import java.util.*;
public class Main {
    static int[] dp;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp=new int[n+1];
        p=new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=n;i++){
            int x=Integer.parseInt(st.nextToken());
            p[i]=x;
        }
        for(int i=1;i<=n;i++){
            for (int j=1; j<=i;j++){
                dp[i]=Math.max(dp[i],dp[i-j]+p[j]);
            }
        }
        System.out.print(dp[n]);
    }

}


