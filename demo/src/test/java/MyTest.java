

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-11
 **/
public class MyTest {

    public static void main(String[] args) {
//        LocalDate now1 = LocalDate.now();
//        LocalDate now2 = LocalDate.now();
//        System.out.println(now1);
//        System.out.println(now2);
//        System.out.println(now2.equals(now1));
//
//        Date date = new Date();
//
//        LocalDateTime localDateTime = DateConvertUtil.toLocalDateTime(date);
//        System.out.println(localDateTime);
//        Date toDate = DateConvertUtil.toDate(localDateTime);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        System.out.println(format.format(toDate));


//        BigDecimal zero = new BigDecimal("0.00");
//        BigDecimal one = new BigDecimal("1");
//
//        System.out.println(zero.compareTo(one));
        for (int i = 0; i < 100; i++) {
            double random = Math.random();
            int num = (int) (random*100000000);
            System.out.println(num+"----"+(String.valueOf(num)).length());
        }


    }
}
