import { Injectable } from '@angular/core';
import { Vehicle } from '../models/vehicle';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { VehicleDTO } from '../models/VehicleDTO';

@Injectable({
  providedIn: 'root',
})
export class VehicleService {
  private apiUrl = 'http://localhost:8080/vehicle';

  constructor(private httpClient: HttpClient) {}

  getAllVehicles(): Observable<Vehicle[]> {
    return this.httpClient.get<Vehicle[]>(this.apiUrl);
  }

  addVehicle(vehicle: VehicleDTO): void {
    this.httpClient.post(this.apiUrl, vehicle)
      .subscribe({
        next: (response) => {
          console.log('Vehicle added:', response);
          alert('Vehicle added');
        },
        error: (err) => console.error('Error adding Vehicle:', err)
      });
  }

  getVehicle(vinNumber: String): Observable<VehicleDTO> {
    return this.httpClient.get<VehicleDTO>(`${this.apiUrl}/${vinNumber}`);
  }

  saveVehicle(vehicle: VehicleDTO, vinNumber: String | null) {
    return this.httpClient.put(`${this.apiUrl}/${vinNumber}`, vehicle);
  }

  deleteVehicle(vinNumber: String) {
    return this.httpClient.delete(`${this.apiUrl}/${vinNumber}`);
  }
}