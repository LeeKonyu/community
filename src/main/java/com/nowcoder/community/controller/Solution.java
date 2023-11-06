package com.nowcoder.community.controller;

class Solution {
    public static String convert(String s, int numRows) {
        char[] sChars = s.toCharArray();
        String[][] charTable = new String[s.length()][s.length()];
        for(int i = 0;i < charTable.length;i++){
            for(int j = 0; j < charTable[0].length;j++){
                charTable[i][j] = "";
            }
        }
        int column = numRows - 2;//中间部分的宽度
        int bottomIndex = numRows - 1;
        int groupNum = s.length()/(numRows + column) + 1;//求出组数
        int width = column + 1;//一组的宽度
        int curIndex = 0;

        for(int i = 0;i < groupNum;i++){//最后一组额外处理
            int startLine = i * width;
            //写本组
            //竖着的一列
            for(int j=0;j<numRows;j++){
                if(curIndex > sChars.length - 1){
                    break;
                }
                charTable[j][startLine] =String.valueOf (sChars[curIndex]);
                curIndex++;
            }
            print(charTable);
            //写斜着的一块
            for(int k = 1;k <= column;k++){
                if(curIndex > sChars.length -1){
                    break;
                }
                charTable[bottomIndex-k][startLine+k] =String.valueOf( sChars[curIndex]);
                curIndex++;

            }
            print(charTable);
        }
        //处理最后一组

        String res = "";
        for(int i = 0;i < charTable.length;i++){
            for(int j = 0; j < charTable[0].length;j++){
                res += charTable[i][j];
            }
        }


        return res;
    }

    public static void print(String[][] charTable){
        //处理最后一组

        for(int i = 0;i < charTable.length;i++){
            for(int j = 0; j < charTable[0].length;j++){
                System.out.printf(charTable[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        convert("AB",1);
    }
}