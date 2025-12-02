package apollo.exercise.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import apollo.exercise.controller.VehicleController;
import apollo.exercise.entity.Vehicle;
import apollo.exercise.repo.VehicleRepo;

@Service
public class VehicleService {
	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);
	private final VehicleRepo vehicleRepo;

	public VehicleService(VehicleRepo vehicleRepo) {
		this.vehicleRepo = vehicleRepo;
	}

	public List<Vehicle> getAllVehicles() {
		return vehicleRepo.findAll();
	}

	public void addVehicle(Vehicle vehicle) {
		vehicleRepo.save(vehicle);
	}

	public Vehicle getVehicle(String vinNumber) {
		return vehicleRepo.findByVinNumber(vinNumber);
	}

	public void saveVehicle(String vinNumber, Vehicle updatedVehicle) {
		Vehicle existingVehicle = vehicleRepo.findByVinNumber(vinNumber);

		existingVehicle.setManufacturerName(updatedVehicle.getManufacturerName());
		existingVehicle.setModelName(updatedVehicle.getModelName());
		existingVehicle.setModelYear(updatedVehicle.getModelYear());
		existingVehicle.setDescription(updatedVehicle.getDescription());
		existingVehicle.setHorsePower(updatedVehicle.getHorsePower());
		existingVehicle.setPrice(updatedVehicle.getPrice());
		existingVehicle.setFuelType(updatedVehicle.getFuelType());

		vehicleRepo.save(existingVehicle);
	}

	public void deleteVehicle(String vinNumber) {
		Vehicle existVehicle = vehicleRepo.findByVinNumber(vinNumber);
		vehicleRepo.delete(existVehicle);
	}
}