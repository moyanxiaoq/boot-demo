package com.czq.online.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description="角色的实体对象")
public class Role {

    /**
     *id
     */
    private String id;

    /**
     *角色名称
     */
    private String roleName;

    /**
     *状态
     */
    private String flag;


}
