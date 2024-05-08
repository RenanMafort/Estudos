package br.com.devdojo.varargs.crudjdbc.repository;


import br.com.devdojo.varargs.crudjdbc.conn.ConnectionFactory;
import br.com.devdojo.varargs.crudjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class ProducerRepository {

    public static List<Producer> findByName(String name) {
        log.info("FindAll producers");
        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stm = createPrepareStatementFindByName(conn, name);
             ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                producers.add(Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build());
            }


        } catch (SQLException e) {
            log.error("Error while trying to findAll producer ", e);

        }

        return producers;
    }

    private static PreparedStatement createPrepareStatementFindByName(Connection connection, String name) throws SQLException {
        String sql = "SELECT * FROM producer where name like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, String.format("%%%s%%", name));
        return preparedStatement;
    }

    public static void delete(int id) {

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementDelete(connection, id)) {

            ps.execute();
            log.info("Deleted producer '{}' from database", id);

        } catch (SQLException e) {
            e.printStackTrace();
            log.info("Errow while deleted producer from databse", e);

        }
    }

    private static PreparedStatement createPrepareStatementDelete(Connection connection, Integer id) throws SQLException {
        String sql = "DELETE  FROM producer WHERE (id = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }


    public static void save(Producer producer) {
        log.info("Saving Producer '{}'", producer);
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stm = createPreparedStatementSave(conn, producer)) {
            stm.execute();
        } catch (SQLException e) {
            log.error("Error while trying to upated producer '{}'", producer.getId(), e);

        }
    }

    private static PreparedStatement createPreparedStatementSave(Connection connection, Producer producer) throws SQLException {
        String sql = "INSERT INTO `repository`.`producer` (`name`) VALUES (?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, producer.getName());
        return preparedStatement;
    }

    public static Optional<Producer> findById(Integer id) {
        log.info("FindAll producers");
        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stm = createPreparedStatementFindById(conn, id);
             ResultSet rs = stm.executeQuery()) {
            if (!rs.next()) return Optional.empty();

            return Optional.of(Producer.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .build());

        } catch (SQLException e) {
            log.error("Error while trying to findAll producer ", e);

        }

        return Optional.empty();
    }

    private static PreparedStatement createPreparedStatementFindById(Connection connection, Integer id) throws SQLException {
        String sql = "SELECT * FROM  `repository`.`producer` WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }

    public static void update(Producer producer) {
        log.info("UPdating producer");
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stm =createdPrepareStatementUpdte(conn,producer)) {
           stm.execute();

        } catch (SQLException e) {
            log.error("Error while trying to upated producer '{}'", producer.getId(), e);

        }
    }

    private static PreparedStatement createdPrepareStatementUpdte(Connection connection, Producer producer ) throws SQLException {
        String sql = "UPDATE `repository`.`producer` SET `name` = ? WHERE (`id` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,producer.getName());
        preparedStatement.setInt(2,producer.getId());
        return preparedStatement;
    }
}
