package com.company;
import java.io.*;
import java.util.*;
public class Main {
    static int[] dp;
    //시간초과-O(2^n)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            int x=Integer.parseInt(st.nextToken());
            dp[i]=x;
        }
        System.out.print(maxPrice(n));
    }
    public static int maxPrice(int n){
        int price=0;
        if(n==0){
            return 0;
        }
        for(int j=0; j<n;j++){
            price = Math.max(price, dp[j] +maxPrice(n-j-1));
        }
        return price;
    }

}


