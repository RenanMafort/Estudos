package br.com.devdojo.varargs.crudjdbc.repository;


import br.com.devdojo.varargs.crudjdbc.conn.ConnectionFactory;
import br.com.devdojo.varargs.crudjdbc.dominio.Anime;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class AnimeRepository {

    public static List<Anime> findByName(String name) {
        log.info("FindAll animers");
        List<Anime> animers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stm = createPrepareStatementFindByName(conn, name);
             ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                animers.add(Anime.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                                .episodes(rs.getInt("episodes"))
                        .build());
            }


        } catch (SQLException e) {
            log.error("Error while trying to findAll anime ", e);

        }

        return animers;
    }

    private static PreparedStatement createPrepareStatementFindByName(Connection connection, String name) throws SQLException {
        String sql = "SELECT * FROM anime where name like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.format("%%%s%%", name));
        return preparedStatement;
    }

    public static void delete(int id) {

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementDelete(connection, id)) {

            ps.execute();
            log.info("Deleted anime '{}' from database", id);

        } catch (SQLException e) {
            e.printStackTrace();
            log.info("Errow while deleted anime from databse", e);

        }
    }

    private static PreparedStatement createPrepareStatementDelete(Connection connection, Integer id) throws SQLException {
        String sql = "DELETE  FROM anime WHERE (id = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }


    public static void save(Anime anime) {
        log.info("Saving Anime '{}'", anime);
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stm = createPreparedStatementSave(conn, anime)) {
            stm.execute();
        } catch (SQLException e) {
            log.error("Error while trying to upated anime '{}'", anime.getId(), e);

        }
    }

    private static PreparedStatement createPreparedStatementSave(Connection connection, Anime anime) throws SQLException {
        String sql = "INSERT INTO `repository`.`anime` (`name`) VALUES (?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, anime.getName());
        return preparedStatement;
    }

    public static Optional<Anime> findById(Integer id) {
        log.info("FindAll animers");
        List<Anime> animers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stm = createPreparedStatementFindById(conn, id);
             ResultSet rs = stm.executeQuery()) {
            if (!rs.next()) return Optional.empty();

            return Optional.of(Anime.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .build());

        } catch (SQLException e) {
            log.error("Error while trying to findAll anime ", e);

        }

        return Optional.empty();
    }

    private static PreparedStatement createPreparedStatementFindById(Connection connection, Integer id) throws SQLException {
        String sql = "SELECT * FROM  `repository`.`anime` WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }

    public static void update(Anime anime) {
        log.info("UPdating anime");
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stm =createdPrepareStatementUpdte(conn,anime)) {
           stm.execute();

        } catch (SQLException e) {
            log.error("Error while trying to upated anime '{}'", anime.getId(), e);

        }
    }

    private static PreparedStatement createdPrepareStatementUpdte(Connection connection, Anime anime ) throws SQLException {
        String sql = "UPDATE `repository`.`anime` SET `name` = ? WHERE (`id` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,anime.getName());
        preparedStatement.setInt(2,anime.getId());
        return preparedStatement;
    }
}
