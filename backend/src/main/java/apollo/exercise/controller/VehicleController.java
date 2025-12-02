package apollo.exercise.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import apollo.exercise.entity.Vehicle;
import apollo.exercise.service.VehicleService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	private static final Logger log = LoggerFactory.getLogger(VehicleController.class);
	private final VehicleService vehicleService;

	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	@GetMapping
	public ResponseEntity<List<Vehicle>> getAllVehicles() {
		List<Vehicle> vehicles = vehicleService.getAllVehicles();
		return ResponseEntity.status(HttpStatus.OK).body(vehicles);
	}

	@PostMapping
	public ResponseEntity<Map<String, String>> addVehicle(@Valid @RequestBody Vehicle vehicle) {
		vehicleService.addVehicle(vehicle);
		Map<String, String> response = Map.of("message", "Vehicle created successfully!");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/{vinNumber}")
	public Vehicle getVehicle(@PathVariable String vinNumber) {
		return vehicleService.getVehicle(vinNumber);
	}

	@PutMapping("/{vinNumber}")
	public void saveVehicle(@PathVariable String vinNumber, @Valid @RequestBody Vehicle updatedVehicle) {
		vehicleService.saveVehicle(vinNumber, updatedVehicle);
	}

	@DeleteMapping("/{vinNumber}")
	public ResponseEntity<Void> deleteVehicle(@PathVariable String vinNumber) {
		vehicleService.deleteVehicle(vinNumber);
		return ResponseEntity.noContent().build();
	}

}