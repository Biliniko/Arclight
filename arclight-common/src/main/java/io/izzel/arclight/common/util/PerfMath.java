package io.izzel.arclight.common.util;

public final class PerfMath {

    private PerfMath() {
    }

    public static double ema(double avg, double exp, double value) {
        return (avg * exp) + (value * (1 - exp));
    }
}
