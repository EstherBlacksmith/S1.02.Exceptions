package entry;

public class Main {
    public static void main(String[] args) {

        System.out.println("Answer the next questions");
        System.out.println( Entry.readByte("Introduce a Byte"));
        System.out.println( Entry.readInt("Introduce your age"));
        System.out.println( Entry.readFloat("Introduce your mensual salary"));
        System.out.println( Entry.readDouble("Introduce your year salary"));
        System.out.println( Entry.readChar("Introduce one character"));
        System.out.println( Entry.readString("Introduce your name"));
        System.out.println( Entry.readBoolean("Introduce Yes (Y) or No (N)"));

    }
}

