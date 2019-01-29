import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Solution2{
    static BufferedReader br;
    static BufferedWriter bw;    
    static StringTokenizer st;
     
    public static void main(String args[]) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int tc=0;
        while(br.ready()){
            tc++;
            int cryptLen = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> cryptList = new ArrayList<>();
             
            st = new StringTokenizer(br.readLine().trim());
            for(int i=1;i<=cryptLen;i++) {
                cryptList.add(Integer.parseInt(st.nextToken()));
            }
             
            int orderCnt = Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine().trim());
            for(int i=0;i<orderCnt;i++) {
                char order = st.nextToken().charAt(0);
                int insPosition = Integer.parseInt(st.nextToken());
                int insCnt = Integer.parseInt(st.nextToken());
                 
                for(int j=0;j<insCnt;j++) {
                    if(insPosition+j<10) {
                        cryptList.add(insPosition+j, Integer.parseInt(st.nextToken()));
                    } else {
                        String temp = st.nextToken();
                    }
                }
            }
             
            bw.write("#"+tc+" ");
            for(int i=0;i<10;i++) {
                bw.write(Integer.toString(cryptList.get(i))+" ");
            }
            bw.newLine();
            bw.flush();
        }
        br.close();
        bw.close();     
    }
     
}