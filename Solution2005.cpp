#include <iostream>

using namespace std;

int arr[12][12] = { 0, };

int main(void) {
	int T;
	cin >> T;
	arr[1][1] = 1;

	for (int i = 2; i <= 10; i++) {
		for (int j = 1; j <= i; j++) {
			arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
		}
	}

	for (int test = 1; test <= T; test++) {
		int n = 0;
		cin >> n;
		cout << "#" << test << endl;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				cout << arr[i][j] << " ";
			}
			cout << endl;
		}
	}
	return 0;
}