import ru.ifmo.se.pokemon.*;

public class LabTwo {
    public static void main(String[] args) {
        Battle b = new Battle();

        Minun p1 = new Minun("Максим", 10);
        Sandygast p2 = new Sandygast("Настя", 10);
        Palossand p3 = new Palossand("Антон", 5);
        Pidove p4 = new Pidove("Раиль", 5);
        Tranquill p5 = new Tranquill("Приходько", 5);
        Unfezant p6 = new Unfezant("Поляков", 5);

        b.addAlly(p1);
        b.addAlly(p3);
        b.addAlly(p5);
        b.addFoe(p2);
        b.addFoe(p4);
        b.addFoe(p6);

        b.go();

    }
}

class Minun extends Pokemon {
    Minun(String name, int level) {
        super(name, level);
        setType(Type.ELECTRIC);
        setStats(60, 40, 50, 75, 85, 95);
        setMove(new MegaDrain(), new Confide(), new Growth(), new SwordsDance());
    }
}

class Sandygast extends Pokemon {
    Sandygast(String name, int level) {
        super(name, level);
        setType(Type.GHOST, Type.GROUND);
        setStats(55, 55, 80, 70, 45, 15);
        setMove(new ShadowBall(), new Rest(), new Snarl());
    }
}

class Palossand extends Sandygast {
    Palossand(String name, int level) {
        super(name, level);
        setStats(85, 75, 110, 100, 75, 35);
        addMove(new Bulldoze());
    }
}

class Pidove extends Pokemon {
    Pidove(String name, int level) {
        super(name, level);
        setType(Type.NORMAL, Type.FLYING);
        setStats(50, 55, 50, 36, 30, 43);
        setMove(new DoubleTeam(), new ThunderWave());
    }
}

class Tranquill extends Pidove {
    Tranquill(String name, int level) {
        super(name, level);
        setStats(62, 77, 62, 50, 42, 65);
        addMove(new FocusBlast());
    }
}

class Unfezant extends Tranquill {
    Unfezant(String name, int level) {
        super(name, level);
        setStats(80, 115, 80, 65, 55, 93);
        addMove(new DazzlingGleam());

    }
}

class Confide extends StatusMove {
    Confide() {
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect.confuse(pokemon);
    }

    @Override
    protected String describe() {
        return "вызывает у противника растерянность";
    }
}

class Growth extends StatusMove {
    Growth() {
        super(Type.NORMAL, 0, 100);

    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.ATTACK, 1);
        pokemon.setMod(Stat.SPECIAL_ATTACK, 1);

    }

    @Override
    protected String describe() {
        return "используя Growth, увеличивает силу атаки и спец. атаки на 1 пункт.";
    }
}

class SwordsDance extends StatusMove {
    SwordsDance() {
        super(Type.NORMAL, 0, 100);

    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.ATTACK, 2);
    }

    @Override
    protected String describe() {
        return "использует Sword Dance, увеличивая силу атаки на 2 пункта.";
    }
}

class MegaDrain extends SpecialMove {
    MegaDrain() {
        super(Type.GRASS, 40, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.HP, -(int) ((pokemon.getStat(Stat.HP) - pokemon.getHP()) / 2.0));
    }

    @Override
    protected String describe() {
        return "использует Mega Drain: наносит урон и восстанавливает до 50% от потерянного здоровья";
    }
}


class ShadowBall extends SpecialMove {
    ShadowBall() {
        super(Type.GHOST, 80, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect effect = new Effect().chance(0.2).turns(1).stat(Stat.SPECIAL_DEFENSE, -1);
        pokemon.addEffect(effect);
    }

    @Override
    protected String describe() {
        return "наносит урон, применяя Shadow Ball, имеет 20% шанс снизить спец. защиту врага на 1 пункт";
    }
}

class Rest extends StatusMove {
    Rest() {
        super(Type.PSYCHIC, 0, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        Effect.sleep(pokemon);
        pokemon.setMod(Stat.HP, -(int) (pokemon.getStat(Stat.HP) - pokemon.getHP()));
    }

    @Override
    protected String describe() {
        return "применяет Rest";
    }
}

class Snarl extends SpecialMove {
    Snarl() {
        super(Type.DARK, 55, 95);

    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.SPECIAL_ATTACK, -1);
    }

    @Override
    protected String describe() {
        return "применяет Snarl, нанося урон и понижая спец. атаку противника на 1 пункт";
    }
}

class Bulldoze extends PhysicalMove {
    Bulldoze() {
        super(Type.GROUND, 60, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.SPEED, -1);
    }

    @Override
    protected String describe() {
        return "применяет Bulldoze, нанося урон и снижая скорость противника на 1 пункт";
    }
}

class DoubleTeam extends StatusMove {
    DoubleTeam() {
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.EVASION, 1);
    }

    @Override
    protected String describe() {
        return "использует Double Team и увеличивает ловкость на 1 пункт";
    }
}

class ThunderWave extends StatusMove {
    ThunderWave() {
        super(Type.ELECTRIC, 0, 90);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect.paralyze(pokemon);
        pokemon.setMod(Stat.SPEED, -1);
    }

    @Override
    protected String describe() {
        return "применяет Thunder Wave, парализуя противника и снижая его скорость";
    }
}

class FocusBlast extends SpecialMove {
    FocusBlast() {
        super(Type.FIGHTING, 120, 70);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect effect = new Effect().chance(0.1).turns(1).stat(Stat.SPECIAL_DEFENSE, -1);

        pokemon.addEffect(effect);

    }

    @Override
    protected String describe() {
        return "применяет Focus Blast, нанося урон, а также с вероятностью 10% снижает спец. защиту противника";
    }
}

class DazzlingGleam extends SpecialMove {
    DazzlingGleam() {
        super(Type.FAIRY, 80, 100);
    }

    @Override
    protected String describe() {
        return "наносит урон, используя Dazzling Gleam";
    }
}