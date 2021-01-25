package com.shopping.demo.entity.base;

import java.io.Serializable;

public interface ToDto<T> extends Serializable {
    T toDto();
}
