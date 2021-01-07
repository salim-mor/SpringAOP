package com.aspectexample.aop.invoc;

import com.aspectexample.aop.beans.Client;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AroundHandler implements MethodInterceptor {

    private Object target ;
    private static Logger logger = Logger.getLogger(AroundHandler.class.getName());

    public AroundHandler() {
    }

    public AroundHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(MethodInvocation method) throws Throwable {

        Client client = (Client) method.getThis();
        Object result;

        if (method.getMethod().getName().equals("verser")) {
            System.out.println("invok");
            long debut = System.currentTimeMillis();
            result = method.proceed();
            long fin = System.currentTimeMillis();
            logger.info("-------------------------------------------------");
            logger.info("Operation retirer // name : "  +client.getNom()+ " nouveau solde : "  +client.getCp().getSolde()+ " Time of execution : " + (fin - debut));
        }


        if (method.getMethod().getName().equals("retirer")){
            long debut = System.currentTimeMillis();
            result = method.proceed();
            long fin = System.currentTimeMillis();
            logger.info("Operation verser // name : "+client.getNom()+
                    "nouveau solde : "+client.getCp().getSolde()+" Time of execution : "+ (fin-debut));
            logger.info("-------------------------------------------------");
        }
        else {
            logger.info("Error");
            logger.info("-------------------------------------------------");
            result=null;
        }
        return result;
    }
}
