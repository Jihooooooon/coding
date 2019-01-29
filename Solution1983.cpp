#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

double score[100] = { 0, };
int main(void) {
	ios::sync_with_stdio(false);
	int T = 0;
	cin >> T;
	for (int test = 1; test <= T; test++) {
		int n = 0;
		int k = 0;
		cin >> n >> k;
		for (int i = 0; i < n; i++) {
			int mid = 0;
			int fin = 0;
			int hw = 0;
			cin >> mid >> fin >> hw;
			score[i] = 0.35*mid + 0.45*fin + 0.2*hw;
		}
		double tempScore = score[k - 1];
		sort(score,score+n);
		int count = 0;
		for (int k = n - 1; k >= 0; k--) {
			if (tempScore == score[k]) {
				count++;
				break;
			}
			count++;
		}
		double temp = (double)count / (double)n;
		string result = "";
		if (0 <= temp&& temp <= 0.1) {
			result = "A+";
		}
		else if (0.1 < temp && temp <= 0.2) {
			result = "A0";
		}
		else if (0.2 < temp && temp <= 0.3) {
			result = "A-";
		}
		else if (0.3 < temp && temp <= 0.4) {
			result = "B+";
		}
		else if (0.4 < temp && temp <= 0.5) {
			result = "B0";
		}
		else if (0.5 < temp && temp <= 0.6) {
			result = "B-";
		}
		else if (0.6 < temp && temp <= 0.7) {
			result = "C+";
		}
		else if (0.7 < temp && temp <= 0.8) {
			result = "C0";
		}
		else if (0.8 < temp && temp <= 0.9) {
			result = "C-";
		}
		else if (0.9 < temp && temp <= 1) {
			result = "D0";
		}
		for (int i = 0; i < n; i++)
		{
			score[i] = 0;
		}
		cout << "#" << test << " " << result << endl;
	}

	return 0;
}