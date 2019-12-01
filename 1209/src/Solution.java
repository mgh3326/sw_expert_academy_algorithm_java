//1209. [S/W 문제해결 기본] 2일차 - Sum

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
      int heightSize = 100;
      int test_case_num = Integer.parseInt(st.nextToken());
      int[][] twoD_arr = new int[heightSize][widthSize];

      for (int height = 0; height < heightSize; height++) {
        int width = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
          int value = Integer.parseInt(st.nextToken());
          twoD_arr[height][width] = value;
          width += 1;
        }
      }
      int result = 0;
      //가로
      for (int height = 0; height < heightSize; height++) {
        int tempValue = 0;
        for (int width = 0; width < widthSize; width++) {
          tempValue += twoD_arr[height][width];
        }
        if (tempValue > result) {
          result = tempValue;
        }
      }
      //세로
      for (int width = 0; width < widthSize; width++) {
        int tempValue = 0;
        for (int height = 0; height < heightSize; height++) {
          tempValue += twoD_arr[height][width];
        }
        if (tempValue > result) {
          result = tempValue;
        }
      }
      //대각선
      int tempValue = 0;
      for (int height = 0; height < heightSize; height++) {
        tempValue += twoD_arr[height][height];
      }
      if (tempValue > result) {
        result = tempValue;
      }

      tempValue = 0;
      for (int height = 0; height < heightSize; height++) {
        tempValue += twoD_arr[height][heightSize - height - 1];
      }
      if (tempValue > result) {
        result = tempValue;
      }
      System.out.println(String.format("#%d %d", test_case, result));
    }

  }
}
