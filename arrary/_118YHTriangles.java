import java.util.ArrayList;
import java.util.List;

class _118YHTriangles{
    public static void main(String[] args) {
        YXT solution = new YXT();
        solution.generate(5);
    }
}

class YXT {
    public List<List<Integer>> generate(int numRows) {
        if(numRows<=0){
            return new ArrayList();
        }
        List<List<Integer>> result = new ArrayList();
        List<Integer> row = new ArrayList();
        row.add(1);
        result.add(row);

        for (int i = 1; i < numRows; i++) {
            row = new ArrayList();
            row.add(1);// 
            for (int j = 1; j < i; j++) {
                row.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            row.add(i, 1);
            result.add(row);
        }
        return result;
    }
}