#include <iostream>

using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	int T = 0;
	cin >> T;
	for (int test = 1; test <= T; test++) {
		int hour1 = 0;
		int min1 = 0;
		int hour2 = 0;
		int min2 = 0;
		cin >> hour1 >> min1 >> hour2 >> min2;
		int finH = hour1 + hour2;
		int finM = min1 + min2;
		if (finM > 59) {
			finM -= 60;
			finH++;
		}
		if (finH > 12) {
			finH -= 12;
		}
		cout << "#" << test << " " << finH << " " << finM << endl;
	}
	return 0;
}