#include <iostream>
#include <string>
using namespace std;

int main(void) {
	//a °¡ 17
	string temp = "";
	cin >> temp;
	for (int i = 0; i < temp.size(); i++) {
		int tempN = (temp[i] - '0') - 16;
		cout << tempN << " ";
	}
	

	return 0;
}