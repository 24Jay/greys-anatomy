package com.googlecode.greysanatomy.console.command;

import com.googlecode.greysanatomy.console.command.annotation.RiscCmd;
import com.googlecode.greysanatomy.console.server.ConsoleServer;

/**
 * �˳�����
 * Created by vlinux on 14/11/1.
 */
@RiscCmd(named = "quit", sort = 8, desc = "Quit the Greys console.",
        eg = {
                "quit"
        })
public class QuitCommand extends Command {
    @Override
    public Action getAction() {
        return new Action() {

            @Override
            public void action(final ConsoleServer consoleServer, final Info info, final Sender sender) throws Throwable {
                sender.send(true, "Bye bye!");
            }

        };
    }
}
