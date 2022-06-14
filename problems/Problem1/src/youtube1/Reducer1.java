package youtube1;
import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
public class Reducer1 extends org.apache.hadoop.mapreduce.Reducer<Text, LongWritable, Text, LongWritable>{	
	@Override
	protected void reduce(Text word, Iterable<LongWritable> values,Context context)
			throws IOException, InterruptedException {
		long sum=0;
		for (LongWritable value : values) { sum+=value.get(); }
		context.write(word, new LongWritable(sum));
	}
}