package temp;

/*    */ import java.io.IOException;
/*    */ import org.apache.hadoop.io.IntWritable;
/*    */ import org.apache.hadoop.io.LongWritable;
/*    */ import org.apache.hadoop.io.Text;
/*    */ import org.apache.hadoop.mapreduce.Mapper;
/*    */ 
/*    */ public class AverageMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
/*    */   public static final int MISSING = 9999;
/*    */   
/*    */   public void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
/*    */     int temperature;
/* 12 */     String line = value.toString();
/* 13 */     String year = line.substring(15, 19);
/*    */     
/* 15 */     if (line.charAt(87) == '+') {
/* 16 */       temperature = Integer.parseInt(line.substring(88, 92));
/*    */     } else {
/* 18 */       temperature = Integer.parseInt(line.substring(87, 92));
/*    */     } 
/* 20 */     String quality = line.substring(92, 93);
/* 21 */     if (temperature != 9999 && quality.matches("[01459]"))
/* 22 */       context.write(new Text(year), new IntWritable(temperature)); 
/*    */   }
/*    */ }