package org.example.collectionsTest;

import java.util.*;


public class TestSynchronized {
    public static void main(String[] args) {
        /**
         * Collections方法提供了同步方法
         */
        Collection<Object> c = Collections.synchronizedCollection(new ArrayList<>());
        List<Object> list = Collections.synchronizedList(new ArrayList<>());
        Set<Object> s = Collections.synchronizedSet(new HashSet<>());
        Map<Object, Object> m = Collections.synchronizedMap(new HashMap<>());
    }
}
