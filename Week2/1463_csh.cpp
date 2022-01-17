#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

#define MAX 999999

int main()
{
    int N, a, b, m;
    cin>>N;
    vector<int> dp(N+1, MAX);
    dp[1]=0;
    for(int i= 2 ; i<=N; i++){
        m = dp[i-1]+1;
        
        i % 3 == 0 ? a = dp[i/3]+1 : a=MAX;
        i % 2 == 0 ? b = dp[i/2]+1 : b=MAX;
        dp[i] = min(a, b);
        
        if(m<min(a,b)){
            dp[i]=m;
        }
    }
    cout<<dp[N];
    return 0;
}