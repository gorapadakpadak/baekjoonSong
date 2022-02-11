package com.company;
import java.io.*;
import java.util.*;
public class Main {
    public static int[][] matrix; //2차원 배열지도
    public static boolean[][] visit;
    public static int num;//단지
    public static int count;//아파트 수
    public static int n;//크기
    public static int[] dr={-1,1,0,0};//좌우
    public static int[] dc={0,0,-1,1};//상하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num=0;
        count=0;
        matrix = new int[n][n];
        visit = new boolean[n][n];
        ArrayList<Integer> answer=new ArrayList<>();
        //n*n행렬에 넣음
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '1') {
                    matrix[i][j] = 1;
                }
            }
        }
        //matrix원소를 하나하나 돌면서 상하좌우에 인접한 1이 있는지 찾는 함수 실행하고 실행시마다 count를 증가시켜 인접한 아파트 수를 재귀적으로 셈
        //인접한 곳에 0이 없으면 count가 0이어서 하나의 단지를 빠져나온것 따라서 count의 값을 기준으로 count가 0이 아니라면
        //하나의 단지가 있다는 뜻이므로 ArrayList에 연결시켜준다.
        for(int i=0;i<n;i++){
            for(int j=0; j<n;j++){
                if(matrix[i][j]==1&&!visit[i][j]){
                    Search(i,j);
                }
                if(count!=0){
                    answer.add(count);
                    count=0;
                }
            }
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        for(int c:answer){
            System.out.println(c);
        }


    }

    public static void Search(int x, int y) {
        count++;
        visit[x][y]=true;
        for(int i=0;i<4;i++){
           int lr= x + dr[i]; //좌우
           int ud=y+dc[i]; //상하
           if(ud>=0&&lr>=0 && ud<n &&lr<n) {
               if (matrix[lr][ud] == 1 && !visit[lr][ud]){
                   Search(lr,ud);
               }
           }
        }

    }
}


