package it.finsoft.demo.controller.landing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest")
@RestController 
public class LandingController
{
	@GetMapping("/greetings")
	public String greetings(@RequestParam(value = "name",defaultValue="World")String name,
							@RequestParam(value = "sname",defaultValue=" ")String surname)
	{
		return "Hello " + name + " " + surname;
	}
}

