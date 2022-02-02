package id.co.pg.price.repository;

import id.co.pg.price.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, String> {
    @Query("SELECT t FROM Price t WHERE t.id = :priceId")
    Optional<Price> findByPriceId(@Param("priceId") String priceId);

    @Query("SELECT t FROM Price t WHERE t.priceDate = :priceDate")
    Optional<Price> findByPriceDate(@Param("priceDate") String priceDate);
}
