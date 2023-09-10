package inditex.productpriceservice.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inditex.productpriceservice.Model.PriceDTO;
import inditex.productpriceservice.entities.Price;
import inditex.productpriceservice.repositories.PricesRepository;

@Service
public class PricesService {
    
    @Autowired
    private PricesRepository pricesRepository;

    public ArrayList<PriceDTO> findByBrandIdAndStartDateAndProductId(String brandId, Date startDate, String productId) {
        int brandIdInt = Integer.parseInt(brandId);
        long productIdLong = Long.parseLong(productId);
        Iterable<Price> prices = pricesRepository.findByBrandIdAndStartDateAndProductId(brandIdInt, startDate, productIdLong);
        ArrayList<PriceDTO> pricesDTO = new ArrayList<PriceDTO>();
        for (Price price : prices) {
            PriceDTO priceDTO = new PriceDTO(price.getBrandId(), price.getStartDate(), price.getEndDate(), price.getPriceList(), price.getProductId(), price.getPrice());
            pricesDTO.add(priceDTO);
        }
        return pricesDTO;
    }

    public Iterable<Price> findAll() {
        return pricesRepository.findAll();
    }
}
