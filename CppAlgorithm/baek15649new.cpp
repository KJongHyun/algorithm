/*
//
// Created by JongHyeon Kim on 2020/02/18.
//
#include <iostream>
using namespace std;


int visit[9];
int arr[9];

void print(int m);
void permu(int depth);

int n, m;

int main()
{
    scanf("%d %d", &n, &m);

    permu(1);

    return 0;
}

void print(int m) {
    for (int i = 1; i <=m; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

}

void permu(int depth) {
    if (depth > m) {
        print(m);
        return;
    }

    for (int i = 1; i <= n; i++) {
        if (visit[i] == 0) {
            arr[depth] = i;
            visit[i] = 1;
            permu(depth + 1);
            visit[i] = 0;
        }

    }
}*/
