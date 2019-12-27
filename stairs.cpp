//
// Created by JongHyeon Kim on 2019/12/27.
//
#include <cstdio>

int stairs[301];
int d[301];

int main()
{
    int count;

    scanf("%d", &count);

    for (int i = 1; i <= count; i++) {
        scanf("%d", &stairs[i]);
    }

    return 0;
}

