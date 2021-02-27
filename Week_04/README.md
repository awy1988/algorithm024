# 学习笔记 第四周
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