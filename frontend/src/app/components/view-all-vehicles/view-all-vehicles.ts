import { ChangeDetectorRef, Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { VehicleService } from '../../services/vehicle.service';
import { Vehicle } from '../../models/vehicle';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-view-all-vehicles',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './view-all-vehicles.html',
  styleUrl: './view-all-vehicles.css',
})
export class ViewAllVehicles {
  vehicles: Vehicle[] = [];

  constructor(private vehicleService: VehicleService, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.vehicleService.getAllVehicles().subscribe(data => {
      this.vehicles = data;
      this.cdr.detectChanges();
    })
  }
}
