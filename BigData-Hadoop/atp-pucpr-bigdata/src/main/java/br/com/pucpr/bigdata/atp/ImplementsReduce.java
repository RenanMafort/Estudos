package br.com.pucpr.bigdata.atp;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ImplementsReduce extends Reducer<Text, IntWritable, Text, IntWritable> {
    private final Text paisMax = new Text();
    private final IntWritable maxOcorrencia = new IntWritable(0);

    @Override
    public void reduce(Text chave, Iterable<IntWritable> valores, Context context) throws IOException, InterruptedException {
        int soma = 0;

        for (IntWritable val : valores) {
            soma += val.get();
        }

        if (soma > maxOcorrencia.get()) {
            maxOcorrencia.set(soma);
            paisMax.set(chave);
        }

        context.write(chave, new IntWritable(soma));
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        context.write(new Text("Mercadoria com maior quantidade de transações financeiras em 2016, no Brasil:"), maxOcorrencia);
        context.write(paisMax, maxOcorrencia);
    }
}
