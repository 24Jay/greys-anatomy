package com.googlecode.greysanatomy.console.command;

<<<<<<< HEAD
import com.googlecode.greysanatomy.console.command.annotation.Arg;
=======
>>>>>>> pr/8
import com.googlecode.greysanatomy.console.server.ConsoleServer;

import java.lang.instrument.Instrumentation;

/**
 * ����������
 *
 * @author vlinux
 */
public abstract class Command {

    /**
<<<<<<< HEAD
     * �ض���·��
     */
    @Arg(name = "o", isRequired = false)
    String redirectPath;

    /**
=======
>>>>>>> pr/8
     * ��Ϣ������
     *
     * @author vlinux
     */
    public static interface Sender {

        /**
         * ������Ϣ
         *
         * @param isF
         * @param message
         */
        void send(boolean isF, String message);

    }


    /**
     * ������Ϣ
     *
     * @author vlinux
     * @author chengtongda
     */
    public static class Info {

        private final Instrumentation inst;
        private final long sessionId;
<<<<<<< HEAD
        private final String jobId;

        public Info(Instrumentation inst, long sessionId, String jobId) {
=======
        private final int jobId;

        public Info(Instrumentation inst, long sessionId, int jobId) {
>>>>>>> pr/8
            this.inst = inst;
            this.sessionId = sessionId;
            this.jobId = jobId;
        }

        public Instrumentation getInst() {
            return inst;
        }

        public long getSessionId() {
            return sessionId;
        }

<<<<<<< HEAD
        public String getJobId() {
=======
        public int getJobId() {
>>>>>>> pr/8
            return jobId;
        }

    }

    /**
     * �����
     *
     * @author vlinux
     */
    public interface Action {

        /**
         * ִ�ж���
         *
         * @param consoleServer
         * @param info
         * @param sender
         * @throws Throwable
         */
        void action(ConsoleServer consoleServer, Info info, Sender sender) throws Throwable;

    }

    /**
     * ��ȡ�����
     *
     * @return
     */
    abstract public Action getAction();

<<<<<<< HEAD
    public String getRedirectPath() {
        return redirectPath;
    }

    public void setRedirectPath(String redirectPath) {
        this.redirectPath = redirectPath;
    }

=======
>>>>>>> pr/8
}
