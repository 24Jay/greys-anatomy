package com.googlecode.greysanatomy.probe;

/**
 * ֪ͨ��
 *
 * @author vlinux
 */
public class Advice {

    /**
     * ̽��Ŀ��
     *
     * @author vlinux
     */
    public static class Target {

<<<<<<< HEAD
        /*
         * ̽��Ŀ����
         */
        private final Class<?> targetClass;

        /*
         * ̽��Ŀ����Ϊ(method/constructor)
         */
        private final TargetBehavior targetBehavior;

        /*
         * ̽��Ŀ��ʵ��
         */
        private final Object targetThis;

        public Target(Class<?> targetClass, TargetBehavior targetBehavior, Object targetThis) {
            this.targetClass = targetClass;
            this.targetBehavior = targetBehavior;
=======
        private final String targetClassName;
        private final String targetBehaviorName;
        private final Object targetThis;

        public Target(String targetClassName, String targetBehaviorName, Object targetThis) {
            this.targetClassName = targetClassName;
            this.targetBehaviorName = targetBehaviorName;
>>>>>>> pr/8
            this.targetThis = targetThis;
        }

        /**
<<<<<<< HEAD
         * ��ȡ̽��Ŀ����
         *
         * @return
         */
        public Class<?> getTargetClass() {
            return targetClass;
        }

        /**
         * ��ȡ̽��Ŀ����Ϊ(method/constructor)
         *
         * @return
         */
        public TargetBehavior getTargetBehavior() {
            return targetBehavior;
=======
         * ��ȡ̽��Ŀ��������
         *
         * @return ��̽���Ŀ��������
         */
        public String getTargetClassName() {
            return targetClassName;
        }

        /**
         * ��ȡ̽��Ŀ����Ϊ(method/constructor)����
         *
         * @return ��̽�����Ϊ����
         */
        public String getTargetBehaviorName() {
            return targetBehaviorName;
>>>>>>> pr/8
        }

        /**
         * ��ȡ̽��Ŀ��ʵ��
         *
<<<<<<< HEAD
         * @return
=======
         * @return ��̽��Ŀ��ʵ��
>>>>>>> pr/8
         */
        public Object getTargetThis() {
            return targetThis;
        }

    }

<<<<<<< HEAD
    /**
     * ̽��Ŀ����Ϊ(method/constructur)
     *
     * @author vlinux
     */
    public static interface TargetBehavior {

        /**
         * ��ȡ��Ϊ������
         *
         * @return
         */
        String getName();

    }

    /**
     * ̽����Ϊ�����캯��̽��
     *
     * @author vlinux
     */
    public static class TargetConstructor implements TargetBehavior {

        private final Constructor<?> constructor;

        public TargetConstructor(Constructor<?> constructor) {
            this.constructor = constructor;
        }

        @Override
        public String getName() {
            return "<init>";
        }

        /**
         * ��ȡ���캯��
         *
         * @return
         */
        public Constructor<?> getConstructor() {
            return constructor;
        }

    }

    /**
     * ̽����Ϊ������̽��
     *
     * @author vlinux
     */
    public static class TargetMethod implements TargetBehavior {

        private final Method method;

        public TargetMethod(Method method) {
            this.method = method;
        }

        @Override
        public String getName() {
            return method.getName();
        }

        /**
         * ��ȡ������
         *
         * @return
         */
        public Method getMethod() {
            return method;
        }

    }


=======
>>>>>>> pr/8
    private final Target target;        // ̽��Ŀ��
    private final Object[] parameters;    // ���ò���
    private final boolean isFinished;    // �Ƿ�doFinish����

    private Object returnObj;            // ����ֵ�����Ŀ�귽�������쳣����ʽ���������ֵΪnull
    private Throwable throwException;    // �׳��쳣�����Ŀ�귽����������ʽ���������ֵΪnull

<<<<<<< HEAD
    /**
     * ̽�������캯��
     *
     * @param target
     * @param parameters
     * @param isFinished
     */
=======
>>>>>>> pr/8
    public Advice(Target target, Object[] parameters, boolean isFinished) {
        this.target = target;
        this.parameters = parameters;
        this.isFinished = isFinished;
    }

    /**
     * �Ƿ����׳��쳣����
     *
     * @return true:�����쳣��ʽ����/false:�Է����쳣��ʽ����������δ����
     */
    public boolean isThrowException() {
        return isFinished() && null != throwException;
    }

    /**
     * �Ƿ����������ؽ���
     *
     * @return true:������������ʽ����/false:�Է�����������ʽ����������δ����
     */
    public boolean isReturn() {
        return isFinished() && !isThrowException();
    }

    /**
     * �Ƿ��Ѿ�����
     *
     * @return true:�Ѿ�����/false:��δ����
     */
    public boolean isFinished() {
        return isFinished;
    }

    public Target getTarget() {
        return target;
    }

    public Object getReturnObj() {
        return returnObj;
    }

    public void setReturnObj(Object returnObj) {
        this.returnObj = returnObj;
    }

    public Throwable getThrowException() {
        return throwException;
    }

    public void setThrowException(Throwable throwException) {
        this.throwException = throwException;
    }

    public Object[] getParameters() {
        return parameters;
    }

    /**
     * getParameters()�����ı�����ԭ��������̫TM����
<<<<<<< HEAD
     * @return
     */
    public Object[] getParams() {return parameters;}

    /**
     * getThrowException()�����ı���
     * @return
     */
    public Throwable getThrowExp() {return throwException;}
=======
     *
     * @return �����б�
     */
    public Object[] getParams() {
        return parameters;
    }

    /**
     * getThrowException()�����ı���
     *
     * @return �쳣����
     */
    public Throwable getThrowExp() {
        return throwException;
    }
>>>>>>> pr/8

}
