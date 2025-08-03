#include <iostream>
#include <vector>
#include <deque>
#include <climits>
using namespace std;

const int INF = INT_MAX;
int N, B, S, E;
vector<vector<pair<int, int>>> graph;

int bfs(int s, int e) {
    vector<int> visited(N, INF);
    deque<pair<int, int>> dq;
    dq.push_front({s, 0});
    visited[s] = 0;
    int ans = INF;

    while (!dq.empty()) {
        auto [cur, d] = dq.front();
        dq.pop_front();
        if (cur == e) {
            if (d < ans) ans = d;
        }
        for (auto& nxtPair : graph[cur]) {
            int nxt = nxtPair.first;
            int cost = nxtPair.second;
            int newDist = d + cost;
            if (newDist < visited[nxt]) {
                visited[nxt] = newDist;
                if (cost == 0)
                    dq.push_front({nxt, newDist});
                else
                    dq.push_back({nxt, newDist});
            }
        }
    }
    return ans;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> B >> S >> E;
    graph.resize(N);
    for (int i = 0; i < B; ++i) {
        int a, b, c;
        cin >> a >> b >> c;
        graph[a].push_back({b, c});
        graph[b].push_back({a, c});
    }

    int ans = bfs(S, E);
    if (ans == INF)
        cout << "It's over with Captain Jack. At least till Pirates of the Caribbean 3.\n";
    else
        cout << ans << " native(s) on the easiest way for Captain Jack.\n";

    return 0;
}
