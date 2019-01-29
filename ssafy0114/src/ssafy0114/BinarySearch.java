package ssafy0114;

public class BinarySearch {
	
	public static int binarySearch(int[] sortedArr, int data, int start, int end) {
		int result=-1;
		if(start>=end) {
			if(sortedArr[start]==data) {
				result=start;
			}
			return result;
		}
		int mid = (start+end)/2;
		if(data>sortedArr[mid]) {
			return binarySearch(sortedArr, data, mid+1, end);
		}
		else if(data < sortedArr[mid]) {
			return binarySearch(sortedArr, data, start, mid-1);
		}
		else {
			return mid;
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test= {1,2,3,4,5,6,7,8,9,10,15,18,23};
		System.out.println(binarySearch(test, 6, 0, test.length-1));
	}

}
