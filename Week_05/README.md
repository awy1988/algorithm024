# 学习笔记 第五周


## 2021.3.4
### 每日一题
[最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)

### 第5周 第12课 | 动态规划
#### 1.动态规划的实现及关键点
递归代码模板
```java
    public void recur(int level, int param) {
        // terminator
        if (level > MAX_LEVEL) {
            // process result
            return;
        }
        // process current logic
        process(level, param);
        
        // drill down
        recur(level: level + 1, newParam);
        
        // restore current status
        
    }
```
分为四部分：
1. 递归终止条件
2. 处理当前层逻辑
3. 下探到下一层
4. 恢复当前层的状态

分治
分治是一种特殊的递归。
递归状态树。
分治也是分为四步
1. 递归终止条件
2. 拆分子问题
3. 调子问题的递归函数
4. 合并结果
```Python
def divide_counquer(problem, param1, param2, ...):
    # recursion terminator
    if problem is None:
        print_result
        return
    # prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)
    
    # conquer subproblems
    subresult1 = self.divide_conquer(subproblems[0], p1, ...)
    subresult2 = self.divide_conquer(subproblems[1], p1, ...)
    subresult3 = self.divide_conquer(subproblems[2], p1, ...)
    ...
    
    # process and generate the final result
    result = process_result(subresult1, subresult2, subresult3, ...）
    
    # revert the current level states
    
```
感触
1. 人肉递归低效，很累
2. 找到最近最简方法，将其拆解成可重复解决的问题
3. 数学归纳法思维（抵制人肉递归的诱惑）

**本质：寻找重复性 -> 计算机指令集**

动态规划与分支是有联系的
区别呢？
动态规划会让你求一个最优解。
所以，动态规划里面的特点就是：**分支 + 最优子结构**

关键点
- 动态规划 和 递归或者分支 没有根本上的区别（关键看有无最优的子结构）
- 共性：找到重复子问题
- 差异性：最优子结构、中途可以淘汰次优解

#### 2.DP例题解析：Fibonacci数列、路径计数
1. Fibonacci数列
- 傻递归 O(2^n)
- 加缓存 O(n)
- 
自顶向下，自底向上。
Fibonacci数列可以使用自底向上的方法，通过循环来递推求解。
递推就是自底向上。

2. 路径计数
路径技术的状态转移方程
   opt[i,j] = opt[i+1, j] + opt[i, j+1]
   完整逻辑：
   if (a[i, j] = '空地' ) :
    opt[i,j] = opt[i+1, j] + opt[i, j+1]
   else:
    opt[i, j] = 0
   
**动态规划的关键点**
1. 最优子结构 opt[n] = best_of(opt[n-1],opt[n-2],...)
2. 存储中间状态：opt[i]
3. 递推公式（美其名曰：装填转移方程或者DP方程）
    Fib:opt[i] = opt[n-1] + opt[n-2]
   二维路径：opt[i, j] = opt[i+1][j] + opt[i][j+1](且判断a[i,j]是否空地)

## 2021.3.6
#### 3. DP例题解析：最长公共子序列
思维小结：
动态规划小结
1. 打破自己的思维惯性，形成机器思维  
   机器思维就是找重复性
2. 理解复杂逻辑的关键
3. 也是职业进阶的要点要领

#### 期中答疑回顾
- wordLadder
- 二叉排序树
- 二叉树的后序遍历与中序遍历
- 判断链表中是否有环
- 合并两个有序数组/链表
- 颜色分类
- 三数之和
- 二叉树的层序遍历
- 滑动窗口的最大值
- 全排列

如何学好递归？
1. 牢记递归树
2. 递归的模板
3. 常见例题（多遍数）
    - 排列
    - 组合
    - 子集
    - 括号生成
    - 硬币兑换
    - 岛屿数量
    - N皇后
    - 数独
