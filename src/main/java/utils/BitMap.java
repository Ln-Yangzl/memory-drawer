package utils;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author: zlyang
 * @date: 2022-05-03 18:59
 * @description:
 */
public class BitMap{
    private final byte[] bits;

    private final int size;

    public BitMap(int size) {
        this.size = size;
        this.bits = new byte[size / 8 + 1];
    }

    public BitMap(BitMap bitMap){
        this.size = bitMap.getSize();
        this.bits = bitMap.getBits().clone();
    }

    public int get(int index) {
        return (bits[index / 8] >> (index % 8)) & 1;
    }

    public void set(int index, int val) {
        boolean setTarget = val != 0;
        byte former = bits[index / 8];
        int offset = index % 8;
        bits[index / 8] = (byte) (setTarget ? former | (1 << offset) : former & ~(1 << offset));
    }

    public byte[] getBits() {
        return bits;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(((bits[i / 8] >> (i % 8)) & 1) == 0 ? " " : "1");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BitMap bitMap = (BitMap) o;
        return size == bitMap.size && Arrays.equals(bits, bitMap.bits);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(bits);
        return result;
    }

}
