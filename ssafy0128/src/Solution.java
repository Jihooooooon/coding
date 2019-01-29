import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int[] deck;
    static int winCount;
    static int loseCount;
    public static void swap(int[] arr, int a, int b) {
        int temp= arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static void permutation(int[] deck2,int count) {
        if(count==9) {
            int user1=0;
            int user2=0;
            for(int i=0; i<9; ++i) {
                if(deck[i]>deck2[i]) {
                    user1 += deck[i]+deck2[i];
                }
                else if(deck[i]<deck2[i]) {
                    user2 += deck[i]+deck2[i];
                }
            }
            if(user1>user2) {
                ++winCount;
            }
            else if(user1<user2) {
                ++loseCount;
            }
            return;
        }
         
        for(int i=count; i<9; ++i) {
            swap(deck2,count, i);
            permutation(deck2, count+1);
            swap(deck2,count, i);
        }
         
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        sc.init();
     
        int testCase=sc.nextInt();
         
        deck= new int[9];
        int[] deck2 = new int[9];
        for(int test=1; test<=testCase; ++test) {
            boolean[] isUse = new boolean[19];
            winCount=0;
            loseCount=0;
            String temp = sc.readLine();
            String[] temp2 = temp.split(" ");
            for(int i=0; i<temp2.length; ++i) {
                deck[i]=Integer.parseInt(temp2[i]);
                isUse[deck[i]]=true;
            }
            int tempCount=0;
            for(int i=1; i<=18; ++i) {
                if(!isUse[i]) {
                    deck2[tempCount++]=i;
                }
            }
            permutation(deck2, 0);
            System.out.println("#"+test+" "+winCount+" "+loseCount);
        }
    }
    static class sc {
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
            while (!st.hasMoreTokens()) {
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