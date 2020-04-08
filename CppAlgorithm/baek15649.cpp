/*
//
// Created by JongHyeon Kim on 2020/02/15.
//
#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int arr[9];

void permutation(int n ,int m, int depth);
void rightSwap(int i, int depth);
void leftSwap(int i, int depth);
void printArr(int m);

int main()
{
    int n, m;
    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; i++) {
        arr[i] = i + 1;
    }

    permutation(n, m, 0);

    return 0;
}

void permutation(int n ,int m, int depth) {
    if (depth == m) {
        printArr(m);
        return;
    }

    for (int i = depth; i < n; i++) {
        rightSwap(i, depth);
        permutation(n, m, depth + 1);
        leftSwap(i, depth);
    }

}

void printArr(int m) {
    for (int i = 0; i < m; i ++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

}

void rightSwap(int i, int depth) {
    int temp = arr[i];
    for (int j = i; j > depth; j--) {
        arr[j] = arr[j - 1];
    }
    arr[depth] = temp;
}

void leftSwap(int i, int depth) {
    int temp = arr[depth];
    for (int j = depth; j < i; j++) {
        arr[j] = arr[j + 1];
    }
    arr[i] = temp;
}*/
