//1215. [S/W 문제해결 기본] 3일차 - 회문1

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
      int strSize = Integer.parseInt((st.nextToken()));
      int widthSize = 8;
      int heightSize = 8;
      String[] strArr = new String[heightSize];
      for (int h = 0; h < heightSize; h++) {
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
          String inputStr = st.nextToken();
          strArr[h] = inputStr;
        }
      }
      int result = 0;
      // 가로
      for (int h = 0; h < heightSize; h++) {
        for (int startIdx = 0; startIdx < widthSize - strSize + 1; startIdx++) {
          boolean isOk = true;
          for (int i = 0; i < strSize / 2; i++) {
            if (strArr[h].charAt(startIdx + i) != strArr[h].charAt(startIdx + strSize - 1 - i)) {
              isOk = false;
              break;
            }
          }
          if (isOk) {
            result += 1;
          }
        }
      }

      // 세로
      for (int w = 0; w < widthSize; w++) {
        for (int startIdx = 0; startIdx < widthSize - strSize + 1; startIdx++) {
          boolean isOk = true;
          for (int i = 0; i < strSize / 2; i++) {
            if (strArr[startIdx + i].charAt(w) != strArr[startIdx + strSize - 1 - i].charAt(w)) {
              isOk = false;
              break;
            }
          }
          if (isOk) {
            result += 1;
          }
        }
      }
      System.out.println(String.format("#%d %d", test_case, result));
    }

  }
}
