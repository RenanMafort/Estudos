package br.com.pucpr.bigdata.atp.implementacao4;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class Implementacao4 {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        String arquivoEntrada = "D:\\Atividades-PUC\\Bases.csv\\base_100_mil.csv";
        String arquivoSaida = "D:\\Atividades-PUC\\resultado\\implementacao4";

        if(args.length == 2) {
            arquivoEntrada = args[0];
            arquivoSaida = args[1];
        }

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "informacao4");
        job.setJarByClass(Implementacao4.class);
        job.setMapperClass(ImplementsMapper.class);
        job.setReducerClass(ImplementsReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(arquivoEntrada));
        FileOutputFormat.setOutputPath(job, new Path(arquivoSaida));
        job.waitForCompletion(true);

    }
}
