package com.mountains.distributed.entity.crm.sys;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description 用户实体类
 * @author tinxi
 * @date 2019/7/9 11:34
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

	private static final long serialVersionUID = -6484737673706200878L;
	private Long id;
	private String userNo;
	private String userName;
	private String dbName;
}
