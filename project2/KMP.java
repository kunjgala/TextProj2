package project2;
import java.util.*;

public class KMP {
  
  public int match(String T, String P) {
    int[] failfn = ComputeFailFn(P);
    int i =0;
    int j =0;
    while(i<T.length()) {
      if(T.charAt(i)==P.charAt(j)) {
        if(j==P.length()-1) {
          return i-j;
        }
        else {
          i++;
          j++;
        }
      }
      else {
        if(j>0) j=failfn[j-1];
        else i++;
      }
    }
    return -1;
  }

  public static int[] ComputeFailFn(String P) {
    int[] failfn = new int[P.length()];
    failfn[0] = 0;
    int i =1;
    int j =0;
    while(i<P.length()) {
      if(P.charAt(i)==P.charAt(j)) {
        failfn[i]=j+1;
        i++;
        j++;
      }
      else if(j>0) {
        j = failfn[j-1];
      }
      else {
        failfn[i]=0;
        i++;
      }
    }
    return failfn;
  }

}