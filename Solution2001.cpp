#include <iostream>

using namespace std;

int map[15][15] = { 0, };

int main(void) {
	int T;
	cin >> T;
	for (int test = 1; test <= T; test++) {
		int N=0, M=0;
		cin >> N >> M;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cin >> map[i][j];
			}
		}
		int result = 0;
		for (int i = 0; i < N - M + 1; i++) {
			for (int j = 0; j < N - M + 1; j++) {
				int temp = 0;
				for (int k = i; k < i + M; k++) {
					for (int t = j; t < j + M; t++) {
						temp += map[k][t];
					}
				}
				result = result < temp ? temp : result;
			}
		}
		cout << "#" << test << " " << result << endl;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 0;
			}
		}
	}
	return 0;
}