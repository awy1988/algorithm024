# 学习笔记 第四周
## 总结

## 2021.2.27
### 每日一题
[移动零 leetcode-283](https://leetcode-cn.com/problems/move-zeroes/)

### 第4周 第11课 | 二分查找
二分查找的前提
1. 目标函数单调性
2. 存在上下界
3. 能够通过索引访问
代码模板
```python
    left,right = 0, len(array) - 1
    while left <= right:
        mid = (lef + right) / 2
        if array[mid] == target:
            #find the target!!
            break or return result
        elif array[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
```

例题：
[x的平方根](https://leetcode-cn.com/problems/sqrtx/)
方法1：二分查找
首先是可以使用二分查找的理论基础：
x的平方根的本质是要求 y=x^2 中的x的值，由于此函数在y轴右侧是单调递增的，
有上下界，所以可以使用二分查找。

## 2021.2.28
### 每日一题
[多数元素](https://leetcode-cn.com/problems/majority-element/)
方法有很多种，个人比较推崇的是排序法和摩尔投票法：
1. 排序法  
排序法的优势在于有了库函数的加持，整个代码非常简单易读。只有两行：
   ```java
   class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
   ```
   先排序，然后返回中间位置的元素，由于寻找的是多数元素，所以中间元素一定是多数元素。
2. 摩尔投票法  
摩尔投票法的时间复杂度是O(n)，空间复杂度是O(1),基本是时间空间复杂度最好的算法。
   其思路是，维护两个变量：当前元素与当前元素的票数。  
   遍历数组将取出的元素与当前元素进行对比，如果相等，票数+1，如果不等，票数-1。
   如果票数降为0，则用新元素的值替换当前元素。相当于为新元素重新计票。
   最后得到票数不为0的元素就是要找的结果。
   ```java
   class Solution {
        public int majorityElement(int[] nums) {
           int count = 0, element = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (count == 0) {
                    element = nums[i];
                    count++;
                    continue;
                }
                if (nums[i] == element) {
                    count++;
                } else {
                    count--;
                }
            }
            return element;
        }
    }   
   ```
