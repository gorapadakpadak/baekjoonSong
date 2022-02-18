package com.company;
import java.util.*;
import java.io.*;
public class Main {
    public static Queue<Point> q=new LinkedList<Point>();
    public static int k,min;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        min=100001;
        visited=new boolean[200001];
        BFS(n);
        System.out.print(min);

    }
    //그냥 숨바꼭질 문제에서 *2해줄때의 조건만 바꿔서 가장 먼저 k와 같아질때 값을 출력하게 했더니 오류남
    //근데 무슨 조건을 추가해야할지 모르겠어서 엎음..
    //더 작은 값을 출력하도록 함
    public static void BFS(int n){
        q.add(new Point(n,0));
        while(!q.isEmpty()){
            Point p=q.poll();
            visited[p.x]=true;
            if(p.x==k){
                min=Math.min(min,p.time);
            }
            //0sec 2*x
            if(p.x*2<=100000&&!visited[p.x*2]){
                q.add(new Point(p.x*2,p.time));
            }
            //1sec 1+x
            if(p.x+1<=100000&&!visited[p.x+1]){
                q.add(new Point(p.x+1,p.time+1));
            }
            if(p.x-1>=0&&!visited[p.x-1]){
                q.add(new Point(p.x-1,p.time+1));
            }
        }

    }
    public static class Point{
        int x;
        int time;
        Point(int x, int time){
            this.x=x;
            this.time=time;
        }
    }

}


