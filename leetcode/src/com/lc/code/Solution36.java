package com.lc.code;

import java.util.HashMap;
import java.util.Map;

public class Solution36 {

    //1、考虑hash
    public boolean isValidSudoku(char[][] board) {
        Map<Character,Integer>[] raws = new HashMap[9];
        Map<Character,Integer>[] cols = new HashMap[9];
        Map<Character,Integer>[] blocks = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            raws[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            blocks[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'){
                    char num = board[i][j];
                    //算出小 方块的位置
                    int blockIndex = i/3*3 + j/3;
                    raws[i].put(num,raws[i].getOrDefault(num,0)+1);
                    cols[j].put(num,cols[j].getOrDefault(num,0)+1);
                    blocks[blockIndex].put(num,blocks[blockIndex].getOrDefault(num,0)+1);
                    if (raws[i].get(num) > 1 || cols[j].get(num) > 1 || blocks[blockIndex].get(num) > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
