/*
#include <iostream>
#include <queue>
#pragma warning(disable:4996)
using namespace std;
bool visit[11][11][11][11];
int map[11][11];
int interval[4][2] = {
	{1, 0},
{-1, 0},
{0, 1},
{0, -1}
};

typedef struct bead {
	int rX;
	int rY;
	int bX;
	int bY;
    int count = 0;
} BEAD;

BEAD currentBead;

queue<BEAD> q;

int bfs();
void move(int &x, int &y, int type);
bool checkCoordinate(int x, int y);
bool checkDir(int x, int y);
int solve();

int x, y, gX, gY;

int main()
{

	cin >> y >> x;
	int rX, rY, bX, bY;
	for (int i = 1; i <= y; i++) {
		char input[11];
		scanf("%s", input);
		for (int j = 0; j < x; j++) {
			if (input[j] == '#') {
				map[i][j + 1] = -1;
			}
			else if (input[j] == '.') {
				map[i][j + 1] = 0;
			}
			else if (input[j] == 'R') {
				map[i][j + 1] = 1;
				rX = j + 1;
				rY = i;
			}
			else if (input[j] == 'B') {
				map[i][j + 1] = 2;
				bX = j + 1;
				bY = i;
			}
			else if (input[j] == 'O') {
				map[i][j + 1] = 3;
				gX = j + 1;
				gY = i;
			}
			else
				return 0;
		}
	}

	q.push({ rX, rY, bX, bY, 0 });

	cout << solve();
	return 0;
}

int solve() {
	return bfs();
}

int bfs() {
	while (!q.empty()) {
		BEAD bead = q.front(); q.pop();
		if (bead.count >= 10)
		    break;
		if (bead.rX == gX && bead.rY == gY)
		    return bead.count;
		for (int i = 0; i < 4; i++) {
			currentBead.rX = bead.rX;
			currentBead.rY = bead.rY;
			currentBead.bX = bead.bX;
			currentBead.bY = bead.bY;
			move(currentBead.rX, currentBead.rY, i);
            move(currentBead.bX, currentBead.bY, i);
            if (currentBead.bX == gX && currentBead.bY == gY)
                continue;
			if (!visit[currentBead.rX][currentBead.rY][currentBead.bX][currentBead.bY]) {
                visit[currentBead.rX][currentBead.rY][currentBead.bX][currentBead.bY] = true;
			}
		}
	}
}

void move(int &x, int &y, int type) {
    while (1) {
        if (map[y + interval[type][0]][x + interval[type][1]] == -1)
            break;
        else if (map[y + interval[type][0]][x + interval[type][1]] == 3) {
            x += interval[type][1];
            y += interval[type][0];
            break;
        }
        x += interval[type][1];
        y += interval[type][0];
    }
}*/
