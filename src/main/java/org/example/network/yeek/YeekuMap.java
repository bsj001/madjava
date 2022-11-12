package org.example.network.yeek;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class YeekuMap<K,V> extends HashMap<K,V> {
    public void removeByValue(Object value){
        for(Object key:keyset()){
            if(get(key) == value){
                remove(key);
                break;
            }
        }
    }

    //private Iterable<? extends Object> keyset() {
    //    return null;
    //}

    public Set<V> valueSet(){
        Set<K> result = new HashSet<>();
        for(K key:keySet()){
            result.add(get(key));
        }
        return result;
    }
    
    public K getKeyByValue(V val){
        for(K key:keySet()){
            if(get(key).equals(val)&& get(key) == val){
                return key;
            }
        }
        return null;
    }
    
    public V put(K key,V value){
        for(V val: valueSet()){
            if(val.equals(value) && value.hashCode() == value.hashCode() ){
                throw new RuntimeException("MyMap实例中不允许有重复value");
            }
        }
        return super.put(key,value);
    }
}
