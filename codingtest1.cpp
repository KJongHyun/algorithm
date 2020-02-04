/*
//
// Created by JongHyeon Kim on 2020/01/28.
//
#include <iostream>
#include <vector>
using namespace std;
vector<int> solution(int n, int min_position, int max_position, vector<int> position);
int main()
{
    vector<int> position;
    position.push_back(-1);
    position.push_back(-3);
    position.push_back(3);

    solution(5, -5, 3, position);

    return 0;
}

vector<int> solution(int n, int min_position, int max_position, vector<int> position) {
    vector<int> answer;

    int interval = (max_position - min_position) / (n - 1);
    for (int i = min_position; i <= max_position; i += interval) {
        bool isSame = false;
        for (int target  = 0; target < position.size(); target++) {
            if (position[target] == i) {
                position.erase(position.begin() + target);
                isSame = true;
                break;
            }
        }
        if (!isSame)
            answer.push_back(i);
    }
    return answer;
}*/
