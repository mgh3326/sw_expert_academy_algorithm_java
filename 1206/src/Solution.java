//1206. [S/W 문제해결 기본] 1일차 - View

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
    int T = 10;
    for (int test_case = 1; test_case <= T; test_case++) {

      StringTokenizer st = new StringTokenizer(br.readLine());
      int widthSize = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      int[] valueArray = new int[widthSize];
      int index = 0;
      while (st.hasMoreTokens()) {
        int i = Integer.parseInt(st.nextToken());
        valueArray[index] = i;
        index += 1;
      }
      int result = 0;
      for (int i = 2; i < widthSize - 2; i++) {
        int array[] = {valueArray[i - 2], valueArray[i - 1], valueArray[i + 1], valueArray[i + 2]};
        int max_value = 0;
        for (int i1 : array) {
          if (i1 > max_value) {
            max_value = i1;
          }
        }
        if (valueArray[i] > max_value) {
          result += valueArray[i] - max_value;
        }
      }
      System.out.println(String.format("#%d %d", test_case, result));
    }

  }
}
