package zuev.nikita.transport;

import java.util.HashMap;
import java.util.Map;

public class Spaceship implements EngineeringTransportInterface, DrivingTransportInterface, ExtraTranportMoves {
    private final Map<Device, Boolean> serviceableDevices;
    /**
     * true - turned on for things those can be turned on, opened for things those can be opened
     */
    private final Map<Device, Boolean> activatedDevices;
    private final String name;
    private double speed;
    private final double MAX_SPEED;
    private boolean rotation;

    @Override
    public void rotate(boolean status) {
        rotation =status;
    }

    @Override
    public boolean rotationStatus() {
        return rotation;
    }

    class ElectronicControlMachine{
        void turnOffEngine(){
            activatedDevices.put(Device.ENGINE, false);
            activatedDevices.put(Device.TURN_ENGINE, false);
        }
    }
    public Spaceship(String name, double maxSpeed) {
        serviceableDevices = new HashMap<>();
        activatedDevices = new HashMap<>();

        Device[] devices = Device.values();
        for (Device device : devices) {
            serviceableDevices.put(device, true);
        }
        for (Device device : devices) {
            activatedDevices.put(device, false);
        }
        this.name = name;
        this.MAX_SPEED = maxSpeed;
    }

    @Override
    public void setServiceableDeviceStatus(Device device, Boolean status) {
        serviceableDevices.put(device, status);
    }

    @Override
    public boolean getServiceableDeviceStatus(Device device) {
        return serviceableDevices.get(device);
    }

    @Override
    public void setActivatedDeviceStatus(Device device, Boolean status) {
        activatedDevices.put(device, status);
        if ((device == Device.ENGINE || device == Device.TURN_ENGINE) && status) {
            System.out.println("Чаф-чаф-чаф-чаф!");
        }
    }

    @Override
    public boolean getActivatedDeviceStatus(Device device) {
        return activatedDevices.get(device);
    }

    @Override
    public String toString() {
        return "Корабль " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spaceship spaceship = (Spaceship) o;

        return serviceableDevices.equals(spaceship.serviceableDevices) &&
                activatedDevices.equals(spaceship.activatedDevices) &&
                speed == spaceship.speed && MAX_SPEED == spaceship.MAX_SPEED && name.equals(spaceship.name);
    }

    @Override
    public int hashCode() {
        return serviceableDevices.hashCode() + activatedDevices.hashCode() +
                name.hashCode() + (int) speed + (int) MAX_SPEED;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
        if (this.speed >= MAX_SPEED) {
            new ElectronicControlMachine().turnOffEngine();
        }
    }
}
