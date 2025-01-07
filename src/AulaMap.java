import java.util.*;
public class AulaMap {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Solicitar os nomes separados por vírgula
            System.out.println("Digite os nomes, separados por vírgula (ex: Marcus, Ana, Bruno):");
            String input = scanner.nextLine();

            // Dividir os nomes usando a vírgula
            String[] namesArray = input.split(",");

            // Map para armazenar os nomes por gênero
            Map<String, List<String>> genderMap = new HashMap<>();
            genderMap.put("Masculino", new ArrayList<>());
            genderMap.put("Feminino", new ArrayList<>());

            // Perguntar o sexo de cada nome e armazenar no Map
            for (String name : namesArray) {
                // Limpar espaços em branco ao redor do nome
                name = name.trim();

                String gender = "";
                while (true) {
                    System.out.println("Qual o sexo do " + name + "? (Masculino/Feminino):");
                    gender = scanner.nextLine().trim();

                    // Validação do sexo
                    if (gender.equalsIgnoreCase("Masculino") || gender.equalsIgnoreCase("Feminino")) {
                        break; // Sai do loop se a entrada for válida
                    } else {
                        System.out.println("Entrada inválida! Por favor, digite 'Masculino' ou 'Feminino'.");
                    }
                }

                // Adicionar o nome ao grupo correspondente
                genderMap.get(gender).add(name);
            }

            // Ordenar os nomes dentro de cada grupo
            for (List<String> names : genderMap.values()) {
                Collections.sort(names);
            }

            // Exibir os nomes organizados por gênero
            System.out.println("\nNomes por gênero:");
            for (Map.Entry<String, List<String>> entry : genderMap.entrySet()) {
                System.out.println(entry.getKey() + ":");
                for (String name : entry.getValue()) {
                    System.out.println(name);
                }
            }

            // Exibir todos os nomes em ordem alfabética
            System.out.println("\nNomes em ordem alfabética:");
            List<String> allNames = new ArrayList<>();
            for (List<String> names : genderMap.values()) {
                allNames.addAll(names);
            }
            Collections.sort(allNames);
            for (String name : allNames) {
                System.out.println(name);
            }

            scanner.close();
        }
    }


