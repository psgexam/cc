import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class PiCalculator {
public static class PiMapper extends Mapper<Object, NullWritable, DoubleWritable, NullWritable>
{
@Override
protected void map(Object key, NullWritable value, Context context)
throws IOException, InterruptedException {
// Calculate and output the value of PI
double piValue = Math.PI;
context.write(new DoubleWritable(piValue), NullWritable.get());
}
}
public static class WholeFileInputFormat extends FileInputFormat<Object, NullWritable> {
@Override
protected boolean isSplitable(Configuration conf, Path file) {
return false;
}
}
public static void main(String[] args) throws Exception {
Configuration conf = new Configuration();
Job job = Job.getInstance(conf, "CalculatePi");
job.setJarByClass(PiCalculator.class);
job.setMapperClass(PiMapper.class);
job.setOutputKeyClass(DoubleWritable.class);
job.setOutputValueClass(NullWritable.class);
// Set the custom input format
job.setInputFormatClass(WholeFileInputFormat.class);
// Input and output paths
FileInputFormat.addInputPath(job, new Path(args[0]));
FileOutputFormat.setOutputPath(job, new Path(args[1]));
// Wait for the job to complete
System.exit(job.waitForCompletion(true) ? 0 : 1);
}
}
