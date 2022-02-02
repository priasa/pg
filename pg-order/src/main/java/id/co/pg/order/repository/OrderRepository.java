package id.co.pg.order.repository;

import id.co.pg.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    @Query("SELECT t FROM Order t WHERE t.id = :priceId AND t.partnerId = :partnerId")
    Optional<Order> findByIdAndPartnerId(@Param("priceId") String priceId, @Param("partnerId") String partnerId);

}
