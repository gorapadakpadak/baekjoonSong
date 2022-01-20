
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int N, temp;
    cin>>N;
    vector<int> seq;
    vector<int> DP;
    vector<int> dp1(N+1, 1); 
    vector<int> dp2(N+1, 1); 
    
    for(int i=0 ; i<N; i++)
    {
        cin>>temp;
        seq.push_back(temp);
    }
    for(int i=1 ; i< N; i++){
        for(int j=0 ; j<i ; j++)
        {
            if (seq[j]< seq[i] && dp1[i]<dp1[j]+1)
                dp1[i]+=1;
        }
    }
    for(int i=N-2 ; i>=0; i--){
        for(int j=N-1 ; j>i ; j--)
        {
            if (seq[j]< seq[i] && dp2[i]<dp2[j]+1)
                dp2[i]+=1;
        }
    }
    for(int i=0 ; i< N; i++){
        DP.push_back(dp1[i]+dp2[i]-1);
        //cout<<DP[i]<<endl;
    }    
    cout<<*max_element(DP.begin(), DP.end());
    return 0;
}