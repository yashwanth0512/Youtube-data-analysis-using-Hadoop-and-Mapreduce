package youtube2;
import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
//import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
public class Mapper1 extends org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, Text, FloatWritable> 
{
	private FloatWritable rating=new FloatWritable();
	private Text videoname=new Text();
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
        String[] words = line.split("\t");
        videoname.set(words[0]);
           if((words.length)>9) 
           {
        	   float i=Float.parseFloat(words[6]);
        	   rating.set(i);
        	   
           }
           context.write(videoname, rating);
	}
}
	
