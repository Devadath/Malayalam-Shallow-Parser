#!/usr/bin/python

import sys

with open(sys.argv[1],"r") as chunk:

	for line in chunk.readlines():
		line = line.strip()
		if line == "":
			continue
		else:
			spl = line.split(" ")
			if len(spl) != 13:
				print(line+"***************************************************************************")
			