package pers.cgglyle.service.account.model.dto;

import lombok.Data;

/**
 * RSA256 key 模型
 *
 * @author cgglyle
 * @date 2021-12-24 14:38
 */
@Data
public class RsaKeyDto {
    private String publicKey;
    private String privateKey;
}
