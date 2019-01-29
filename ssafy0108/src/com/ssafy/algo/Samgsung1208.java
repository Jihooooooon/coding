package com.ssafy.algo;

import java.util.Scanner;
 
public class Samgsung1208 {
    static int arr[]=new int[100];
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
             
            for(int test_case=0;test_case<10;test_case++) {
             
                int dStop = sc.nextInt();
                int chk_min = 0;
                int chk_max = 0;
                int min_idx = 0;
                int max_idx = 0;
           
                 
                for(int i = 0; i<100; i++) {
                    arr[i] = sc.nextInt();
    
                    if(i==0) {
                        chk_min =arr[i];
                        chk_max = arr[i];
                    }else {
                        if(chk_min > arr[i]) {
                            chk_min = arr[i];
                            min_idx = i;
                        }
                        if(chk_max < arr[i]) {
                            chk_max = arr[i];
                            max_idx = i;
                        }
                    }
                }
                         
                for(int chk = 0 ; chk < dStop ; chk++) {
     
                    arr[min_idx] = arr[min_idx] + 1;
                    arr[max_idx] = arr[max_idx] - 1;
                    chk_min = arr[min_idx];
                    chk_max = arr[max_idx];
                  
                    for(int i = 0; i<100; i++) {
                        if(chk_min > arr[i]) {
                            chk_min = arr[i];
                            min_idx = i;
                        }
                        if(chk_max < arr[i]) {
                            chk_max = arr[i];
                            max_idx = i;
                        }
                    }
           
                    if(arr[min_idx] ==arr[max_idx] || (arr[max_idx]-arr[min_idx])==1 ) {
                        break;
                    }
                     
                }
                System.out.println("#"+(test_case+1)+" "+(arr[max_idx]-arr[min_idx]));
                 
            }
     
    }
 
}