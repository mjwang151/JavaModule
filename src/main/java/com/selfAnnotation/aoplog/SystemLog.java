package com.selfAnnotation.aoplog;

import lombok.Data;

import java.util.Date;
@Data
public class SystemLog {
    private String id;

    private String description;

    private String method;

    private Long logType;

    private String requestIp;

    private String exceptioncode;

    private String exceptionDetail;

    private String params;

    private String createBy;

    private Date createDate;
}
