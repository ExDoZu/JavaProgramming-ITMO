package zuev.nikita.creature;

import zuev.nikita.transport.Device;
import zuev.nikita.transport.DrivingTransportInterface;
import zuev.nikita.transport.EngineeringTransportInterface;

public class Human extends LivingBeing implements EngineeringMoves, DrivingMoves, EyesMoves, NeznaykaTeamMoves, SelfMovingMoves {
    private Profession profession;
    private boolean openedEyes;
    private static int countOfPeople = 0;

    @Override
    public void screech() {
        System.out.println(getName() + " взвизгнул.");
    }

    @Override
    public void shakeHead(boolean updown) {
        class Shaker{
            private final boolean updown;
            Shaker(boolean updown){
                this.updown = updown;
            }
            void shake(){
                if (updown){
                    System.out.println(getName() + " потряс головой");
                }else{
                    System.out.println(getName() + " помотал головой");
                }
            }
        }
        new Shaker(updown).shake();
    }

    @Override
    public void closeEyesByHands() throws ImpossibleMoveException {
        if (openedEyes) {
            openedEyes = false;
            System.out.println(getName() + " закрыл глаза руками.");
        } else {
            throw new ImpossibleMoveException("А глаза итак закрыты!");
        }
    }

    @Override
    public boolean isClosedEyes() {
        return openedEyes;
    }

    @Override
    public void openEyes() throws ImpossibleMoveException {
        if (!openedEyes) {
            openedEyes = true;
            System.out.println(getName() + " открыл глаза.");
        } else {
            throw new ImpossibleMoveException("А глаза итак открыты!");
        }
    }

    @Override
    public void imagineStupidThings(String stupidThing) {
        System.out.println(getName() + " вообразил, что " + stupidThing);

    }

    @Override
    public void pushOff(String something) {
        System.out.println(getName() + " оттолкнулся от "+something);
    }

    @Override
    public void think(String something) {
        if (something.isEmpty()) {
            System.out.println(getName() + " задумался.");
        } else {
            System.out.println(getName() + " задумался о " + something);
        }
    }

    @Override
    public void notice(String something) {
        System.out.println(getName() + " обратил внимание на " + something);
    }

    @Override
    public void say(String something) {
        System.out.println(getName() + " сказал:\n- " + something);
    }

    @Override
    public void keepEarsOpen() {
        System.out.println(getName() + " прислушался.");
    }

    @Override
    public void see(String something) {
        System.out.println(getName() + " увидел " + something);
    }

    public static class PeopleCounter {
        private void setCountOfPeople(int count) {
            countOfPeople = count;
        }

        public int getCountOfPeople() {
            return countOfPeople;
        }

    }

    public Human(String name, int age, Gender gender, int height, int weight, Profession profession) {
        super(name, age, gender, height, weight);
        setProfession(profession);
        new PeopleCounter().setCountOfPeople(countOfPeople + 1);
        openedEyes=true;
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
    public double checkSpeed(DrivingTransportInterface transport) throws NotProfessionalException {
        if (profession == Profession.ASTRONAUT || profession == Profession.ASTRONAUTPILOT) {
            System.out.println(getName() + " проверяет скорость транспорта");
            return transport.getSpeed();
        } else {
            throw new NotProfessionalException(getName() + " не спец в космических короблях.");
        }

    }
}
