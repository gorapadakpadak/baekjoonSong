#include <iostream>
#include <vector>
#include <numeric>
#include <algorithm>
#define NUM 9

using namespace std;
int main()
{
    int temp, sum, answer;
    vector<int> dwarf;
    vector<int>::iterator it;
    int number;
    int flag = 0;
    int i, j;
    for(int i=0 ; i< NUM ; i++){
        cin>>temp;
        dwarf.push_back(temp);
    }
    

    sum = accumulate(dwarf.begin(), dwarf.end(), decltype(dwarf)::value_type(0));
        

    for(i= 0 ; i < NUM ; i++ ){
        for(j= i+1 ; j < NUM ; j++ ){
            if((sum - dwarf[i] - dwarf[j]) == 100 ) 
            {
                dwarf.erase( j + dwarf.begin());
                //앞에 인덱스 먼저 지우면 앞당겨지기 때문에 뒤에 먼저 지워줌
                dwarf.erase( i + dwarf.begin());
                flag =1;
                break;
            }
            
        }
        if (flag == 1) break;
    }
    
    sort(dwarf.begin(), dwarf.end());
    
    for(int k=0 ; k< dwarf.size() ; k++){
        cout<<dwarf[k]<<endl;
    }

    return 0;
}