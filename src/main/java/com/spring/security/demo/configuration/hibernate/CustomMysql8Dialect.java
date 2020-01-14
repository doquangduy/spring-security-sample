package com.spring.security.demo.configuration.hibernate;

import org.hibernate.dialect.MySQL8Dialect;
import org.hibernate.type.LocalDateTimeType;
import org.hibernate.type.LocalDateType;
import org.hibernate.type.LocalTimeType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

import java.sql.Types;
@SuppressWarnings("unused")
public class CustomMysql8Dialect extends MySQL8Dialect {
    public CustomMysql8Dialect() {
        super();
        registerHibernateType(Types.TIME, LocalTimeType.INSTANCE.getName());
        registerHibernateType(Types.DATE, LocalDateType.INSTANCE.getName());
        registerHibernateType(Types.TIMESTAMP, LocalDateTimeType.INSTANCE.getName());
        registerHibernateType(Types.BIGINT, LongType.INSTANCE.getName());
        registerHibernateType(Types.CHAR, 1, StringType.INSTANCE.getName());
    }
}
