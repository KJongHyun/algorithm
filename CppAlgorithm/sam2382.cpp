/*
//
// Created by JongHyeon Kim on 2019/11/03.
//
#include <iostream>
#include <vector>
using namespace std;



int T, N, M, K;

int changeDir(int dir);
void move();
void checkColision();
void checkWall();
int solve(int M);
typedef struct crowd {
    int x;
    int y;
    int numb;
    int dir;
    ~crowd() {
        cout << "소멸자 테스트" << endl;
    }
}CROWD;

vector<CROWD> map[101][101];

int main() {
    cin >> T;
    for (int _t = 0; _t < T; _t++) {
        cin >> N >> M >> K;
        for (int _k = 0; _k < K; _k++) {
            int x, y, numb, dir;
            cin >> y >> x >> numb >> dir;
            map[y][x].push_back({ x, y, numb, dir });
        }
        printf("#%d %d\n", _t + 1, solve(M));
    }

    return 0;
}

void move() {
    for (int y = 0; y < N; y++) {
        for (int x = 0; x < N; x++) {
            if (map[y][x].size() == 0)
                continue;
            CROWD crowd = map[y][x].front();
            switch(crowd.dir) {
                // 상
                case 1:
                    map[y - 1][x].push_back(crowd);
                    break;
                // 하
                case 2:
                    map[y + 1][x].push_back(crowd);
                    break;
                // 좌
                case 3:
                    map[y][x - 1].push_back(crowd);
                    break;
                //
                case 4:
                    map[y][x + 1].push_back(crowd);
                    break;
                default:
                    cout << "=======default======";
                    return;
            }
            map[y][x].erase(map[y][x].begin());
        }
    }
}

void checkColision() {
    for (int y = 1; y < N - 1; y++) {
        for (int x = 1; x < N - 1; x++) {
            if (map[y][x].size() == 0)
                continue;
            int sum = 0;
            CROWD maxCROWD = {0, 0, -999, 0};
            for (int i = 0; i < map[y][x].size(); i++) {
                sum += map[y][x][i].numb;
                if (maxCROWD.numb < map[y][x][i].numb)
                    maxCROWD = map[y][x][i];
            }
            maxCROWD.numb = sum;
            map[y][x].clear();
            map[y][x].push_back(maxCROWD);
        }
    }
}

void checkWall() {
    for (int i = 0; i < N; i++) {
        if (map[0][i].size() > 0) {
            CROWD &crowd = map[0][i].front();
            crowd.dir = changeDir(crowd.dir);
            crowd.numb = crowd.numb / 2;
        }
        if (map[N - 1][i].size() > 0) {
            CROWD &crowd = map[N - 1][i].front();
            crowd.dir = changeDir(crowd.dir);
            crowd.numb = crowd.numb / 2;
        }
        if (map[i][0].size() > 0) {
            CROWD &crowd = map[i][0].front();
            crowd.dir = changeDir(crowd.dir);
            crowd.numb = crowd.numb / 2;
        }
        if (map[i][N - 1].size() > 0) {
            CROWD &crowd = map[i][N - 1].front();
            crowd.dir = changeDir(crowd.dir);
            crowd.numb = crowd.numb / 2;
        }
    }

}

int solve(int M) {
    for (int _m = 0; _m < M; _m++) {
        move();
        checkWall();
        checkColision();
    }

    int sum = 0;

    for (int y = 0; y < N; y++) {
        for (int x = 0; x < N; x++) {
            if (map[y][x].size() == 0)
                continue;
            sum += map[y][x].front().numb;
        }
    }

    return sum;
}

int changeDir(int dir) {
    switch (dir) {
        case 1:
            return 2;
        case 2:
            return 1;
        case 3:
            return 4;
        case 4:
            return 3;
        default:
            return 0;
    }
}*/
