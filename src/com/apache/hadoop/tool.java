package com.apache.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;



public class tool extends Configured implements Tool {

	/*public static void main(String[] args) throws Exception {
		System.out
				.println("************************** In main method ****************");

		Configuration configuration = new Configuration();
	tool dateTR = new tool();
	
		int exitCode = ToolRunner.run(configuration, dateTR, args);
		System.exit(exitCode);
	}

	public int run(String[] arg0) throws Exception {

		Configuration conf = getConf();
		if (arg0.length != 2) {
			System.err.println("Usage: wordcount <in> <out>");
			System.exit(2);
		}
		
		Job job = new Job(conf,"Word Count1");
		
		System.out
				.println("************************** After property populator ****************");
		job.setJarByClass(tool.class);
		job.setMapperClass(mapper.class);
		job.setReducerClass(reducer.class);
		job.setCombinerClass(reducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(valuemeantuple.class);

		
		Path inputPath = new Path(arg0[0]);
		Path outputPath = new Path(arg0[1]);

		FileInputFormat.addInputPath(job, inputPath);
		FileOutputFormat.setOutputPath(job, outputPath);

		System.exit(job.waitForCompletion(true) ? 0 : 1);
		return 0;
		
	}*/
	

	   /*public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable>{

	    private final static IntWritable one = new IntWritable(1);
	    private Text word = new Text();

	    @Override
	    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
	      StringTokenizer itr = new StringTokenizer(value.toString()," ");
	      while (itr.hasMoreTokens()) {
	        word.set(itr.nextToken());
	        context.write(word, one);
	      }
	    }
	  }
	   
	   public static class IntSumReducer extends Reducer<Text,IntWritable,Text,IntWritable> {
	    private IntWritable result = new IntWritable();

	    @Override
	    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
	      int sum = 0;
	      for (IntWritable val : values) {
	        sum += val.get();
	      }
	      result.set(sum);
	      context.write(key, result);
	    }
	  }  */ 
	   
	    public static void main(String[] args) throws Exception {
	        // TODO code application logic here
	    /*Configuration conf = new Configuration();
	    Job job=Job.getInstance(conf, "word count");*/
	    	System.out
			.println("************************** In main method ****************");

	Configuration configuration = new Configuration();
tool dateTR = new tool();

	int exitCode = ToolRunner.run(configuration, dateTR, args);
	System.exit(exitCode);
	    }

		@Override
		public int run(String[] args) throws Exception {
			// TODO Auto-generated method stub
			Job job = new Job(new Configuration());
		    job.setJarByClass(tool.class);
		    job.setJobName("linear");
		    job.setMapperClass(mapper.class);
		    job.setCombinerClass(reducer.class);
		    job.setReducerClass(reducer.class);
		    job.setOutputKeyClass(Text.class);
		    job.setOutputValueClass(FloatWritable.class);
		    FileInputFormat.addInputPath(job, new Path(args[0]));
		    FileOutputFormat.setOutputPath(job, new Path(args[1]));
		    System.exit(job.waitForCompletion(true) ? 0 : 1);
			return 0;
		}
}
