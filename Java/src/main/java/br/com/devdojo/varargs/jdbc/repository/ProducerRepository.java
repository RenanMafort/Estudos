package br.com.devdojo.varargs.jdbc.repository;

import br.com.devdojo.varargs.jdbc.conn.ConnectionFactory;
import br.com.devdojo.varargs.jdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class  ProducerRepository {
    public static void save(Producer producer) {
        String sql = "INSERT INTO `repository`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement()) {
            int rowsAffected = stm.executeUpdate(sql);
            log.info("'{}' Database rows afected '{}'", producer.getName(), rowsAffected);


        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", producer.getName(), e);

        }
    }

    public static void saveTransaction(List<Producer> producer) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            conn.setAutoCommit(false);
            PreparedStatementSaveTransaction(conn,producer);
            conn.commit();
        } catch (SQLException e) {
            log.error("Error while trying to save producer '{}'", producer, e);

        }
    }

    private static void PreparedStatementSaveTransaction(Connection connection,List<Producer> producers) throws SQLException {
        String sql = "INSERT INTO `repository`.`producer` (`name`) VALUES (?)";
        boolean shouldRollback = false;
        for (Producer p : producers){
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                log.info("Saving producer '{}'", p.getName());
                preparedStatement.setString(1,p.getName());
                preparedStatement.execute();
            }catch (SQLException e){
                e.printStackTrace();
                shouldRollback = true;
            }
        }
        if (shouldRollback) connection.rollback();
    }

    public static void delete(Integer id, Integer id2) {
//        String sql = "DELETE FROM `repository`.`producer` WHERE (`id` BETWEEN '%d' and '%d');".formatted(id,id2);
        String sql = "DELETE FROM producer WHERE id BETWEEN %d and %d".formatted(id, id2);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement()) {
            int rowsAffected = stm.executeUpdate(sql);
            log.info("Deleted fromDatabase, rows afected '{}'", rowsAffected);


        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", id, e);

        }
    }

    public static void delete(Integer id) {
//        String sql = "DELETE FROM `repository`.`producer` WHERE (`id` BETWEEN '%d' and '%d');".formatted(id,id2);
        String sql = "DELETE FROM producer WHERE id = %d".formatted(id);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement()) {
            int rowsAffected = stm.executeUpdate(sql);
            log.info("Deleted fromDatabase, rows afected '{}'", rowsAffected);


        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", id, e);

        }
    }

    public static void update(Producer producer) {
//        String sql = "DELETE FROM `repository`.`producer` WHERE (`id` BETWEEN '%d' and '%d');".formatted(id,id2);
        String sql = "UPDATE `repository`.`producer` SET `name` = '%s' WHERE (`id` = '%d')"
                .formatted(producer.getName(), producer.getId());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement()) {
            int rowsAffected = stm.executeUpdate(sql);
            log.info("Update fromDatabase, rows afected '{}'", rowsAffected);


        } catch (SQLException e) {
            log.error("Error while trying to upated producer '{}'", producer.getId(), e);

        }
    }

    public static void updatePreparedStatement(Producer producer) {
//        String sql = "DELETE FROM `repository`.`producer` WHERE (`id` BETWEEN '%d' and '%d');".formatted(id,id2);
        String sql = "UPDATE `repository`.`producer` SET `name` = '%s' WHERE (`id` = '%d')";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stm =updatePreparedStatement(conn,producer)) {
            int rowsAffected = stm.executeUpdate();
            log.info("Update fromDatabase, rows afected '{}'", rowsAffected);


        } catch (SQLException e) {
            log.error("Error while trying to upated producer '{}'", producer.getId(), e);

        }
    }

    private static PreparedStatement updatePreparedStatement(Connection connection,Producer producer ) throws SQLException {
        String sql = "UPDATE `repository`.`producer` SET `name` = ? WHERE (`id` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,producer.getName());
        preparedStatement.setInt(2,producer.getId());
        return preparedStatement;
    }
    public static List<Producer> findAll() {
//        String sql = "DELETE FROM `repository`.`producer` WHERE (`id` BETWEEN '%d' and '%d');".formatted(id,id2);

        log.info("FindAll producers");
        return findByName(Strings.EMPTY);
    }

    public static List<Producer> findByName(String name) {
//        String sql = "DELETE FROM `repository`.`producer` WHERE (`id` BETWEEN '%d' and '%d');".formatted(id,id2);

        log.info("FindAll producers");
        String sql = "SELECT * FROM producer where name like '%%%s%%'".formatted(name);

        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(sql)) {

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

    public static List<Producer> findByNamePreparedStatement(String name) {
//        String sql = "DELETE FROM `repository`.`producer` WHERE (`id` BETWEEN '%d' and '%d');".formatted(id,id2);

        log.info("FindAll producers");
        String sql = "SELECT * FROM producer where name like ?";

        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stm = createPreparedStatement(conn,sql,name);
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

    public static List<Producer> findByNameCallableStatement(String name) {
//        String sql = "DELETE FROM `repository`.`producer` WHERE (`id` BETWEEN '%d' and '%d');".formatted(id,id2);

        log.info("FindAll producers");
        String sql = "CALL `repository`.`sp_get_producer_by_name`(?);";

        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stm = findByNameCallableStatement(conn,sql,name);
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

    private static CallableStatement findByNameCallableStatement(Connection connection,String sql ,String name) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(sql);
        callableStatement.setString(1,String.format("%%%s%%",name));
        return callableStatement;
    }


    private static PreparedStatement createPreparedStatement(Connection connection,String sql ,String name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,String.format("%%%s%%",name));
        return preparedStatement;
    }
    public static void showProducerMetaData() {

        log.info("FindAll producers");
        String sql = "SELECT * FROM producer";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(sql)) {

            ResultSetMetaData metaData = rs.getMetaData();

            int columnCount = metaData.getColumnCount();

            log.info("Columns count" + columnCount);
            for (int i = 1; i <= columnCount; i++) {
                log.info("Table name '{}'", metaData.getTableName(i));
                log.info("Column name '{}'", metaData.getColumnName(i));
                log.info("Column size '{}'", metaData.getColumnDisplaySize(i));
                log.info("Column Type '{}'", metaData.getColumnTypeName(i));
            }


        } catch (SQLException e) {
            log.error("Error while trying to findAll producer ", e);

        }

    }

    public static void showDriverMetaData() {

        log.info("Show Driver MetaData");
        try (Connection conn = ConnectionFactory.getConnection()) {
            DatabaseMetaData metaData = conn.getMetaData();
            if (metaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                log.info("Supports TYPE_FORWARD_ONLY");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("and Suppors CONCUR_UPDATABLE");
                }
            }
            if (metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                log.info("Supports TYPE_SCROLL_INSENSITIVE");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("and Suppors CONCUR_UPDATABLE");
                }
            }

            if (metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                log.info("Supports TYPE_SCROLL_INSENSITIVE");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("and Suppors CONCUR_UPDATABLE");
                }
            }


        } catch (SQLException e) {
            log.error("Error while trying to findAll producer ", e);

        }

    }

    public static void showTypeScrollWorking() {

        log.info("showTypeScrollWorking  producers order by name desc");
        String sql = "SELECT * FROM producer ";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stm.executeQuery(sql)) {
            log.info("Last row? '{}'", rs.last());
            log.info("Row number? '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("First row? '{}'", rs.first());
            log.info("Row number? '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("Row absolute? '{}'", rs.absolute(4));
            log.info("Row number? '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());


            log.info("Row relative? '{}'", rs.relative(-2));
            log.info("Row number? '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());


            log.info("Is last? '{}'", rs.isLast());
            log.info("Row number? '{}'", rs.getRow());

            log.info("Is first? '{}'", rs.isFirst());
            log.info("Row number? '{}'", rs.getRow());

            log.info("-----------------");
            while (rs.previous()) {
                log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            }

        } catch (SQLException e) {
            log.error("Error while trying to findAll producer ", e);

        }

    }

    public static List<Producer> findByNameAndToLowerCase(String name) {
//        String sql = "DELETE FROM `repository`.`producer` WHERE (`id` BETWEEN '%d' and '%d');".formatted(id,id2);

        log.info("FindAll producers");
        String sql = "SELECT * FROM producer where name like '%%%s%%'".formatted(name);

        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stm.executeQuery(sql)) {

            while (rs.next()) {
                rs.updateString("name", rs.getString("name").toLowerCase());
                rs.updateRow();
                rs.cancelRowUpdates();
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

    public static List<Producer> findByNameOrInsertWhenNotFound(String name) {
//        String sql = "DELETE FROM `repository`.`producer` WHERE (`id` BETWEEN '%d' and '%d');".formatted(id,id2);

        log.info("FindAll producers");
        String sql = "SELECT * FROM producer where name like '%%%s%%'".formatted(name);

        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stm.executeQuery(sql)) {
            if (rs.next()) return producers;


            rs.moveToInsertRow();
            rs.updateString("name", name);
            rs.insertRow();
            rs.beforeFirst();
            rs.next();
            producers.add(Producer.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .build());


        } catch (SQLException e) {
            log.error("Error while trying to findAll producer ", e);

        }

        return producers;
    }

}
