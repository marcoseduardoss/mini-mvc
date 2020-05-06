/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.me.agenda.modelo.persistencia;

import java.util.List;

/**
 *
 * @author marcos.eduardo
 */
public interface DaoI <T>{

    
    public List<T> getTodos();

    public T obterPorId(Long id);

    public void remover(T entidade);

    public void salvar(T entidade);
    
    public void atualizar(T entidade);
    
}
