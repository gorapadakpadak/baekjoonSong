package com.company;
import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int node, dist;
        //가중치 저장
        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static ArrayList<Node>[] list;//노드들의 연결 정보를 저장하는 배열
    static boolean[] visit;
    static int max = 0;
    static int N;
    static int max_idx = 0;
    //루트 기준으로 dfs를 진행할때 가장 큰 가중치를 가진 노드를 구하고 그 노드를 기준으로 dfs를 실행하는 방식
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[parent].add(new Node(child, weight));
            list[child].add(new Node(parent, weight));
        }

        visit = new boolean[N + 1];
        visit[1] = true;
        //임의의 노드 (1)에서 가장 먼 노드를 구함
        dfs(1, 0);

        visit = new boolean[N + 1];
        visit[max_idx] = true;
        //1로부터 가장 먼 노드가 max_idx이고 이거로 부터 가장 먼 노드를 다시 구함
        dfs(max_idx, 0);
        bw.write(max + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
    //노드 벜호와 가중치를 받아서 현재 노드의 가중치를 최대값으로 계속 업데이트하고 최대일때의 노드 번호를 INDEX에 저장
    //visit을 통해 방문하지 않은 노드일 dfs호출때
    public static void dfs(int idx, int dist) {
        if (max < dist) {
            max = dist;
            max_idx = idx;
        }

        for (Node n : list[idx]) {
            if (!visit[n.node]) {
                visit[n.node] = true;
                dfs(n.node, dist + n.dist);
            }
        }
    }
}