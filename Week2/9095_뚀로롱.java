package com.company;
import java.io.*;
import java.util.*;
public class Main {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        //1,2,3더하기
        //1,2,3을 적절히 조합하여 합이 n이 되게 만들어야하므로 1+(n-1),2+(n-2),3+(n-3) 인 경우로 나눌 수 있고
        //n-1,n-2,n-3을 구하는 경우의 수를 재귀적으로 구해 더해주면 된다
        //1={1} 1가지
        //2={1+1},{2}  2가지
        //3={1+1+1},{1+2},{2+1},{3} 4가지
        //4=1+3,2+2,3+1=dp(3)+dp(2)+dp(1)=4+2+1
        //5=1+4,2+3,3+2=dp(4)+dp(3)+dp(2)
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-->0){
            int n=Integer.parseInt(br.readLine());
            bw.write(dp(n)+"\n");
        }
        bw.flush();
    }
    public static int dp(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 4;
        }
        return dp(n-1)+dp(n-2)+dp(n-3);
    }
    
}


