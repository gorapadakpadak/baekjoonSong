package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static int[] seq;
    public static Integer[] rightDp,leftDp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        seq=new int[N];
        rightDp=new Integer[N];
        leftDp=new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++) {
            int x = Integer.parseInt(st.nextToken());
            seq[i]=x;
        }
        //일단 배열에 넣고
        //중복이...
       for(int i=0; i<N;i++){
           LIS(i);
           LDS(i);
       }
       int max=-1;
       //좌우 가장 긴 부분 수열을 구한 뒤 합친다
       for(int i=0;i<N;i++){
           max=Math.max(rightDp[i]+leftDp[i],max);
       }
       System.out.println(max-1);

    }
    //N이전의 노드 탐색
   static int LIS(int N){
        if(rightDp[N]==null){
            rightDp[N]=1;
            for(int i=N-1;i>=0;i--){
                if(seq[i]<seq[N]){
                    rightDp[N]=Math.max(rightDp[N],LIS(i)+1);
                }
            }
        }
        return rightDp[N];
   }
    //N이후의 노드 탐색
    static int LDS(int N){
        if(leftDp[N]==null){
            leftDp[N]=1;
            for(int i=N+1;i< leftDp.length;i++){
                if(seq[i]<seq[N]){
                    leftDp[N]=Math.max(leftDp[N],LDS(i)+1);
                }
            }
        }
        return leftDp[N];
    }

}