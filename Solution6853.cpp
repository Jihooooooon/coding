#include <iostream>

using namespace std;

static int x_1;
static int x_2;
static int y_1;
static int y_2;

bool isIn(int x, int y) {
	if (x_1 < x &&x < x_2 && y_1 < y && y < y_2) {
		return true;
	}
	else {
		return false;
	}
}

bool isBoard(int x, int y) {
	bool board = false;
	if (x == x_1 || x == x_2) {
		if (y_1 <= y && y <= y_2) {
			board = true;
		}
	}
	if (y == y_1 || y == y_2) {
		if (x_1 <= x && x <= x_2) {
			board = true;
		}
	}
	return board;
}



void makeSort() {
	if (x_1 > x_2) {
		int temp = x_2;
		x_2 = x_1;
		x_1 = temp;
	}
	if (y_1 > y_2) {
		int temp = y_2;
		y_2 = y_1;
		y_1 = temp;
	}
	return ;
}



int main() {
	int T = 0;
	cin >> T;
	for (int test = 1; test <= T; test++) {
		cin >> x_1 >> y_1 >> x_2 >> y_2;
		makeSort();
		int inCount = 0;
		int boardCount = 0;
		int outCount = 0;
		int N = 0;
		cin >> N;
		for (int i = 0; i < N; i++) {
			int x = 0;
			int y = 0;
			cin >> x >> y;
			if (isIn(x, y)) {
				inCount++;
			}
			else if (isBoard(x, y)) {
				boardCount++;
			}
			else {
				outCount++;
			}
		}
		cout << "#" << test << " " << inCount << " " << boardCount << " " << outCount << endl;
	
	
	}
	return 0;
}