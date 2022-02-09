#include <stdio.h>
#include <queue>
#include <memory.h>

using namespace std;



int bfs(int n, int m, bool check[][101], int maze[][101]){
    int min = 0;
    int cnt[101][101];
    memset(cnt, 0, sizeof(cnt));
    
    int dx[4] = {0, 1, 0, -1};
    int dy[4] = {1, 0, -1, 0};
    
    queue <pair<int, int>> q;
    check[1][1]=true;
    q.push({1, 1});
    
    while(!q.empty()){
        pair<int, int> temp = q.front();
        q.pop();
        for(int i=0; i<4; i++){
            int next_x = temp.first +dx[i];
            int next_y = temp.second +dy[i];
            if(check[next_x][next_y]==false && 
                next_x>0 && next_y>0 &&
                next_x<=n && next_y<=m &&
                maze[next_x][next_y]==1)
                {
                    check[next_x][next_y] =true;
                    //printf("%d %d\n",next_x, next_y);
                    cnt[next_x][next_y] = cnt[temp.first][temp.second]+1;
                    q.push({next_x, next_y});
            }
        }
    }
    return cnt[n][m];
}

int main()
{
    int N, M;
    scanf("%d %d",&N, &M);
    
    int maze[101][101];
    bool check[101][101];
    
    memset(check, false, sizeof(check));
    
    for(int i=1; i<=N; i++){
        for(int j=1 ; j<=M ; j++){
            scanf("%1d", &maze[i][j]);
        }
    }
    
    printf("%d\n", bfs(N, M, check, maze)+1);
    return 0;
}