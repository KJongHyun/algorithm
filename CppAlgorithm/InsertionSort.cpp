/*
//
// Created by JongHyeon Kim on 2019/11/14.
//
#include <iostream>
using namespace std;

int main()
{
    int array[] = {7, 8, 2, 9, 4, 6};

    for (int i = 1; i < 6; i++) {
        int key = array[i];
        int j = i - 1;
        while(j >= 0 && array[j] > key)
        {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = key;
    }

    for (int i = 0; i < 6; i++) {
        cout << array[i] << " ";
    }

    return 0;
}

*/
