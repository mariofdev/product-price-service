package inditex.productpriceservice.repositories;
import inditex.productpriceservice.entities.Price;
import org.springframework.stereotype.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PricesRepository extends JpaRepository<Price, Long> {
    Iterable<Price> findByBrandIdAndStartDateAndProductId(long brandId, Date startDate, String productId);
}
