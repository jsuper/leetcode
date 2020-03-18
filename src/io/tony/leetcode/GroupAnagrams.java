package io.tony.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length < 1) {
      List<String> ret = Arrays.asList(strs);
      return strs.length == 0 ? Collections.emptyList() : Arrays.asList(ret);
    }
    Map<String, List<String>> result = new HashMap<>();
    char[] a1 = strs[0].toCharArray();
    Arrays.sort(a1);
    ArrayList<String> value = new ArrayList<>();
    value.add(strs[0]);
    result.put(new String(a1), value);
    for (int i = 1; i < strs.length; i++) {
      String s = strs[i];
      char[] a = s.toCharArray();
      Arrays.sort(a);
      String t = new String(a);
      result.compute(t, (key, r) -> {
        if(r==null) {
          r = new ArrayList<>() ;
        }
        r.add(s) ;
        return r;
      });
    }
    return new ArrayList<>(result.values());
  }


  public static void main(String[] args) {
    String a[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(new GroupAnagrams().groupAnagrams(a));
  }
}
