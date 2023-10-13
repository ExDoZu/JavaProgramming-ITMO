package zuev.nikita.creature;

public abstract class LivingBeing implements RelaxMoves, BaseLivingBeingInterface, EmotionMoves, NaturalMoves {
    private final String name;
    private int age;
    private int height;
    private int weight;
    private final Gender gender;
    private int timeToSleep;
    private int timeToLookingOut;

    public LivingBeing(String name, int age, Gender gender, int height, int weight) {
        this.name= name;
        setAge(age);
        setHeight(height);
        setWeight(weight);
        this.gender = gender;
        timeToSleep = 0;
        timeToLookingOut = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void sleep(int seconds) {
        timeToSleep = seconds;
        System.out.printf("%s спит. Проснется через %d минут.\n", name, timeToSleep / 60);
    }

    @Override
    public void lookOutThePorthole(int seconds) {
        timeToLookingOut = seconds;
        System.out.printf("%s смотрит в иллюминатор и будет продолжать заниматься этим %d минут.\n", name, timeToLookingOut / 60);
    }

    @Override
    public boolean isSleeping() {
        return timeToSleep > 0;
    }

    @Override
    public void rejoice() {
        System.out.printf("%s обрадовался.\n", name);
    }

    @Override
    public void lookOutThePorthole() {
        timeToLookingOut--;
    }

    @Override
    public void sleep() {
        timeToSleep--;
        if (timeToSleep == 0) {
            System.out.println(name + " проснулся.");
        }
    }

    @Override
    public boolean isLookingOut() {
        return timeToLookingOut > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LivingBeing a = (LivingBeing) o;

        return getName().equals(a.getName()) && getAge() == a.getAge() && getGender() == a.getGender() && getHeight() == a.getHeight() &&
                getWeight() == a.getWeight();
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age + height + weight + gender.hashCode() + (isLookingOut() ? 1 : 0) + (isSleeping() ? 1 : 0);
    }

    @Override
    public String toString() {
        return "Живое существо по имени " + name;
    }
}
