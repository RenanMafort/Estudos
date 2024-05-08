package br.com.devdojo.varargs.jdbc.repository;

import br.com.devdojo.varargs.jdbc.conn.ConnectionFactory;
import br.com.devdojo.varargs.jdbc.dominio.Producer;
import br.com.devdojo.varargs.jdbc.listener.CustomRowSetListener;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerRepositoryRowSet {
    public static List<Producer> findByNameJdbcRowSet(String name){
        String sql = "CALL `repository`.`sp_get_producer_by_name`(?);";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jrs = ConnectionFactory.getjdbcRowSet()){
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setString(1,String.format("%%%s%%",name));
            jrs.execute();
            while (jrs.next()){
                producers.add(Producer.builder().id(jrs.getInt("id"))
                        .name(jrs.getString("name")).build());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return producers;
    }

//    public static void updateJdbcRowSet(Producer producer){
//        String sql = "UPDATE FROM producer SET name = ? WHERE (id = ?)";
//        try (JdbcRowSet jrs = ConnectionFactory.getjdbcRowSet()){
//            jrs.setCommand(sql);
//            jrs.setString(1, producer.getName());
//            jrs.setInt(2, producer.getId());
//            jrs.execute();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//
//    }

    public static void updateJdbcRowSet(Producer producer){
        String sql = "SELECT * FROM producer  WHERE (id = ?)";
        try (JdbcRowSet jrs = ConnectionFactory.getjdbcRowSet()){
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setInt(1, producer.getId());
            jrs.execute();
            if (!jrs.next()) return;
            jrs.updateString("name", producer.getName());
            jrs.updateRow();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void updateCachedRowSet(Producer producer){
        String sql = "SELECT * FROM producer  WHERE (id = ?)";
        try (CachedRowSet crs = ConnectionFactory.getCachedRowSet();
        Connection connection = ConnectionFactory.getConnection()){
            connection.setAutoCommit(false);
            crs.setCommand(sql);
            crs.setInt(1, producer.getId());
            crs.execute(connection);
            if (!crs.next()) return;
            crs.updateString("name", producer.getName());
            crs.updateRow();
            crs.acceptChanges();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
