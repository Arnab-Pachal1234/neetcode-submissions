interface Vehicle {
    String getType();
}

class Car implements Vehicle {
    @Override
    public String getType() {
        return "Car";
    }
}

class Bike implements Vehicle {
    @Override
    public String getType() {
        return "Bike";
    }
}

class Truck implements Vehicle {
    @Override
    public String getType() {
        return "Truck";
    }
}

abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        Car curr = new Car();
        return curr;
    }
}

class BikeFactory extends VehicleFactory {
     @Override
    public Vehicle createVehicle() {
        Bike curr = new Bike();
        return curr;
    }
}

class TruckFactory extends VehicleFactory {
     @Override
    public Vehicle createVehicle() {
        Truck curr = new Truck();
        return curr;
    }
}
