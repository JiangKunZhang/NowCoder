package n皇后;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/9 23:23
 */
public class Solution {
    class Pair {
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public List<List<String>> solveNQueens(int n) {
        //按坐标位置存放所有解决方案
        List<List<Pair>> res = new ArrayList<>();
        //存放一种解决方案中的所有皇后的位置
        List<Pair> curRes = new ArrayList<>();
        //得到所有结果
        dfs(res, curRes, 0, n);
        //按String存放所有解决方案
        List<List<String>> solutions = new ArrayList<>();
        //把坐标位置转成string
        solutions = getSolution(res, n);
        return solutions;
    }

    public void dfs(List<List<Pair>> res, List<Pair> curRes, int curRow, int n) {
        if (curRow == n) {
            res.add(new ArrayList<>(curRes));
        }

        //尝试当前行的每一个位置是否可以放置一个皇后
        for (int col = 0; col < n; col++) {
            if (isValid(curRes, curRow, col)) {
                //如果可以，在保存当前位置，继续确定下一行皇后的位置
                //直接调用构造函数，内部构造pair, 或者调用make_pair
                curRes.add(new Pair(curRow, col));
                dfs(res, curRes, curRow + 1, n);
                //回溯，删除当前位置，尝试当前行的其它位置
                curRes.remove(curRes.size() - 1);
            }
        }
    }

    // curRes: 一个解决方案，从第一行开始到当前行的上一行每一行已经放置皇后的点
    public boolean isValid(List<Pair> curRes, int row, int col) {
        // 判断当前行尝试的皇后位置是否和前面几行的皇后位置有冲突
        // col == i.second: 第i个皇后与当前这个点在同一列
        // row + col == i.first + i.second: 第i个皇后与当前点在撇上，横坐标+纵坐标值相同
        // row - col == i.first - i.second：第i个皇后与当前点在捺上, 横坐标-纵坐标值相同
        for (Pair curPair : curRes) {
            if (col == curPair.y || row + col == curPair.x+curPair.y || row-col == curPair.x-curPair.y) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> getSolution(List<List<Pair>> res, int n) {
        //把每一种解决方案都转换为string形式，最终结果
        List<List<String>> solutions = new ArrayList<>();
        for (List<Pair> solution : res) {
            //n * n char: 每行有n个元素，把皇后的位置修改为Q
            List<StringBuilder> curSolution = new ArrayList<>();
            //先把当前的这个解全部变成 '.'
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    sb.append(".");
                }
                curSolution.add(sb);
            }

            //在当前的一个结果中找到 x,y 的位置，设置为 'Q'
            for (Pair pair : solution) {
                curSolution.get(pair.x).setCharAt(pair.y, 'Q');
            }

            //把StringBuilder变成String
            List<String> temp = new ArrayList<>();
            for (StringBuilder sb : curSolution) {
                temp.add(sb.toString());
            }
            //添加一个解
            solutions.add(temp);
        }
        return solutions;
    }
}
