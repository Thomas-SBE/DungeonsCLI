package tsbe.multiversal.common;

public class Stats {

    public int strength = 0;
    public int health = 0;
    public int luck = 0;

    public Stats() { }
    public Stats(Stats s) {
        luck = s.luck;
        strength = s.strength;
        health = s.health;
    }
}
