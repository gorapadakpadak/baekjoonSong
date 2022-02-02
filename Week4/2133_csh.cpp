#include <iostream>
#include <vector>
using namespace std;

int main()
{
    int N;
    int dp[31] = {0};

    cin>>N;

    dp[0] = 1; //아무것도 안한 상태
    dp[2] = 3;
    if(N>=3)
    {
        for(int i=4 ; i<=N ; i+=2)
        {
            dp[i] = dp[i-2]*dp[2];
            
            for(int j=4; j<i ; j+=2)
            {
                dp[i]+=dp[i-j]*2;
            }
            dp[i] += 2;
            
        }
    }
    cout<<dp[N];
    return 0;
}