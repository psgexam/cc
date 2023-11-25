# cc
1) (checking whether all nodes are proper):  start-all.sh    , jps
2) (creating input directory)  hadoop fs -mkdir /yourinput
3)(putting files) hadoop fs -put /localfilepath /hadoopinputpath
hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-2.6.0.jar wordcount input output

 For wordcount
hadoop jar hadoop*/share/hadoop/mapreduce/hadoop-mapreduce-examples*.jar pi 2 100
 (for pi program)
And finally after ur work give stop-all.sh
 And make sure in place of 2.6.0 give ur Hadoop jar installed version ( by default installed)
