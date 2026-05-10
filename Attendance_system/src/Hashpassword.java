public class Hashpassword {

    public String hash(String plainText) {
            int sides = 3;
            String cipherText = new String();

            for (int i = 0; i < sides; i++) {
                for (int j = i; j < plainText.length(); j = j + sides) {
                    cipherText = cipherText + plainText.charAt(j);
                }
            }

            return cipherText;
        }
    }


