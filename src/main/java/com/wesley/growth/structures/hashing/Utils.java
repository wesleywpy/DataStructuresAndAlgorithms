package com.wesley.growth.structures.hashing;

/**
 * @author Created by Wesley on 2017/10/23.
 */
public abstract class Utils {

    /**
     * 散列函数的宗旨是要在单元之间均匀分配关键字
     * @param key
     * @param tableSize
     */
    public static int hash(String key, int tableSize){
        int hashVal = 0;

        for(int i = 0; i < key.length(); i++){
            hashVal += 37 * hashVal + key.charAt(i);
        }

        hashVal %= tableSize;
        if(hashVal < 0){
            hashVal += tableSize;
        }

        return hashVal;
    }


}
