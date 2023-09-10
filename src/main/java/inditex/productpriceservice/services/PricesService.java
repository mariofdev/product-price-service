package inditex.productpriceservice.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inditex.productpriceservice.entities.Price;
import inditex.productpriceservice.repositories.PricesRepository;

@Service
public class PricesService {
    
    @Autowired
    private PricesRepository pricesRepository;

    public Iterable<Price> findByBrandIdAndStartDateAndProductId(String brandId, Date startDate, String productId) {
        return pricesRepository.findByBrandIdAndStartDateAndProductId(brandId, startDate, productId);
    }
}
