#include <iostream>

using namespace std;

int main(void) {
	int T = 0;
	cin >> T;

	for (int test = 1; test <= T; test++) {
		int maxN = 0;
		for (int i = 0; i < 10; i++) {
			int temp = 0;
			cin >> temp;
			maxN = maxN < temp ? temp : maxN;
			
		}
		cout << "#" << test << " " << maxN << endl;
	}
}