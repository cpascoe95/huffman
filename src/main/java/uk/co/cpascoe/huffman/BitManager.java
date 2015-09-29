package uk.co.cpascoe.huffman;

import java.util.Arrays;

public class BitManager {
    private byte[] data;
    private int pos;
    private static final byte[] POWERS = new byte[] {(byte)128, 64, 32, 16, 8, 4, 2, 1};

    public BitManager() {
        this.data = new byte[] {0};
        this.pos = 0;
    }

    public BitManager(byte[] data) {
        this.data = Arrays.copyOf(data, data.length);
        this.pos = 0;
    }

    public byte getBit() {
        return (byte)((this.data[this.pos / 8] & BitManager.POWERS[this.pos % 8]) != 0 ? 1 : 0);
    }

    public void setBit(byte bit) {
        byte currentBit = this.getBit();

        if (currentBit != bit) {
            this.data[this.pos / 8] = (byte)(this.data[this.pos / 8] ^ BitManager.POWERS[this.pos % 8]);
        }
    }

    public void next() {
        this.pos++;
        if (this.pos / 8 >= this.data.length) {
            this.data = Arrays.copyOf(data, data.length * 2);
        }
    }
}