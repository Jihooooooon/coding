#include <iostream>
#include <algorithm>


using namespace std;
static int deck[9] = { 0, };
static int winCount = 0;
static int loseCount = 0;

void swap(int arr[], int a, int b) {
	int temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;
}

void permutation(int deck2[], int count) {
	if (count == 9) {
		int user1 = 0;
		int user2 = 0;
		for (int i = 0; i < 9; i++) {
			if (deck[i] > deck2[i]) {
				user1 += deck[i] + deck2[i];
			}
			else if (deck[i] < deck2[i]) {
				user2 += deck[i] + deck2[i];
			}
		}
		if (user1 > user2) {
			winCount++;
		}
		else if (user1 < user2) {
			loseCount++;
		}
		return;
	}
	for (int i = count; i < 9; i++) {
		swap(deck2, count, i);
		permutation(deck2, count + 1);
		swap(deck2, count, i);
	}
}

int main() {
	std::ios_base::sync_with_stdio(false);

	int T = 0;
	cin >> T;
	int deck2[9] = { 0, };
	for (int test = 1; test <= T; test++) {
		bool isUse[19] = { false, };
		winCount = 0;
		loseCount = 0;
		cin >> deck[0] >> deck[1] >> deck[2] >> deck[3] >> deck[4] >> deck[5] >> deck[6] >> deck[7] >> deck[8];
		//scanf("%d %d %d %d %d %d %d %d %d", &deck[0], &deck[1], &deck[2], &deck[3], &deck[4], &deck[5], &deck[6], &deck[7], &deck[8]);

		for (int i = 0; i < 9; i++) {
			isUse[deck[i]] = true;
		}
		int tempCount = 0;
		for (int i = 1; i <= 18; i++) {
			if (!isUse[i]) {
				deck2[tempCount++] = i;
			}

		}
		sort(deck2, deck2 + 9);
		do {
			int user1 = 0;
			int user2 = 0;
			for (int i = 0; i < 9; i++) {
				if (deck[i] > deck2[i]) {
					user1 += deck[i] + deck2[i];
				}
				else if (deck[i] < deck2[i]) {
					user2 += deck[i] + deck2[i];
				}
			}
			if (user1 > user2) {
				winCount++;
			}
			else if (user1 < user2) {
				loseCount++;
			}
		} while (next_permutation(deck2,deck2+9));
		//permutation(deck2, 0);
		printf("#%d %d %d\n", test, winCount, loseCount);
	}




	return 0;
}