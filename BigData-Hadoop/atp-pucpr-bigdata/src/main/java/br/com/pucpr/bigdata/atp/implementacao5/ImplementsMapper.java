package br.com.pucpr.bigdata.atp.implementacao5;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ImplementsMapper extends Mapper<Object, Text, Text, IntWritable> {
        public void map(Object chave, Text valor, Context context) throws IOException, InterruptedException {
            String linha = valor.toString();
            String[] campos = linha.split(";");

            if (campos.length == 10 && campos[1].equals("2016")) {
                context.write(new Text(campos[3]),new IntWritable(1));
            }

        }

}
