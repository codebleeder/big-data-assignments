Programming assignment using MapReduce: PageRank Problem

PageRank is an algorithm used by the Google web search engine to rank websites in their search engine results. It is named after Larry
Page, although many people think it means "rank of pages".

You can see a brief introduction at: http://en.wikipedia.org/wiki/PageRank.

Your task is to implement a simplified PageRank with MapReduce.

To simplify your work, you can assume that we have the following input file:

A C F 0.166667
B D E F 0.166667
C A B 0.166667
D A B C E F 0.166667
E F 0.166667
F B C 0.166667

The first line, for example, is interpreted as follows:
“A” means "Page A“.
"C F" means "Page A" has outlinks to "Page C" and "Page F“.
"0.166667" is the initial PR value of Page A.

Remember, this is a DIRECTIONAL graph, i.e. links have direction. For instance, "A C F" means A has outlinks to C and F, and "B D E F"
means B has outlinks to D, E and F.

After you read in this input, your MR jobs should parse and process the data, and output the PR value for ONE iteration. This means you only
need to use the formula on the data ONCE.

Your output file should look like this, where PR is the pagerank value computed by your program:
A C F PR
B D E F PR
C A B PR
D A B C E F PR
E F PR
F B C PR

Extra Credit
--------------
You may have noticed that our input and output files have the same format. This means that you should be able to write a program to
iteratively read input from the previous output, and then figure out the next step PR value.

Write an iterative MapReduce program to figure out PageRank of 3 steps.