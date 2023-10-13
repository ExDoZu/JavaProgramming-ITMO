package zuev.nikita;

interface EngineeringTransportInterface {
    void setServiceableDeviceStatus(Device device, Boolean status);

    boolean getServiceableDeviceStatus(Device device);

    void setActivatedDeviceStatus(Device device, Boolean status);

    boolean getActivatedDeviceStatus(Device device);
}
