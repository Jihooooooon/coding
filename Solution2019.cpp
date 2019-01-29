#include <iostream>

using namespace std;

int arr[31] = { 0, };

int main(void) {
	arr[1] = arr[0] = 1;
	for (int i = 2; i < 31; i++) {
		arr[i] = 2 * arr[i - 1];
	}
	int T;
	cin >> T;
	for (int i = 1; i <= T+1; i++) {
		cout << arr[i] << " ";
	}

	return 0;
}