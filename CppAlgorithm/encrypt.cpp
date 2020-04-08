/*
//
// Created by JongHyeon Kim on 2020/01/19.
//
#include <iostream>
#include <string>
using namespace std;

int solution(int n);

int main()
{
    cout << solution(10) << endl;
    return 0;
}

int solution(int n) {
    int answer = 0;
    int *arr = (int*)malloc(n);

    for (int i = 2; i <= n; i++) {
        arr[i] = i;
    }
    for (int i = 2; i <= n; i++) {
        if (arr[i] == 0)
            continue;
        for (int j = 2*i; j <= n; j += i) {
            cout << j << endl;
            arr[j] = 0;
        }
    }

    for (int i = 2; i <= n; i++) {
        if(arr[i] != 0)
            answer++;
    }


    return answer;
}
*/
