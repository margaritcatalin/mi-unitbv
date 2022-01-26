package com.carstore.Warehouse.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.carstore.CarStoreModel.model.Car;
import com.carstore.Warehouse.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {


	@Autowired
	private CarService carService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Car addCarPost(@RequestBody Car car) {
		return carService.save(car);
	}

	@RequestMapping(value = "/add/image", method = RequestMethod.POST)
	public ResponseEntity<String> upload(@RequestParam("id") Long id, HttpServletResponse response,
			HttpServletRequest request) {
		try {
			Car car = carService.findOne(id);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id + ".png";

			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/image/car/" + fileName)));
			stream.write(bytes);
			stream.close();

			return new ResponseEntity<String>("Upload Success!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Upload failed!", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/update/image", method = RequestMethod.POST)
	public ResponseEntity<String> updateImagePost(@RequestParam("id") Long id, HttpServletResponse response,
			HttpServletRequest request) {
		try {
			Car car = carService.findOne(id);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id + ".png";

			try {
				Files.delete(Paths.get("src/main/resources/static/image/car/" + fileName));
			} catch (Exception e) {
				System.out.println("Image for carId " + id + "was not present for deletion");
			}

			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/image/car/" + fileName)));
			stream.write(bytes);
			stream.close();

			return new ResponseEntity<String>("Upload Success!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Upload failed!", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Car updateCarPost(@RequestBody Car car) {
		return carService.save(car);
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public ResponseEntity<String> remove(@RequestBody String id) throws IOException {
		carService.removeOne(Long.parseLong(id));

		String fileName = id + ".png";
		try {
			Files.delete(Paths.get("src/main/resources/static/image/car/" + fileName));
		} catch (Exception e) {
			System.out.println("Image for carId " + id + "was not present for deletion");
		}

		return new ResponseEntity<String>("Remove Success!", HttpStatus.OK);
	}

	@RequestMapping("/carList")
	public List<Car> getCarList() {
		return carService.findAll();
	}

	@RequestMapping("/{id}")
	public Car getCar(@PathVariable("id") Long id) {
		Car car = carService.findOne(id);
		return car;
	}

	@RequestMapping(value = "/searchCar", method = RequestMethod.POST)
	public List<Car> searchCar(@RequestBody String keyword) {
		List<Car> carList = carService.blurrySearch(keyword);

		return carList;
	}

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}
	
}
