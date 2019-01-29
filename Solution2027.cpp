#include <iostream>
#include <string>

using namespace std;

int main(void) {
	string temp = "+++++";
	for (int i = 0; i < 5; i++) {
		temp[i] = '#';
		cout << temp << endl;
	}

	return 0;
}