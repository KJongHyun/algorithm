/*
#include <iostream>
#include <queue>
#include <vector>

using namespace std;
int map[101][101][101];
int interval[6][3] = {
        {1,  0,  0},
        {-1, 0,  0},
        {0,  1,  0},
        {0,  -1, 0},
        {0,  0,  1},
        {0,  0,  -1}
};


int x, y, z;

void solve();

int dfs();


bool checkCoordinate(int x, int y, int z);

typedef struct Point {
public:
    int x;
    int y;
    int z;
    int depth;

} Point;

queue<Point> q;

int main() {

    cin >> x >> y >> z;
    for (int k = 1; k <= z; k++) {
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                int input;
                scanf("%d", &input);
                map[k][i][j] = input;
                if (input == 1) {
                    q.push({j, i, k, 0});
                }
            }
        }
    }
    solve();
    return 0;
}

void solve() {
    int day = dfs();

    for (int k = 1; k <= z; k++) {
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                if (map[k][i][j] == 0) {
                    cout << -1 << endl;
                    return;
                }
            }

        }
    }

    cout << day << endl;
}

int dfs() {
    int i = 0;
    int max = -999;
    while (!q.empty()) {
        Point currentPoint = q.front();
        if (max < currentPoint.depth) {
            max = currentPoint.depth;
        }
        q.pop();
        for (int j = 0; j < 6; j++) {
            int dx = currentPoint.x + interval[j][0];
            int dy = currentPoint.y + interval[j][1];
            int dz = currentPoint.z + interval[j][2];
            if (checkCoordinate(dx, dy, dz)) {
                q.push({dx, dy, dz,currentPoint.depth + 1});
                map[dz][dy][dx] = 1;
            }
        }
    }

    return max;
}


bool checkCoordinate(int currentX, int currentY, int currentZ) {
    if (currentX <= x && currentY <= y && currentZ <= z && currentX > 0 && currentY > 0 && currentZ > 0 && map[currentZ][currentY][currentX] == 0)
        return true;
    else
        return false;
}*/
