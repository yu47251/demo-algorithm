package com.example.demo.algorithm.sudoku;

/**
 * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 *
 * 思路：
 * 遍历二维数组中所有元素
 * 是"."直接过，
 * 不是"."的，需要判断三个维度是否有重复的。
 * 1. 校验同行，
 * 2. 校验同列
 * 3. 校验当前方块的
 *
 * @author Eric Wang
 * @since 2022/5/19 16:04
 */
public class ValidSudoku {
    public boolean valid(char[][] board) {
        // 双重循环
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(!isPoint(board[i][j]) && !check(board, i, j)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean check(char[][] board , int i, int j){
        return checkValid(board[i][j]) && checkLine(board[i][j], board, i) && checkColumn(board[i][j], board, j) && checkGrid(board[i][j], board, i, j);
    }

    // 检查字符是否合格， 1-9，.， 其他的都是false
    public boolean checkValid(char value){
        return '1' == value || '2' == value || '3' == value || '4' == value || '5' == value || '6' == value || '7' == value || '8' == value || '9' == value;
    }

    public boolean isPoint(char value){
        return '.' == value;
    }

    // 检查当前行，是否有重复的。
    public boolean checkLine(char value, char[][] board, int line){
        int count = 0;
        for (int i = 0; i < board[line].length; i++) {
            if(value == board[line][i]){
                count ++;
            }
        }
        if(count != 1){
            return false;
        }
        return true;
    }

    // 检查当前列，是否有重复的
    public boolean checkColumn(char value, char[][] board, int column){
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if(value == board[i][column]){
                count ++;
            }
        }
        if(count != 1){
            return false;
        }
        return true;
    }

    // 检查当前大格是否有重复
    public boolean checkGrid(char value, char[][] board, int i, int j){
        int count = 0;
        for (int k = (i / 3) * 3; k <= (i / 3) * 3 + 2 ; k++) {
            for (int l = (j / 3) * 3; l <= (j / 3) * 3 + 2 ; l++) {
                if(value == board[k][l]){
                    count++;
                }
            }
        }
        if(count != 1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};

        System.out.println("result = " + new ValidSudoku().valid(board));

        char[][] falseBoard = {{'8','3','.','.','7','.','.','.','.'}
                              ,{'6','.','.','1','9','5','.','.','.'}
                              ,{'.','9','8','.','.','.','.','6','.'}
                              ,{'8','.','.','.','6','.','.','.','3'}
                              ,{'4','.','.','8','.','3','.','.','1'}
                              ,{'7','.','.','.','2','.','.','.','6'}
                              ,{'.','6','.','.','.','.','2','8','.'}
                              ,{'.','.','.','4','1','9','.','.','5'}
                              ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println("result = " + new ValidSudoku().valid(falseBoard));

    }
}
