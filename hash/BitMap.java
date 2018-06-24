
public class BitMap{
    // bit mapping
    private byte[] bits;
    private int capacity;

    public BitMap(int capacity){
        this.capacity = capacity;
        // >> 3 equals to /8
        bits = new byte[(capacity >> 3) + 1];
    }

    public void add(int num){
        // index
        int index = num >> 3;
        // position
        // & 0x07 equals to %8
        int position = num & 0x07;
        bits[index] |= 0x01 << position;
    }

    public boolean contain(int num){
        int index = num >> 3;
        int position = num & 0x07;
        return (bits[index] & (0x01 << position)) != 0;
    }

    public void clear(int num){
        int index = num >> 3;
        int position = num & 0x07;
        bits[index] &= ~(0x01 << position);
    }

    public static void main(String[] args) {
        BitMap bitmap = new BitMap(100);
        bitmap.add(7);
        System.out.println("Insert 7 successfully.");

        boolean isexsit = bitmap.contain(7);
        System.out.println("Is 7 in bit map?"+isexsit);

        bitmap.clear(7);
        isexsit = bitmap.contain(7);
        System.out.println("Is 7 in bit map?"+isexsit);
    }
}
