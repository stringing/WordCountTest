import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Description
 * @Author Stringing
 * @Date 2018/8/13 10:56
 */
public class WordCountReducer extends Reducer<Text,LongWritable,Text,LongWritable> {
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        long count = 0;
        for(LongWritable l : values){
            count += l.get();
        }
        context.write(key, new LongWritable(count));
    }
}
