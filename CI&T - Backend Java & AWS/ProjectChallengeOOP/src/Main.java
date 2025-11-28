import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso cursoJava = new Curso();
        cursoJava.setTitulo("Curso Java");
        cursoJava.setDescricao("desc Curso Java");
        cursoJava.setCargaHoraria(8);

        Curso cursoPOO = new Curso();
        cursoPOO.setTitulo("Curso POO");
        cursoPOO.setDescricao("desc Curso POO");
        cursoPOO.setCargaHoraria(8);

        Mentoria mentoriaJava = new Mentoria();
        mentoriaJava.setTitulo("Mentoria Java");
        mentoriaJava.setDescricao("desc Mentoria Java");
        mentoriaJava.setData(LocalDate.now());

        Bootcamp bootcampJava = new Bootcamp();
        bootcampJava.setNome("Bootcamp Java Developer");
        bootcampJava.setDescricao("desc Bootcamp Java");
        bootcampJava.getConteudos().add(cursoJava);
        bootcampJava.getConteudos().add(cursoPOO);
        bootcampJava.getConteudos().add(mentoriaJava);

        Dev devBernardo = new Dev();
        devBernardo.setNome("Bernardo");
        devBernardo.inscreverBootcamp(bootcampJava);
        devBernardo.progredir();
        System.out.println(" ");
        System.out.println("Developer Bernardo");
        System.out.println("Conteudos Inscritos"+ devBernardo.getConteudosInscritos());
        System.out.println("Conteudos Concluidos" + devBernardo.getConteudosConcluidos());
        System.out.println("XP TOTAL: " + devBernardo.calcularTotalXP());
        System.out.println(" ");

        Dev devMaria = new Dev();
        devMaria.setNome("Maria");
        devMaria.inscreverBootcamp(bootcampJava);
        System.out.println(" ");
        System.out.println("Developer Maria");
        System.out.println("Conteudos Inscritos"+ devMaria.getConteudosInscritos());
        System.out.println("Conteudos Concluidos" + devMaria.getConteudosConcluidos());
        System.out.println("XP TOTAL: " + devMaria.calcularTotalXP());
        System.out.println(" ");


        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcampJava);
        devJoao.progredir();
        System.out.println(" ");
        System.out.println("Developer Joao");
        System.out.println("Conteudos Inscritos"+ devJoao.getConteudosInscritos());
        System.out.println("Conteudos Concluidos"+ devJoao.getConteudosConcluidos());
        System.out.println("XP TOTAL: " + devJoao.calcularTotalXP());
        System.out.println(" ");
    }
}