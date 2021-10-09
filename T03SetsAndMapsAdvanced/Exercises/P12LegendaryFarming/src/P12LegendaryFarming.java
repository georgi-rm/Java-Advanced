import java.util.*;

public class P12LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new LinkedHashMap<>();
        Map<String, Integer> junk = new LinkedHashMap<>();

        materials.put("shards", 0);
        materials.put("motes", 0);
        materials.put("fragments", 0);

        boolean isShadowmourneObtained = false;
        boolean isValanyrObtained = false;
        boolean isDragonwrathObtained = false;


        while (!isShadowmourneObtained && !isValanyrObtained && !isDragonwrathObtained) {
            String[] commandData = scanner.nextLine().split("\\s+");
            int quantity;
            for (int i = 0; i < commandData.length; i += 2) {
                String material = commandData[i + 1];

                material = material.toLowerCase();

                quantity = Integer.parseInt(commandData[i]);

                switch (material) {
                    case "shards":
                        quantity += materials.get(material);
                        if (quantity >= 250) {
                            isShadowmourneObtained = true;
                            quantity -= 250;
                        }
                        materials.put(material, quantity);
                        break;
                    case "fragments":
                        quantity += materials.get(material);
                        if (quantity >= 250) {
                            isValanyrObtained = true;
                            quantity -= 250;
                        }
                        materials.put(material, quantity);
                        break;
                    case "motes":
                        quantity += materials.get(material);
                        if (quantity >= 250) {
                            isDragonwrathObtained = true;
                            quantity -= 250;
                        }
                        materials.put(material, quantity);
                        break;
                    default:
                        junk.putIfAbsent(material, 0);
                        quantity += junk.get(material);
                        junk.put(material, quantity);
                        break;
                }
                if (isShadowmourneObtained || isValanyrObtained || isDragonwrathObtained) {
                    break;
                }
            }
        }

        if (isShadowmourneObtained) {
            System.out.println("Shadowmourne obtained!");
        } else if (isValanyrObtained) {
            System.out.println("Valanyr obtained!");
        } else {
            System.out.println("Dragonwrath obtained!");
        }

        materials.entrySet().stream()
                .sorted((e1, e2) -> {
                    if (e1.getValue() > e2.getValue()) {
                        return -1;
                    } else if (e1.getValue() < e2.getValue()) {
                        return 1;
                    } else {
                        return e1.getKey().compareTo(e2.getKey());
                    }

                })
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        junk.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

    }
}
