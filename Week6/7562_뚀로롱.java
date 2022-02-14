package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static boolean[][] visited;
    public static StringTokenizer st;
    public static int size,count,dx,dy;
    public static int[] tx={-2,-1,1,2,2,1,-1,-2};
    public static int[] ty={1,2,2,1,-1,-2,-2,-1};
    public static Queue<Integer> qx;
    public static Queue<Integer> qy;
    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //케이스마다 출력하면 마지막 케이스가 출력이 안 되어서 string에 값을 저장 후 마지막에 출력한다
        String s="";
        int test=Integer.parseInt(br.readLine());
        for(int i=0;i<test;i++) {
            size = Integer.parseInt(br.readLine());
            visited = new boolean[size][size];
            //두번째 줄 (현재 위치)
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //세번째 줄 (이동하려는 위치)
            st = new StringTokenizer(br.readLine());
            dx = Integer.parseInt(st.nextToken());
            dy = Integer.parseInt(st.nextToken());
            int answer=BFS(x, y);
            s=s+answer+"\n";
        }
        System.out.println(s);

    }
    public static int BFS(int cx, int cy){
        qx=new LinkedList<>();
        qy=new LinkedList<>();
        count = 0;
        qx.add(cx);
        qy.add(cy);
        while(!qx.isEmpty()&&!qy.isEmpty()){
            int  q_size= qx.size();
            for(int i=0;i<q_size;i++) {
                int a = qx.peek();
                int b = qy.peek();
                qx.remove();
                qy.remove();
                if(a==dx&&b==dy){
                   return count;
                }
                for (int j = 0; j < 8; j++) {
                    int lx = a + tx[j];
                    int ly = b + ty[j];
                    if (lx >= 0 && ly >= 0 && lx < size && ly < size) {
                        if (!visited[lx][ly]) {
                            visited[lx][ly] = true;
                            qx.add(lx);
                            qy.add(ly);
                        }
                    }
                }
            }
            count++;
        }
        return count;

    }
}


