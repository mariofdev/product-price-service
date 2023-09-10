package inditex.productpriceservice.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public PriceDTO findByBrandIdAndStartDateAndProductId(String brandIdStr, String startDateStr, String productIdStr) throws ParseException {

        // Transformamos startDate a Date
        Date startDate = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss").parse(startDateStr);
        
        // Transformamos brandId a int
        int brandId = Integer.parseInt(brandIdStr);
        
        // Transformamos productId a long
        long productId = Long.parseLong(productIdStr);

        /*
         * Establecemos una lógica de de filtrado siguiente:
         *  - Obtener el listado de precios que coincide con el brandId y productId dados
         *  - Del listado obtenido en el punto anterior, obtenemos los precios que están vigentes por fecha (start_date menor al start_date dado y end_date mayor o igual que el start_date dado)
         *  - Del listado obtenido en el punto anterior, obtenemos el precio con mayor priority
         */

        // Recuperamos todos los precios para la combinación de brandId y productId dados
        List<Price> allPrices = pricesRepository.findByBrandIdAndProductId(brandId, productId);

        // Lista para almacenar los precios vigentes
        List<Price> validPrices = new ArrayList<>();

        // Iteramos a través de los precios y filtramos los vigentes
        for (Price price : allPrices) {
            if (startDate.compareTo(price.getStartDate()) >= 0 && startDate.compareTo(price.getEndDate()) <= 0) {
                validPrices.add(price);
            }
        }

        // Encontramos el precio con el mayor priority
        PriceDTO finalPrice = null;
        int maxPriority = Integer.MIN_VALUE;
        for (Price price : validPrices) {
            if (price.getPriority() > maxPriority) {
                maxPriority = price.getPriority();
                finalPrice = new PriceDTO(price.getBrandId(), price.getStartDate(), price.getEndDate(), price.getPriceList(), price.getProductId(), price.getPrice());
            }
        }
        return finalPrice;
    }

    public Iterable<Price> findAll() {
        return pricesRepository.findAll();
    }
}
