import java.util.*;

class AsciiCharSequence implements CharSequence {
    private final byte[] asciiCharSequence;

    public AsciiCharSequence(byte[] byteSequence) {
        this.asciiCharSequence = byteSequence;
    }

    public int length() {
        return this.asciiCharSequence.length;
    }

    public char charAt(int index) {
        return (char) this.asciiCharSequence[index];
    }

    public CharSequence subSequence(int start, int end) {
        byte[] byteSequence = new byte[end - start];

        for (int i = start, j = 0; i < end; i++, j++) {
            byteSequence[j] = this.asciiCharSequence[i];
        }

        return new AsciiCharSequence(byteSequence);
    }

    public String toString() {
        String asciiString = "";

        for (byte b : this.asciiCharSequence) {
            asciiString += (char) b;
        }

        return asciiString;
    }
}