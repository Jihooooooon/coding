#include <iostream>

using namespace std;

int temp[10001] = { 0, };

int main(void) {
	temp[1] = 1;
	for (int i = 2; i < 10001; i++) {
		temp[i] = i + temp[i - 1];
	}
	int n = 0;
	for (int i = 1; i < 11; i++) {
		cout << temp[i] << endl;

	}
	cin >> n;
	cout << temp[n];

	return 0;
}