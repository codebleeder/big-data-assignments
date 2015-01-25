#!/usr/bin/env python
__author__ = 'cloudera'

import sys

for line in sys.stdin:
    words = line.split()

    for word in words:
        if 'hackathon' in word or 'Hackathon' in word:
            print "%s\t%d" % ('hackathon', 1)
        elif 'Dec' in word:
            print "%s\t%d" % ('Dec', 1)
        elif 'Chicago' in word:
            print "%s\t%d" % ('Chicago', 1)
        elif 'Java' in word:
            print "%s\t%d" % ('Java', 1)



