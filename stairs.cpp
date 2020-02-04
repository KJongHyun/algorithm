/*
//
// Created by JongHyeon Kim on 2019/12/27.
//
#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int stairs[301];
int d[301];
int callCount = 1;

int dp(int n, int stairCount);

int dp2(int n, int count);

int main() {
    int count;

    scanf("%d", &count);

    for (int i = 1; i <= count; i++) {
        scanf("%d", &stairs[i]);
    }

    printf("%d", dp(count, 1));

    return 0;
}

int dp(int n, int stairCount) {

    if (n == 0)
        return 0;
    if (n == 1) {
        return stairs[1];
    }
    if (d[n] != 0)
        return d[n];

    int value;
    cout << callCount << " ";
    if (stairCount == 1) {
        int oneStair = dp(n - 1, 0);
        int twoStair = dp(n - 2, 1);
        if (oneStair > twoStair) {
            cout << "n = " << n << " " << n - 1 << endl;
            return d[n] = stairs[n] + oneStair;
        } else {
            cout << "n = " << n << " " << n - 2 << endl;
            return d[n] = stairs[n] + twoStair;
        }
    } else if (stairCount == 0) {
        cout << "n = " << n << " " << n - 2 << endl;
        int twoStair = dp(n - 2, 1);
        return d[n] = stairs[n] + twoStair;
    }
}

*/
/*int dp2(int n, int count) {
    int stairCount = 0;
    if (n == 0)
        return 0;
    if (n == 1)
        return d[1][0] = stairs[1];
    if (d[n][0] != 0 && d[n][1])
        if (d[n][0] > d[n][1])
            return d[n][0];
        else
            return d[n][1];
    int maxVal = 0;
    if (count == 2) {
        stairCount = 1;
        maxVal = dp(n - 2, 1);
    } else {
        int one = dp(n - 1, count + 1);
        int two = dp(n - 2, 1);
        if (one > two) {
            maxVal = one;
            stairCount = 0;
        } else {
            maxVal = two;
            stairCount = 1;
        }
    }
    d[n][stairCount] = maxVal + stairs[n];
    if (d[n][0] > d[n][1])
        return d[n][0];
    else
        return d[n][1];

}*/

