package com.prototype;

import lombok.*;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/4/22 21:36
 */
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ColoneProduct implements Cloneable {
    private String buildA;
    private String buildB;
    private String buildC;
    private String buildD;

    @Override
    protected ColoneProduct clone() throws CloneNotSupportedException {
        return ((ColoneProduct) super.clone());
    }
}
