package io.tony.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapDemo {
  static class Key {
    String key ;
    String val ;

    public Key(String key, String val) {
      this.key = key;
      this.val = val;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Key key1 = (Key) o;
      return Objects.equals(key, key1.key) &&
        Objects.equals(val, key1.val);
    }

    @Override
    public int hashCode() {
      return Objects.hash(key);
    }
  }
  public static void main(String[] args) {
    Map<Key, String> a = new HashMap<>(2);
    a.put(new Key("1", "1"), "1");
    a.put(new Key("1", "2"), "2");
    a.put(new Key("1", "3"), "3");
    a.put(new Key("1", "4"), "4");
    a.put(new Key("1", "5"), "5");
    a.put(new Key("1", "6"), "6");
    a.put(new Key("1", "7"), "7");
    a.put(new Key("1", "8"), "8");
    a.put(new Key("1", "9"), "9");
  }
}
