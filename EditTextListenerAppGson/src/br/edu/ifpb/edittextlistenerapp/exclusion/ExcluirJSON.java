package br.edu.ifpb.edittextlistenerapp.exclusion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Anota��o para excluir campo do JSON gerado pelo Gson.
 * 
 * @author David Buzatto
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.FIELD )
public @interface ExcluirJSON {
    // apenas marca��o de campo
}