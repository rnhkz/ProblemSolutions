# RedMeat

### Problem

There are goats who produce a set amount of milk on a given day. For 90 days, the amount of milk produced by each goat is compared. The goat with the lowest produce is compared; if there is no other goat who produced the same amount of milk, the goat is slaughtered.

### Solution

A cycle is a repeating sequence of numbers representing amounts of milk produced each day. Cycles vary in length between each goat, no less than one, and no greater than ten.
```
4 1 2 3 4
5 4 1 2 4 2
2 2 1
```
The first number of each line is the length of the cycle. each line represents a goat.
### Day 1
```
Entry 1: [1 2 3 4]
          ^
Entry 2: [4 1 2 4 2]
          ^
Entry 3: [2 1]
          ^
```
Entry 1 has the least production. It is removed.
### Day 2
```
Entry 2: [4 1 2 4 2]
            ^
Entry 3: [2 1]
            ^
```
A goat is removed if it produces the least milk, and there are no ties. All entries stay.
### Day 3
```
Entry 2: [4 1 2 4 2]
              ^
Entry 3: [2 1]
          ^
```
Entry 3 returns to the beginning of its cycle. Both Entry 2 and Entry 3 produce the same amount of milk. Neither are removed.
### Day 4
```
Entry 2: [4 1 2 4 2]
                ^
Entry 3: [2 1]
            ^
```
Entry 3 is removed.
