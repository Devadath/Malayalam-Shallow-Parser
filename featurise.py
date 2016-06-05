#!/usr/bin/python

import sys

Data = open(sys.argv[1],"r",encoding = "UTF-8")
Out = open(sys.argv[2],"w",encoding = "UTF-8")

total = 0
i = 0
for line in Data.readlines():
	# line = line.strip()
	# m = line.split(" ")
	# print (line,"=",len(m))
	if line == "":
		continue
	if line == "\n":
		Out.write(line)
	else:
		line = line.strip()
		splits = line.split("\t")
		line = splits[0]
		lineord = list(line)
		length = len(lineord)
		ba1 = ["".join(lineord[-(i+1):]) for i in range(length)]
		fo1 = ["".join(lineord[:i+1]) for i in range(length)]
		ba1.reverse()
		if length == 0:
			continue
		if length > 0 and length < 7 :
			#print (line,"<5",length)
			if length == 1:
				Out.write(line+" "+fo1[0]+" "+"NONE"+" "+"NONE"+" "+"NONE"+" "+"NONE"+" "+"NONE"+" "+"NONE"+" "+"NONE"+" "+"NONE"+" "+ba1[0]+" "+str(length)+" "+splits[-1]+"\n")
			if length == 2:
				Out.write(line+" "+fo1[0]+" "+fo1[1]+" "+"NONE"+" "+"NONE"+" "+"NONE"+" "+"NONE"+" "+"NONE"+" "+"NONE"+" "+ba1[0]+" "+ba1[1]+" "+str(length)+" "+splits[-1]+"\n")
			if length == 3:
				Out.write(line+" "+fo1[0]+" "+fo1[1]+" "+fo1[2]+" "+"NONE"+" "+"NONE"+" "+"NONE"+" "+"NONE"+" "+ba1[0]+" "+ba1[1]+" "+ba1[2]+" "+str(length)+" "+splits[-1]+"\n")
			if length == 4:
				Out.write(line+" "+fo1[0]+" "+fo1[1]+" "+fo1[2]+" "+"NONE"+" "+"NONE"+" "+"NONE"+" "+ba1[0]+" "+ba1[1]+" "+ba1[2]+" "+ba1[3]+" "+str(length)+" "+splits[-1]+"\n")
			if length == 5:
				Out.write(line+" "+fo1[0]+" "+fo1[1]+" "+fo1[2]+" "+"NONE"+" "+"NONE"+" "+ba1[0]+" "+ba1[1]+" "+ba1[2]+" "+ba1[3]+" "+ba1[4]+" "+str(length)+" "+splits[-1]+"\n")						
			if length == 6:
				Out.write(line+" "+fo1[0]+" "+fo1[1]+" "+fo1[2]+" "+"NONE"+" "+ba1[0]+" "+ba1[1]+" "+ba1[2]+" "+ba1[3]+" "+ba1[4]+" "+ba1[5]+" "+str(length)+" "+splits[-1]+"\n")						
	
		else:
			ba = ["".join(lineord[-(i+1):]) for i in range(7)]
			ba.reverse()
			fo = ["".join(lineord[:i+1]) for i in range(3)]
			Out.write(line+" "+fo[0]+" "+fo[1]+" "+fo[2]+" "+ba[0]+" "+ba[1]+" "+ba[2]+" "+ba[3]+" "+ba[4]+" "+ba[5]+" "+ba[6]+" "+str(length)+" "+splits[-1]+"\n")