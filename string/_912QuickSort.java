class QuickSort912 {

    // https://leetcode-cn.com/problems/sort-an-array/submissions/ 912题
    // static int[] array = { 5, 8, 2, 9, 4, 3, 7, 6, 1, 0 };
    // static int[] array = { 5, 1,1,2,0,0};
    static int[] array = {-4, 0,7,4,9,-5,-1,0,-7,-1};

    public static void main(String[] args) {
        sort(array, 0, array.length - 1);
        print(array);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi)// 递归退出判断条件
            return;
        int p = partition(a, lo, hi);// 对于某一元素，其本身不必参与递归了，因为其所在的位置已经满足前面的不大于，后面的不小于
        sort(a, lo, p - 1);
        sort(a, p + 1, hi);
    }
    // 更简洁
    static int partition(int[] nums,int low,int high){
        int pivot = nums[low];
        while(low<high) {
            while(low<high && nums[high]>=pivot)
                --high;
            nums[low] = nums[high];
            while(low<high && nums[low]<=pivot) 
                ++low;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    // https://blog.csdn.net/xiaoguobaf/article/details/51084828 方法出处
    private static int partition1(int[] a, int lo, int hi) {
        int left = lo;// 左pointer，供扫描用
        int right = hi+1;// 右pointer，供扫描用，加1是为了方便扫描的推进，
        int pivot = a[lo];

        while (left < right) {
            while (a[--right] >= pivot && right > left){// 如果右边的数大于pivot，就继续往左找，直到找到比pivot小的位置，退出循环
                // if(right == left){
                    // break;
                // }
            }
            

            while (a[++left] <= pivot && right > left){// 如果左边的数小于pivot，就继续往右边找，直到找到比pivot大的位置，退出循环
                // if(left == right){
                //     break;
                // }
            }

            if(left >= right) {
                break;
            }
            swap(a, left, right);
        }
        swap(a, lo, right);
        return right;// 返回切分元素的位置
    }

    private static void swap(int[] a, int i, int j) {
        // 对于待排序数组中无重复元素时，可以使用异或操作来实现，但是如果有重复的，那么就不可以，重复的元素会被置为0
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}