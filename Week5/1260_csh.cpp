#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <algorithm>
#include <memory.h>
using namespace std;

void dfs(int start, bool check[], vector<int>graph[]){
    stack<int> s;
    check[start]=true;
    s.push(start);
    cout<<start<<" ";
    while(!s.empty()){
        int current_node = s.top();
        s.pop();
        for(int i=0 ; i < graph[current_node].size() ; i++ ){
            int next_node = graph[current_node][i];
            if(check[next_node]==false){
                cout<<next_node<<" ";
                check[next_node] = true;
                
                s.push(current_node);
                s.push(next_node);
                break;
            }
        }
    }
}

void bfs(int start, bool check[], vector<int>graph[]){
    queue<int> q;
    q.push(start);
    check[start]=true;
    cout<<start<<" ";
    while(!q.empty()){
        int temp = q.front();
        q.pop();
        for(int i=0 ; i<graph[temp].size();i++){
            if(check[graph[temp][i]]==false){
                cout<<graph[temp][i]<<" ";
                check[graph[temp][i]]=true;
                q.push(graph[temp][i]);
                
            }
        }
    }
}

void bfs();
int main()
{
    int N, M, V;
    cin>>N>>M>>V;
    vector<int> graph[N+1];
    bool check[N+1];
    for( int i=0 ; i<M; i++){
        int u, v;
        cin>>u>>v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    for( int i=0 ; i<=N; i++){
        sort(graph[i].begin(), graph[i].end());
    }    
    memset(check, false, sizeof(check));
    dfs(V,check ,graph);
    memset(check, false, sizeof(check));
    cout<<endl;
    bfs(V,check ,graph);
    return 0;
}