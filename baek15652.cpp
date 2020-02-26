//
// Created by JongHyeon Kim on 2020/02/26.
//
#include <iostream>
using namespace std;

void combination(int depth, int key);
void printArr(int m);

int n, m;

int arr[9];

int main()
{
    scanf("%d %d", &n, &m);

    combination(0, 1);

    return 0;
}

void combination(int depth, int key) {
    if (depth == m) {
        printArr(m);
        return;
    }

    for (int i = key; i <= n; i++) {
        arr[depth + 1] = i;
        combination(depth + 1, i);
    }
}

void printArr(int m) {
    for(int i = 1; i <= m; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}