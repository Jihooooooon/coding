package com.ssafy.algo;



class UserSolution {
	public final static int N = 4;

	public static int guess_count = 0;
	public static int[] visit ;
	public static int[] allCase = new int[5100];
	public static int isInit = 0;

	public void init() {
		
		if (isInit == 0) {
			guess_count=0;
			isInit = 1;
			visit = new int[10000];
			for (int i = 0; i < 10; ++i) {
				for (int j = 0; j < 10; ++j) {
					if (i == j)
						continue;
					for (int k = 0; k < 10; ++k) {
						if (i == k || j == k)
							continue;
						for (int l = 0; l < 10; ++l) {
							if (i == l || k == l || j == l)
								continue;
							allCase[guess_count++] = 1000 * i + 100 * j + 10 * k + l;
						}
					}
				}
			}
		}
	}
	
	public Solution.Result compare(int key, int input) {
		Solution.Result result=new Solution.Result();
		int strike=0;
		int ball=0;
		int[] tempCount = new int[10];
		
		for(int i=0; i<4; ++i) {
			int result1= key%10;
			key /=10;
			int result2= input%10;
			input /=10;
			if(result1==result2) {
				++strike;
			}
			++tempCount[result1];
			++tempCount[result2];
			
		}	
		
		for(int i=0; i<10; ++i) {
			if(tempCount[i]==2) {
				++ball;
			}
		}
		
		ball -=strike;
		result.ball =ball;
		result.strike = strike;
		
		return result;
	}
	
	

	public void doUserImplementation(int guess[]) {

		Solution.Result result = null;
		Solution.Result myResult = null;
		int key = 0;
		init();
		while (true) {
			for (int i = 0; i < guess_count; ++i) {
				if (visit[allCase[i]] == 0) {
					key = allCase[i];
					guess[3] = key % 10;
					guess[2] = (key / 10) % 10;
					guess[1] = (key / 100) % 10;
					guess[0] = key / 1000;
					result = Solution.query(guess);
					break;
				}
			}

			if (result.strike == 4) {
				isInit=0;
				break;
			}

			for (int i = 0; i < guess_count; ++i) {
				if(visit[allCase[i]]==0) {
					myResult = compare(key, allCase[i]);
					if(myResult.ball==result.ball && myResult.strike==result.strike) {
						continue;
					}
					visit[allCase[i]]=1;
				}
			}
			
		}

	}

}