package inditex.productpriceservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import inditex.productpriceservice.entities.Brand;

@Repository
public interface BrandsRepository extends JpaRepository<Brand, Long> {
    Iterable<Brand> findBrandByBrandId(String brandId);    
}
