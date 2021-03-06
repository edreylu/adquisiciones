/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.usuario.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Edward Reyes
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUserName(String userName);

	Usuario findByNoUsuario(Integer noUsuario);

	Usuario findByNoPersonal(Integer noPersonal);

	Usuario findByResetPasswordToken(String token);

	boolean existsUsuarioByNoPersonalAndNoUsuarioNot(Integer noPersonal, Integer noUsuario);
}
