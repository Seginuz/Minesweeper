enum DangerLevel {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    int levelNumber;

    DangerLevel(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    int getLevel() {
        return levelNumber;
    }
}