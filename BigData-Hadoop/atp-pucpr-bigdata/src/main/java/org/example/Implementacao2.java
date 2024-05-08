package org.example;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.Arrays;

public class Implementacao2 {
    public static class MapperImplementacao2 extends Mapper<Object, Text,Text, IntWritable> {

        @Override
        public void map(Object chave, Text linha, Context context) throws IOException, InterruptedException {
            String line = linha.toString();
            String[] campos = line.split(";");
            if (campos.length == 9 && campos[4].equalsIgnoreCase("NARCOTICS")) {
                String ano = campos[2];
                String crime = campos[5];
                int ocorrencia = 1;

                Text chaveMap = new Text(ano);
                Text crime2 = new Text(crime);
                IntWritable valorMap = new IntWritable(ocorrencia);

                context.write(chaveMap, valorMap);
            }
        }
    }

        public static class ReducerImplementacao2 extends Reducer<Text, IntWritable, Text, IntWritable> {

            @Override
            public void reduce(Text chave, Iterable<IntWritable> valores, Context context) throws IOException, InterruptedException {

                int soma = 0;
                for (IntWritable value : valores) {
                    soma += value.get();
                }
                System.out.println(valores);
                IntWritable valorSaida = new IntWritable(soma);
                context.write(chave, valorSaida);
            }
        }


        public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
            String fileInput = "D:\\Atividades-PUC\\Bases.csv\\ocorrencias_criminais_sample.csv";
            String fileOutPut = "D:\\Atividades-PUC\\Implementacao\\implementacao2\\resultado1";
            Path pathInput = new Path("D:\\Atividades-PUC\\Bases.csv\\ocorrencias_criminais_sample.csv");
            Path pathOutput = new Path("D:\\Atividades-PUC\\Implementacao\\implementacao2\\resultado1");


            if (args.length == 2) {
                fileInput = args[0];
                fileOutPut = args[1];
            }

            Configuration configuration = new Configuration();
            Job job = Job.getInstance(configuration, "atividade2");

            job.setJarByClass(Implementacao2.class);
            job.setMapperClass(MapperImplementacao2.class);
            job.setReducerClass(ReducerImplementacao2.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);

            FileInputFormat.addInputPath(job, new Path(fileInput));
            FileOutputFormat.setOutputPath(job, new Path(fileOutPut));
            job.waitForCompletion(true);
        }
}
