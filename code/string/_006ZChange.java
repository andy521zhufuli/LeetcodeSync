public class _006ZChange{
    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        String result = convert(s, 3);
        System.out.println(result);
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1){// 基本判空，如果一行的话，直接返回就行了
            return s;
        }
        int len = Math.min(s.length(), numRows);// 数组的长度，去最小值即可
        String []rows = new String[len];
        for(int i = 0; i < len; i++) 
            rows[i] = "";// 初始化
        int index = 0;
        boolean change = false;
        for(int i = 0;i < s.length(); i++) {
            rows[index] += s.substring(i,i + 1);
            if(index == 0 || index == numRows - 1) {// 
                change = !change;
            }
            index += change ? 1 : -1;
        }
    
        String result = "";
        for(String row : rows) {// 最后还是需要一个循环把答案输出
            result += row;
        }
        return result;
    }
}