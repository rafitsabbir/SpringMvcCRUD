package springmvccrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvccrud.model.User;
import springmvccrud.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userservice;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("user/user_page");

		List<User> list = userservice.listAllUsers();
		mv.addObject("listuser", list);

		return mv;

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("user/user_form");

		User user = new User();
		mv.addObject("userform", user);

		return mv;

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("user/user_form");

		User user = userservice.findUserbyId(id);
		mv.addObject("userform", user);

		return mv;

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("userform") User user) {

		if (user != null && user.getId() != null) {
			userservice.updateUser(user);
		} else {
			userservice.addUser(user);
		}

		return new ModelAndView("redirect:/list");

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("user/user_form");

		userservice.deleteUser(id);

		return new ModelAndView("redirect:/list");

	}
}
