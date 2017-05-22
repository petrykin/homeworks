package lesson11.task2;

public enum Sizes {
    XXS(36) {
        @Override
        public String getDescription() {
            return "детский размер";
        }
    },
    XS(38),
    S(40),
    M(42),
    L(44);

    Sizes(int euroSize) {
        EuroSize = euroSize;
    }

    public String getDescription() {
        return "взрослый размер";
    }

    @Override
    public String toString() {
        return name() + "(" + EuroSize + ") " + getDescription();
    }

    private int EuroSize;
}
