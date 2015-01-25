#!/bin/bash

hadoop fs -rm -r -f asst3/output

hadoop jar /usr/lib/hadoop-0.20-mapreduce/contrib/streaming/hadoop-streaming.jar \
-file mapper.py -mapper mapper.py \
-file reducer.py -reducer reducer.py \
-input hdfs://quickstart.cloudera:8020/user/cloudera/asst3/input/sample.txt \
-output asst3/output \


