/*
//
// Created by JongHyeon Kim on 2019/12/24.
//

#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int d[501][501];
int triangle[501][501];

int dp(int n, int index);

int main() {
    int n;
    scanf("%d", &n);

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            scanf("%d", &triangle[i][j]);
        }
    }
    int max = -999;
    for (int i = 1; i <= n; i++) {
        int val = dp(n, i);
        if (val > max)
            max = val;
    }

    printf("%d", max);

    return 0;
}

int dp(int n, int index) {
    if (n == 1)
        return triangle[1][1];
    if (d[n][index] != 0)
        return d[n][index];
    if (index == 1) {
        return d[n][index] = dp(n - 1, 1) + triangle[n][1];
    }
    if (index == n) {
        return d[n][index] = dp(n - 1, n - 1) + triangle[n][n];
    }
    return d[n][index] = max(dp(n - 1, index - 1), dp(n - 1, index)) + triangle[n][index];
}

*/
