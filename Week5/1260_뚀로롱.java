package com.company;
import java.io.*;
import java.util.*;
public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // BFS 해시맵
            HashMap<Integer, List<Integer>> hashmapBFS = new HashMap<Integer, List<Integer>>();
            // DFS 해시맵 (리스트는 내림차순 정렬)
            HashMap<Integer, List<Integer>> hashmapDFS = new HashMap<Integer, List<Integer>>();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            int startNode = Integer.parseInt(st.nextToken());

            for(int i = 0; i < edge; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int key = Integer.parseInt(st.nextToken());
                int connectNode = Integer.parseInt(st.nextToken());

                List<Integer> priorBFS = new ArrayList<Integer>();
                List<Integer> priorDFS = new ArrayList<Integer>();

                List<Integer> connectBFS = new ArrayList<Integer>();
                List<Integer> connectDFS = new ArrayList<Integer>();

                // BFS
                if(hashmapBFS.containsKey(key)) {
                    priorBFS = hashmapBFS.get(key);
                    priorBFS.add(connectNode);
                    hashmapBFS.replace(key, priorBFS);
                }
                else {
                    priorBFS.add(connectNode);
                    hashmapBFS.put(key, priorBFS);
                }

                // 입력을 뒤집어서 한번 더 해시맵에 데이터 추가
                if(hashmapBFS.containsKey(connectNode)) {
                    connectBFS = hashmapBFS.get(connectNode);
                    connectBFS.add(key);
                    hashmapBFS.replace(connectNode, connectBFS);
                }
                else {
                    connectBFS.add(key);
                    hashmapBFS.put(connectNode, connectBFS);
                }


                // DFS
                if(hashmapDFS.containsKey(key)) {
                    priorDFS = hashmapDFS.get(key);
                    priorDFS.add(connectNode);
                    hashmapDFS.replace(key, priorDFS);
                }
                else {
                    priorDFS.add(connectNode);
                    hashmapDFS.put(key, priorDFS);
                }

                // 입력을 뒤집어서 한번 더 해시맵에 데이터 추가
                if(hashmapDFS.containsKey(connectNode)) {
                    connectDFS = hashmapDFS.get(connectNode);
                    connectDFS.add(key);
                    hashmapDFS.replace(connectNode, connectDFS);
                }
                else {
                    connectDFS.add(key);
                    hashmapDFS.put(connectNode, connectDFS);
                }

            }

            Queue<Integer> queueDFS = dfs(hashmapDFS, startNode);
            Queue<Integer> queueBFS = bfs(hashmapBFS, startNode);

            queueDFS.stream().forEach(x -> {
                try {
                    bw.write(x + " ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw.write("\n");

            queueBFS.stream().forEach(x -> {
                try {
                    bw.write(x + " ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw.write("\n");

            bw.flush();
            bw.close();

        }

        private static Queue<Integer> bfs(HashMap<Integer, List<Integer>> hashmapBFS, int startNode) {
            Queue<Integer> needVisit = new LinkedList<Integer>();
            Queue<Integer> visited = new LinkedList<Integer>();

            needVisit.offer(startNode);

            while(!needVisit.isEmpty()) {
                int node = needVisit.poll();
                if(!visited.contains(node)) {
                    visited.add(node);
                    List<Integer> priorBFS = hashmapBFS.get(node);
                    if(priorBFS != null) { // 연결된 정점이 있는 경우
                        Collections.sort(priorBFS);
                        needVisit.addAll(hashmapBFS.get(node));
                    }
                }
            }

            return visited;
        }

        private static Queue<Integer> dfs(HashMap<Integer, List<Integer>> hashmapDFS, int startNode) {
            Stack <Integer> needVisit = new Stack<Integer>();
            Queue<Integer> visited = new LinkedList<Integer>();

            needVisit.push(startNode);

            while(!needVisit.isEmpty()) {
                int node = needVisit.pop();
                if(!visited.contains(node)) {
                    visited.add(node);
                    List<Integer> priorDFS = hashmapDFS.get(node);
                    if(priorDFS != null) { // 연결되어 있는 정점이 존재하는 경우
                        Collections.sort(priorDFS, Collections.reverseOrder());
                        needVisit.addAll(priorDFS);
                    }
                }
            }

            return visited;

        }

}


