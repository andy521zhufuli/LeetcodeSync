import java.util.ArrayList;
import java.util.List;

class _1089DuplicateZeros {
    public static void main(String[] args) {
        _TSolution so = new _TSolution();
        so.test();
    }
}

/**
 * 1089. 复写零
 * https://leetcode-cn.com/problems/duplicate-zeros/
 * 要求，O(n)的时间复杂度，一次遍历搞定，那就正向循环一次（找出需要修改的0的个数：n0 + i = length -1）
                                      反向循环一次（复制0），这里要注意如果最后一位是0的话，0就不能复制 这个边界条件忘记了
 * 还有一个技巧，要巧妙的用n0 + i = length - 1,这个等式
 */
class _TSolution{

    public void test() {
        int[] arr = {1,0,0,1};
        duplicateZeros(arr);
    }

    public void duplicateZeros(int[] arr) {
        int n0 = 0;
        int length = arr.length-1;

        for (int i = 0; i <= length - n0; i++) {
            if (arr[i] == 0) {
                if (i == length - n0) {
                    arr[length] = 0;
                    length = length - 1;// 去掉最后一位0
                    break;
                }
                n0++;
            }
        }

        int last = length - n0;
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + n0] = 0;
                n0--;
                arr[i + n0] = 0;
            }else{
                arr[i + n0] = arr[i];
            }
        }
    }

}