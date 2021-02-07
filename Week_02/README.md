# 学习笔记 第二周
## 总结
### 知识点
#### 学习内容
1. 哈希表、映射、集合
2. 树、二叉树、二叉搜索树
3. 堆和二叉堆、图

#### 练习题目
##### 作业
- [二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal)
- [二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)
- [N叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal)
- [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/)
##### 每日一题
- [两个数组的交集 II](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/)
- [滑动窗口的最大值](https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)
- [删除最外层的括号](https://leetcode-cn.com/problems/remove-outermost-parentheses/)
- [Fizz Buzz](https://leetcode-cn.com/problems/fizz-buzz/)
- [各位相加](https://leetcode-cn.com/problems/add-digits/)
- [二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree)
- [移动零](https://leetcode-cn.com/problems/move-zeroes/)

#### 训练场题目
- 本周欠奉


### 学习过程
> 本周由于突然工作强度变大，导致计划中的改善都被搁浅。
> 能够坚持完成作业已经感觉十分不易，下周开始要进入春节，这段时间由于疫情，实际上少了很多的事情与交际。
> 利用这段时间，希望自己可以将改善表格中的内容贯彻落实下去。

#### 改善
1. 练习题没有严格遵循五毒神掌。(**仍需改善**)
    - 建立表格，管理习题的复习
2. 练习的问题缺少体系认知（不知道练习的题目可以归为哪一类）。（**仍需改善**）
    - 建立表格，或者使用脑图归类（不一定能够达成，能够归类的前提是自己能够有足够的题目的练习量）
3. 学习总结写的比较少。大部分时间都是单纯的看视频和练习。学而不思则罔，下周要改进。（**仍需改善**）
    - 每个题解做完之后，写总结。总结包括两项：
        - 总体思路
        - 注意点

#### 保持
* [x] 1.坚持每日完成一题练习
* [x] 2.保证学习视频的观看


## 2月2日
### 关于暴力解法的心得
暴力解法一般都是我们在面对算法问题时第一个想到的方法。
提到暴力解法，第一个想到的就是暴力多重循环遍历。
但是今天从 [异位词](https://leetcode-cn.com/problems/valid-anagram) 这道题，我发现了第二个暴力解法的思路，那就是先排序。

暴力手段现在又增加了一个：先排序。

已知的暴力手段：
- 多重循环遍历
- 先排序

## 2月6日
与树相关的算法，一般都要用到递归的方式来解决问题。

在使用迭代方式解决与树相关的问题时，往往需要用到栈，那么为什么需要栈呢?
为什么不是队列呢？
我感觉可能主要的原因是，**树形结构中，在自身的数据结构层面，缺乏有效的回溯手段**，
这样我们要实现回溯就必须采用一些手段。
其实递归就相当于利用了语言层面的栈来进行回溯。
双端队列当然也能实现回溯，但是在实现的过程中，归根结底还是利用了双端队列中相当于栈的功能。
