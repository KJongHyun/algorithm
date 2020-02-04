/*
//
// Created by JongHyeon Kim on 2020/01/28.
//
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

typedef struct Search {
    int count;
    vector<int> sum;
} Search;

int sumVector(vector<int> v) {
    int sum = 0;
    for (int i = 0; i < v.size(); i++) {
        sum += v[i];
    }
    return sum;
}

int main()
{
    Search s = {0};
    s.sum.push_back(3);
    Search s2 = {1, s.sum};
    s2.sum.push_back(5);

    cout << s.sum[1] << endl;

    cout << s2.sum[0] << endl;

    cout << sumVector(s.sum);
    cout << sumVector(s2.sum);


    return 0;
}
int solution (int N, int M, int T, int K) {
  */
/*  int answer = 0;
    queue<Search> q;
    q.push({0});
    while(!q.empty()) {
        Search currentSearch = q.front();
        q.pop();
        if (currentSearch.amount == M && currentSearch.period == N) {
            answer++;
            continue;
        }
        for (int i = 0; i <= N;i++) {

        }
    }
    return answer;*//*

}*/
