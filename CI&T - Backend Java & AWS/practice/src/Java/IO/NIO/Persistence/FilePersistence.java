package Java.IO.NIO.Persistence;

public interface FilePersistence {
    String write(final String data);
    boolean remove(final String data);
    String replace(final String dataOld, final String dataNew);
    String findAll();
    String findBy(final String data);
}
