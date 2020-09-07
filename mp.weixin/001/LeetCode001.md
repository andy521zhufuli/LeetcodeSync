## 关于刷题
有两点吧：
1. 之前也刷过题，但是都是刷一下就中断了，没有坚持下来，导致自己也没有什么总结和沉淀，遇到之前做过的题目也还是依然不会做
2. 给自己一个认真坚持做一件事的理由

## 两数之和
闲话少说，书归正传，下面就是`LeetCode`的[第一题](https://leetcode-cn.com/problems/two-sum/)
![两数之和.png](https://s1.ax1x.com/2020/08/16/dEUQV1.png)

### 浮现在脑海的第一种解法
读完一遍题目之后，第一感觉就是`两遍for循环`。没错，暴力解法可以解决，但是这种解决方法不优雅，时间复杂度为：`O(N^2)`，而且面试的时候面试官一定会让你想一种更快的解法，这里给出暴力解法的代码，不做过多解释
```java
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) {
                return new int[] { i, j };
            }
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
```
### 优化解法
初中的时候物理老师就教过我们：`省力就一定费距离`，对应到代码里面，想要时间复杂度低，就一定要拿空间来换。

分析暴力解法，发现他的第二重循环是为了在数组里面找一个特定的数`diff` = target - nums[i]，我们发现Map这种数据结构查找一个数的复杂度是O(1)的，刚好可以去掉第二重循环，但是我们需要先初始化好这个Map才能去查找特定的数，所以我们一开始就要把`nums`里面的数全部`put`到Map里面去，单独开辟了一个新的存储空间，

还注意到题目要求是返回这两个数在数组中的下标，所以我们需要把`nums[i]`作为key，循环中的`i`作为value存储在Map里面

> **注意：**
> 
> 因为题目中说：`数组中同一个元素不能使用两遍`，翻译一下就是返回的结果index不会是两个相同的。
> 所以我们判断的时候需要`map.get(diff) != i`这个条件，因为如果给出[3.2,4],target=6。如果没有上面那个条件，我们输出的结果会是[0,0]，因为在map里面判断的时候diff=3，而map又包含3的key，这不满足题目中的`数组中同一个元素不能使用两遍`前置条件，

代码如下：
```java
public int[] twoSum(final int[] nums, final int target) {
    final Map<Integer, Integer>  map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int diff = target - nums[i];
        if(map.containsKey(diff) && map.get(diff) != i) {// 在上面注意中已解释
            return new int[]{i, map.get(target - nums[i])};
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}  
```
虽然上面代码中也有两个`for循环`，但是他们是`串行`的，并没有嵌套，总体来说时间复杂度还是O(N)，因为O(2N)中的常数2可以忽略。

### 更简洁的解法
这种解法我是没想到的，所以这里也不做过多解释，只给出代码
```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}
```

## 数组item重复问题
做完题目之后也在评论去里面看了，有很多人提到nums里面如果有重复的数字问题，我觉得是没有问题的
如果有两个重复的数字，在放进map的时候，后面的数字会更新前面存进去的index，这时候对应两种情况
1. target是两个相同数字之和，比如[3,3,3,9],target=6因为第二个3放进map的时候key=3，value=2，第一个存进去的3已经被更新掉了，当开始寻找diff的时候，返回的结果是[0,2]，答案没有问题，而且也只有一个接解。只是对于第三种解法，得到的结果是[0,1]，答案也是没问题的
2. target不是两个数字之和，也相同的数字被后面的数字覆盖也就无所谓了。