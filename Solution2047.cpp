#include <iostream>
#include <string>

using namespace std;

int main(void) {
	string temp = "";
	cin >> temp;
	for (int i = 0; i < temp.size(); i++) {
		temp[i] = toupper(temp[i]);
	}
	cout << temp;
	return 0;
}