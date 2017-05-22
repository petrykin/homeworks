package lesson11.task2;

public class DressMakingStudio {
    public void dressMale(Clothes[] clothes) {
        System.out.println("Мужская одежда (в наличии):");
        for (Clothes clothe : clothes) {
            if (clothe instanceof IMaleClothes) {
                System.out.println(clothe);
            }
        }
    }

    public void dressFemale(Clothes[] clothes) {
        System.out.println("Женская одежда (в наличии):");
        for (Clothes clothe : clothes) {
            if (clothe instanceof IFemaleClothes) {
                System.out.println(clothe);
            }
        }
    }
}
