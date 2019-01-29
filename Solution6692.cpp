#include <iostream>

using namespace std;

int main() {
	int T=0,N=0;
	cin >> T;
	for (int test = 1; test <= T; test++) {
		cin >> N;
		double result=0;
		for(int i=0; i<N; i++){
			double temp1, temp2;
			cin >> temp1 >> temp2;
			result += (temp1*temp2);
		}
		

		cout << fixed;
		cout.precision(6);
		cout << "#" << test << " " << result << endl;
	}

	


	return 0;
}