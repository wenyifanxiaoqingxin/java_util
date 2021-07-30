package leetcode;

import Demo.Test.LinkList.LinkList;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: some desc
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/6/29 4:05 下午
 */
public class LruMethod extends LinkedHashMap {

    private int capacity;


    public LruMethod(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry entry){
        return size()>capacity;

    }
}
