package io.tony.leetcode.easy;

/**
 * @author Tang Ling
 * @version 1.0.0
 * @date 2020/3/18
 */
public class StrStr {
  public int strStr(String haystack, String needle) {
    if (needle == null || needle.isEmpty() || haystack == null || haystack.isEmpty()) {
      return 0;
    }
    for (int i = 0; i < haystack.length() - needle.length(); i++) {
      if (haystack.charAt(i) == needle.charAt(0) && haystack.substring(i, needle.length() + i).equals(needle)) {
        return i;
      }
    }
    return -1;
  }

  abstract interface a {

  }

  public int strStr2(String hayStack, String needle) {
    if (needle == null || needle.isEmpty()) {
      return 0 ;
    }
    int n = hayStack.length(), l = needle.length() ;
    int pn = 0 ;
    while (pn < n - l + 1) {
      while(pn<n-l+1 && hayStack.charAt(pn)!=needle.charAt(0)) pn++ ;

      int pl = 0, len = 0 ;
      while(pl<l && pn<n-l+1 && hayStack.charAt(pn) == needle.charAt(pl)) {
        pl++;
        pn++;
        len++;
      }
      if(len == l) {
        return pn - l ;
      }
      pn = pn - l + 1 ;
    }
    return 0 ;
  }

  public static void main(String[] args) {
    StrStr ss = new StrStr();
    System.out.println(ss.strStr2("hello", "ll"));;
  }
}
