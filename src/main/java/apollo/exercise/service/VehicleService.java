package apollo.exercise.service;

import org.springframework.stereotype.Service;

import apollo.exercise.entity.Vehicle;
import apollo.exercise.repo.VehicleRepo;

@Service
public class VehicleService {
	private final VehicleRepo vehicleRepo;

	public VehicleService(VehicleRepo vehicleRepo) {
		this.vehicleRepo = vehicleRepo;
	}

	public void addVehicle(Vehicle vehicle) {
		vehicleRepo.save(vehicle);
	}
}