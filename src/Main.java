import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar os nomes separados por vírgula
        System.out.println("Digite os nomes, separados por vírgula (ex: Marcus, Ana, Bruno):");
        String input = scanner.nextLine();

        // Dividir os nomes usando a vírgula
        String[] namesArray = input.split(",");

        // Lista para armazenar os pares Nome:Sexo
        List<String> pairsList = new ArrayList<>();

        // Perguntar o sexo de cada nome
        for (String name : namesArray) {
            // Limpar espaços em branco ao redor do nome
            name = name.trim();

            // Variável para controlar a validação do sexo
            String gender = "";
            while (true) {
                System.out.println("Qual sexo do " + name + "? (Masculino/Feminino):");
                gender = scanner.nextLine().trim();

                // Validação do sexo
                if (gender.equalsIgnoreCase("Masculino") || gender.equalsIgnoreCase("Feminino")) {
                    break;  // Sai do loop se a entrada for válida
                } else {
                    System.out.println("Entrada inválida! Por favor, digite 'Masculino' ou 'Feminino'.");
                }
            }

            // Adicionar o par "Nome:Sexo" à lista
            pairsList.add(name + ":" + gender);
        }

        // Ordenar a lista com base no par "Nome:Sexo"
        Collections.sort(pairsList);

        // Exibir todos os nomes em ordem alfabética
        System.out.println("\nNomes em ordem alfabética:");
        List<String> allNames = new ArrayList<>();
        for (String pair : pairsList) {
            String[] parts = pair.split(":");
            allNames.add(parts[0]);
        }
        Collections.sort(allNames);
        for (String name : allNames) {
            System.out.println(name);
        }

        // Estrutura para armazenar os nomes por gênero
        Map<String, List<String>> genderGroups = new HashMap<>();
        genderGroups.put("Masculino", new ArrayList<>());
        genderGroups.put("Feminino", new ArrayList<>());

        // Organizar os nomes nos grupos de gênero
        for (String pair : pairsList) {
            String[] parts = pair.split(":");
            String name = parts[0];
            String gender = parts[1];

            // Adicionar o nome no grupo correspondente
            if (gender.equalsIgnoreCase("Masculino")) {
                genderGroups.get("Masculino").add(name);
            } else if (gender.equalsIgnoreCase("Feminino")) {
                genderGroups.get("Feminino").add(name);
            }
        }

        // Ordenar os nomes dentro de cada grupo
        for (List<String> names : genderGroups.values()) {
            Collections.sort(names);
        }

        // Exibir os nomes organizados por gênero
        System.out.println("\nNomes por gênero:");
        for (String gender : genderGroups.keySet()) {
            System.out.println(gender + ":");
            for (String name : genderGroups.get(gender)) {
                System.out.println(name);
            }
        }

        scanner.close();
    }
}
