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
<<<<<<< HEAD
     * @return
=======
     *
     * @return ��������Ľ���
>>>>>>> pr/8
     */
    public String desc();

    /**
<<<<<<< HEAD
     * ����,��help������
     * @return
=======
     * ����
     *
     * @return �������������
     */
    public String[] eg() default {};

    /**
     * ����,��help������
     *
     * @return ����������Ŀ¼�е�����
>>>>>>> pr/8
     */
    public int sort() default 0;

}
