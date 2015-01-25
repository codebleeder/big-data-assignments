// cc MaxTemperatureReducer Reducer for maximum temperature example
// vv MaxTemperatureReducer
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

public class PageRankExtraCreditReducer
  extends Reducer<Text, Text, LongWritable, Text> {
  
  @Override
  public void reduce(Text key, Iterable<Text> values,
      Context context)
      throws IOException, InterruptedException {
	  
	  double pageRank = 0.0;
	  String outBoundLinks = key.toString();
	  
	  for(Text value : values){
		  String valueString = value.toString();
		  
		  if(valueString.contains("."))
			  pageRank = pageRank + Double.parseDouble(valueString);
		  else
			  outBoundLinks = outBoundLinks+" "+valueString;
			  // debug
			  //System.out.println(key.toString()+" : "+value.toString());
	  }
	  outBoundLinks = outBoundLinks + " " + Double.toString(pageRank);
	  // debug
	  //System.out.println(key.toString()+" : "+pageRank);
	  System.out.println(outBoundLinks);
	  
	  context.write(null, new Text(outBoundLinks));
  }
}

