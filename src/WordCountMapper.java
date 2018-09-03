import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @Description
 * @Author Stringing
 * @Date 2018/8/13 10:55
 */
public class WordCountMapper extends Mapper<LongWritable,Text,Text,LongWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String data = value.toString();
        String[] words = data.split(" ");
        for(String w : words){
            context.write(new Text(w), new LongWritable(1));
        }
    }
}
