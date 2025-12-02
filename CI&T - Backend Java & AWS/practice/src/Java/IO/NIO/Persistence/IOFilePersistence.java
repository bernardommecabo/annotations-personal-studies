package Java.IO.NIO.Persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class IOFilePersistence implements FilePersistence{
    private  final String currentPath = System.getProperty("user.dir");
    private  final String storedPath = "\\practice\\src\\Java\\IO\\NIO\\Persistence\\IO\\";
    private  final String fileName;

    public IOFilePersistence(String fileName) throws IOException {
        this.fileName = fileName;
        var file = new File(currentPath + fileName);
        if (!file.exists() && !file.mkdirs()){
            throw new IOException("Erro ao criar arquivo");
        }
        clearFile();
    }

    @Override
    public String write(String data) {
        try (
            var fileWriter = new FileWriter(currentPath + storedPath + fileName, true);
            var bufferedWriter = new BufferedWriter(fileWriter);
        ){
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @Override
    public boolean remove(String data) {
        var content = findAll();
        var contentList = new ArrayList<>(Arrays.asList(content.split(System.lineSeparator())));
         if (contentList.stream().noneMatch(c -> c.contains(data))) return false;

         contentList.stream()
                 .filter(c -> c.contains(data))
                 .forEach(this :: write);
        return true;
    }

    @Override
    public String replace(String dataOld, String dataNew) {
        var content = findAll();
        var contentList = new ArrayList<>(Arrays.asList(content.split(System.lineSeparator())));
        if (contentList.stream().noneMatch(c -> c.contains(dataOld))) return " ";

        clearFile();
        contentList.stream()
                .map(c -> !c.contains(dataOld) ? dataNew : c)
                .forEach(this :: write);

        return "";
    }

    @Override
    public String findAll() {
        var content  = new StringBuilder();
        try(var reader = new BufferedReader(new FileReader(currentPath + storedPath + fileName))){
            String line;
            do{
                line = reader.readLine();
                if((line != null)) {
                    content.append(line)
                            .append(System.lineSeparator());
                }
            }while(line != null);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return content.toString();
    }

    @Override
    public String findBy(String data) {
        String found = "";
        try(var reader = new BufferedReader(new FileReader(currentPath + storedPath + fileName))){
            String line = reader.readLine();
            while(line != null){
                if ((line.contains(data))){
                    found = line;
                    break;
                }
                line = reader.readLine();
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return found;
    }

    private void clearFile(){
        try (OutputStream outputStream = new FileOutputStream(currentPath + storedPath + fileName)){
            System.out.printf("Inicializando recursos (%s) \n", currentPath + storedPath + fileName);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
