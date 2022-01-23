#include <iostream>
#include <string>
using namespace std;

int main()
{
    int T, num;
    string str, result;
    cin>>T;
    
    for(int i=0 ; i<T; i++){
        cin>>str;
        num = 0;
        result="YES";
        for(int j=0 ; j<str.size() ; j++){
            if(str[j] == '(')
                num++;
            else //if (str[j] == ')')
                num--;
            if(num < 0){
                result="NO";
                break;
            }
        }
        if(num!=0) result="NO";
        cout<<result<<endl;
    }
    
    return 0;
}