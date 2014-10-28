package com.googlecode.greysanatomy.console.command.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ����ָ����������
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RiscNamedArg {

    /**
     * �����������е�λ��
     *
     * @return
     */
    public String named();

    /**
     * ����ע��
     *
     * @return
     */
    public String description() default "";

    /**
     * �Ƿ���ֵ
     *
     * @return
     */
    public boolean hasValue() default false;

    /**
     * ����У��
     *
     * @return
     */
    public ArgVerifier[] verify() default {};

}
