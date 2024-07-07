package Backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Backend.model.Route;

public interface RouteRepository extends JpaRepository<Route, Integer> {

    @Query("SELECT r FROM Route r WHERE r.routeVisibility = true")
    List<Route> findGlobalRoutes();

    @Query("SELECT r FROM Route r WHERE r.user.id = :userId")
    List<Route> findRoutesForUser(@Param("userId") Integer userId);

}
