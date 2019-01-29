package ssafy0121;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution6607 {
	static int[] sequenceList = new int[44724];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int index=0;
		
		for(int i=1; i<44724; i++) {
			sequenceList[i]=sequenceList[i-1]+i;
	
			
		}
		
		int testCase = sc.nextInt();
		for(int test=1; test<=testCase; test++) {
			int n=sc.nextInt();
			int pivot=0;;
			pivot = binarySearch(n);
		
			int term = sequenceList[pivot]-n;
			StringBuilder sb = new StringBuilder();
			System.out.print("#"+test+" ");
			for (int i = 0; i < pivot - term; i++) {
	            //System.out.print(")");
				sb.append(")");
	        }
			sb.append("(");
	        for (int i = pivot-term; i < pivot; i++) {
	        	//System.out.print(")");
	        	sb.append(")");
	        }
	        
	        for (int i = 0; i < pivot - 1; i++) {
//	        	System.out.print("(");
	        	sb.append("(");
	        }

	        System.out.println(sb.toString());
			
			
			
		}
		
	}
	
	public static int binarySearch(int n) {
		int start =0;
		int end = sequenceList.length-1;
		int result=0;
		while(true) {
			int mid = (start+end)/2;
			if(sequenceList[mid]>=n && sequenceList[mid-1]<n) {
				result=mid;
				break;
			}
			else if(sequenceList[mid]>n) {
				end=mid-1;
			}
			else if(sequenceList[mid]<n) {
				start=mid+1;
			}
		}
		return result;
	}

	static class sc{
		static BufferedReader br;
		static StringTokenizer st;
		
		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}
		
		static String readLine() {
			try {
				return br.readLine();
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}
		
		static String readLineReplaceAll() {
			try {
				return br.readLine().replaceAll("\\s+", "");
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}
		static String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			return st.nextToken();
		}
		
		static int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
