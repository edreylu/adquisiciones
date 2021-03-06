/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.main.application;

import com.modules.sirsr.usuario.domain.UsuarioDTO;
import com.modules.sirsr.usuario.domain.UsuarioService;
import com.modules.sirsr.config.Mensaje;
import java.security.Principal;
import java.util.Objects;
import com.modules.sirsr.config.WebUtils;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import static com.modules.sirsr.config.WebUtils.getSiteURL;

/**
 *
 * @author Edward Reyes
 */

@Controller
public class MainController {

	private final UsuarioService usuarioService;
	@Value("${google.recaptcha.sitio}")
	private String key;

	@Autowired
	public MainController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/")
	public String welcomePage() {
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model, Principal principal) {
		String url = Objects.nonNull(principal) ? "redirect:/menu" : "login";
		model.addAttribute("key", key);
		return url;
	}

	@GetMapping("/menu")
	public String menu(Model model, Principal principal) {
		UsuarioDTO usuario = usuarioService.findByUserName(WebUtils.getUserName());
		model.addAttribute("usuario", usuario);
		return "menu";
	}

	@GetMapping("/logout")
	public String logoutSuccessfulPage(Model model) {
		return "redirect:/";
	}

	@GetMapping("/reiniciar_password")
	public String reiniciarPassword() {
		return "reiniciar_password";
	}

	@PostMapping("/reiniciar_password")
	public String reiniciarPassword(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		String email = request.getParameter("email");
		String token = RandomString.make(30);
		String resetPasswordLink = getSiteURL.apply(request) + "/cambiar_password?token=" + token;
		Mensaje.addMensaje(usuarioService.updateResetPasswordToken(token, email, resetPasswordLink), redirectAttrs);
		return "redirect:/login";
	}

	@GetMapping("/cambiar_password")
	public String cambiarPassword(@Param(value = "token") String token, Model model) {
		Mensaje mensaje = usuarioService.getByResetPasswordToken(token);
		int errorToken = mensaje.getResult() == 1 ? 0 : 1;
		model.addAttribute("token", token);
		model.addAttribute("errorToken", errorToken);
		return "cambiar_password";

	}

	@PostMapping("/cambiar_password")
	public String cambiarPassword(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		String token = request.getParameter("token");
		String password = request.getParameter("password");
		Mensaje mensaje = usuarioService.getByResetPasswordToken(token);
		model.addAttribute("title", "Reinicie su password");
		if (mensaje.getResult() == 1) {
			Mensaje.addMensaje(usuarioService.updatePassword(token, password), redirectAttrs);
		} else {
			model.addAttribute("errorToken", 1);
			return "cambiar_password";
		}
		return "redirect:/login";
	}

}
