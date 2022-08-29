import java.util.*;

class Aplikasi2 {
    public static void main(String args[]) {
        Aplikasi2 vaultDoor = new Aplikasi2();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sebelum kamu bisa masuk ke aplikasi ini (((((LAGI))))), masukkan passwordnya: ");
        String userInput = scanner.next();
        String input = userInput.substring("tecartfestival22{".length(), userInput.length() - 1);
        if (vaultDoor.cekpass(input)) {
            System.out.println("Oke gud kamu tau passwordna.");
        } else {
            System.out.println("Sape elu!");
        }
    }

    public boolean cekpass(String password) {
        if (password.length() != 27) {
            return false;
        }
        byte[] passBytes = password.getBytes();
        byte[] myBytes = {
                0x4c,
                0x12,
                0x56,
                0x7d,
                0x51,
                0x12,
                0x12,
                0x7d,
                0x4a,
                0x16,
                0x50,
                0x46,
                0x7d,
                0x44,
                0x12,
                0x50,
                0x7d,
                0x7a,
                0x12,
                0x70,
                0x7d,
                0x50,
                0x13,
                0x45,
                0x4a,
                0x56,
                0x1d,
        };
        for (int i = 0; i < 27; i++) {
            if (((passBytes[i] ^ 0x22) - myBytes[i]) != 0) {
                return false;
            }
        }
        return true;
    }
}