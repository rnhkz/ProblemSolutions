#!/bin/python3

import math
import os
import random
import re
import sys

#A solution
def get_maximum_maxima(categories):
    #Dict: Category : Term
    #       Term[0] = Counts number of occurences in categories for the particular category
    #       Term[1] = Keeps a record of the value of Term[0] at previous points in time
    #       A unit of time here is equivalent to processing one category
    #maxArr: An array of arrays representing a record of which category had the most amount of occurences in categories[:i+1]
    #maxArr[i] = Categories of the maximum of Term[1][i] across all categories

    Dict = {}  
    maxArr = []

    #We go through categories, adding a term for each category to Dict
    #There are two items stored in a term:
    #   Term[0] = Counts number of occurences in categories for the particular category
    #   Term[1] = Keeps a record of the value of Term[0] at previous points in time
    #   A unit of time here is equivalent to processing one category
    
    for category in categories:
        if not Dict.get(category):
            Dict[category] = [0, []]
    
    #We find the category with the most amount of occurences after processing one category in categories
    #The found category is recorded in maxArr
    #maxArr[i] = The categories with most occurences in categories[:i+1]

    for x, c in enumerate(categories):
        for i, v in dict.items(Dict):
            if c == i:
                v[0] += 1
            v[1].append(v[0])
        
        currentMax = [0, {}]
        for i, v in dict.items(Dict):
            if v[1][x] > currentMax[0]:
                currentMax[0] = v[1][x]
                currentMax[1] = {i}
            elif v[1][x] == currentMax[0]:
                currentMax[0] = v[1][x]
                currentMax[1].add(i)
        maxArr.append(currentMax[1])

    #We create a map denoting length of longest substring containing a single category in maxArr, for every category
    Dict2 = {}
    for cats in maxArr:
        for c in cats:
            if not Dict2.get(c):
                Dict2[c] = 0
            Dict2[c] += 1

    return max(dict.values(Dict2))

#Better, less complicated solution
def get_maximum_maxima2(categories):
    #Dict:  Category : counter for occurnces in categories
    #Dict2: Category : The maximum amount of times in a row counter for Categories was the highest counter
    #                  after processing a single category in categories
    #prevCategory: The previous category processed in categories

    Dict = {category : 0 for category in categories}
    Dict2 = {category : 0 for category in categories}
    prevCategory = []

    #We find the categories with the most amount of occurences after processing one category in categories
    #The previously found categories are stored in prevCategory
    currentMax = [0, {}]
    for x, c in enumerate(categories):
        Dict[c] += 1
        for i, v in dict.items(Dict):
            if v > currentMax[0]:
                currentMax[0] = v
                currentMax[1] = {i}
            elif v == currentMax[0]:
                currentMax[0] = v
                currentMax[1].add(i)
        for i in currentMax[1]:
            Dict2[i] += 1
        prevCategory = currentMax[1]

    return max(dict.values(Dict2))

if __name__ == '__main__':
    inFile = "input.txt"
    outFile = "output.txt"
    with open(inFile) as fin, open(outFile) as fout:
        for x, (iline, oline) in enumerate(zip(fin, fout)):
            categories = iline.rstrip()
            res = get_maximum_maxima2(categories)
            if (res == int(oline.rstrip())):
                print(f"Test case {x+1} PASS: {res} = {oline.rstrip()}")
            else:
                print(f"Test case {x+1} FAIL: {res} != {oline.rstrip()}")
