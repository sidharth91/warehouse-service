package com.assignment.warehouse.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class WareHouseErrorMessage {
    private String message;
    private int errorCode;
    private LocalDateTime timestamp;
}
