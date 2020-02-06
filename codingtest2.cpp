#include <string>
#include <vector>
#include <queue>

using namespace std;

typedef struct Search {
    int amount;
    int period;
    vector<int> tDay;
}Search;

void calcTday(int T, int numb, vector<int> tDay) {
    if (tDay.size() == T) {
        tDay.erase(tDay.begin());
    }
    tDay.push_back(numb);

}

int sumTday(vector<int> v) {
    int sum = 0;
    for (int i = 0; i < v.size(); i++) {
        sum += v[i];
    }

    return sum;
}

int solution(int N, int M, int T, int K) {
    int answer = 0;
    queue<Search> q;
    q.push({0, 0});
    while(!q.empty()) {
        Search currentSearch = q.front();
        q.pop();
        if (currentSearch.period > N)
            continue;
        if (sumTday(currentSearch.tDay) > K)
            continue;
        if (currentSearch.amount == M && currentSearch.period == N) {
            answer++;
            continue;
        }

        for (int i = 0; i <= M - currentSearch.amount; i++) {
            Search s = {currentSearch.amount + i, currentSearch.period + 1, currentSearch.tDay};
            if (s.tDay.size() == T) {
                s.tDay.erase(s.tDay.begin());
            }
            s.tDay.push_back(i);

            q.push(s);
        }
    }
    return answer;
}