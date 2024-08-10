package io.github.renansereia.quarkussocial.domain.repository;

import io.github.renansereia.quarkussocial.domain.model.Followers;
import io.github.renansereia.quarkussocial.domain.model.User;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class FollowerRepository implements PanacheRepository<Followers> {

    public boolean follows(User user, User follower){
        var paramas = Parameters.with("follower",follower)
                .and("user",user).map();

        PanacheQuery<Followers> query = find("follower = :follower and user = :user", paramas);
        return query.firstResultOptional().isPresent();
    }

    public List<Followers> findByUser(Long userId){
        return find("user.id", userId).list();
    }

    public void deleteByFollowerAndUser(Long followerId, Long userId){
        var params = Parameters
                .with("userId",userId)
                .and("followerId",followerId)
                .map();
        delete("follower.id = :followerId and user.id = :userId",params);
    }
}
