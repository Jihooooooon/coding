#include <iostream>

using namespace std;

int main(void) {
	int n = 0;
	cin >> n;
	cout << 1;
	for (int i = 2; i <= n; i++) {
		if ((n % i) == 0) {
			cout << " " << i;
		}
	}

	return 0;
}