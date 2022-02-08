#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <algorithm>
#include <memory.h>
using namespace std;
int cnt = 0;

void dfs(int start, vector<int> graph[], bool check[]){
    check[start] = true;
    //cout<<start<<" ";
    for(int i=0 ; i<graph[start].size(); i++){
        if(check[graph[start][i]]==false){
            check[graph[start][i]]=true;
            dfs(graph[start][i], graph, check);
        }
    }
}

int main()
{
    int N, M, V;
    cin>>N>>M;
    vector<int> graph[N+1];
    bool check[N+1];
    memset(check, false, sizeof(check));
    for( int i=0 ; i<M; i++){
        int u, v;
        cin>>u>>v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    for( int i=0 ; i<=N; i++){
        sort(graph[i].begin(), graph[i].end());
    }    
    
    for(int i=1; i<=N ; i++){
        if(check[i]==false){
            dfs(i, graph, check);
            cnt++;
        }
    }
    cout<<cnt;
    return 0;
}