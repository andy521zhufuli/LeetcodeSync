import java.util.LinkedList;

class ReverseWords{
    public static void main(String[] args) {
        
        Solution1 solution = new Solution1();
        System.out.println(solution.reverseWords("the sky is blue!"));

        SolutionStart2End solutionStart2End = new SolutionStart2End();
    
        System.out.print(solutionStart2End.reverseWords("the      sky is  blue!"));
    }
}


/**
 * 我自己实现的版本
 */
class SolutionStart2End{
    public String reverseWords(String s) {
        s = s.trim();
        int start = 0;
        LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                continue;
            }else if (s.charAt(i) == ' ') {
                String word = s.substring(start, i);
                word = word.trim();
                if (!word.equals("")) {
                    stack.push(word);    
                }
                start = i;
            }
        }
        if(start < s.length()) {
            String word = s.substring(start, s.length());
            word = word.trim();
            if(!word.equals("")) {
                stack.push(word);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

}

/**
 * 网上找的答案，给了我解题思路
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/solution/fan-zhuan-zi-fu-chuan-li-de-dan-ci-by-ye-you-chao/
 * 这个人很厉害，把很多题都记录下来了：https://note.youdao.com/ynoteshare1/index.html?id=383f28fda2c91ea9736e71a189c80718&type=note
 * Java版本：https://note.youdao.com/ynoteshare1/index.html?id=e3152a4cf9f16867c36adce45bc134cb&type=note
 */
class Solution1 {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        s=s.trim();
        int end=s.length();
        boolean isBlank=false;
        for (int i = s.length()-1; i >-1; i--) {
            if (s.charAt(i)!=32&&i!=0){
                isBlank=true;
                continue;
            } else if (s.charAt(i)==32&&isBlank){
                sb.append(s.substring(i+1,end));
                sb.append(s.charAt(i));
            }else if(i==0){
                sb.append(s.substring(i,end));
            }
            isBlank=false;
            end=i;
        }
        return sb.toString();
    }
}

