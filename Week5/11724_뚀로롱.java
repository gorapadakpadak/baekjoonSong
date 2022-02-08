package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static int[] dp;
    public static int N;
    public static int M;
    public static boolean[] visited;
    public static int[][] map;

    public static void main (String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N+1];
        map  = new int[N+1][N+1];
        for (int i=1; i<M+1; i++) {
            int tmpA = sc.nextInt();
            int tmpB = sc.nextInt();
            map[tmpA][tmpB] = map[tmpB][tmpA] = 1;
        }

        boolean hasTree = false;
        int cnt = 0;
        for (int i=1; i<N+1; i++) {
            if (!visited[i]) {
                hasTree = bfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static boolean bfs(int start) {
        boolean ret = false;
        LinkedList<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int poll = q.poll();

            for (int i=1; i<N+1; i++) {
                if (map[poll][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    ret = true;
                }
            }
        }

        return ret;
    }

}


