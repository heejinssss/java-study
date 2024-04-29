package chapter04;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest {
	public static void main(String[] args) {
//		Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
//		TimeZone tz = TimeZone.getDefault();
//		System.out.println(aLocale + ":" + tz);

		Calendar cal = Calendar.getInstance();
		printDate(cal);

		cal.set(Calendar.YEAR, 2024);
		cal.set(Calendar.MONTH, 11); // 12 - 1
		cal.set(Calendar.DATE, 25);
		printDate(cal); // 크리스마스는 무슨 요일?
		
		cal.set(2000, 01, 21); // 생일
		cal.add(Calendar.DATE, 10000); // 태어난지 10000일 되는 날
		printDate(cal);
	}

	private static void printDate(Calendar cal) {
		final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"};

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); // 0 ~ 11 (+1)
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1(일) ~ 7(토)
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);

		System.out.println(year + "년 "
						 + (month + 1) + "월 "
						 + date + "일 "
						 + DAYS[day-1] + "요일 "
						 + hour + "시 "
						 + minute + "분 "
						 + second + "초 ");
	}
}
