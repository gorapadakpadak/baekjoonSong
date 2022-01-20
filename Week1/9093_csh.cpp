#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>
using namespace std;

int main()
{
    int N;
    cin>>N;
    cin.ignore();
    for(int i=0;i<N;i++)
    {
        string str, buff;
        vector<string> vec;
        getline(cin, str);
        stringstream stream(str);
        while(stream >> buff)
        {   
            vec.push_back(buff);
        }
        for(int i=0 ; i<vec.size() ; i++){
            reverse(vec[i].begin(), vec[i].end());
            cout<<vec[i]<<" ";
        }
        cout<<endl;
    }

    return 0;
}