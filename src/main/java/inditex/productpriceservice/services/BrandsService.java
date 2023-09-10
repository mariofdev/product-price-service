package inditex.productpriceservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import inditex.productpriceservice.entities.Brand;
import inditex.productpriceservice.repositories.BrandsRepository;

@Service
public class BrandsService {
    
    @Autowired
    private BrandsRepository brandsRepository;

    public Iterable<Brand> findByBrandId(String brandId) {
        int brandIdInt = Integer.parseInt(brandId);
        return brandsRepository.findBrandByBrandId(brandIdInt);
    }
}
