//1213. [S/W 문제해결 기본] 3일차 - String

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
      int test_case_num = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      String findStr = st.nextToken();
      st = new StringTokenizer(br.readLine());
      String inputStr = st.nextToken();
      int result = 0;
      while (true) {
        int index = inputStr.indexOf(findStr);
        if (index == -1) {
          break;
        }
        inputStr = inputStr.substring(index + findStr.length());
        result += 1;
      }
      System.out.println(String.format("#%d %d", test_case, result));
    }

  }
}
