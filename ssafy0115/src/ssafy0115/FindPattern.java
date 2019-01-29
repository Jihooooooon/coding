package ssafy0115;

public class FindPattern {
	
	public static int findPattern(String example, String input) {
		char[] exampleArr = example.toCharArray();
		char[] inputArr = input.toCharArray();
		int j=0;
		
		int result=-1;
		for(int i=0; i<exampleArr.length; i++) {
			if(j==inputArr.length) {
				result=i-j+1;
				break;
			}
			if(j==(inputArr.length-1)&&exampleArr[i]==inputArr[j]) {
				result = i-j;
				break;
			}
			if(exampleArr[i]==inputArr[j]) {
				j++;
				continue;
			}
			else {
				j=0;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String example = "Hello World!";
		String input = "World";
		System.out.println(findPattern(example, input));
	}

}
