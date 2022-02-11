#include <stdio.h>
#include <memory.h>
#include <stack>
#include <vector>
#include <algorithm>
using namespace std;

int N;
int arr[26][26];  
bool visited[26][26]; 

int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

int dfs(int start, int end){
    int cnt=0;
    stack<pair<int, int>> s;
    s.push({start, end});
    visited[start][end]=true;
    //printf("%d %d\n", start, end);
   
    while(!s.empty()){
        int x = s.top().first;
        int y = s.top().second;
        s.pop();
        for(int i=0; i<4 ; i++){
            if( x + dx[i] >0 && y + dy[i] >0
                && x + dx[i] <=N && y + dy[i] <= N
                && visited[x+dx[i]][y+dy[i]]==false
                 && arr[x+dx[i]][y+dy[i]]==1){
                
                visited[x+dx[i]][y+dy[i]]=true;
                cnt++;
                s.push(make_pair(x, y));
                s.push(make_pair(x+dx[i], y+dy[i]));
                //printf("%d %d\n", x+dx[i], y+dy[i]);
                break;
            }
        }
    }
    //printf("\n");
    return cnt+1;
}

int main()
{
    vector<int> cnt;
    scanf("%d", &N);

    memset(visited, false, sizeof(visited));
    
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            scanf("%1d", &arr[i][j]);
        }
    }
    
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            if(arr[i][j]==1 && visited[i][j]==false){
                cnt.emplace_back(dfs(i, j));
            }
        }
    }
    
    sort(cnt.begin(), cnt.end());
    printf("%d\n", cnt.size());
   
    for(int i=0; i<cnt.size(); i++)
        printf("%d\n", cnt[i]);
    
    
    
    return 0;
}