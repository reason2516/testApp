package com.test;

public class TestByte {
    public static void main(String[] args) {
        byte testByte = (byte) 0b10010001;
        int testInt = (byte)0b10010001;

        byte x = -12;
        int z = 0xff;
        int i = toUnsignedInt(x);
        System.out.println(i);
    }

    public static int toUnsignedInt(byte x) {
        return (int) x & 0xff;
    }
}
