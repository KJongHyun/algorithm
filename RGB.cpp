/*
#include <cstdio>

int rgb[1001][3];
int d[1001][3];
int dp(int n, int index);
int main()
{
    int numb;
    scanf("%d", &numb);
    for (int i = 1; i <= numb; i++) {
        for (int j = 0; j < 3; j++) {
            scanf("%d", &rgb[i][j]);
        }
    }

    long min = 99999999999999L;
    for (int i = 0; i < 3; i++) {
        int result = dp(numb, i);
        if (min > result)
            min = result;
    }

    printf("%ld", min);
    return 0;
}

int dp(int n, int index) {
    if (n == 1) {
        return rgb[n][index];
    }
    if (d[n][index] != 0)
        return d[n][index];
    int a, b;
    switch (index) {
        case 0:
            a = dp(n - 1, 1);
            b = dp(n - 1, 2);
            break;
        case 1:
            a = dp(n - 1, 0);
            b = dp(n - 1, 2);
            break;
        case 2:
            a = dp(n - 1, 0);
            b = dp(n - 1, 1);
            break;
    }

    if (a >= b)
        return d[n][index] = rgb[n][index] + b;
    else
        return d[n][index] = rgb[n][index] + a;
}*/
