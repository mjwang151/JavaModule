package com.builder;

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
public class Product {
    private String buildA;
    private String buildB;
    private String buildC;
    private String buildD;

    public static class Nbuilder {
        private String buildA;
        private String buildB;
        private String buildC;
        private String buildD;

        public Nbuilder buildA(String buildA){
            this.buildA = buildA;
            return this;
        }
        public Nbuilder buildB(String buildB){
            this.buildB = buildB;
            return this;
        }
        public Nbuilder buildC(String buildC){
            this.buildC = buildC;
            return this;
        }
        public Nbuilder buildD(String buildD){
            this.buildD = buildD;
            return this;
        }
        public Product build(){
            return new Product(this.buildA,this.buildB,this.buildC,this.buildD);
        }
    }
}
