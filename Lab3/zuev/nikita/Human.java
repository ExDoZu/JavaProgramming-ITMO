package zuev.nikita;

class Human extends LivingBeing implements EngineeringMoves, DrivingMoves {
    private Profession profession;

    Human(String name, int age, Gender gender, int height, int weight, Profession profession) {
        super(name, age, gender, height, weight);
        setProfession(profession);
    }

    Profession getProfession() {
        return profession;
    }

    void setProfession(Profession profession) {
        this.profession = profession;
    }

    @Override
    public boolean checkServiceableDevice(EngineeringTransportInterface engineeringTransportInterface, Device device) {
        return engineeringTransportInterface.getServiceableDeviceStatus(device);
    }

    @Override
    public void repairDevice(EngineeringTransportInterface engineeringTransportInterface, Device device) {
        engineeringTransportInterface.setServiceableDeviceStatus(device, true);
    }

    @Override
    public boolean checkActivatedDeviceStatus(EngineeringTransportInterface engineeringTransportInterface, Device device) {
        return engineeringTransportInterface.getActivatedDeviceStatus(device);
    }

    @Override
    public void changeActivatedDeviceStatus(EngineeringTransportInterface engineeringTransportInterface, Device device, Boolean status) {
        engineeringTransportInterface.setActivatedDeviceStatus(device, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Human a = (Human) obj;
        return getName().equals(a.getName()) && getAge() == a.getAge() && getGender() == a.getGender() &&
                getHeight() == a.getHeight() && getWeight() == a.getWeight() && getProfession() == a.getProfession();
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int hashCode() {
        return getName().hashCode() + getWeight() + getHeight() + getAge() + getGender().hashCode() + (isLookingOut() ? 1 : 0) + (isSleeping() ? 1 : 0);
    }

    @Override
    public double checkSpeed(DrivingTransportInterface transport) {
        System.out.println(getName()+" проверяет скорость транспорта");
        return transport.getSpeed();
    }
}
