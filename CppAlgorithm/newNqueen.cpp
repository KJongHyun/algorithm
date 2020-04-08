/*
//
// Created by JongHyeon Kim on 2020/03/09.
//
#include <iostream>
using namespace std;


int n;
int cnt = 0;

int arrXLine[15];
int arrYLine[15];

int arrLeftDiagonal[30];
int arrRightDiagonal[30];



void solve(int cX, int cY, int depth);

bool check(int x, int y);

int main()
{
    scanf("%d", &n);


    solve(1, 1, 1);

    printf("%d", cnt);

    return 0;
}

void solve(int cX, int cY, int depth) {
    if (depth > n) {
        cnt++;
        return;
    }

        for (int x = 1; x <= n; x++) {

            if (check(x, cY)) {
                solve(1, cY + 1, depth + 1);
                arrXLine[x] = 0;
                arrYLine[cY] = 0;
                arrLeftDiagonal[n - (x - cY)] = 0;
                arrRightDiagonal[x + cY - 1] = 0;
            }
        }

}

bool check(int x, int y) {
    if (arrXLine[x] == 1 || arrYLine[y] == 1)
        return false;

    int left = x - y;
    int right = x + y;

    if (arrLeftDiagonal[n - left] == 1 || arrRightDiagonal[right - 1] == 1)
        return false;


    arrXLine[x] = 1;
    arrYLine[y] = 1;
    arrLeftDiagonal[n - left] = 1;
    arrRightDiagonal[right - 1] = 1;
    return true;
}


*/
/*//*
/
// Created by JongHyeon Kim on 2020/03/09.
//
#include <iostream>
using namespace std;


int n;
int cnt = 0;

int arrColLine[15];
int arrYLine[15];

int arrLeftDiagonal[30];
int arrRightDiagonal[30];



void solve(int cY, int depth);

bool check(int x, int y);

int main()
{
    scanf("%d", &n);


    solve(1, 1);

    printf("%d", cnt);

    return 0;
}

void solve(int cY, int depth) {
    if (depth > n) {
        cnt++;
        return;
    }

    for (int x = 1; x <= n; x++) {
        if (check(x, cY)) {
            solve(cY + 1, depth + 1);
            arrColLine[x] = 0;
            arrLeftDiagonal[n - (x - cY)] = 0;
            arrRightDiagonal[x + cY - 1] = 0;
        } else
            continue;
    }

}

bool check(int x, int y) {
    if (arrColLine[x] == 1)
        return false;

    int left = x - y;
    int right = x + y;

    if (arrLeftDiagonal[n - left] == 1 || arrRightDiagonal[right - 1] == 1)
        return false;



    arrColLine[x] = 1;
    arrLeftDiagonal[n - left] = 1;
    arrRightDiagonal[right - 1] = 1;
    return true;
}*//*




*/
