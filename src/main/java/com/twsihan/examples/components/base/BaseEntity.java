package com.twsihan.examples.components.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import java.io.Serializable;

public class BaseEntity implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Setter
    @Getter
    @Transient
    private Integer page = 0;

    @Setter
    @Getter
    @Transient
    private Integer rows = 10;
}
