package org.lzw.base.conf.aspect;


import org.springframework.stereotype.Repository;

//@Repository  通过 @Bean注入了,不需要再用@Repository
public class MyCalcTool {

    public int aadd(){

        int i =5 ; int j =3;

       return i+j;
    }

    public int aminus(int i ,int j){

        return i-j;
    }
}
