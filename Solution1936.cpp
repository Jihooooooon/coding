#include <iostream>

using namespace std;

int main(void) {
	int a, b;
	cin >> a >> b;

	if ((b - a == 1) || (a - b) == 2) {
		cout << "B";
	}
	else {
		cout << "A";
	}
	return 0;
}