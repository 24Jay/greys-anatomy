package com.googlecode.greysanatomy.console;

import jline.console.completer.Completer;

import java.util.List;

/**
 * �������������TAB����
 *
 * @author vlinux
 */
public class InputCompleter implements Completer {

    @Override
    public int complete(String buffer, int cursor, List<CharSequence> candidates) {
        if (null == buffer
                || buffer.isEmpty()
                || buffer.trim().isEmpty()) {
            candidates.add("");
            return 0;
        } else {
            candidates.add(buffer + " ");
        }
        return 0;
    }

}
