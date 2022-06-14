package youtube1;
import java.io.IOException;
//import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
public class Mapper1 extends org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, Text, LongWritable> 
{
	private Text word=new Text();
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
        String[] words = line.split("\t");
           if((words.length)>5) { word.set(words[3]); }
           context.write(new Text(word), new LongWritable(1));
	}
}
	
