#include <iostream>
#include <algorithm>
using namespace std;
static int N;
static int K;
static int dis[100001] = {0};
static int nearDis[100000] = { 0 };

void quick_sort(int a[], int L, int R) {
	
	int left, right, pivot = a[L];
	for (left = L, right = R; left < right; right--) {
		while (a[right] >= pivot && left < right) right--;
		if (left < right) a[left] = a[right];
		while (a[left] <= pivot && left < right) left++;
		if (left >= right) break;
		a[right] = a[left];
	}
	a[left] = pivot;
	if (left > L) quick_sort(a, L, left - 1);
	if (left < R) quick_sort(a, left + 1, R);
}

int main() {
	int T = 0;
	cin >> T;
	for (int test = 1; test <= T; test++) {
		cin >> N >> K;
		int result = 0;
		for (int i = 0; i < N; i++) {
			cin >> dis[i];
		}
		for (int i = 0; i < N - 1; i++) {
			nearDis[i] = dis[i + 1] - dis[i];
		}
		if (N <= K) {
			result = 0;
		}
		else {
			sort(nearDis,nearDis+(N-1));
			for (int k = 0; k < N-K ; k++) {
				result += nearDis[k];
			}
		}
		cout << "#" << test << " " << result << endl;
	}
	


	return 0;
}