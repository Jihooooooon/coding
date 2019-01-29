package ssafy0115;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by JIHOON on 2018-10-16.
 */
public class Solution5432 {

    public void solution(){
        Scanner sc = new Scanner(System.in);
        int testTime = sc.nextInt();
        for(int i=1; i<= testTime; i++){
            String temp = sc.next();
            char[] bracket = new char[temp.length()];

            for(int j=0; j<temp.length();j++){
                bracket[j]=temp.charAt(j);
            }


            int count=0;

            CharStack stack = new CharStack();
            for(int j=0; j<temp.length()-1;j++){
                int first=j;
                int last=j+1;

                if(bracket[first]=='('&&bracket[last]==')') {
                    count += stack.size();
                    j++;
                }
                else{
                    if(bracket[first]=='(') {
                        stack.push('(');
                        count++;
                    }
                    else{
                        stack.pop();
                    }
                }

            }
            System.out.println("#"+i+" "+count);
        }
    }
    public class CharStack{
        StringBuilder sb;

        public CharStack(){
            sb = new StringBuilder();
        }

        public void push(char input){
            sb.append(input);
        }
        public char peek(){
            int lastIndex = sb.length()-1;
            char result = sb.charAt(lastIndex);
            return result;
        }
        public char pop(){
            int lastIndex = sb.length()-1;
            char result = sb.charAt(lastIndex);
            sb.setLength(lastIndex);
            return result;
        }

        public int size(){
            return sb.length();
        }

        public boolean isEmpty(){
            return sb.length()==0?true:false;
        }

    }

    public static void main(String[] args) {
        new Solution5432().solution();
    }
}
