package AWS.Service.Matcher;

import java.util.*;

public class ServiceMatcher {
    public void AWSserviceMatcher(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.toLowerCase();

        Map<String, List<String>> services = new LinkedHashMap<>();
        services.put("EC2", Arrays.asList("servidor para rodar aplicacoes","aplicacoes"));
        services.put("S3", Arrays.asList("armazenar","imagens", "videos"));
        services.put("RDS", Arrays.asList("banco","relacional"));
        services.put("Lambda", Arrays.asList("funcoes","sem servidor"));
        services.put("Servico desconhecido",  Arrays.asList("inteligencia artificial","artificial"));

        String finalSolicitacao = input;
        String result = services.entrySet().stream()
                .filter(entry -> entry.getValue().stream().anyMatch(finalSolicitacao::contains))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("Servico desconhecido");

        System.out.println(result);
    }
}
