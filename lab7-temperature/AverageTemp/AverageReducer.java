package temp;

/*    */ import java.io.IOException;
/*    */ import org.apache.hadoop.io.IntWritable;
/*    */ import org.apache.hadoop.io.Text;
/*    */ import org.apache.hadoop.mapreduce.Reducer;
/*    */ 
/*    */ public class AverageReducer
/*    */   extends Reducer<Text, IntWritable, Text, IntWritable> {
/*    */   public void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
/*  9 */     int max_temp = 0;
/* 10 */     int count = 0;
/* 11 */     for (IntWritable value : values) {
/*    */       
/* 13 */       max_temp += value.get();
/* 14 */       count++;
/*    */     } 
/* 16 */     context.write(key, new IntWritable(max_temp / count));
/*    */   }
/*    */ }
