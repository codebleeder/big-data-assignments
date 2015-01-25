#! /usr/bin/env python
__author__ = 'cloudera'
import sys

(last_key, max_value) = (None, 0)
ChicagoCount = 0
DecCount = 0
hackathonCount = 0
JavaCount = 0

for line in sys.stdin:
    (key, val) = line.strip().split("\t")
    if key == 'Chicago':
        ChicagoCount += 1
    elif key == 'Dec':
        DecCount += 1
    elif key == 'hackathon':
        hackathonCount += 1
    elif key == 'Java':
        JavaCount += 1

print "%s\t%d" % ('Chicago', ChicagoCount)
print "%s\t%d" % ('Dec', DecCount)
print "%s\t%d" % ('hackathon', hackathonCount)
print "%s\t%d" % ('Java', JavaCount)