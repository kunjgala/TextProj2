package project2;

public class Brute {

  public int match(String T, String P) {
    int idx = -1;
    if(T.length()==0 || P.length()==0) return -1;
    for(int i=0;i<T.length();i++) {
      if(P.charAt(0)==T.charAt(i))
       {
        int k = i+1;
        int j = 1;
        int count=1;
        while (j<P.length() && k<T.length()) {
          if(P.charAt(j)==T.charAt(k)) {
            count++;
          }
          k++;
          j++;
        }
        if(count==P.length()) {
          return i;
        }
      }
    }
    return idx;
  }
  
}
