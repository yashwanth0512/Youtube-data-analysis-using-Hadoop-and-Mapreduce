package youtube2;
import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
//import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
public class Reducer1 extends org.apache.hadoop.mapreduce.Reducer<Text, FloatWritable, Text, FloatWritable>{
	protected void reduce(Text word, Iterable<FloatWritable> values,Context context)
			throws IOException, InterruptedException {
		float sum=0;
		for (FloatWritable value : values) { sum+=value.get(); }
		context.write(word, new FloatWritable(sum));
	}
}