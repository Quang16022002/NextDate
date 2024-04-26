import java.util.Scanner;

public class NextDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập ngày, tháng, năm từ người dùng
        System.out.println("Nhập ngày (d):");
        int d = scanner.nextInt();
        System.out.println("Nhập tháng (m):");
        int m = scanner.nextInt();
        System.out.println("Nhập năm (y):");
        int y = scanner.nextInt();

        // Kiểm tra tính hợp lệ của ngày tháng năm
        if (isValidDate(d, m, y)) {
            // Tính toán ngày, tháng, năm tiếp theo
            int nextDay = d + 1;
            int nextMonth = m;
            int nextYear = y;

            // Kiểm tra nếu ngày tiếp theo vượt quá số ngày của tháng hiện tại
            if (nextDay > daysInMonth(m, y)) {
                nextDay = 1;
                nextMonth++;
                // Kiểm tra nếu tháng tiếp theo vượt quá 12 (tháng cuối cùng của năm)
                if (nextMonth > 12) {
                    nextMonth = 1;
                    nextYear++;
                }
            }

            // In ra ngày tháng năm tiếp theo
            System.out.println("Ngày tiếp theo là: " + nextDay + "/" + nextMonth + "/" + nextYear);
        } else {
            System.out.println("Ngày tháng năm không hợp lệ.");
        }

        scanner.close();
    }

    // Hàm kiểm tra tính hợp lệ của ngày tháng năm
    public static boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1 || day > daysInMonth(month, year)) {
            return false;
        }
        return true;
    }

    // Hàm trả về số ngày trong một tháng của một năm nhất định
    public static int daysInMonth(int month, int year) {
        switch (month) {
            case 1: // Tháng 1, 3, 5, 7, 8, 10, 12 có 31 ngày
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4: // Tháng 4, 6, 9, 11 có 30 ngày
            case 6:
            case 9:
            case 11:
                return 30;
            case 2: // Tháng 2 có 28 hoặc 29 ngày tùy thuộc vào năm nhuận
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0; // Trường hợp không hợp lệ
        }
    }

    // Hàm kiểm tra năm nhuận
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
