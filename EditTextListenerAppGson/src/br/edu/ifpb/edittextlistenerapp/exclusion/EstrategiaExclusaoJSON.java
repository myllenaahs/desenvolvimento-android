package br.edu.ifpb.edittextlistenerapp.exclusion;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
/**
 * Estrat�gia de exclus�o de campos para o Gson usando a anota��o @ExcluirJSON.
 * 
 * @author David Buzatto
 */
public class EstrategiaExclusaoJSON implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField( FieldAttributes fa ) {
        // verifica se tem a anota��o da exclus�o do JSON
        return fa.getAnnotation( ExcluirJSON.class ) != null;
    }
    @Override
    public boolean shouldSkipClass( Class<?> type ) {
        // aceita qualquer classe
        return false;
    }
}