package lesson11.task2;

public class Demo {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new TeeShirt(Sizes.XS, "темно-серый", 350),
                new TeeShirt(Sizes.L, "черный", 250),
                new Trousers(Sizes.M, "голубой", 500),
                new Trousers(Sizes.XXS, "синий", 225),
                new Skirt(Sizes.S, "розовый", 400),
                new Skirt(Sizes.M, "красный", 520),
                new Tie(Sizes.L, "синий", 300),
                new Tie(Sizes.L, "красный", 280),
        };

        DressMakingStudio studio = new DressMakingStudio();
        studio.dressMale(clothes);
        System.out.println();
        studio.dressFemale(clothes);
    }
}
