package com.ssafy.algo;
import java.io.*;


class Solution {
    public static void main(String args[]) throws IOException {
        //System.setIn(new FileInputStream("res/input.txt"));
 
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int T;
            T = Integer.parseInt(br.readLine());
 
            for (int testCase = 1; testCase <= T; testCase++) {
                result = new StringBuffer();
                solve(br, bw);
                print(testCase);
            }
            bw.flush();
        }
    }
 
    private static StringBuffer result;
 
    private static void solve(BufferedReader br, BufferedWriter bw) throws IOException {
        String[] lineSplit = br.readLine().split(" ");
        int N = Integer.parseInt(lineSplit[0]);
        String direction = lineSplit[1];
 
        int[][] arr = new int[N][N];
 
        for (int i = 0; i < N; i++) {
            String[] splits = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(splits[j]);
            }
        }
 
        switch (direction) {
            case "up":
                // x축
                for (int i = 0; i < N; i++) {
                    boolean isDone[] = new boolean[N];
                    // y축 변화
                    for (int j = 1; j < N; ++j) {
                        // 지금꺼랑
                        int temp = arr[j][i];
                        // 전꺼랑 비교
                        for (int k = j - 1; k >= 0; --k) {
                            if (arr[k][i] == 0) {
                                arr[k+1][i] = 0;
                                arr[k][i] = temp;
                            } else if (arr[k][i]    > temp) break;
                            else if (arr[k][i] == temp) {
                                if (isDone[k]) break;
                                for (int l = j; l >= k+1; --l) {
                                    arr[l][i] = 0;
                                }
                                arr[k][i] *= 2;
                                isDone[k] = true;
                                break;
                            } else if (arr[k][i] != 0 && arr[k][i] < temp) break;
                        }

                    }
//                   
                }
                break;
            case "down":
                // x축
                for (int i = 0; i < N; i++) {
                    boolean isDone[] = new boolean[N];
                    // y축 변화
                    for (int j = N-2; j >= 0; --j) {
                        // 지금꺼랑
                        int temp = arr[j][i];
                        // 전꺼랑 비교
                        for (int k = j + 1; k < N; ++k) {
                            if (arr[k][i] == 0) {
                                arr[k-1][i] = 0;
                                arr[k][i] = temp;
                            }
                            else if (arr[k][i] > temp) break;
                            else if (arr[k][i] == temp) {
                                if (isDone[k]) break;
                                for (int l = j; l <= k-1; ++l) {
                                    arr[l][i] = 0;
                                }
                                arr[k][i] *= 2;
                                isDone[k] = true;
                                break;
                            } else if (arr[k][i] != 0 && arr[k][i] < temp) break;
                        }
                    }
                }
                break;
            case "left":
                // y축
                for (int i = 0; i < N; i++) {
                    boolean isDone[] = new boolean[N];
                    // x축 변화
                    for (int j = 1; j < N; ++j) {
                        // 지금꺼랑
                        int temp = arr[i][j];
                        // 전꺼랑 비교
                        for (int k = j - 1; k >= 0; --k) {
                            if (arr[i][k] == 0) {
                                arr[i][k+1] = 0;
                                arr[i][k] = temp;
                            }
                            else if (arr[i][k] > temp) break;
                            else if (arr[i][k] == temp) {
                                if (isDone[k]) break;
                                for (int l = j; l >= k+1; --l) {
                                    arr[i][l] = 0;
                                }
                                arr[i][k] *= 2;
                                isDone[k] = true;
                                break;
                            } else if (arr[i][k] != 0 && arr[i][k] < temp) break;
                        }
                    }
                }
                break;
            case "right":
                // y축
                for (int i = 0; i < N; i++) {
                    boolean isDone[] = new boolean[N];
                    // x축 변화
                    for (int j = N-2; j >= 0; --j) {
                        // 지금꺼랑
                        int temp = arr[i][j];
                        // 전꺼랑 비교
                        for (int k = j + 1; k < N; ++k) {
                            if (arr[i][k] == 0) {
                                arr[i][k-1] = 0;
                                arr[i][k] = temp;
                            }
                            else if (arr[i][k] > temp) break;
                            else if (arr[i][k] == temp) {
                                if (isDone[k]) break;
                                for (int l = j; l <= k-1; ++l) {
                                    arr[i][l] = 0;
                                }
                                arr[i][k] *= 2;
                                isDone[k] = true;
                                break;
                            } else if (arr[i][k] != 0 && arr[i][k] < temp) break;
                        }
                    }
                }
                break;
        }
 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result.append(arr[i][j]).append(' ');
            }
            if (i == N-1) break;
            result.append('\n');
        }
    }
 
    private static void print(int testCase) {
        System.out.printf("#%d \n", testCase);
        System.out.println(result.toString());
    }
}