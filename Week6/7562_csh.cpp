#include <iostream>
#include <vector>
#include <queue>
#include <memory.h>
using namespace std;

int dx[8] = { 1, 2, 2, 1, -1, -2, -2, -1};
int dy[8] = { 2, 1, -1, -2, -2, -1, 1, 2};

int chess[301][301];

int bfs(pair<int, int> start, pair<int, int> goal, int l, bool check[][301]){
    int cnt[l+1][l+1];
    memset(cnt, 0, sizeof(cnt));
    queue <pair<int, int>> q;
    q.push(start);
    check[start.first][start.second]=true;
    cnt[start.first][start.second]=0;
    while(!q.empty()){
        pair <int, int> temp = q.front();
        q.pop();
        for(int i=0; i<8 ; i++){
            int x = dx[i] + temp.first;
            int y = dy[i] + temp.second;
            if(x>=0 && x<l && y>=0 && y<l 
            && check[x][y]==false){
                check[x][y]=true;
                q.push({x,y});
                //cout<<"x, y :" <<x<<" "<<y<<endl;
                cnt[x][y]+=cnt[temp.first][temp.second]+1;
            }
        }
    }
    return cnt[goal.first][goal.second];
}

int main()
{
    int T;
    cin>>T;
    while(T--){
        int l;//체스판 한 변의 길이
        int input1, input2;
        vector <pair<int, int>> current_goal;
        
        cin>>l;
        bool check[l+1][301];
        memset(check, false, sizeof(check));
        
            for(int i=0 ;i<2; i++){
            cin>>input1>>input2;
            current_goal.push_back({input1, input2});
        }
        cout<< bfs(current_goal[0], current_goal[1], l, check)<<endl;
        
    }

    return 0;
}