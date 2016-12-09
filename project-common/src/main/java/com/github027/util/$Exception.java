package com.github027.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import com.google.common.io.Closer;

public class $Exception {

    private $Exception() {}

    public static String printStacktraceToString(final Exception e) {
        if (e == null) {
            return "";
        }

        final Closer closer = Closer.create();
        try {
            final Writer writer = closer.register(new StringWriter());
            final PrintWriter printWriter = closer.register(new PrintWriter(writer));
            e.printStackTrace(printWriter);
            return writer.toString();
        } finally {
            $Util.close(closer);
        }
    }

    public static String safeGetMessage(final Exception e) {
        return (e == null)? "": e.getMessage();
    }

}
