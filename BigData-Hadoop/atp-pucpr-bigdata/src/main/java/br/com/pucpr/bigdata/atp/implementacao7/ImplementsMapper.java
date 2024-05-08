package br.com.pucpr.bigdata.atp.implementacao7;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.VIntWritable;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ImplementsMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    private Text mercadoria = new Text();
    private LongWritable peso = new LongWritable();
        public void map(LongWritable  chave, Text valor, Context context) throws IOException, InterruptedException {
             String[] campos = valor.toString().split(";");

            try {
                // Ignora cabeçalho e linhas em branco
                if (campos.length == 10 && !campos[0].equals("country_or_area")) {
                    mercadoria.set(campos[3]);
                    peso.set(campos[6].trim().isEmpty() ? 0 : Long.parseLong(campos[6]));
                    context.write(mercadoria, peso);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }

}
