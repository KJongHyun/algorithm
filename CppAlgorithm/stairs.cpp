/*
#include <algorithm>
#include <iostream>
using namespace std;

int dp[301];
int dpm(int n);
int arr[301];

int main()
{
    int numb;

    cin >> numb;

    for (int i = 1; i <= numb; i++) {
        cin >> arr[i];
    }

    cout << dpm(numb);

    return 0;
}

int dpm(int n) {
    if (n == 0) {
        return 0;
    } else if (n == 1) {
        return arr[1];
    } else if (n == 2) {
        return arr[1] + arr[2];
    } else if (dp[n] != 0) {
        return dp[n];
    } else {
        dp[n] = max((arr[n] + arr[n - 1] + dpm(n - 3)), (arr[n] + dpm(n - 2)));
        return dp[n];
    }
}*/
