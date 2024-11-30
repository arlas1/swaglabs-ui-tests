package swaglabs.constants;

public class InputDetails {

    public enum InputType {
        ALPHABET,
        ALPHANUMERIC,
        COMPLEX
    }

    public enum InputLength {
        SHORT(10),
        LONG(1000);

        private final int length;

        InputLength(int length) {
            this.length = length;
        }

        public int getLength() {
            return length;
        }
    }

}
