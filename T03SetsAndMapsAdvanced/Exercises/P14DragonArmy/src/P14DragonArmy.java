import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P14DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfDragonRecords = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, DragonStats>> allDragons = new LinkedHashMap<>();

        for (int record = 0; record < numberOfDragonRecords; record++) {
            String[] dragonData = scanner.nextLine().split("\\s+");
            String typeOfDragon = dragonData[0];
            String nameOfDragon = dragonData[1];
            String damageOfDragon = dragonData[2];
            String healthOfDragon = dragonData[3];
            String armorOfDragon = dragonData[4];
            allDragons.putIfAbsent(typeOfDragon, new TreeMap<>());
            Map<String, DragonStats> allDragonsFromCurrentType = allDragons.get(typeOfDragon);
            allDragonsFromCurrentType.put(nameOfDragon, new DragonStats(nameOfDragon));
            DragonStats currentDragon = allDragonsFromCurrentType.get(nameOfDragon);

            if (!damageOfDragon.equals("null")) {
                currentDragon.setDamage(Integer.parseInt(damageOfDragon));
            }

            if (!healthOfDragon.equals("null")) {
                currentDragon.setHealth(Integer.parseInt(healthOfDragon));
            }

            if (!armorOfDragon.equals("null")) {
                currentDragon.setArmour(Integer.parseInt(armorOfDragon));
            }
        }

        for (Map.Entry<String, Map<String, DragonStats>> dragonsByType : allDragons.entrySet()) {
            double averageDamage = dragonsByType.getValue().values()
                    .stream()
                    .mapToInt(DragonStats::getDamage)
                    .average().orElse(0);
            double averageHealth = dragonsByType.getValue().values()
                    .stream()
                    .mapToInt(DragonStats::getHealth)
                    .average().orElse(0);
            double averageArmor = dragonsByType.getValue().values()
                    .stream()
                    .mapToInt(DragonStats::getArmour)
                    .average().orElse(0);
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", dragonsByType.getKey(), averageDamage, averageHealth, averageArmor);
            dragonsByType.getValue().values()
                    .forEach(System.out::println);
        }
    }

    private static class DragonStats {
        private final String name;
        private int damage;
        private int health;
        private int armour;

        public DragonStats(String name) {
            this.name = name;
            this.damage = 45;
            this.health = 250;
            this.armour = 10;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getArmour() {
            return armour;
        }

        public void setArmour(int armour) {
            this.armour = armour;
        }

        @Override
        public String toString() {
            return String.format("-%s -> damage: %d, health: %d, armor: %d",
                    this.name, this.damage, this.health, this.armour);
        }
    }
}
