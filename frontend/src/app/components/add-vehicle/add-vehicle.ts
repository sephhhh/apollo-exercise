import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { VehicleService } from '../../services/vehicle.service';
import { Vehicle } from '../../models/vehicle';
import { VehicleDTO } from '../../models/VehicleDTO';

@Component({
  selector: 'app-add-vehicle',
  imports: [RouterLink, FormsModule],
  templateUrl: './add-vehicle.html',
  styleUrl: './add-vehicle.css',
})
export class AddVehicle {
  manufacturerName = "";
  description = "";
  horsePower: number | null = null;
  modelName = "";
  modelYear: number | null = null;
  purchasePrice: string = "";
  fuelType = "";
  vin = "";

  constructor(private vehicleService: VehicleService) {}

  addVehicle() {
  const vehicle: VehicleDTO = {
    manufacturerName: this.manufacturerName,
    description: this.description,
    horsePower: this.horsePower,
    modelName: this.modelName,
    modelYear: this.modelYear,
    price: this.purchasePrice.toString(),
    fuelType: this.fuelType,
    vinNumber: this.vin
  }

  this.vehicleService.addVehicle(vehicle);
  }


}
