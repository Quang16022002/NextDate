import org.junit.Test;
import static org.junit.Assert.*;

public class TestNextDate {

    @Test
    public void testValidDate() {
        assertTrue(NextDate.isValidDate(1, 1, 2022)); // Ngày tháng năm đúng
        assertTrue(NextDate.isValidDate(31, 12, 2023)); // Ngày tháng năm đúng
        assertTrue(NextDate.isValidDate(29, 2, 2020)); // Năm nhuận
    }

    @Test
    public void testInvalidDate() {
        assertFalse(NextDate.isValidDate(0, 1, 2022)); // Ngày âm
        assertFalse(NextDate.isValidDate(32, 1, 2022)); // Ngày lớn hơn 31
        assertFalse(NextDate.isValidDate(29, 2, 2021)); // Năm không nhuận
        assertFalse(NextDate.isValidDate(31, 4, 2022)); // Tháng không hợp lệ
    }

    @Test
    public void testDaysInMonth() {
        assertEquals(31, NextDate.daysInMonth(1, 2022)); // Tháng 1 năm bình thường
        assertEquals(29, NextDate.daysInMonth(2, 2020)); // Tháng 2 năm nhuận
        assertEquals(28, NextDate.daysInMonth(2, 2021)); // Tháng 2 năm không nhuận
        assertEquals(30, NextDate.daysInMonth(4, 2022)); // Tháng 4 năm bình thường
    }

    @Test
    public void testLeapYear() {
        assertTrue(NextDate.isLeapYear(2020)); // Năm nhuận
        assertFalse(NextDate.isLeapYear(2021)); // Năm không nhuận
        assertFalse(NextDate.isLeapYear(1900)); // Năm không nhuận (chia hết cho 100 nhưng không chia hết cho 400)
        assertTrue(NextDate.isLeapYear(2000)); // Năm nhuận (chia hết cho cả 100 và 400)
    }
}
