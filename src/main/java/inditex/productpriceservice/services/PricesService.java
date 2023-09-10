package inditex.productpriceservice.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inditex.productpriceservice.Model.PriceDTO;
import inditex.productpriceservice.entities.Price;
import inditex.productpriceservice.repositories.PricesRepository;

@Service
public class PricesService {
    
    @Autowired
    private PricesRepository pricesRepository;

    public Iterable<PriceDTO> findByBrandIdAndStartDateAndProductId(String brandId, Date startDate, String productId) {
        int brandIdInt = Integer.parseInt(brandId);
        long productIdLong = Long.parseLong(productId);
        return pricesRepository.findByBrandIdAndStartDateAndProductId(brandIdInt, startDate, productIdLong);
    }

    public Iterable<Price> findAll() {
        return pricesRepository.findAll();
    }
}
