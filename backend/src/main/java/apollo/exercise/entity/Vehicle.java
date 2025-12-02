package apollo.exercise.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "Manufacturer name is required")
	private String manufacturerName;

	@NotBlank(message = "Description is required")
	private String description;

	@NotNull(message = "Horse Power is required")
	@Positive(message = "Horse Power must be positive")
	private Integer horsePower;

	@NotBlank(message = "Model Name name is required")
	private String modelName;

	@NotNull(message = "Year is required")
	private Integer modelYear;

	@NotNull(message = "Price is required")
	@Positive(message = "Price must be positive")
	@Digits(integer = 10, fraction = 2, message = "Price can have max 2 decimal places")
	private BigDecimal price;

	@NotBlank(message = " Fuel Type is required")
	private String fuelType;

	@NotBlank(message = "Vin Number is required")
	@Pattern(regexp = "^[A-HJ-NPR-Z0-9]{17}$", message = "VIN contains invalid characters (I, O, Q not allowed)")
	@Size(min = 17, max = 17, message = "VIN must be exactly 17 characters")
	private String vinNumber;

	public Vehicle() {
	}

	public Vehicle(String manufacturerName, String description, Integer horsePower, String modelName, Integer modelYear,
			BigDecimal price, String fuelType, String vinNumber) {
		this.manufacturerName = manufacturerName;
		this.description = description;
		this.horsePower = horsePower;
		this.modelName = modelName;
		this.modelYear = modelYear;
		this.price = price;
		this.fuelType = fuelType;
		this.vinNumber = vinNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(Integer horsePower) {
		this.horsePower = horsePower;
	}

	public Integer getModelYear() {
		return modelYear;
	}

	public void setModelYear(Integer modelYear) {
		this.modelYear = modelYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}
}