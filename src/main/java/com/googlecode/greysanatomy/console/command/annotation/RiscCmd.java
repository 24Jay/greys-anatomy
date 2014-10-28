package com.googlecode.greysanatomy.console.command.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ����ָ�
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RiscCmd {

    /**
     * ָ�����������<br/>
     *
     * @return �������������
     */
    public String named();

    /**
     * ָ������Ľ���
     * @return
     */
    public String desc();

    /**
     * ����,��help������
     * @return
     */
    public int sort() default 0;

}
