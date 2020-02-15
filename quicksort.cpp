/*
//
// Created by JongHyeon Kim on 2020/02/05.
//
#include <iostream>
using namespace std;

int number = 15;
int data[15] = {10, 3, 8, 5, 2, 6, 4, 1, 9, 7,  31, 15, 23, 17, 29};
int swapCount = 0;

void quickSort(int * data, int start, int end) {
    if (start >= end)
        return;

    int key = start;
    int i = start + 1;
    int j = end;
    int temp;
    // 가장 바깥 while
    while (i <= j) {
        cout << "바깥 while : " << count++ << endl;
        while (data[key] >= data[i] && i <= end) {
            i++;
        }
        while (data[key] <= data[j] && j > start) {
            j--;
        }
        if (i > j) {
            temp = data[j];
            data[j] = data[key];
            data[key] = temp;
        } else {
            temp = data[j];
            data[j] = data[i];
            data[i] = temp;
        }

    }

    quickSort(data, start, j - 1);
    quickSort(data, j + 1, end);

}

int main() {
    quickSort(data, 0, number - 1);
    for (int i = 0 ; i < number; i++) {
        cout << data[i] << " ";
    }
    return 0;
}*/
