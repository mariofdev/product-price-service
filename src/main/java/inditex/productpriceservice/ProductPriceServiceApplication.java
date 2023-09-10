package inditex.productpriceservice;

import java.text.SimpleDateFormat;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import inditex.productpriceservice.entities.Brand;
import inditex.productpriceservice.entities.Price;
import inditex.productpriceservice.repositories.BrandsRepository;
import inditex.productpriceservice.repositories.PricesRepository;

@SpringBootApplication
public class ProductPriceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductPriceServiceApplication.class, args);
	}

	// Bean de carga inicial de los datos en los repositorios
	@Bean
	public CommandLineRunner initLoad(
		PricesRepository pricesRepository,
		BrandsRepository brandsRepository) {
		return (args) -> {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
			brandsRepository.save(new Brand(1, "ZARA"));
			pricesRepository.save(new Price(1,dateFormat.parse("2020-06-14-00.00.00"), dateFormat.parse("2020-12-31-23.59.59"), 1, 35455, 0, 35.50, "EUR"));
			pricesRepository.save(new Price(1, dateFormat.parse("2020-06-14-15.00.00"), dateFormat.parse("2020-06-14-18.30.00"), 2, 35455, 1, 25.45, "EUR"));
			pricesRepository.save(new Price(1, dateFormat.parse("2020-06-15-00.00.00"), dateFormat.parse("2020-06-15-11.00.00"), 3, 35455, 1, 30.50, "EUR"));
			pricesRepository.save(new Price(1, dateFormat.parse("2020-06-15-16.00.00"), dateFormat.parse("2020-12-31-23.59.59"), 4, 35455, 1, 38.95, "EUR"));

		};
	}

}
