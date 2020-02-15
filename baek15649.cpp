//
// Created by JongHyeon Kim on 2020/02/15.
//
#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int arr[9];

void permutation(int n ,int m, int depth);
void swap(int * a, int * b);
void printArr(int m);

int main()
{
    int n, m;
    cin >> n >> m;

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
        swap(&arr[i], &arr[depth]);
        permutation(n, m, depth + 1);
        swap(&arr[i], &arr[depth]);
    }

}

void printArr(int m) {
    for (int i = 0; i < m; i ++) {
        cout << arr[i] << " ";
    }
    cout << endl;

}

void swap(int * a, int * b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}