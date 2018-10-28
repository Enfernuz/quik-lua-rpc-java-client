package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@Value
public class StopEventInfo {

    private static final String FLAG = "flag";

    private static final int FLAG_FROM_DIALOG_WINDOW = 1;
    private static final int FLAG_FROM_TERMINAL_CLOSURE = 2;

    int flag;

    @JsonCreator
    public static StopEventInfo getInstance(@JsonProperty(value = FLAG, required = true) final int flag) {

        switch (flag) {
            case FLAG_FROM_DIALOG_WINDOW:
                return InstanceHolder.FROM_DIALOG_WINDOW;
            case FLAG_FROM_TERMINAL_CLOSURE:
                return InstanceHolder.FROM_TERMINAL_CLOSURE;
            default:
                return new StopEventInfo(flag);
        }
    }

    private StopEventInfo(final int flag) {
        this.flag = flag;
    }

    public boolean isFromDialogWindow() {
        return flag == FLAG_FROM_DIALOG_WINDOW;
    }

    public boolean isFromTerminalClosure() {
        return flag == FLAG_FROM_TERMINAL_CLOSURE;
    }

    @NotNull
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(FLAG, flag)
                .toString();
    }

    private static final class InstanceHolder {

        private static final StopEventInfo FROM_DIALOG_WINDOW = new StopEventInfo(FLAG_FROM_DIALOG_WINDOW);
        private static final StopEventInfo FROM_TERMINAL_CLOSURE = new StopEventInfo(FLAG_FROM_TERMINAL_CLOSURE);

        // sanity check
        static {
            assert FROM_DIALOG_WINDOW.isFromDialogWindow();
            assert FROM_TERMINAL_CLOSURE.isFromTerminalClosure();
        }
    }
}
