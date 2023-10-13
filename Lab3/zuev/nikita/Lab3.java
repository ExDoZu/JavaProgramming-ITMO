package zuev.nikita;

public class Lab3 {
    public static void main(String[] args) {
        Human ponchik = new Human("Пончик", 13, Gender.MALE, 160, 80, Profession.ASTRONAUT);
        Human neznayka = new Human("Незнайка", 13, Gender.OTHER, 165, 60, Profession.ASTRONAUTPILOT);
        Spaceship spaceship = new Spaceship("ДоЛуныИОбратно", 1000);

        ponchik.sleep(3600);
        neznayka.sleep(3600);
        spaceship.setSpeed(1000);
        while (ponchik.isSleeping()) {
            ponchik.sleep();
            neznayka.sleep();
        }

        if (!ponchik.checkActivatedDeviceStatus(spaceship, Device.ENGINE)) {
            System.out.println("Двигатель не работает!");
            ponchik.rejoice();

            if (ponchik.checkServiceableDevice(spaceship, Device.ENGINE)) {
                System.out.println("На самом деле двигатель не сломан, просто выключен.");
            } else {
                ponchik.repairDevice(spaceship, Device.ENGINE);
            }

            ponchik.changeActivatedDeviceStatus(spaceship, Device.PORTHOLE, true);
            neznayka.lookOutThePorthole(1);
            ponchik.lookOutThePorthole(1);

            if (!ponchik.isLookingOut()) {
                if (ponchik.checkSpeed(spaceship) > 0) {
                    System.out.println("Корабль движется");
                } else {
                    System.out.println("Корабль не движется");
                }
            } else {
                System.out.println("Не удалось определить: стоит корабль или нет.");
            }

            spaceship.setActivatedDeviceStatus(Device.ENGINE, true);
            System.out.println("Незнайка и пончик увидели в иллюминаторе Луну");
            neznayka.lookOutThePorthole();
            ponchik.lookOutThePorthole();
        }
    }
}

