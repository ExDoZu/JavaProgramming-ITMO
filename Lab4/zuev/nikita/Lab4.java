package zuev.nikita;

import zuev.nikita.creature.*;
import zuev.nikita.transport.*;

public class Lab4 {
    public static void main(String[] args) {
        Human ponchik = new Human("Пончик", 13, Gender.MALE, 160, 80, Profession.ASTRONAUT);
        Human neznayka = new Human("Незнайка", 13, Gender.OTHER, 165, 60, Profession.ASTRONAUTPILOT);
        Spaceship spaceship = new Spaceship("ДоЛуныИОбратно", 1000);
        Acceleration acceleration = new Acceleration() {
            @Override
            public void pressUp(LivingBeing someone, String target) {
                System.out.println("Инерция прижала " + someone.getName() + " к " + target);
            }
        };
        System.out.println("На корабле "+ new Human.PeopleCounter().getCountOfPeople()+" человека");


        ponchik.sleep(3600);
        neznayka.sleep(3600);
        spaceship.setSpeed(1000);
        while (ponchik.isSleeping()) {
            ponchik.sleep();
            neznayka.sleep();
        }

        System.out.println("Few moments later...");

        ponchik.see(",как все это угрожающе висело над головой и было уже так близко, что  казалось, стоит только протянуть  руку,  и  можно  потрогать  верхушку  какой-нибудь лунной горы");
        ponchik.pushOff("иллюминатор");

        ponchik.say("Ну ее! Не хочу я смотреть на эту Луну!");
        neznayka.say("Почему?");
        ponchik.say("А зачем она висит прямо над головой? Еще упадет на нас сверху!");
        neznayka.say("Чудак! Это не Луна на нас упадет, а мы на нее.");
        ponchik.say("Как же мы можем на нее упасть, если мы снизу, а Луна сверху?");
        neznayka.say("Ну, понимаешь, - объяснил Незнайка, - Луна просто притянет нас.");
        ponchik.say("Значит, мы вроде как  бы  прицепимся  к  Луне  снизу?");

        neznayka.say("Вот-вот. Вроде как бы прицепимся.");
        ponchik.say("Ничего себе дельце! - воскликнул Пончик. - Значит, когда мы вылезем из ракеты, то будем ходить по Луне вверх ногами?");
        neznayka.say("Это зачем же еще? - удивился Незнайка.");
        ponchik.say("А как же иначе? - ответил Пончик. - Если мы снизу, а  Луна  сверху, то хочешь не хочешь, а придется переворачиваться вверх тормашками.");
        neznayka.say("Гм! - ответил  в  раздумье  Незнайка.  -  Кажется,  на  самом  деле получается что-то не совсем то, что надо!");

        neznayka.think("");
        neznayka.notice(", что не слышит привычного шума двигателя.");

        neznayka.say("Постой-ка. Ты слышишь что-нибудь?");
        ponchik.say("А что я должен слышать, по-твоему?");
        neznayka.say("Шум реактивного двигателя.");

        ponchik.keepEarsOpen();

        ponchik.say("По-моему, нет никакого шума.");
        neznayka.say("Вот те на! Неужели  двигатель  испортился? Долетели почти до самой Луны, и вдруг такая досада!");


        //-------------------------------

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
            try {
                if (!ponchik.isLookingOut()) {
                    if (ponchik.checkSpeed(spaceship) > 0) {
                        System.out.println("Корабль движется");
                    } else {
                        System.out.println("Корабль не движется");
                    }
                } else {
                    System.out.println("Не удалось определить: стоит корабль или нет.");
                }

            } catch (NotProfessionalException e) {
                System.out.println("Не удалось определить: стоит корабль или нет.");
            }

            spaceship.setActivatedDeviceStatus(Device.TURN_ENGINE, true);
            spaceship.rotate(true);
            System.out.println("Незнайка и пончик увидели в иллюминаторе Луну");
            neznayka.lookOutThePorthole();
            ponchik.lookOutThePorthole();
        }

        //----------
        neznayka.imagineStupidThings(", что произошло столкновение  ракеты  с  Луной.");
        ponchik.imagineStupidThings(", что произошло столкновение  ракеты  с  Луной.");
        neznayka.screech();
        ponchik.screech();
        acceleration.pressUp(neznayka, "стенка кабины");
        acceleration.pressUp(ponchik, "стенка кабины");

        ponchik.lookOutThePorthole(1);
        neznayka.lookOutThePorthole(1);
        ponchik.see("увидел,  как  в боковых  иллюминаторах  промелькнула  светящаяся   поверхность   Луны   и, качнувшись еще раз словно на волнах, ухнула куда-то вниз вместе  со  всеми горными цепями, лунными морями, кратерами и ущельями.");
        neznayka.see("увидел,  как  в боковых  иллюминаторах  промелькнула  светящаяся   поверхность   Луны   и, качнувшись еще раз словно на волнах, ухнула куда-то вниз вместе  со  всеми горными цепями, лунными морями, кратерами и ущельями.");

        ponchik.lookOutThePorthole();
        neznayka.lookOutThePorthole();
        ponchik.shakeHead(true);
        try {
            ponchik.closeEyesByHands();
            ponchik.openEyes();
        }catch(ImpossibleMoveException e){
            System.out.println(e.getMessage());
            ponchik.openEyes();
        }
        ponchik.see(", что  на  небе  никакой  Луны  уже  не  было.  Со  всех  сторон  в иллюминаторах сверкали лишь яркие звездочки.");
        ponchik.imagineStupidThings(", что ракета, врезавшись в Луну,  расколотила  ее  на  кусочки,  которые  разлетелись  в стороны и превратились в звезды.");
    }
}

