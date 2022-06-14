package youtube1;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
public class JobMain implements Tool{
	private Configuration conf;
	@Override
	public Configuration getConf() { return conf;}
	@Override
	public void setConf(Configuration conf) { this.conf=conf; }
	@Override
	public int run(String[] args) throws Exception {
		@SuppressWarnings("deprecation")
		Job job=new Job();
		job.setJobName("youtube1");
		job.setJarByClass(this.getClass());
		job.setMapperClass(Mapper1.class);
		job.setReducerClass(Reducer1.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(LongWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		return job.waitForCompletion(true)  ? 0: -1;	
	}
  public static void main(String args[]) throws Exception
  {
	  int status=ToolRunner.run(new Configuration(), new JobMain(), args);
	  System.out.println("My status"+status);  
  } 
  }