package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static String s;
    public static StringTokenizer tempSt;
    public static int[][] map;
    public static boolean[][] visited;
    public static int count,w,h;
    public static int[] dx={-1,-1,0,1,1,1,0,-1};
    public static int[] dy={0,1,1,1,0,-1,-1,-1};
    public static ArrayList<Integer> answer=new ArrayList<>();
    public static BufferedReader br;
    public static StringTokenizer st;
    public static void main(String args[]) throws IOException{
        boolean end=true;
        //BufferedReader 꼭 밖에서 생성해줘야함! 안 그러면 while문 속에서 계속 생성되어 에러남
        br = new BufferedReader(new InputStreamReader(System.in));
        while(end) {
            //너비,높이 값 받기
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            //종료조건
            if (w == 0 && h == 0) {end=false; break;}
            //2차원배열에 넣기
            map=new int[w][h]; //w- j|
            visited=new boolean[w][h];
            count=0;
            for(int i=0;i<h;i++){
                s=br.readLine();
                tempSt=new StringTokenizer(s," ");
                for(int j=0;j<w;j++){
                    map[j][i]=Integer.parseInt(tempSt.nextToken());
                }
            }
            //섬 개수 세기
           for(int i=0;i<w;i++){
                for(int j=0;j<h;j++){
                    if(map[i][j]==1&&!visited[i][j]){
                        count++;
                        Search(i,j);
                    }
                }
            }
            answer.add(count);
        }
        for(int c:answer){
            System.out.println(c);
        }
    }
    public static void Search(int x, int y){
            visited[x][y]=true;
            for(int i=0;i<8;i++){
                int tx=x+dx[i];
                int ty=y+dy[i];
                if(tx>=0&&ty>=0&&tx<w&&ty<h){
                    if(map[tx][ty]==1&&!visited[tx][ty]){
                        Search(tx,ty);
                    }
                }
            }

    }
}


