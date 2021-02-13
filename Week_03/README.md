# 学习笔记 第三周
## 2021.2.7
### 每日一题
[移动零 leetcode-283](https://leetcode-cn.com/problems/move-zeroes/)

### 第7课 泛型递归，树的递归
#### 1.递归的实现，特性及思维要点
前情回顾：树的面试题解法一般都是递归
这主要是因为两个方面：
1. 节点的定义
2. 重复性（自相似性）

递归的套路（**四大模块**）：
1. 递归终结条件
2. 处理当前层逻辑
3. 下探到下一层
4. 清理当前层
   
代码模板
```Java
public void recur(int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
        // process result
        return;
    }
    
    // process current logic
    process(level, param);
    
    // drill down
    recur(level:level + 1, newParam);
    
    // restore current status
}
```
思维要点
1. 不要人肉进行递归（最大误区）  
刚开始学的时候可以使用将递归的状态树画出等方式来进行思维，但是在熟练之后，不要再继续这样的行为，直接用代码说话。
这样才能真正从代码的层面掌握递归。
2. 找到最近最简的方法，将其拆解成可重复解决的问题（重复子问题）  
找最近重复子问题，为什么要这么做？  
因为我们写的程序的指令只包括 **选择(if-else)**，**循环(for-while-loop)**，**递归(recursion)**，为什么较少的代码能够解决感觉非常复杂的问题？因为我们可见的这个感觉复杂的问题，本身有所谓的
   "可重复性"。因为递归解决这部分可重复性，所以我们会看到非常简洁的代码。
3. 数学归纳法的思维
最开始，最简单的条件是成立的，且n成立时，能够推导出n+1时也成立，这样就可以使用递归来解决这样的问题。
> 1. 抵制人肉递归
> 2. 找到最近重复性
> 3. 数学归纳法的思维

## 2021.2.8
### 每日一题
[二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

## 2021.2.9
### 每日一题
[剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)

### 第7课 泛型递归，树的递归
#### 1.实战题目解析：爬楼梯，括号生成等问题
题目1：爬楼梯

题目2：括号生成问题

## 2021.2.10
### 每日一题
[从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

### 第8课 分治，回溯
#### 1.分治、回溯的实现和特性
分治和回溯其实可以理解为一种特殊的递归。

**分治代码模板**
```Python
def divide_conquer(problem, param1, param2...):
   # recursion terminator
   
   # prepare data
   
   # conquer subproblems
   
   # process and generate the final result
   
   # revert the current level states
```
一个复杂的问题，解决方法往往是异曲同工的，不管是在现实世界还是程序里面。
最关键一个点是，给你一个现实题目或者面试题目，**怎样把它拆分成子问题**比较重要。 主要看经验，而这个的话其实
就是CEO或者是所谓的架构师经常完成必做的事情。
还有一点是，怎样 Merge 这些 SubResult，得到这些子结果怎么把它合并起来可能也有个讲究。
还有中间可能需要做一些事情，比如说这种比较复杂的分治或者是比较复杂的公司组织结构的话，经常要做一些事情，就是这些中间的结果
如何做**质量控制与质量保证**。
注意，我们只关注当前层要做的事情，尽量不要去插手其他层的内容。
不要插手其他层的逻辑的原因有两点：
1. 人脑不太擅长人肉递归，当我们做人肉递归的话，会觉得累，容易出错。
2. 如果你一竿子插下去，干扰别人做事的话，其实在公司组织结构，这是一种微管理或者是事无巨细的话，很讨厌的，个人觉得，程序也如此
   
——覃超

## 2021.2.12

### 第8课 分治、回溯
#### 2.实战题目解析：Pow(x,n)、子集
1. Pow(x,n)

2. 