package br.com.rafaelmurata.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logic {

    void executa(HttpServletRequest req,HttpServletResponse res) throws Exception;

}
