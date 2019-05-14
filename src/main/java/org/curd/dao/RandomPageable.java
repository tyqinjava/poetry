package org.curd.dao;

import java.util.List;

public interface RandomPageable<T> {

    List<T> findRandPage(Integer size);

}
