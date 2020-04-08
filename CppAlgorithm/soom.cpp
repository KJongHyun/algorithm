///*
//#include <iostream>
//#include <queue>
//
//using namespace std;
//
//int bfs();
//
//int subin, sis;
//
//int visit[300000];
//
//typedef struct SEC {
//public:
//    int key;
//    int sec;
//}SEC;
//
//int main() {
//    cin >> subin >> sis;
//    int sec = bfs();
//    cout << sec;
//    return 0;
//}
//
//int bfs() {
//    int min = 999999999;
//    queue<SEC> q;
//    q.push({subin, 0});
//    while (!q.empty()) {
//        SEC currentSec = q.front();
//        q.pop();
//        visit[currentSec.key] = 1;
//        if (currentSec.key == sis) {
//            if (min > currentSec.sec)
//                min = currentSec.sec;
//        }
//        if (currentSec.key > 0 && visit[currentSec.key - 1] == 0) {
//            q.push({currentSec.key - 1, currentSec.sec + 1});
//        }
//        if (currentSec.key < sis && visit[currentSec.key + 1] == 0) {
//            q.push({currentSec.key + 1, currentSec.sec + 1});
//        }
//        if (currentSec.key < sis && visit[currentSec.key * 2] == 0) {
//            q.push({currentSec.key * 2, currentSec.sec + 1});
//        }
//    }
//    return min;
//}*/
