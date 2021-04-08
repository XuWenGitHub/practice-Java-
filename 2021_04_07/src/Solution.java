import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[][] box = {
                {9, 9, 10}, {8, 10, 9}, {9, 8, 10}, {9, 8, 10}, {10, 8, 8}, {9, 8, 9}, {9, 8, 8}, {8, 9, 10}, {10, 9, 10}, {8, 8, 10}, {10, 9, 10}, {10, 9, 8}, {8, 9, 9}, {9, 10, 8}, {8, 9, 9}, {10, 10, 9}, {8, 9, 10}, {8, 10, 10}, {8, 9, 10},
                {10, 10, 8}, {10, 10, 9}, {9, 10, 10}, {10, 8, 9}, {10, 10, 9}, {8, 9, 10}, {8, 8, 9}, {8, 10, 10}, {9, 9, 10},
                {10, 8, 8}, {10, 10, 8}, {8, 9, 9}, {8, 9, 8}, {10, 10, 8}, {8, 10, 8}, {10, 9, 10},
                {9, 9, 10}, {9, 9, 9}, {8, 9, 8}, {9, 8, 8}, {8, 9, 10}, {10, 10, 8}, {9, 9, 9}, {10, 10, 10}, {10, 9, 8}, {9, 8, 9}, {8, 8, 10},
                {8, 8, 8}, {8, 8, 8}, {8, 9, 10}, {10, 9, 8}, {8, 10, 8}, {8, 10, 10}, {9, 10, 10}, {8, 8, 9}, {9, 9, 9},
                {10, 8, 8}, {8, 10, 10}, {9, 10, 9}, {9, 9, 8}, {8, 10, 9}, {9, 8, 8}, {9, 9, 10}, {9, 10, 10}, {8, 8, 10}
        };
        System.out.println(pileBox(box));
    }

    public static int pileBox(int[][] box) {
        res = 0;
        cur = 0;
        Arrays.sort(box, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[2] != o2[2]) return o1[2] - o2[2];
                        else if (o1[1] != o2[1]) return o1[1] - o2[1];
                        else if (o1[0] != o2[0]) return o1[0] - o2[0];
                        return 0;
                    }
        });
        dfs(box, 0, 0, 0, 0);
        cur = 0;
        return res;
    }

    static int res;
    static int cur;

    //wi,di,hi代表上面的箱子，下一个箱子，要比它大
    //index代表当前第几个箱子
    public static void dfs(int[][] box, int wi, int di, int hi, int index) {
        if (index == box.length) {
            res = Math.max(res, cur);
            return;
        }

        if (box[index][0] > wi && box[index][1] > di && box[index][2] > hi) {
            //放下面
            cur += box[index][2];
            dfs(box, box[index][0], box[index][1], box[index][2], index + 1);
            cur -= box[index][2];
            //不放下面
        } else {
            //不放下面
        }
        dfs(box, wi, di, hi, index + 1);
    }
}