package covy.userservice.dto;

import covy.userservice.vo.ResponseOrder;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <클래스 설명>
 *
 * @author : junni802
 * @date : 2025-02-18
 */

@Getter
@Setter
public class UserDto {

    private String email;

    private String pwd;

    private String name;

    private String userId;

    private Date createAt;

    private String encryptedPwd;

    private List<ResponseOrder> orders;

}
