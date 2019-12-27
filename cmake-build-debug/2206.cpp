/*
//
// Created by JongHyeon Kim on 2019/11/01.
//
#include <iostream>
#include <queue>

using namespace std;

int map[1001][1001];
int visit[1001][1001];
int x, y;

bool checkCoordinate(int x, int y, int &brokeCount, int &course);

int interval[4][2] = {
        {1,  0},
        {-1, 0},
        {0,  1},
        {0,  -1}
};

typedef struct point {
    int x;
    int y;
    int depth;
    int brokeCount;
    int course;
} Point;

int bfs();

int main() {
    cin >> y >> x;
    for (int i = 1; i <= y; i++) {
        for (int j = 1; j <= x; j++) {
            scanf("%1d", &map[i][j]);
        }
    }

    int depth = bfs();

    for (int i = 1; i <= y; i++) {
        for (int j = 1; j <= x; j++) {
            cout << visit[i][j];
        }
        cout << endl;
    }

    cout << depth << endl;

    return 0;
}

int bfs() {
    queue<Point> q;
    q.push({1, 1, 1, 1, 1});
    Point currentPoint;
    while (!q.empty()) {
        currentPoint = q.front();
        q.pop();




        for (int i = 0; i < 4; i++) {
            int brokeCount = currentPoint.brokeCount;
            int course = currentPoint.course;
            int dx = currentPoint.x + interval[i][0];
            int dy = currentPoint.y + interval[i][1];

            if (visit[dy][dx] != course && checkCoordinate(dx, dy, brokeCount, course)) {
                q.push({dx, dy, currentPoint.depth + 1, brokeCount, course});
                visit[dy][dx] = course;
            }
        }
    }

    if (currentPoint.x == x && currentPoint.y == y)
        return currentPoint.depth;
    else {
        return -1;
    }
}

bool checkCoordinate(int dx, int dy, int &brokeCount, int &course) {
    if (dx > 0 && dy > 0 && dx <= x && dy <= y) {
        if (map[dy][dx] == 1) {
            if (brokeCount == 1) {
                course++;
                brokeCount--;
                return true;
            } else
                return false;
        } else {
            return true;
        }
    } else
        return false;
}
*/
