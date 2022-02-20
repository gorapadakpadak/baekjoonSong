#include <iostream>
#include <vector>
#define MAX 2000
using namespace std;
 
bool visit[MAX] = { false, }; //친구 방문 여부
vector<int> v[MAX]; //친구 관계
 
void dfs(int x, int idx) { //친구 x, idx개의 친구 관계
	visit[x] = true; //친구 x를 방문처리
	if (idx == 4) { //4개를 찾기만 하면
		cout << 1; //1 출력하고
		exit(0); //종료
	}
	for (int i = 0; i < v[x].size(); i++) { //x에 대한 친구관계를 모두 조사
		if (!visit[v[x][i]]) { //방문하지 않은 친구면
			dfs(v[x][i], idx + 1); //그 친구부터 다시 탐색
		}
	}
	visit[x] = false; //현재 x를 미방문처리
}
 
int main() {
	int n, m;
	int a, b;
	cin >> n >> m;
	
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
 
		//친구니까 서로 관계를 맺어준다.
		v[a].push_back(b);
		v[b].push_back(a);
	}
 
	//n명에 대하여 dfs를 수행하여 깊이가 4가 되는 경우를 찾는다.
	for (int i = 0; i < n; i++) {
		dfs(i, 0);
	}
 
	cout << 0; //못 찾은 경우는 0을 출력
}