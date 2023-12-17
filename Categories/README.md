# Categories

### Problem

A string contains characters, which represent categories. The categories are counted from left to right. After one category is counted, a category is the maximum if it has the highest count number out of all other categories. Multiple categories can be the maximum. Find the number representing the maximum amount of time a single category can be the maximum in a row for a string.

### Solution

For string "adbccbcaa":

```
  a d b c c b c a a
-------------------
a|1 1 1 1 1 1 1 2 3
b|0 0 1 1 1 2 2 2 2
c|0 0 0 1 2 2 3 3 3
d|0 1 1 1 1 1 1 1 1
```

String[0] is counted first. category 'a' is the maximum. String [1] is counted next. 'a, b' are the maximum. String[2] is counted next. 'a, b, c' are the maximum...

All categories in String are counted. 'a' is the maxumum four times in a row for indices [0, 3]. 'b' is the maximum four times in a row for indices [2, 6]. 'c' is the maximum six times for indices [3, 8]. 'd' is the maximum three times in a row for indices [1, 3]. The function returns six.

```
>6
```
