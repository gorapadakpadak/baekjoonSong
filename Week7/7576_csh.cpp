#include <stdio.h>
#include <vector>
#include <queue>
#include <memory.h>
#define MAX 100001
using namespace std;

int box[1001][1001];
int M, N;

int bfs(){
    int dx[4] = {0, 1, 0, -1};
    int dy[4] = {1, 0, -1, 0};
    int max=-1;
    queue<pair<int, int>> q;
    
    for(int i=1 ; i<=N; i++){
        for(int j=1 ; j<=M; j++){
            if (box[i][j]==1)
                q.push({i, j});
        }
    }
    
    while(!q.empty()){
        pair<int, int> temp = make_pair(q.front().first, q.front().second);
        q.pop();
        for(int i=0; i<4; i++){
            int x = dx[i]+temp.first;
            int y = dy[i]+temp.second;
            if(x>=1 && x<=N && y>=1 && y<=M && box[x][y]==0){ //현재 예제에서 6,4
                q.push({x,y});
                box[x][y] = box[temp.first][temp.second]+1;
            }
        }
    }
    //만약에 0이 남아 있으면 -1로 리턴, 아니면 최댓값 -1
    for(int i=1 ; i<=N; i++){
        for(int j=1 ; j<=M; j++){
            //printf("%d ",box[i][j]);
            if (box[i][j] ==0) return -1;
            else if(box[i][j]>max)
                max=box[i][j];
        }
        //printf("\n");
    }   
    return max-1;
}

int main(){
    scanf("%d %d",&M, &N); //각각 가로, 세로 길이

    for(int i=1 ; i<=N; i++){
        for(int j=1 ; j<=M; j++){
            scanf("%d", &box[i][j]);
        }
    }
    printf("%d\n",bfs());
    return 0;
}