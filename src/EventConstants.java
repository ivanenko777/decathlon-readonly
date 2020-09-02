public enum EventConstants {
    FIRST_EVENT("100 m", "Seconds", 25.4347f, 18f, 1.81f),
    SECOND_EVENT("Long jump", "Metres", 90.5674f, 2.2f, 1.4f),
    THIRD_EVENT("Shot put", "Metres", 51.39f, 1.5f, 1.05f),
    FOUTRH_EVENT("High jump", "Metres", 585.64f, 0.75f, 1.42f),
    FIFTH_EVENT("400 m", "Seconds", 1.53775f, 82f, 1.81f),
    SIXTH_EVENT("110 m hurdles", "Seconds", 5.74352f, 28.5f, 1.92f),
    SEVENTH_EVENT("Discus throw", "Metres", 12.91f, 4f, 1.1f),
    EIGHTH_EVENT("Pole vault", "Metres", 140.182f, 1f, 1.35f),
    NINTH_EVENT("Javelin throw", "Metres", 10.14f, 7f, 1.08f),
    TENTH_EVENT("1500 m", "Minutes:Seconds", 0.03768f, 480f, 1.85f);

    private final String name;
    private final String units;
    private final float a;
    private final float b;
    private final float c;

    EventConstants(String name, String units, float a, float b, float c) {
        this.name = name;
        this.units = units;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getName() {
        return name;
    }

    public String getUnits() {
        return units;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public float getC() {
        return c;
    }
}
