package Java.IO.NIO.Persistence;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.stream.Stream;

public class NIOFilePersistence implements FilePersistence{

    private  final String currentPath = System.getProperty("user.dir");
    private  final String storedPath = "\\practice\\src\\Java\\IO\\NIO\\Persistence\\NIO\\";
    private  final String fileName;

    public NIOFilePersistence(String fileName) throws IOException {
        this.fileName = fileName;
        var file = new File(currentPath +storedPath);
        if(!file.exists() && !file.mkdirs())throw new IOException("Erro ao criar arquivo");
        clearFile();
    }
    @Override
    public String write(String data) {
        try(
                var file = new RandomAccessFile(new File(currentPath + storedPath + fileName),"rw");
        ){
            file.seek(file.length());
            file.writeBytes(data);
            file.writeBytes(System.lineSeparator());


        }catch(IOException exception){
            exception.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean remove(String data) {
        var content = findAll();
        var contentList = Stream.of(content.split(System.lineSeparator())).toList();

        if (contentList.stream().noneMatch(c -> c.contains(data))) return false;

        clearFile();
        contentList.stream()
                .filter(c -> !c.contains(data))
                .forEach(this::write);
        return true;
    }

    @Override
    public String replace(String dataOld, String dataNew) {
        var content = findAll();
        var contentList = Stream.of(content.split(System.lineSeparator())).toList();

        if (contentList.stream().noneMatch(c -> c.contains(dataOld))) return "";

        clearFile();
        contentList.stream()
                .map(c -> !c.contains(dataOld) ? dataNew : c)
                .forEach(this::write);
        return dataNew;
    }

    @Override
    public String findAll() {
        var content = new StringBuilder();
        try (
                var file = new RandomAccessFile(new File(currentPath + storedPath + fileName),"r");
                var channel = file.getChannel();
        ){
            var buffer = ByteBuffer.allocate(256);
            var bytesRead = channel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                while(buffer.hasRemaining()){
                    content.append((char) buffer.get());
                }
                buffer.clear();
                bytesRead = channel.read(buffer);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return content.toString();
    }

    @Override
    public String findBy(String data) {
        var content = new StringBuilder();
        try(
                var file = new RandomAccessFile(new File(currentPath + storedPath + fileName),"r");
                var channel = file.getChannel();
        ){
            var buffer = ByteBuffer.allocate(256);
            var bytesRead = channel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                while(buffer.hasRemaining()){
                    while (!content.toString().endsWith(System.lineSeparator())){
                        content.append((char) buffer.get());
                    }
                    if (content.toString().contains(data)) {
                        break;
                    }
                    else {
                        content.setLength(0);
                    }
                    if (!content.isEmpty()) break;
                }
                buffer.clear();
                bytesRead = channel.read(buffer);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return content.toString();
    }

    private void clearFile(){
        try (OutputStream outputStream = new FileOutputStream(currentPath + storedPath + fileName)){
            System.out.printf("Inicializando recursos (%s) \n", currentPath + storedPath + fileName);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
