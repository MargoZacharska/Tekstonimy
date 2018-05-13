
public class UnsupportedCharException extends Exception{

    char e;
    public UnsupportedCharException(char e) {
        this.e = e;
    }

    @Override
    public String toString() {
        return "znak " + e + " jest nieobslugiwany";
    }
}
