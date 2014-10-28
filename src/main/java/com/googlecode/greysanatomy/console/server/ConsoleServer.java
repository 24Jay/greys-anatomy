package com.googlecode.greysanatomy.console.server;

import com.googlecode.greysanatomy.Configer;
import com.googlecode.greysanatomy.console.rmi.RespResult;
import com.googlecode.greysanatomy.console.rmi.req.ReqCmd;
import com.googlecode.greysanatomy.console.rmi.req.ReqGetResult;
import com.googlecode.greysanatomy.console.rmi.req.ReqHeart;
import com.googlecode.greysanatomy.console.rmi.req.ReqKillJob;
import com.googlecode.greysanatomy.util.GaStringUtils;
import com.googlecode.greysanatomy.util.HostUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.instrument.Instrumentation;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * ����̨������
 *
 * @author vlinux
 */
public class ConsoleServer extends UnicastRemoteObject implements ConsoleServerService {

    private static final long serialVersionUID = 7625219488001802803L;

    private static final Logger logger = LoggerFactory.getLogger("greysanatomy");

    private final ConsoleServerHandler serverHandler;
    private final Configer configer;

    private Registry registry;
    private boolean bind = false;

    /**
     * �������̨������
     *
     * @param configer
     * @param inst
     * @throws RemoteException
     * @throws MalformedURLException
     */
    private ConsoleServer(Configer configer, final Instrumentation inst) throws RemoteException, MalformedURLException, AlreadyBoundException {
        super();
        serverHandler = new ConsoleServerHandler(this, inst);
        this.configer = configer;
        rebind();
    }

    /**
     * ��Naming
     *
     * @throws MalformedURLException
     * @throws RemoteException
     * @throws AlreadyBoundException
     */
    public synchronized void rebind() throws MalformedURLException, RemoteException, AlreadyBoundException {

        registry = LocateRegistry.createRegistry(configer.getTargetPort());
        for (String ip : HostUtils.getAllLocalHostIP()) {
            final String bindName = String.format("rmi://%s:%d/RMI_GREYS_ANATOMY", ip, configer.getTargetPort());
            try {
                Naming.lookup(bindName);
                bind = true;
            } catch (NotBoundException e) {
                // ֻ��û�а󶨲Ż�ȥ��
                logger.info("rebind : " + bindName);
                Naming.bind(bindName, this);
            }
        }

    }

    /**
     * �����Naming
     *
     * @throws RemoteException
     * @throws NotBoundException
     * @throws MalformedURLException
     */
    private synchronized void unbind() throws RemoteException, NotBoundException, MalformedURLException {

        for (String ip : HostUtils.getAllLocalHostIP()) {

            final String bindName = String.format("rmi://%s:%d/RMI_GREYS_ANATOMY", ip, configer.getTargetPort());
            try {
                Naming.unbind(bindName);
                logger.info("unbind : " + bindName);
            } catch (NotBoundException e) {
                continue;
            } catch (NoSuchObjectException e) {
                continue;
            }
        }//for

        if (null != registry) {
            UnicastRemoteObject.unexportObject(registry, true);
//            PortableRemoteObject.unexportObject(this);
        }

        bind = false;

    }

    /**
     * �Ƿ��ѱ�RMI.bind()
     *
     * @return
     */
    public boolean isBind() {
        return bind;
    }

    /**
     * �ر�ConsoleServer
     *
     * @throws RemoteException
     * @throws NotBoundException
     * @throws MalformedURLException
     */
    public void shutdown() throws RemoteException, NotBoundException, MalformedURLException {
        unbind();
    }


    private static volatile ConsoleServer instance;

    /**
     * ��������̨������
     *
     * @param configer
     * @throws MalformedURLException
     * @throws RemoteException
     */
    public static synchronized ConsoleServer getInstance(Configer configer, Instrumentation inst) throws RemoteException, MalformedURLException, AlreadyBoundException {
        if (null == instance) {
            instance = new ConsoleServer(configer, inst);
            logger.info(GaStringUtils.getLogo());
        }
        return instance;
    }

    @Override
    public RespResult postCmd(ReqCmd cmd) throws Exception {
        return serverHandler.postCmd(cmd);
    }

    @Override
    public long register() throws Exception {
        return serverHandler.register();
    }

    @Override
    public boolean checkPID(int pid) throws Exception {
        return configer.getJavaPid() == pid;
    }

    @Override
    public RespResult getCmdExecuteResult(ReqGetResult req) throws Exception {
        return serverHandler.getCmdExecuteResult(req);
    }

    @Override
    public void killJob(ReqKillJob req) throws Exception {
        serverHandler.killJob(req);
    }

    @Override
    public boolean sessionHeartBeat(ReqHeart req) throws Exception {
        return serverHandler.sessionHeartBeat(req);
    }

    public Configer getConfiger() {
        return configer;
    }
}
