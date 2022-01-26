#include <iostream>
#include <algorithm>
using namespace std;

int N;
char arr[50][50];

int checkTheNumberInColumn(int n){
    int max = 0;
    int cnt;
    for(int i=0 ; i<N; i++){
        cnt=1;
        for(int j=0 ; j<N; j++)
        {
            if (arr[i][j] == arr[i][j+1])
                cnt++;
            else
                {
                if(max < cnt)
                    max = cnt;
                cnt=1;
                }
        }
    }
    return max;
}

int checkTheNumberInRow(int n){
    int max=0;
    int cnt;    
    for(int i=0 ; i<N; i++){
        cnt=1;
        for(int j=0 ; j<N; j++)
        {        
            if (arr[j][i] == arr[j+1][i])
                cnt++;
            else
                {
                if(max < cnt)
                    max = cnt;
                cnt=1;
                }
        }
    }
    return max;
}

//연속 부분(행 또는 열)
int main()
{

    int max=0;
    char temp;
    cin>>N;
    
    //allocation
    for(int i=0 ; i<N; i++)
    {
        for( int j = 0 ; j < N ; j++){
            cin>>temp;
            arr[i][j]=temp;
        }
    } 
    
    //find in order of the row
    for(int i=0 ; i<N; i++) //
    {
        for( int j = 0 ; j < N-1 ; j++){
            if(arr[i][j] != arr[i][j+1]){
                swap(arr[i][j], arr[i][j+1]);
                if( max < checkTheNumberInColumn(i))
                    max = checkTheNumberInColumn(i);
                if( max < checkTheNumberInRow(j))
                    max = checkTheNumberInRow(j);
                swap(arr[i][j], arr[i][j+1]);
            }
        }
    }
    
    //find in order of the column
    for(int i=0 ; i<N; i++) //
    {
        for( int j = 0 ; j < N-1 ; j++){
            if(arr[j][i] != arr[j+1][i]){
                swap(arr[j][i], arr[j+1][i]);
                if( max < checkTheNumberInColumn(i))
                    max = checkTheNumberInColumn(i);
                if( max < checkTheNumberInRow(j))
                    max = checkTheNumberInRow(j);
                swap(arr[j][i], arr[j+1][i]);
            }
        }
    }
    cout<< max;
    
    return 0;
}
