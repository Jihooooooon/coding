#include <iostream>
#include <string>
using namespace std;

int main(void) {
	int T = 0;
	cin >> T;
	for (int test = 1; test <= T; test++) {
		string temp = "";
		cin >> temp;
		int start = 0;
		int end = temp.size() - 1;
		int isP = true;
		while (true) {
			if (start >= end) {
				break;
			}
			if (temp[start] != temp[end]) {
				isP = false;
				break;
			}
			start++;
			end--;
		}
		cout << "#" << test << " " << isP << endl;
	}
}