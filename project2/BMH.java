package project2;
import java.util.*;

public class BMH {
  
  public int match(String T, String P) {
    T = T.toLowerCase();
    P = P.toLowerCase();
    int[] lastocc = computeLastOcc(P);
    int i = P.length()-1;
    int j = P.length()-1;
    while (i<T.length()-1) {
      if(T.charAt(i)==P.charAt(j)) {
        if(j==0) return i;
        else {
          i--;
          j--;
        }
      }
      else {
        int l = lastocc[(int) T.charAt(i)];
        i = i+P.length()-Math.min(j, 1+l);
        j = P.length()-1;
      }
    }
    System.out.println(Arrays.toString(lastocc));
    return -1;
  }

  public int[] computeLastOcc(String P) {
    int[] lastocc = new int[256];
    for(int i=0;i<256;i++) lastocc[i]=-1;
    for(int i=P.length()-1;i>=0;i--) {
      if(lastocc[(int) P.charAt(i)]==-1) {
        lastocc[(int) P.charAt(i)]=i;
      }
    }
    return lastocc;
  }

}
