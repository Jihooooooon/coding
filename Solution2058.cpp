#include <iostream>

using namespace std;

int main() {
	int temp = 0;
	cin >> temp;
	int result = 0;
	while (temp > 0) {
		result += temp % 10;
		temp /= 10;
	}
	cout << result;


	return 0;
}