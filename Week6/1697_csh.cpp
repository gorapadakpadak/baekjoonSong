#include <iostream>
#include <memory.h>
#include <queue>
#define MAX 100001
using namespace std;

int check[100001];
    
    //수빈이의 위치가 X일 때 걷는다면 
    //1초 후에 X-1 또는 X+1로 이동하게 된다.
    //순간이동을 하는 경우에는 
    //1초 후에 2*X의 위치로 이동
int bfs(int start, int goal){
    int cnt[MAX]={0};
    
    int dir[3] = {1, -1, 2};
    
    queue <int> q;
    q.push(start);
    check[start] = true;
    while(!q.empty())
    {
        int temp = q.front();
        q.pop();
        for(int i=0 ; i<3; i++){
            int x;
            dir[i] == 2 ? x = temp*2 : x = temp + dir[i];
            if(temp == goal){
                return cnt[goal];
            }
            if(x>=0 && x<MAX
                && check[x]==false){
                    check[x]=true;
                    q.push(x);
                    cnt[x] = cnt[temp]+1;
                }
        }
    }
    return cnt[goal];
    
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0); 
    cout.tie(0);    
    
    int N, K;
    cin>>N>>K;
    
    memset(check, false, sizeof(check));

    cout<<bfs(N, K);

    return 0;
}