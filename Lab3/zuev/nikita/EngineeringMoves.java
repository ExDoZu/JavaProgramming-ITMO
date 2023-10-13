package zuev.nikita;

interface EngineeringMoves {
    boolean checkServiceableDevice(EngineeringTransportInterface engineeringTransportInterface, Device device);

    void repairDevice(EngineeringTransportInterface engineeringTransportInterface, Device device);

    boolean checkActivatedDeviceStatus(EngineeringTransportInterface engineeringTransportInterface, Device device);

    void changeActivatedDeviceStatus(EngineeringTransportInterface engineeringTransportInterface, Device device, Boolean status);
}
