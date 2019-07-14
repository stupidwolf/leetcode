# 最长回文串

## 问题描述
```
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
```

## 解法一, manacher(马车夫算法)
https://subetter.com/articles/manacher-algorithm.html

### 关键点:
- 回文分为奇回文，偶回文，通过分别向每个字符的前后添加一个占位的字符，转换为奇回文，例如之前字符串的长度为n，转换之后的字符串长度为 2*n + 1

- 向上一步骤得到的字符串的第一位添加一个特殊字符，作为占位符，方便代码的书写(可选)

- manacher算法的思想，利用前面的最大回文串的结果来计算以i为对称点的最大回文串。
```
   设 id 为字符串其中一点,数组p[]分别为字符串各点的最大回文串对应的半径，点 mx = id + p[id], 求点i对应回文串的最大半径 p[i] (id < i < mx)
   
   思路: 由于 i 关于 id 的对称点 j，对应的p[j]是已知的，可通过p[j]求p[i]
   1. if p[j] <= mx - i，此时 由于 字符串 (j - p[j]) ~ (j + p[j])对称，(mx - i)
```





