package apollo.exercise.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apollo.exercise.entity.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
	Vehicle findByVinNumber(String vinNumber);

	void deleteByVinNumber(String vinNumber);
}