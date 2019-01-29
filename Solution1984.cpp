#include <iostream>

using namespace std;

int main(void) {
	int T = 0;
	cin >> T;

	for (int test = 1; test <= T; test++) {

		int min = 10000;
		int max = 0;
		int temp = 0;
		double result = 0;
		for (int i = 0; i < 10; i++) {
			cin >> temp;
			max = max < temp ? temp : max;
			min = min > temp ? temp : min;
			result += temp;
		}
		result = result - max - min;
		printf("#%d %.0f\n", test, result);
	}


	return 0;
}