package id.co.pg.partner.repository;

import id.co.pg.partner.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PartnerRepository extends JpaRepository<Partner, String> {

    @Query("SELECT t FROM Partner t WHERE t.id like %:partner_id%")
    List<Partner> findByPartnerId(@Param("partner_id") String partnerId);
}
