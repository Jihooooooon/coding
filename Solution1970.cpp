#include <iostream>

using namespace std;

int main(void) {
	int T;
	cin >> T;
	for (int test = 1; test <= T; test++) {
		int ct1, ct2, ct3, ct4, ct5, ct6, ct7, ct8;
		int n = 0;
		cin >> n;
		ct1 = n / 50000;
		n = n - ct1 * 50000;
		ct2 = n / 10000;
		n = n - ct2 * 10000;
		ct3 = n / 5000;
		n = n - ct3 * 5000;
		ct4 = n / 1000;
		n = n - ct4 * 1000;
		ct5 = n / 500;
		n = n - ct5 * 500;
		ct6 = n / 100;
		n = n - ct6 * 100;
		ct7 = n / 50;
		n = n - ct7 * 50;
		ct8 = n / 10;
		cout << "#" << test << endl;
		printf("%d %d %d %d %d %d %d %d", ct1, ct2, ct3, ct4, ct5, ct6, ct7, ct8);

	}

	return 0;
}