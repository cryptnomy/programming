from sys import stdin, stdout

stdin.readline()
lst1 = set(stdin.readline().split())
stdin.readline()
lst2 = stdin.readline().split()

[stdout.write('1\n') if l in lst1 else stdout.write('0\n') for l in lst1]