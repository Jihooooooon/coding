#include <iostream>

using namespace std;
int alpha[27] = { 0, };
int main(void) {
	int T;
	cin >> T;
	for (int test = 1; test <= T; test++) {
		int n = 0;
		cin >> n;
		for (int i = 0; i < n; i++) {
			char a = '\0';
			int b = 0;
			cin >> a >> b;
			alpha[((int)(a)-65)] = b;
		
		}
		cout << "#" << test << endl;
		int count = 0;
		for (int i = 0; i < 27; i++) {
			for (int j = 0; j < alpha[i]; j++) {

				if (count == 10) {
					cout << endl;
					count = 0;
				}

				count++;
				cout << (char)(i + 65);
				

			}
		}
		cout << endl;
		for (int i = 0; i < 27; i++) {
			alpha[i] = 0;
		}


	}



	return 0;
}