//1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws Exception {
//    String path = Solution.class.getResource(".").getPath();
//    System.setIn(new FileInputStream(path + "data/input.txt"));

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());
    for (int test_case = 1; test_case <= T; test_case++) {

      st = new StringTokenizer(br.readLine());
      int test_case_num = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      int[] valueArray = new int[101];
      int max_value = 0;
      int max_index = 0;
      while (st.hasMoreTokens()) {
        int i = Integer.parseInt(st.nextToken());
        valueArray[i] += 1;
        if (max_value < valueArray[i]) {
          max_value = valueArray[i];
          max_index = i;
        } else if (max_value == valueArray[i] && max_index < i) {
          max_index = i;
        }
      }
      int result = max_index;

      System.out.println(String.format("#%d %d", test_case_num, result));
    }

  }
}
