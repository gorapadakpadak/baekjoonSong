#include <cstring>
#include <vector>
#include <iostream>

using namespace std;

// vector의 자료형을 위한 구조체 정의
struct Node
{
    int index;
    int dist;
};
int v, maxDist, maxNode;
bool visit[100001]; // 방문확인
vector<Node> graph[100001];

void dfs(int node, int dist)
{
    // 방문한 노드면 return
    if (visit[node])
        return;
    // maxDist 갱신
    if (maxDist < dist)
    {
        maxDist = dist;
        maxNode = node;
    }
    visit[node] = true; //방문 체크
    // 현재 정점에서 연결 된 정점들로 dfs 수행
    for (int i = 0; i < graph[node].size(); i++)
    {
        int nextIndex = graph[node][i].index;
        int nextDist = graph[node][i].dist;
        dfs(nextIndex, nextDist + dist);
    }
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> v;
    int fr, to, dist;
    for (int i = 1; i < v + 1; i++)
    {
        cin >> fr;
        while (true)
        {
            cin >> to;
            if (to == -1)
                break;
            cin >> dist;
            graph[fr].push_back({to, dist});
            graph[to].push_back({fr, dist});
        }
    }

    // 임의의 정점 1에서 가장 거리가 먼 정점 찾기
    dfs(1, 0);
    memset(visit, 0, sizeof(visit));
    maxDist = 0;
    // 1과 가장 먼 정점에서 다시 dfs 수행하여 트리의 지름 찾기
    dfs(maxNode, 0);

    cout << maxDist << '\n';

    return 0;
}