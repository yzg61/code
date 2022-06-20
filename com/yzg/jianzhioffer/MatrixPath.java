package com.yzg.jianzhioffer;

/**
 * @author yzg
 * @create 2019/9/21
 */
public class MatrixPath {

    /**
     * 题目描述
     *
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，
     * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
     * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
     * 但是矩阵中不包含"abcb"路径，
     * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
     * 路径不能再次进入该格子。
     */

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (str.length == 0 || matrix.length == 0)
            return false;
        char[][] c = new char[rows][cols];
        boolean[][] b = new boolean[rows][cols];//记录是否走过
        int i = 0;
        int x = -1;
        int y = -1;
        for (int r =0; r < rows; r++){
            for (int j = 0; j < cols; j ++){
                c[r][j] = matrix[i];
                if (matrix[i] == str[0]){//找到起点
                    x = r;
                    y = j;
                }
                i++;
            }
        }
        if (x < 0){
            return false;
        }


        return isHasPath(c,b,str,0,x,y,rows,cols);
    }

    //判断是否是路径中的元素
    public boolean isHasPath( char[][] c,
                              boolean[][] b, char[] str, int index,
                              int x, int y, int rows, int cols){
        if (x < 0 || y < 0 || x >= rows || y >= cols
                || b[x][y] || str[index] != c[x][y] )
            return false;

        if (index >= str.length - 1)
            return true;

        b[x][y] = true;//设置为已经过
        index++;//寻找路径的下一个元素
        return isHasPath(c,b,str,index,x,y-1,rows,cols)
                ||isHasPath(c,b,str,index,x-1,y,rows,cols)
                ||isHasPath(c,b,str,index,x+1,y,rows,cols)
                ||isHasPath(c,b,str,index,x,y+1,rows,cols);
    }

    public static void main(String[] args) {
        MatrixPath m = new MatrixPath();
        boolean b = m.hasPath("abcesfcsadee".toCharArray(),
                3, 4, "bcced".toCharArray());
        System.out.println("b = " + b);
    }

}
