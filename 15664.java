import java.util.*;

public class Main {
    
    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      int m = sc.nextInt();

      arr = new int[n];
      check = new boolean[n];
      set = new HashSet<>();

      for(int i=0; i<n; i++) {
          arr[i] = sc.nextInt();
      }

      Arrays.sort(arr);
      go(new int[m], 0, 0);

  }

  static int[] arr;
  static boolean[] check;
  static HashSet<String> set;

  static String convert(int[] sel) {
      StringBuilder sb = new StringBuilder();
      
      for(int i=0; i<sel.length; i++) {
          sb.append(sel[i]);
          sb.append(" ");
      }
      
      return sb.toString(); 
  }
  
  static void go(int[] sel, int sel_idx, int arr_idx) {
      
      if(sel_idx == sel.length) {
          String str = convert(sel);
          
          if(!set.contains(str)) {
              set.add(str);
              System.out.println(str);
          }
          
          return;
      }

      if(arr_idx == arr.length)
          return;
      
      sel[sel_idx] = arr[arr_idx];
      go(sel, sel_idx+1, arr_idx+1);
      go(sel, sel_idx, arr_idx+1);
  }
    
}