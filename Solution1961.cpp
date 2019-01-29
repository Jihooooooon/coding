#include <iostream>

using namespace std;
int arr[7][7] = { 0, };
int main(void) {
	int T;
	cin >> T;
	for (int test = 1; test <= T; test++) {
		int n = 0;
		cin >> n;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin >> arr[i][j];
			}
		}
		cout << "#" << test << endl;
		for (int i = 0; i <n; i++) {
			for (int j = n - 1; j >= 0; j--) {
				cout << arr[j][i];
			}
			cout << " ";
			for (int j = n - 1; j >= 0; j--) {
				cout << arr[n-i-1][j];
			}
			cout << " ";
			for (int j = 0; j <n; j++) {
				cout << arr[j][n-i-1];
			}
			cout << endl;
			
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = 0;
			}
		}
	
	}


	return 0;
}