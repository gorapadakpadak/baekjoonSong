#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main()
{
    stack <int> stack;
    int N, i = 0, num;
    string str;
    cin>>N;
    
    while(i<N){
        cin>>str;
        if(str=="push")
        {
            cin>>num; 
            stack.push(num);
        }
        else if ( str == "top" ) {
            if(stack.empty()==1) 
                cout<<-1<<endl; 
            else{
                cout<<stack.top()<<endl;
            }
        }
        else if ( str == "size" ) cout<<stack.size()<<endl;
        else if ( str == "pop" ) {
            if(stack.empty()==1) 
                cout<<-1<<endl; 
            else{
                cout<<stack.top()<<endl; 
                stack.pop();
            }
        }
        else if ( str == "empty" ) cout<<stack.empty()<<endl;
        i++;
        }
    return 0;
}