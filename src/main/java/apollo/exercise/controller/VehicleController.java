package apollo.exercise.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apollo.exercise.entity.Vehicle;
import apollo.exercise.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);
	private final VehicleService vehicleService;

	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	@PostMapping
	public void addVehicle(@RequestBody Vehicle vehicle) {
		vehicleService.addVehicle(vehicle);
	}
}