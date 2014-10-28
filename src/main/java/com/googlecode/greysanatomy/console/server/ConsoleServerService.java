package com.googlecode.greysanatomy.console.server;

import com.googlecode.greysanatomy.console.rmi.RespResult;
import com.googlecode.greysanatomy.console.rmi.req.ReqCmd;
import com.googlecode.greysanatomy.console.rmi.req.ReqGetResult;
import com.googlecode.greysanatomy.console.rmi.req.ReqHeart;
import com.googlecode.greysanatomy.console.rmi.req.ReqKillJob;

import java.rmi.Remote;

/**
 * ����̨�����interface
 *
 * @author chengtongda
 */
public interface ConsoleServerService extends Remote {

    /**
     * ��������
     *
     * @param cmd
     * @return
     */
    public RespResult postCmd(ReqCmd cmd) throws Exception;

    /**
     * ע�����
     *
     * @return
     */
    public long register() throws Exception;

    /**
     * �˶�PID�Ƿ���ȷ
     *
     * @param pid
     * @return
     * @throws Exception
     */
    public boolean checkPID(int pid) throws Exception;

    /**
     * ��ȡ����ִ�н��
     *
     * @param req
     * @return
     */
    public RespResult getCmdExecuteResult(ReqGetResult req) throws Exception;

    /**
     * ɱ������
     *
     * @param req
     */
    public void killJob(ReqKillJob req) throws Exception;

    /**
     * session����
     *
     * @param req
     */
    public boolean sessionHeartBeat(ReqHeart req) throws Exception;

}
