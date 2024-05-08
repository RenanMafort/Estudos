package br.com.pucpr.bigdata.atp.implementacao2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.Counters;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Implementacao2 {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, URISyntaxException {
        String arquivoEntrada = "D:\\Atividades-PUC\\Bases.csv\\base_100_mil.csv";
        String arquivoSaida = "D:\\Atividades-PUC\\resultado\\implementacao2";

        if(args.length == 2) {
            arquivoEntrada = args[0];
            arquivoSaida = args[1];
        }



        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "implementacao2");
        job.setJarByClass(Implementacao2.class);
        job.setMapperClass(ImplementsMapper.class);
        job.setReducerClass(ImplementsReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(arquivoEntrada));
        FileOutputFormat.setOutputPath(job, new Path(arquivoSaida));

        job.waitForCompletion(true);

    }
}
