#include <stdio.h>
#include <vector>
#include <queue>
#include <memory.h>
#define MAX 100001
using namespace std;

vector<int> graph[MAX];
int result[MAX];
void bfs(int start){
    int visited[MAX];
    memset(visited, false, sizeof(visited));    
    queue<int> q;
    q.push(start);
    visited[start]=true;
    while(!q.empty()){
        int temp = q.front();
        q.pop();
        for(int i=0; i<graph[temp].size(); i++){
            if(visited[graph[temp][i]]== false){    
                visited[temp] = true;
                q.push(graph[temp][i]);
                //printf("%d %d\n",temp, graph[temp][i]);
                result[graph[temp][i]] = temp;
            }
        }
    }
}
int main(){
    int N;
    scanf("%d",&N);
    int u, v;
    for(int i=0 ; i<N-1; i++){
        scanf("%d %d",&u, &v);
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    bfs(1);
    for(int i=2; i<= N; i++)
    {
        printf("%d\n",result[i]);
    }
    /*for(int i=2; i<= N; i++)
    {
        bfs(i);
    }*/
    return 0;
}