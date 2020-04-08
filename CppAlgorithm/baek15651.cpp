/*
//
// Created by JongHyeon Kim on 2020/02/25.
//
#include <iostream>
using namespace std;
int n, m;
int arr[8];
void backTracking(int depth);
void printArr(int m);
int main()
{
    scanf("%d %d", &n, &m);

    backTracking(0);

    return 0;
}

void backTracking(int depth) {
    if (depth == m) {
        printArr(m);
        return;
    }
    for (int i = 1; i <= n; i++) {
        arr[depth + 1] = i;
        backTracking(depth + 1);
    }
}

void printArr(int m) {
    for (int i = 1; i <= m; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}
*/
