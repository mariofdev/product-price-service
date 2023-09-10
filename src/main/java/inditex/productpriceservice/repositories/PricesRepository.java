package inditex.productpriceservice.repositories;
import inditex.productpriceservice.entities.Price;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PricesRepository extends JpaRepository<Price, Long> {
    Iterable<Price> findByBrandIdAndStartDateAndProductId(int brandId, Date startDate, long productId);

    List<Price> findByBrandIdAndProductId(int brandId, long productId);
}
