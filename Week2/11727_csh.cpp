
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int n;
    cin>>n;
    vector<int> dp(n+1, 0);  

    dp[1]= 1;
    dp[2]= 3;
    
    for(int i=3; i<=n; i++){
        dp[i]=dp[i-1] + dp[i-2] * 2;// + subDp[i];
        dp[i]%=10007;
    }
    cout<<dp[n];
    return 0;
}