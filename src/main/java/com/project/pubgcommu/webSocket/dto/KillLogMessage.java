package com.project.pubgcommu.webSocket.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class KillLogMessage {
    private Long logId;
    private String type;
    private int increase;
}
