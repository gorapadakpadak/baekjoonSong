package com.company;
import java.util.*;
import java.io.*;
public class Main {
    private static int n;
    private static ArrayList<Integer>[] list;
    //인접리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list=new ArrayList[n+1];
       for(int i=1;i<=n;i++){
           list[i]=new ArrayList<Integer>();
       }
        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int le = Integer.parseInt(st.nextToken());
            int re = Integer.parseInt(st.nextToken());
            list[le].add(re);
            list[re].add(le);
        }
        int[] parent=new int[n+1];
        DFS(list, parent,n,1,0);
        for(int j=2;j<=n;j++){
            System.out.println(parent[j]);
        }
    }
    private static void DFS(ArrayList<Integer>[] list, int[] parent,int n, int start, int p){
        parent[start]=p;
        for(int c: list[start]){
            if(c!=p) DFS(list,parent,n,c,start);
        }
    }


}


