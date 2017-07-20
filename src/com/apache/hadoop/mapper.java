package com.apache.hadoop;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class mapper extends Mapper<LongWritable, Text, Text, FloatWritable>{
	public void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException 
	{
	    System.out.println("*****************Inside mapper.java***************");
		String s=value.toString();
		String str[]=s.split(",");
		float x,y;
		x=Float.parseFloat(str[0]);
		y=Float.parseFloat(str[1]);
		context.write(new Text("x"), new FloatWritable(x));
		context.write(new Text("y"), new FloatWritable(y));
		context.write(new Text("x2"), new FloatWritable(x*x));
		context.write(new Text("y2"), new FloatWritable(y*y));
		context.write(new Text("xy"), new FloatWritable(x*y));
	}
}
