package zuev.nikita.creature;

import zuev.nikita.transport.DrivingTransportInterface;

interface DrivingMoves {
    double checkSpeed(DrivingTransportInterface transport) throws NotProfessionalException;
}
