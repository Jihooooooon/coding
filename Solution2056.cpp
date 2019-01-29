#include <iostream>
#include <string>
using namespace std;
char date[13] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
int main(void) {
	int T;
	cin >> T;
	for (int test = 1; test <= T; test++) {
		string inputDay = "";
		cin >> inputDay;
		string year = inputDay.substr(0, 4);
		string month = inputDay.substr(4, 2);
		string day = inputDay.substr(6, 2);
		int tYear = atoi(year.c_str());
		int tMonth = atoi(month.c_str());
		int tDay = atoi(day.c_str());
		string result = "";
		if (tMonth < 1 || tMonth>12) {
			result = "-1";
		}
		else {
			if (tDay<1 || tDay>date[tMonth]) {
				result = "-1";
			}
			else {
				result = year + "/" + month + "/" + day;
			}
		}
		cout << "#" << test << " " << result << endl;
	}
	return 0;
}