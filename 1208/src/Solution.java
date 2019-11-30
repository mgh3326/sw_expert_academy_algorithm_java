//1208. [S/W 문제해결 기본] 1일차 - Flatten

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws Exception {
//    String path = Solution.class.getResource(".").getPath();
//    System.setIn(new FileInputStream(path + "data/input.txt"));

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = 10;
    for (int test_case = 1; test_case <= T; test_case++) {

      StringTokenizer st = new StringTokenizer(br.readLine());
      int widthSize = 100;
      int dumpNum = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      int[] valueArray = new int[widthSize + 1];
      int maxValue = 0;
      int minValue = 100;
      while (st.hasMoreTokens()) {
        int value = Integer.parseInt(st.nextToken());
        valueArray[value] += 1;
        if (maxValue < value) {
          maxValue = value;
        }
        if (minValue > value) {
          minValue = value;
        }
      }
      for (int i = 0; i < dumpNum; i++) {
        if (maxValue == minValue) {
          break;
        }
        valueArray[maxValue] -= 1;
        valueArray[maxValue - 1] += 1;
        valueArray[minValue] -= 1;
        valueArray[minValue + 1] += 1;
        if (valueArray[maxValue] == 0) {
          while (true) {
            maxValue -= 1;
            if (valueArray[maxValue] > 0) {
              break;
            }
          }
        }
        if (valueArray[minValue] == 0) {
          while (true) {
            minValue += 1;
            if (valueArray[minValue] > 0) {
              break;
            }
          }

        }
      }
      int result = maxValue - minValue;
      System.out.println(String.format("#%d %d", test_case, result));
    }

  }
}
