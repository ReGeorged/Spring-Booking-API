package com.exam.giorgibazierashvili.constants;

public enum RecordState {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    private final String status;

    RecordState(String status) {
        this.status = status;
    }

    public String getCustomName() {
        return status;
    }


}
