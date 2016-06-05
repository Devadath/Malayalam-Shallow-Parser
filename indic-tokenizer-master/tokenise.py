#!/usr/bin/python

import sys
from irtokz import tokenize_ind # Tokeniser for Indian languages
from irtokz import tokenize_rom # Tokeniser for English

inp_file = open(sys.argv[1],"r").read()
out_file = open(sys.argv[2],"w")
language = sys.argv[3]

if language == "Eng":
	tok = tokenize_rom(split_sen=True)
	out_file.write(tok.tokenize(inp_file))

else:
	tok = tokenize_ind(lang= "'"+language+"'", split_sen=True)
	out_file.write(tok.tokenize(inp_file))

