package br.com.pucpr.bigdata.atp.implementacao8;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ImplementsReduce extends Reducer<Text, LongWritable, Text, LongWritable> {
    private Text mercadoria = new Text();
    private LongWritable totalPeso = new LongWritable();

    public void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        long somaPeso = 0;
        for (LongWritable valor : values) {
           if (valor.get() > somaPeso){
               somaPeso = valor.get();
           }
        }


            mercadoria.set(key);
            totalPeso.set(somaPeso);

    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        context.write(new Text("Mercadoria com maior total de peso, de acordo com todas as transacoes comerciais, separadas por ano:"), null);
        context.write(mercadoria, totalPeso);
    }
}
