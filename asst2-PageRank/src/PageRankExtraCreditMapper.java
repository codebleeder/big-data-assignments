


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PageRankExtraCreditMapper
  extends Mapper<LongWritable, Text, Text, Text> {

  private static final int MISSING = 9999;
  
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
	  
	  // convert the text input to string and split it with spaces 
	 // String[] line = (value.toString()).split("//s");
	  String lineString = value.toString();
	  List<String> line = Arrays.asList(lineString.split("\\s+"));
	 
	  System.out.println(line);
	  System.out.println("line.length = " + line.size());
	  System.out.println("line.get(0) = " + line.get(0));
	  System.out.println("line.get(1) = " + line.get(1)); 
	  
	  // calculate PR(n)/L(n), 
	  // PR(n) = Page Rank
	  // L(n) = number of out-bound links 
	  double prByL = (Double.parseDouble((line.get(line.size()-1))))/(line.size()-2.0);
	  
	  // debug
	  //System.out.println(line.get(0)+" prByL = "+prByL);
	  
	  // write node receiving link: PR(n)/L(n)
	  for(int index=1;index<=line.size()-2;index++){
	  context.write(new Text(line.get(index)), new Text(String.valueOf(prByL)));
	  //debug
	  //System.out.println(line.get(index)+" : "+prByL);
	  }
	  
	  for(int i=1;i<=line.size()-2;i++){
		  context.write(new Text(line.get(0)), new Text(line.get(i)));
		  // debug
		  //System.out.println(line.get(0)+" : "+line.get(i));
	  }
  	}
  }

