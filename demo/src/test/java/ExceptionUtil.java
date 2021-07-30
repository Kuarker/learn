import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-7-28
 **/
@Slf4j
public class ExceptionUtil {

    static <T> T getData(Supplier<T> supplier,String errorMsg) {
        try {
            return supplier.get();
        } catch (Exception e) {
            log.info("异常信息 {}" ,e);
           throw new RuntimeException(errorMsg);
        }
    }
}
