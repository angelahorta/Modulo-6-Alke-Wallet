package aw.modulo6.controller;

import aw.modulo6.entity.UsuarioEntity;
import aw.modulo6.util.Utiles;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

	// Método controlador para la página "/menu" usando GET
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public ModelAndView Login() {
		ModelAndView mav = new ModelAndView();

		// Obtener el usuario actual (simulado para este ejemplo)
		UsuarioEntity user = Utiles.getUser();

		// Preparar mensajes para mostrar en la vista
		String nombreUser = "Hola, " + user.getNombre();
		String montoUser = "Tu saldo es: $" + user.getSaldo();

		// Agregar objetos al modelo y establecer la vista a mostrar
		mav.addObject("nombreUser", nombreUser);
		mav.addObject("montoUser", montoUser);
		mav.setViewName("menu");
		return mav;
	}

}
