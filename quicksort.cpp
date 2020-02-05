//
// Created by JongHyeon Kim on 2020/02/05.
//
#include <iostream>
using namespace std;

int number = 10;
int data[10] = {10, 3, 8, 5, 2, 6, 4, 1, 9, 7 };

void quickSort(int * data, int start, int end) {
    if (start >= end)
        return;

    int key = start;
    int i = start + 1;
    int j = end;
    int temp;
    while (i <= j) { // 엇갈릴 때까지 반복
        while (data[key] >= data[i] && i <= end) {
            i++;
            cout << "while i : " << i << endl;
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
            cout << "key :  " << key << " end : " << end << " i : " << i <<  " j : " << j << endl;
        }

    }

    quickSort(data, start, j - 1);
    quickSort(data, j + 1, end);

}

int main() {
    quickSort(data, 0, 9);
    for (int i = 0 ; i < 10; i++) {
        cout << data[i] << " ";
    }
    return 0;
}