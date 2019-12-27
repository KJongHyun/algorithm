/*
//
// Created by JongHyeon Kim on 2019/11/10.
//
#include <iostream>
using namespace std;

int main()
{
    int array[8] = {0, 1, 2, 3, 4, 5, 6, 7};
    int lo = 1;
    int hi = 7;
    int mid;
    int target = 5;
    while (lo <= hi) {
        mid = (lo + hi) / 2;
        if (target <= array[mid]) hi = mid - 1;
        if (target > array[mid]) lo = mid + 1;
    }

    cout << "lo : " << lo << endl;
    cout << "hi : " << hi << endl;

    return 0;
}


*/
