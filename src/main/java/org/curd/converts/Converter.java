package org.curd.converts;

public interface Converter<S,R> {

    R convertTo(S s);

    S toConvert(R r);

}
