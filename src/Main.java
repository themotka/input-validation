import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    static int getAge(String sDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateTime = LocalDate.parse(sDate, formatter);
        LocalDate now = LocalDate.now().withYear(dateTime.getYear());
        if (dateTime.isAfter(now)){
            return LocalDate.now().getYear() - dateTime.getYear() - 1;
        }
        else return LocalDate.now().getYear() - dateTime.getYear();
    }
    static char matchSex(String patronymic){
        if (patronymic.charAt((patronymic.length()-1)) == 'ч'){
            return 'М';
        }
        else return 'Ж';
    }

    static void validateText(String string) throws IllegalArgumentException{
        if (!string.matches("[А-Яа-я]+")){
            throw new IllegalArgumentException(String.format("Ошибка в \"%s\"", string));
        }
    }

    static void validateDate(String date) throws IllegalArgumentException{
        if(!date.matches("^(3[01]|[12][0-9]|0?[1-9])(.)(1[0-2]|0?[1-9])\\2([0-9]{2})?[0-9]{2}$")){
            throw new IllegalArgumentException("Введите дату рождения в корректном формате");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Все данные должны быть введены на русском языке. \nДата в формате ДД.ММ.ГГГГ");
        String patronymic ="", name = "", surname = "", date = "";
        try {
            System.out.println("Введите имя:");
            name = scanner.nextLine();
            validateText(name);
            System.out.println("Введите фамилию:");
             surname = scanner.nextLine();
            validateText(surname);
            System.out.println("Введите отчество:");
            patronymic = scanner.nextLine();
            validateText(patronymic);
            System.out.println("Введите дату:");
             date = scanner.nextLine();
            validateDate(date);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.printf("%s %c.%c, %c, %d полных лет", surname, name.charAt(0),
                patronymic.charAt(0), matchSex(patronymic), getAge(date));

    }
}