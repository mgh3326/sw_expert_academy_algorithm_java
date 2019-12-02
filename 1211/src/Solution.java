//1211. [S/W 문제해결 기본] 2일차 - Ladder2

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
      int resultValue = 1000000;
      for (int startWidth = 0; startWidth < widthSize; startWidth++) {
        if (twoD_arr[0][startWidth] == 0) {
          continue;
        }
        int currentWidth = startWidth;
        int tempValue = 0;
        for (int currentHeight = 0; currentHeight < heightSize; currentHeight++) {
          if (currentWidth - 1 >= 0 && twoD_arr[currentHeight][currentWidth - 1] == 1) {// 왼쪽
            do {
              currentWidth -= 1;
              tempValue += 1;
            } while (currentWidth != 0 && twoD_arr[currentHeight][currentWidth - 1] != 0);
          } else if (currentWidth + 1 <= widthSize - 1 && twoD_arr[currentHeight][currentWidth + 1] == 1) {//오른쪽
            do {
              currentWidth += 1;
              tempValue += 1;
            } while (currentWidth != widthSize - 1 && twoD_arr[currentHeight][currentWidth + 1] != 0);
          }
          tempValue += 1;
        }
        if (resultValue >= tempValue) {
          resultValue = tempValue;
          result = startWidth;
        }
      }
      System.out.println(String.format("#%d %d", test_case, result));
    }

  }
}
