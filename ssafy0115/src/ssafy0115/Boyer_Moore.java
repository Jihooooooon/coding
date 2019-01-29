package ssafy0115;

public class Boyer_Moore {
	
	public static int boyer_Moore(String example, String input) {
		int result=-1;
		char[] arr1 = example.toCharArray();
		char[] arr2 = input.toCharArray();
		if(arr1.length<arr2.length) {
			return result;
		}
		int j=arr2.length-1;
		for(int i=arr2.length-1; i< arr1.length; i++) {
			if(arr1[i]==arr2[j]) {
				int tempJ=j;
				int tempI=i;
				boolean flag=false;
				while(--tempI>=0) {
					if(arr1[tempI]!=arr2[tempJ]) {
						flag=true;
						break;
					}
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String example = "Hello World!";
		String input = "World";
	}

}
