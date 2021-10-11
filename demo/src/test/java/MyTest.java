import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-11
 **/
@Slf4j
public class MyTest {

    public static void main(String[] args) throws Throwable {
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
//        for (int i = 0; i < 100; i++) {
//            double random = Math.random();
//            int num = (int) (random*100000000);
//            System.out.println(num+"----"+(String.valueOf(num)).length());
//        }
//        HashSet<BigDecimal> set = new HashSet<>();
//        set.add(new BigDecimal("0.2"));
//        set.add(new BigDecimal("0.3"));
//        set.add(new BigDecimal("0.4"));
//        BigDecimal minAvgDailyPrice = set.stream().min(BigDecimal::compareTo).orElseGet(()->null);
//        System.out.println(minAvgDailyPrice);

//        System.out.println(int.class);
//        System.out.println(Integer.class);
//        AuthVO authVO = new AuthVO();authVO.setDepartmentUuid("rr").setMobile("tt");
//        MyAssert.notNull(null, "ObjectMapper should not be null %s","23er23r");


//        for (int i = 0; i < 34; i++) {
//            LocalDate date = LocalDateTime.now().plusHours(i).toLocalDate();
//            if (date.isAfter(LocalDate.now())){
//                System.out.println(i+"---------"+date);
//            }
//        }
//        System.out.println(LocalDate.now().atStartOfDay());
//        LocalDateTime localDateTime = LocalDate.now().atTime(0, 1, 0);
//        System.out.println(localDateTime);
//        System.out.println(localDateTime.plusHours(12L));
//        System.out.println(DateConvertUtil.toLocalDateTime(LocalDate.now()));
//
//        // 获取当日开始时间 ，比如 时分秒都为0
//        Date beginOfDay = DateUtil.beginOfDay(new Date());
//        // 设置成当日的12点，这是新对象了
//        Date startTime = DateUtil.offsetHour(beginOfDay, 12);
//        // 两天后
//        Date endOfDay = DateUtil.offsetDay(beginOfDay, 2);
//        // 两天后的下午两点
//        Date endTime = DateUtil.offsetHour(endOfDay, 14);
//        // 计算不同时间之间的间隔
//        long days = DateUtil.between(startTime, endTime, DateUnit.DAY);
//        System.out.println(DateUtil.formatDateTime(startTime) + " --- " + DateUtil.formatDateTime(endTime)+" :时间间隔"+days+ "天");
//        Date date=startTime;
//        for (int i = 1; i <= 3; i++) {
//            System.out.println(DateUtil.formatDateTime(date));
//            date=DateUtil.offsetDay(date,1);
//        }

//        String a=null;
//        System.out.println(a==null);
//        Arrays.asList(a);
//        Arrays.asList(null);

//        BigDecimal bigDecimal = new BigDecimal("2.22");
//        System.out.println(bigDecimal.toString());

//        Date date1 = DateConvertUtil.toDate(LocalDate.now());
//        Date date2 = DateConvertUtil.toDate(LocalDate.now());
//        Date parse1 = DateUtil.parse("2021-09-15");
//        Date parse2 = DateUtil.parse("2021-09-15");
//        System.out.println(date1.equals(date2));

//        BigDecimal one = new BigDecimal("0.22");
//        BigDecimal two = new BigDecimal("1.22");
//
//
//        System.out.println(one.compareTo(two));
//        if (one.compareTo(two)==-1) {
//            System.out.println(one);
//        }else {
//            System.out.println(two);
//        }

//
//        String name="112131";
//        String name2="12";
//        System.out.println(name2.contains(""));


//       long start = System.currentTimeMillis();
//        TimeUnit.SECONDS.sleep(5);
//        log.info("更该已预定房单的定时任务执行完毕，耗时{}ms", System.currentTimeMillis() - start);

//        HashSet<String> set = new HashSet<>();
//        for (int i = 0; i < 100; i++) {
//            int randomNum = (int) Math.floor(Math.random() * 1000);
//            TimeUnit.MILLISECONDS.sleep(100);
//            Date dateTime = DateUtil.beginOfDay(new Date());
//            String date = DateConvertUtil.toLocalDate(dateTime).format(DateTimeFormatter.BASIC_ISO_DATE).substring(2);
//            String roomRrderNumStr = date + "126" + String.format("%03d", randomNum);
//            System.out.println(roomRrderNumStr);
//            set.add(roomRrderNumStr);
//        }
//        System.out.println(set.size());
//    }


        List<Integer> list = new ArrayList<>();


        list.add(1);
        Method add =list.getClass().getDeclaredMethod("add",Object.class);
        add.invoke(list, "kkk");
        add.invoke(list, "www");
        add.invoke(list, "eee");
        add.invoke(list, "rrr");
        System.out.println(list);

    }
}


