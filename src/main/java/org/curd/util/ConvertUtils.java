package org.curd.util;

import org.curd.converts.Converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConvertUtils {

    private ConvertUtils(){}

    public static <T> List<T> iterableConvert(Iterable other, Converter converter){
        if(other==null||converter == null) {
            throw new IllegalArgumentException();
        }
        List<T> s = new ArrayList<T>();
        Iterator iterator = other.iterator();
        while(iterator.hasNext()) {
            Object o = iterator.next();
            s.add((T) converter.convertTo(o));
        }
        return s;
    }

}
