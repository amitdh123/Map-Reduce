import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/* 
 * To define a map function for your MapReduce job, subclass 
 * the Mapper class and override the map method.
 * The class definition requires four parameters: 
 *   The data type of the input key
 *   The data type of the input value
 *   The data type of the output key (which is the input key type 
 *   for the reducer)
 *   The data type of the output value (which is the input value 
 *   type for the reducer)
 */

public class ResponseMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

  /*
   * The map method runs once for each line of text in the input file.
   * The method receives a key of type LongWritable, a value of type
   * Text, and a Context object.
   */
	private final static IntWritable one = new IntWritable(1);
	 @Override
  public void map(LongWritable _key, Text value, Context context)
      throws IOException, InterruptedException {

	String politicalKey = value.toString();

    String[] splitPoliticalValues = politicalKey.split("\",\"");
    context.write(new Text(splitPoliticalValues[0]), new IntWritable(1));
     
  }
}


