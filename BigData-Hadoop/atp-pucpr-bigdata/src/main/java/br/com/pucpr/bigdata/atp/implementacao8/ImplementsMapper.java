package br.com.pucpr.bigdata.atp.implementacao8;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ImplementsMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
        public void map(LongWritable  chave, Text valor, Context context) throws IOException, InterruptedException {
             String[] campos = valor.toString().split(";");

            try {
                if (campos.length == 10 && !campos[0].equals("country_or_area")) {
                    campos = valor.toString().split(";");
                    String ano = campos[1];
                    String peso = campos[6];
                    String mercadoria = campos[3];
                    Text chavemap = new Text(ano + " " + mercadoria);
                    context.write(chavemap, new LongWritable(peso.trim().isEmpty() ? 0 : Long.parseLong(peso)));
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }

}
