// cc MaxTemperature Application to find the maximum temperature in the weather dataset
// vv MaxTemperature
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class PageRankExtraCredit {

  public static void main(String[] args) throws Exception {
    if (args.length != 4) {
      System.err.println("Usage: PageRankExtraCredit <input path> <input/output 1 path><input/output 2 path><output 3 path>");
      System.exit(-1);
    }
    
    // iteration 1 
    Job job1 = new Job();
    job1.setJarByClass(PageRankExtraCredit.class);
    job1.setJobName("Page Rank");

    FileInputFormat.addInputPath(job1, new Path(args[0]));
    FileOutputFormat.setOutputPath(job1, new Path(args[1]));
    
    job1.setMapperClass(PageRankExtraCreditMapper.class);
    job1.setReducerClass(PageRankExtraCreditReducer.class);

    job1.setOutputKeyClass(Text.class);
    //job.setOutputValueClass(IntWritable.class);
    job1.setOutputValueClass(Text.class);
    
    // iteration 2 
    if(job1.waitForCompletion(true)){
		Job job2 = new Job();
		job2.setJarByClass(PageRankExtraCredit.class);
		job2.setJobName("Page Rank");
		
		FileInputFormat.addInputPath(job2, new Path(args[1]));
		FileOutputFormat.setOutputPath(job2, new Path(args[2]));
		
		job2.setMapperClass(PageRankExtraCreditMapper.class);
		job2.setReducerClass(PageRankExtraCreditReducer.class);
		
		job2.setOutputKeyClass(Text.class);
		//job.setOutputValueClass(IntWritable.class);
		job2.setOutputValueClass(Text.class);
  
		  if(job2.waitForCompletion(true)){
				Job job3 = new Job();
				job3.setJarByClass(PageRankExtraCredit.class);
				job3.setJobName("Page Rank");
				
				FileInputFormat.addInputPath(job3, new Path(args[2]));
				FileOutputFormat.setOutputPath(job3, new Path(args[3]));
				
				job3.setMapperClass(PageRankExtraCreditMapper.class);
				job3.setReducerClass(PageRankExtraCreditReducer.class);
				
				job3.setOutputKeyClass(Text.class);
				//job.setOutputValueClass(IntWritable.class);
				job3.setOutputValueClass(Text.class);
				
				System.exit(job3.waitForCompletion(true) ? 0 : 1);
		    }

    }
    
      
  }
}
// ^^ MaxTemperature
