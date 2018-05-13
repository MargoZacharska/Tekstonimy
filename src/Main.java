import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, UnsupportedCharException {

        if (args.length != 2) {
            System.out.println("Niewlasciwa liczba argumentow. Uzycie:");
            System.out.println("\t Slownik_T9 <sciezka_do_slownika> <tekstonim>");
            System.out.println("Przykladowo");
            System.out.println("\t Slownik_T9 slownik.txt 8378");
            System.exit(1);
        }
        String plik = args[0];
        String klucz = args[1];

        Slownik slownik = new Slownik(plik);

        System.out.println(slownik.dajSlowa2(klucz) + "  " + slownik.dajSlowa(klucz));


    }

}
