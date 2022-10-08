import java.util.*;

class Aplikasi {
    public static void main(String args[]) {
        Aplikasi vaultDoor = new Aplikasi();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sebelum kamu bisa masuk ke aplikasi ini, masukkan passwordnya: ");
        String userInput = scanner.next();
        String input = userInput.substring("tecartfestival22{".length(), userInput.length() - 1);
        if (vaultDoor.cekpass(input)) {
            System.out.println("Oke gud kamu tau passwordna.");
        } else {
            System.out.println("Sape elu!");
        }
    }

    public boolean cekpass(String password) {
        return password.length() == 33 &&
                password.charAt(32) == 'g' &&
                password.charAt(20) == 'a' &&
                password.charAt(17) == 'a' &&
                password.charAt(6) == 'r' &&
                password.charAt(23) == 't' &&
                password.charAt(25) == 'p' &&
                password.charAt(5) == 'o' &&
                password.charAt(14) == 'a' &&
                password.charAt(8) == '_' &&
                password.charAt(1) == 'a' &&
                password.charAt(9) == 'i' &&
                password.charAt(11) == 'i' &&
                password.charAt(10) == 'n' &&
                password.charAt(22) == 'a' &&
                password.charAt(7) == 'd' &&
                password.charAt(30) == 'n' &&
                password.charAt(31) == 'g' &&
                password.charAt(13) == 's' &&
                password.charAt(12) == '_' &&
                password.charAt(15) == 'n' &&
                password.charAt(18) == 't' &&
                password.charAt(3) == 's' &&
                password.charAt(29) == 'a' &&
                password.charAt(21) == 'm' &&
                password.charAt(26) == 'a' &&
                password.charAt(24) == '_' &&
                password.charAt(16) == 'g' &&
                password.charAt(19) == '_' &&
                password.charAt(2) == 's' &&
                password.charAt(0) == 'p' &&
                password.charAt(4) == 'w' &&
                password.charAt(27) == 'n' &&
                password.charAt(28) == 'j';

    }
}