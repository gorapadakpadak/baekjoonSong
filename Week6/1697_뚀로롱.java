package com.company;
import java.util.*;
import java.io.*;
public class Main {
    public static Queue<Integer> q=new LinkedList<>();
    public static int k;
    public static int[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        visited=new int[100001];
        if(n!=k){
            BFS(n);
        } else {
            //n이랑 k가 같을 경우 처리
            System.out.print(0);
        }
    }
    public static void BFS(int n){
        q.add(n);
        visited[n]=1;
        //방문했던 곳은 앞서 방문했을때가 시간이 덜 걸린 경우이므로 다음에 방문 시 패스
        while (!q.isEmpty()) {
            int tmp=q.poll();
            for (int i = 0; i < 3; i++) {
                int next=tmp;
                switch(i){
                    case 0: next+=1;
                        break;
                    case 1: next-=1;
                        break;
                    case 2: next*=2;
                        break;
                }
                if(next==k){
                    System.out.println(visited[tmp]);
                    return;
                }
                //배열 크기 넘지 않는지 확인
                if(next>=0&& next<visited.length&&visited[next]==0){
                    q.add(next);
                    visited[next]=visited[tmp]+1;
                }
                }
        }

    }


}
