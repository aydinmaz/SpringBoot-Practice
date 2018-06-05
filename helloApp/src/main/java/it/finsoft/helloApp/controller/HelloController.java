package it.finsoft.helloApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.finsoft.helloApp.model.Dog;
import it.finsoft.helloApp.model.Person;

@Controller
public class HelloController {
	
    @RequestMapping("/hello")//this u write in url
    public String hello(Model model, @RequestParam(value="name", required=true, defaultValue="World") String name, 
    								 @RequestParam(value="lastname", required=true, defaultValue="World") String ln) {
    								//mikhast faqat neshun bede ke ba parametr ham mishe ettelaat dad,vali man ke ziyad az in ravesh khosham nemiyad
    	Person p = new Person();
    	p.setName("karina");
    	p.setLastname("karina2");
    	p.setAge(3);
    	Person p2 = new Person();
    	p2.setName("olagh");
    	model.addAttribute("something",p);//"something" is the my arbitrary chosen name of box that I put my p inside it and inside jsp I access this box
        model.addAttribute("something2",p2);
    	return "hello";//inja mige ke boro be hello.jsp
    }
    
    @RequestMapping("/dog")// in adrrese url hast
    public String dog( Model model)// dog esme functione va delkhahi
    	{ 
	    	Dog d = new Dog();
	    	d.setColor("yellow");
	    	//d.setSize("small");
	    	//d.setHair("riccio");
	    	Dog d2 = new Dog();
	    	d2.setColor("red");
	    	d2.setSize("big");
	    	d2.setHair("long");
	    	model.addAttribute("dogInfo", d);//dogInfo esm baste delkhah hast ke d ro mizarim tush va dakhel jsp hamin baste ro ba $ baz mikonim
	    	model.addAttribute("dogInfo2", d2);//inham ye baste moshabeh hast baray ersal ye d dige
	        return "dog";//in jsp i hast ke basteh ha ro mifrestim behesh
    	}
    
    @RequestMapping("/dogNew")
    public String dog2(Model model ) {
       
    	Dog d = new Dog();//agar che dognew yek adres url jadid hast ama jsp hamun jsp dog hast,va chon dar dog.jsp 2 ta baste darim (dogInfo,dogInfo2)
    	d.setColor("red");//va inja faqat baray dogInfo ettelaat mifrestim,dogInfo 2 ro be surat khaali dar webpage neshun mide
    	d.setSize("big");
    	d.setHair("riccio");
    	model.addAttribute("dogInfo", d);
        return "dog";
    }
    
    @RequestMapping("/dogNew2")
    public String dog3(Model model ) 
	    {
	    	Dog d = new Dog();
	    	d.setColor("red");
	    	d.setSize("big");
	    	d.setHair("riccio");
	    	model.addAttribute("dogInfo", d);
	        return "dogx";
	    }
    
    @RequestMapping("/dogNew3")
    public String dog4(Model model ) 
	    {
	    	
	        return "dogx";
	    }
    @RequestMapping("/vafan")
    public String hello2(Model model, @RequestParam(value="name", required=true, defaultValue="World") String georgia, 
			 						 @RequestParam(value="lastname", required=true, defaultValue="World") String majid,
			 						 @RequestParam(value="age", required=true, defaultValue="6") int age) 

    {
    	model.addAttribute("dogName", georgia);
    	model.addAttribute("dogLn", majid);
    	model.addAttribute("dogA", age);
    	return "hello"; 
    	}
    
}

