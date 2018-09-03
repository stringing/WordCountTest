import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @Description
 * @Author Stringing
 * @Date 2018/8/13 10:56
 */
public class WordCountMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if(args.length < 2){
            System.err.println("Usage: MyWordCount <input path> <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();

        job.setJarByClass(WordCountMain.class);
        job.setJobName("My word count");

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
