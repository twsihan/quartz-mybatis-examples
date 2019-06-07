package com.twsihan.examples.entities;

import com.twsihan.examples.components.base.BaseEntity;
import lombok.Data;

@Data
public class Example extends BaseEntity
{
    private String username;

    private String password;

    private String type;

    private Integer enabled;
}
