package zuev.nikita.creature;

import zuev.nikita.transport.EngineeringTransportInterface;
import zuev.nikita.transport.Device;

interface EngineeringMoves {
    boolean checkServiceableDevice(EngineeringTransportInterface engineeringTransportInterface, Device device);

    void repairDevice(EngineeringTransportInterface engineeringTransportInterface, Device device);

    boolean checkActivatedDeviceStatus(EngineeringTransportInterface engineeringTransportInterface, Device device);

    void changeActivatedDeviceStatus(EngineeringTransportInterface engineeringTransportInterface, Device device, Boolean status);
}
