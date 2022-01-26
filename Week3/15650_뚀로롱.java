package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static int sum;
    public static int[] seq;
    public static boolean[] visit;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        sb=new StringBuilder();
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        //길이 M인 경우의 수 담을 배열
        seq=new int[M];
        //1~N 수 중 출력했던거면 visit했다는 뜻으로 true로 바꿔준다
        visit=new boolean[N+1];
        //깊이우선탐색(DFS)실행 인자로 N,M,깊이 전달
        //시작은 깊이 0인 root부터
        dfs(N,M,0);
        System.out.print(sb);
    }
    //ex) n=4 m=2
    private static void dfs(int n, int m, int d){
        //깊이랑 뽑아야하는 수가 같으면 for문 돌아라
        //d=0 m=2 ->if문 통과
        if(d==m) {
            //돌다가 오름차순 아니면 출력 안 하고 넘어감
            for(int i=1; i<seq.length;i++){
                if(seq[i-1]>seq[i]) return;
            }
            for (int a : seq) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<n;i++){
            if(!visit[i]){
                visit[i]=true;
                seq[d]=i+1;
                dfs(n,m,d+1);
                visit[i]=false;
            }
        }
        return;
    }

}