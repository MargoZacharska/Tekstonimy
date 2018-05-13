import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Slownik {

    private Map<String, ArrayList<String>> slownik = new HashMap<>();

    public Slownik(String plik) throws IOException, UnsupportedCharException
    {
        BufferedReader f = new BufferedReader( new FileReader(plik));
        String line;
        while((line = f.readLine())!=null)
        {
            dodajSlowo(line);
        }
        f.close();
    }

    public String klucz2(String slowo)
    {
        StringBuilder sb = new StringBuilder();
        for (char c: slowo.toLowerCase().toCharArray()) {

            if(c <= 'o')
            {
                sb.append((c - 'a') / 3 + 2);
                continue;
            }

            if(c <= 'w')
            {
                sb.append((c - 'p') / 4 + 7);
                continue;
            }
            sb.append(9);

        }
        return sb.toString();
    }

    public String klucz(String slowo) throws UnsupportedCharException
    {
        StringBuilder sb = new StringBuilder();
        for (char c: slowo.toLowerCase().toCharArray()) {

            switch (c) {
                case 'a':
                case 'ą':
                case 'b':
                case 'c':
                case 'ć':
                    sb.append("2");
                    break;
                case 'd':
                case 'e':
                case 'ę':
                case 'f':
                    sb.append("3");
                    break;
                case 'g':
                case 'h':
                case 'i':
                    sb.append("4");
                    break;
                case 'j':
                case 'k':
                case 'l':
                case 'ł':
                    sb.append("5");
                    break;
                case 'm':
                case 'n':
                case 'ń':
                case 'o':
                case 'ó':
                    sb.append("6");
                    break;
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 'ś':
                    sb.append("7");
                    break;
                case 't':
                case 'u':
                case 'v':
                case 'w':
                    sb.append("8");
                    break;
                case 'x':
                case 'y':
                case 'z':
                case 'ż':
                case 'ź':
                    sb.append("9");
                    break;

                default:
                    throw new UnsupportedCharException(c);
            }
        }
        return sb.toString();
    }

    private void dodajSlowo(String slowo) throws UnsupportedCharException
    {
        String key = klucz(slowo);
        ArrayList<String> slowa = null;

        if (slownik.containsKey(key)) {
            slowa = slownik.get(key);
        }
        else {
            slowa = new ArrayList<>();
            slownik.put(key, slowa);
        }

        slowa.add(slowo);
    }

    public int dajSlowa2(String klucz) {
        List<String> list = slownik.get(klucz);
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<String> dajSlowa(String klucz){
        List<String> list = slownik.get(klucz);
        if(list == null)
            return null;
        return list.stream().limit(5).collect(Collectors.toList());
    }
}
