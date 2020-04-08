/*
//
// Created by JongHyeon Kim on 2019/12/20.
//

#include <iostream>
#include <cstdio>
using namespace std;
long d[101];
long dp(int n);
int main()
{
    int testCase;
    scanf("%d", &testCase);
    for (int i = 0; i < testCase; i++) {
        int n;
        scanf("%d", &n);
        printf("%ld\n", dp(n));
    }

    return 0;
}

long dp(int n) {
    if (n == 1 || n == 2 || n == 3)
        return 1;
    if (n == 4 || n == 5)
        return 2;
    if (d[n] != 0)
        return d[n];
    return d[n] = dp(n - 5) + dp(n - 1);
}*/
