import { Routes } from '@angular/router';
import { Home } from './components/home/home';
import { AddVehicle } from './components/add-vehicle/add-vehicle';
import { ViewAllVehicles } from './components/view-all-vehicles/view-all-vehicles';
import { VehicleInfo } from './components/vehicle-info/vehicle-info';

export const routes: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' }, // default page
    { path: 'home', component: Home },

    { path: 'add-vehicle', component: AddVehicle },
    { path: 'view-all-vehicles', component: ViewAllVehicles }, 
    { path: 'vehicle/:vin', component: VehicleInfo },
];
