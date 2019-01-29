#include <iostream>

using namespace std;

int main(void) {
	int T = 0;
	cin >> T;
	for (int test = 1; test <= T; test++) {
		int n = 0;
		cin >> n;

		int result = (n / 2)*(-1);
		if (n % 2 == 1) {
			result += n;
		}

		cout << "#" << test << " " << result << endl;
	}



	return 0;
}