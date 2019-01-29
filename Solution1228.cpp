#include <iostream>
using namespace std;

int main()
{
	for (int T = 1; T <= 10; T++)
	{
		int code[10];
		int N;
		char insert;
		int bin; 
		cin >> N;
		for (int i = 0; i < N; i++)
		{  
			if (i < 10) cin >> code[i];
			else cin >> bin;
		}

		cin >> N >> insert;


		for (int i = 0; i < N; i++)
		{
			int x, y;
			cin >> x >> y;
			if (x < 10)
			{
				for (int j = 9 - y; j >= x; j--) 
					if (j + y < 10) code[j + y] = code[j];
				
				for (int j = 0; j < y; j++) 
				{
					if (x + j < 10) cin >> code[x + j]; // 마찬가지로 x+j가 10보다 클 경우 저장할 필요가 없음
					else cin >> bin; // 입력은 받아야하니 bin으로 받아줌
				}
			}
			else //x>10인 경우
				for (int j = 0; j < y; j++) cin >> bin;

			if (i != N - 1) cin >> insert;

		}
		cout << "#" << T;
		for (int i = 0; i < 10; i++) cout << " " << code[i];
		cout << endl;
	}
}