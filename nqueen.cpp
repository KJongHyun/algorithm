/*
//
// Created by JongHyeon Kim on 2020/03/09.
//
#include <iostream>

using namespace std;


int arr[15][15];
int n;
int cnt = 0;


void solve(int cX, int cY, int depth);

void mark(int x, int y, int depth);

void unMark(int x, int y, int depth);

int main() {
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
    int currentX = cX;
    for (int y = cY; y <= n; y++) {
        for (int x = currentX; x <= n; x++) {
            if (arr[y][x] == 0) {
                mark(x, y, depth);
                solve(1, y + 1, depth + 1);
                unMark(x, y, depth);
            }
        }
        currentX = 1;
    }

}

void mark(int x, int y, int depth) {
    arr[y][x] = depth;
    // left
    for (int l = x - 1; l >= 1; l--) {
        if (arr[y][l] == 0)
            arr[y][l] = depth;
    }
    // right
    for (int r = x + 1; r <= n; r++) {
        if (arr[y][r] == 0)
            arr[y][r] = depth;
    }
    // top
    for (int t = y - 1; t >= 1; t--) {
        if (arr[t][x] == 0)
            arr[t][x] = depth;
    }
    // bottom
    for (int b = y + 1; b <= n; b++) {
        if (arr[b][x] == 0)
            arr[b][x] = depth;
    }
    // left, top
    for (int dl = -1, dt = -1; dl + x >= 1 && dt + y >= 1; dl--, dt--) {
        if (arr[y + dt][x + dl] == 0)
            arr[y + dt][x + dl] = depth;
    }
    // right, top
    for (int dr = 1, dt = -1; dr + x <= n && dt + y >= 1; dr++, dt--) {
        if (arr[y + dt][x + dr] == 0)
            arr[y + dt][x + dr] = depth;
    }
    // left, bottom
    for (int dl = -1, db = 1; dl + x >= 1 && db + y <= n; dl--, db++) {
        if (arr[y + db][x + dl] == 0)
            arr[y + db][x + dl] = depth;
    }
    // right, bottom
    for (int dr = 1, db = 1; dr + x <= n && db + y <= n; dr++, db++) {
        if (arr[y + db][x + dr] == 0)
            arr[y + db][x + dr] = depth;
    }


}

void unMark(int x, int y, int depth) {
    arr[y][x] = 0;
    // left
    for (int l = x - 1; l >= 1; l--) {
        if (arr[y][l] == depth)
            arr[y][l] = 0;
    }
    // right
    for (int r = x + 1; r <= n; r++) {
        if (arr[y][r] == depth)
            arr[y][r] = 0;
    }
    // top
    for (int t = y - 1; t >= 1; t--) {
        if (arr[t][x] == depth)
            arr[t][x] = 0;
    }
    // bottom
    for (int b = y + 1; b <= n; b++) {
        if (arr[b][x] == depth)
            arr[b][x] = 0;
    }
    // left, top
    for (int dl = -1, dt = -1; dl + x >= 1 && dt + y >= 1; dl--, dt--) {
        if (arr[y + dt][x + dl] == depth)
            arr[y + dt][x + dl] = 0;
    }
    // right, top
    for (int dr = 1, dt = -1; dr + x <= n && dt + y >= 1; dr++, dt--) {
        if (arr[y + dt][x + dr] == depth)
            arr[y + dt][x + dr] = 0;
    }
    // left, bottom
    for (int dl = -1, db = 1; dl + x >= 1 && db + y <= n; dl--, db++) {
        if (arr[y + db][x + dl] == depth)
            arr[y + db][x + dl] = 0;
    }
    // right, bottom
    for (int dr = 1, db = 1; dr + x <= n && db + y <= n; dr++, db++) {
        if (arr[y + db][x + dr] == depth)
            arr[y + db][x + dr] = 0;
    }

}


*/
