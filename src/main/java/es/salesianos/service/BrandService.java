package es.salesianos.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.salesianos.model.Brand;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class BrandService implements es.salesianos.service.Service<Brand> {
	
	private static Logger log = LogManager.getLogger(BrandService.class);

	private List<Brand> brands = new ArrayList<>();
	
	@Override
	public void insert(Brand item) {
		log.info("INSERTING NEW BRAND:" + item);

		List<String> lines = Arrays.asList(item.getName().toString());
		Path file = Paths.get("/Users/aibarz/testingFileWrite.txt");
		try {
			Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("COULDN'T WRITE ON THE FILE", e);
		}
		brands.add(item);
	}

	@Override
	public List<Brand> listAll() {
		List<Brand> listBrands = new ArrayList<>();
		Path file = Paths.get("/Users/aibarz/testingFileWrite.txt");
		List<String> readAllLines = new ArrayList<>();
		try {
			readAllLines = Files.readAllLines(file, Charset.forName("UTF-8"));
		} catch (IOException e) {
			log.error("error al leer del fichero", e);
		}

		for (String line : readAllLines) {
			Brand brand = new Brand();
			brand.setName(line);
			log.info("SHOWING BRANDS:" + brand);
			listBrands.add(brand);
		}
		return listBrands;
	}
	
}
