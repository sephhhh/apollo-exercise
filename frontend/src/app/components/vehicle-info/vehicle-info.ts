import { CommonModule } from '@angular/common';
import { Component, ChangeDetectorRef } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { VehicleService } from '../../services/vehicle.service';
import { Vehicle } from '../../models/vehicle';
import { VehicleDTO } from '../../models/VehicleDTO';

@Component({
  selector: 'app-vehicle-info',
  imports: [FormsModule, RouterLink, CommonModule],
  templateUrl: './vehicle-info.html',
  styleUrl: './vehicle-info.css',
})
export class VehicleInfo {
  currentVin: String | null = "";
  isReadOnly = true;

  manufacturerName = "";
  description = "";
  horsePower: number | null = null;
  modelName = "";
  modelYear: number | null = null;
  price = "";
  fuelType = "";
  vinNumber = "";

  constructor(private route: ActivatedRoute, private vehicleService: VehicleService, private cdr: ChangeDetectorRef, private router: Router) {}

  onSubmit(form: any) {
    console.log('Form submitted:', form.value);
    this.isReadOnly = false; 
  }

  saveVehicleInfo() {
    this.isReadOnly = true;


    const newVehicleInfo: VehicleDTO = {
      manufacturerName: this.manufacturerName,
      description: this.description,
      horsePower: this.horsePower,
      modelName: this.modelName,
      modelYear: this.modelYear,
      price: this.price,
      fuelType: this.fuelType,
      vinNumber: this.vinNumber

    }

    this.vehicleService.saveVehicle(newVehicleInfo, this.currentVin).subscribe({
      next: (updated) => {
        console.log("Vehicle updated:", updated);
      },
      error: (err) => {
        console.error("Update failed", err);
      }
    })

  }

  deleteVehicle() {
    this.vehicleService.deleteVehicle(this.vinNumber).subscribe({
      next: () => {
        console.log("Vehicle deleted!");
        this.router.navigate(['/view-all-vehicles']);
      },
      error: (err) => {
        console.error("Delete failed:", err);
      }
    });


  }

  ngOnInit(): void {
    this.currentVin = this.route.snapshot.paramMap.get("vin");

    if (this.currentVin) {
      this.vehicleService.getVehicle(this.currentVin).subscribe(data => {
        this.manufacturerName = data.manufacturerName;
        this.description = data.description;
        this.horsePower = data.horsePower;
        this.modelName = data.modelName;
        this.modelYear = data.modelYear;
        this.price = data.price;
        this.fuelType = data.fuelType;
        this.vinNumber = data.vinNumber;

        this.cdr.detectChanges();
      })
    } else {
      console.error("VIN is missing from the URL!");
    }
  }

}
