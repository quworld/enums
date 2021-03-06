package enums.interfaces;

import java.util.Objects;

import static enums.util.EnumConstants.findFirst;

/**
 * Created by Rabin on 2017-07-11.
 */
@FunctionalInterface
public interface EnumCode{
    String getCode();

    static <T extends Enum<T> & EnumCode> T of(Class<T> enumClazz, String code) {
        return findFirst(enumClazz,
                c -> Objects.equals(c.getCode(), code))
                .orElseThrow(()->new IllegalArgumentException("Not found enum constant. argument : " + code));
    }
}
