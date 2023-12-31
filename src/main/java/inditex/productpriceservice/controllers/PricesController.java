package inditex.productpriceservice.controllers;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import inditex.productpriceservice.Model.PriceDTO;
import inditex.productpriceservice.entities.Price;
import inditex.productpriceservice.services.PricesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "PricesController", description = "Controlador REST obtener precios almacenados en la tabla PRICES")
@RequestMapping("/api/v1/")
public class PricesController {

    @Autowired
    private PricesService pricesService;
    
    @ApiOperation("Obtener todos los precios")
    @GetMapping("/prices/getAll")
    public Iterable<Price> getPrices() {
        return pricesService.findAll();
    }

    @ApiOperation("Obtener datos de los precios por brandId, startDate y productId")
    @GetMapping("/prices")
    public PriceDTO findByBrandIdAndStartDateAndProductId( 
    @RequestParam(value = "brandId", required = true) String brandId,
    @RequestParam(value = "startDate", required = true) String startDateStr,
    @RequestParam(value = "productId", required = true) String productId) throws ParseException{
        return pricesService.findByBrandIdAndStartDateAndProductId(brandId, startDateStr, productId);
    }
}
