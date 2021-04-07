package com.turkcell.poc.log;

import com.turkcell.poc.enums.RequestTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "log")
@Data
@Accessors(chain = true)
public class LogCollection {
    @Id
    private String id;

    @Field("request_type")
    private RequestTypeEnum requestTypeEnum;

    @Field("request_time")
    private Date requestTime;

    @Field("request_class")
    private String requestClass;

    @Field("request_method_name")
    private String requestMethodName;

    @Field("request_method_path")
    private String requestMethodPath;

    @Field("request_url")
    private String requestUrl;

    @Field("request_params")
    private String requestParams;
}
