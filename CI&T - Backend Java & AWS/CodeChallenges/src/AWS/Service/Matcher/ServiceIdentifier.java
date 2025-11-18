package AWS.Service.Matcher;

import java.util.ArrayList;
import java.util.List;

public class ServiceIdentifier {
    public void identifier(String input){
        List<String> services = new ArrayList<>();
        services.add("EC2");
        services.add("S3");
        services.add("Lambda");

        if (!services.contains(input)) {
            System.out.println("Codigo invalido");
        }else
            System.out.println(input);
    }
}
