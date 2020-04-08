/*
#include <iostream>

using namespace std;

long fibo(int n);
long fib(int n);

int callCount = 0;

long dp[41];
long dpZero[41];
long dpOne[41];

long fibZero = 0;
long fibOne = 0;

int main() {
    int testCase;
    cin >> testCase;
    for (int i = 0; i < testCase; i++) {
        int input;
        scanf("%d", &input);
        fibo(input);
        cout << dpZero[input] << " " << dpOne[input] << endl;
    }

    return 0;
}

long fibo(int n) {
    if (n == 0) {
        dpZero[0] = 1;
        dpOne[0] = 0;
        return 0;
    } else if (n == 1) {
        dpZero[1] = 0;
        dpOne[1] = 1;
        return 1;
    }
    if (dp[n]) {
        return dp[n];
    } else {
        dp[n] = fibo(n - 1) + fibo(n - 2);
        dpZero[n] = dpZero[n - 1] + dpZero[n - 2];
        dpOne[n] = dpOne[n - 1] + dpOne[n - 2];
        return dp[n];
    }
}

*/
/*
long fib(int n) {
    if (n == 0) {
        fibZero++;
        return 0;
    } else if (n == 1) {
        fibOne++;
        return 1;
    } else {
        return fib(n - 1) + fib(n - 2);
    }

}*/

