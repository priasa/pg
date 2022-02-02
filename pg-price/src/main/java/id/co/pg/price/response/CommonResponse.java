package id.co.pg.price.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@ApiModel(value = "commonResponse")
public class CommonResponse<T> implements Serializable {
    @ApiModelProperty(name = "status", required = true)
    private boolean status;
    @ApiModelProperty(name = "message")
    private String message;
    @ApiModelProperty(name = "object")
    private T object;
}
