package com.timer.info;

import java.io.Serializable;

public class TriggerInfo implements Serializable {
    private int totalFireCount; // timer count
    private int remainingFireCount;
    private boolean runForever; // if true, totalFireCount dont matter
    private long repeatIntervalMs; // fire at every set interval
    private long initialOffsetMs; // how long till timer fires from start
    private String callbackData;
}