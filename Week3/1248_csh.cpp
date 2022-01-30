#include <iostream>
#include <string>
#include <vector>
#include <numeric>
 
using namespace std;
 
vector<int> v;
int N;
string s;
char ec[15][15];
 
bool chk() {
    int cnt=0;
    for(int j=0; j<v.size(); j++) {
        for(int i=j; i<v.size(); i++) {
//            int idx = N * j + i;
            int sumv = accumulate(v.begin()+j , v.begin()+i+1,0);
            if(ec[j][i] == '-') {
                if( sumv>=0) return false;
            }else if(ec[j][i] == '0') {
                if(sumv !=0)return false;
            } else {
                if(sumv <= 0) return false;;
            }
            cnt++;
        }
    }
    
    return true;
}
 
void dfs() {
    if(v.size() == N) {
        for(int x : v) {
            cout << x << ' ';
        }
        exit(0);
        return;
    }
    
    
    for(int i=-10; i<=10; i++) {
        v.push_back(i);
        if(chk()==1) dfs();
        v.pop_back();
    }
}
 
int main() {
    cin >> N >> s;
    int cnt=0;
    for(int j=0; j<N; j++) {
        for(int i=j; i<N; i++) {
            ec[j][i] = s[cnt++];
        }
    }
    
    dfs();
    
    
    return 0;
}
 
 
