/*
#include <iostream>
#include <queue>
using namespace std;

int map[1001][1001];
bool visit[1001][1001][2];

int interval[4][2] = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
};

int x, y;
void bfs();
int answer = -1;

bool checkOutSide(int dx, int dy);

typedef struct block_info {
    int x;
    int y;
    int broke_count = 1;
    int count = 1;
}BLOCK;

queue<BLOCK> q;

int main()
{
    cin >> y >> x;

    for (int i = 1; i <= y; i++) {
        for (int j = 1; j <= x; j++) {
            scanf("%1d", &map[i][j]);
        }
    }

    q.push({1, 1});
    visit[1][1][1] = true;

    bfs();

    cout << answer << endl;

    return 0;
}

void bfs() {
    while(!q.empty()) {
        BLOCK block = q.front();
        q.pop();

        if (block.x == x && block.y == y) {
            answer = block.count;
            break;
        }

        for (int i = 0; i < 4; i++) {
            BLOCK currentBlock = block;
            int x = currentBlock.x + interval[i][0] ;
            int y = currentBlock.y + interval[i][1];

            if (checkOutSide(x, y)) {
                // 벽인 경우
                if (map[y][x] == 1) {
                    // 벽을 뚫을 수 있는 기회가 남은경우
                    if (currentBlock.broke_count == 1) {
                        currentBlock.broke_count--;
                    }
                    else // 없는 경우 못가기 때문에 continue
                        continue;
                }

                // 방문하지 않은 경우
                if (!visit[x][y][currentBlock.broke_count]) {
                    q.push({x, y, currentBlock.broke_count, currentBlock.count + 1});
                    visit[x][y][currentBlock.broke_count] = true;
                }
            }



        }
    }
}

bool checkOutSide(int dx, int dy) {
    return dx <= x && dy <= y && dx >= 1 && dy >= 1;
}*/
