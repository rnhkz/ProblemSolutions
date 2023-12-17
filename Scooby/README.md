# Scooby
Rooms are referred to as a single uppercase letter. The program reads in paths that exist between rooms, and checks if two rooms can be reached.

# Examlpes
### #1
Given the data:
```
  EF GH IJ FH
  EG
```
"EF GH IJ FH" are paths that exist, and "EG" represents the two rooms being checked for connection.
  
  There exists a path from "E" to "G": E->F->H->G

Output:
```
yes
```
  
### #2
Given the data:
```
  AB CD EA FD BG FC
  AF
```
There exists no path between "A" and "F".

Output:
```
no
```
