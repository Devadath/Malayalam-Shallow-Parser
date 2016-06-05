#!/usr/bin/bash

java StatisticalSandhiSplitter9 config >  temp.txt  #sandhi splitting
rm temp.txt
python indic-tokenizer-master/tokenise.py san.out tok.out -l mal	#Tokenising
python3 featurise_test.py tok.out pos.test	#Feature extraction for POS tagging
sed '/^[\? |\. |\! ] \?/a \\n' pos.test > pos.test.sent
crf_test -m POS.model pos.test.sent | cut -f 1,13 > chunk.test #POS tagging and cleaning the output format
crf_test -m Chunk.model chunk.test > chunked_text #Chunking

