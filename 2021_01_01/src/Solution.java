import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //水域大小
    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[i].length;j++){
                int sum = findPool(land,i,j);
                if(sum!=0){
                    list.add(sum);
                }
            }
        }

        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }
    public int findPool(int[][] land,int x,int y){
        int num = 0;
        if(x<0||x>=land.length||y<0||y>=land[x].length||land[x][y]!=0){
            return num;
        }
        num++;
        land[x][y] = -1;
        num += findPool(land, x + 1, y);
        num += findPool(land, x - 1, y);
        num += findPool(land, x, y + 1);
        num += findPool(land, x, y - 1);
        num += findPool(land, x + 1, y + 1);
        num += findPool(land, x + 1, y - 1);
        num += findPool(land, x - 1, y + 1);
        num += findPool(land, x - 1, y - 1);
        return num;
    }
}