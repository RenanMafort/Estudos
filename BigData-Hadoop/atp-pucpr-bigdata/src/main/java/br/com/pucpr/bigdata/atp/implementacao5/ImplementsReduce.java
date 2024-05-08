package br.com.pucpr.bigdata.atp.implementacao5;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ImplementsReduce extends Reducer<Text, IntWritable, Text, IntWritable> {
    private final Text mercadoria = new Text();
    private final IntWritable maxOcorrencia = new IntWritable(0);

    @Override
    public void reduce(Text chave, Iterable<IntWritable> valores, Context context) throws IOException, InterruptedException {
        int soma = 0;

        for (IntWritable val : valores) {
            soma += val.get();
        }

        if (soma > maxOcorrencia.get()) {
            maxOcorrencia.set(soma);
            mercadoria.set(chave);
        }
        context.write(chave, new IntWritable(soma));
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        context.write(new Text("Mercadoria com maior quantidade de transacoes financeiras em 2016:"), null);
        context.write(mercadoria, maxOcorrencia);
    }
}
