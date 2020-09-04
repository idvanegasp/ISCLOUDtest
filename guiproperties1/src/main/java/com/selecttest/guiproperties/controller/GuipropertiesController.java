package com.selecttest.guiproperties.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List; 
import org.springframework.ui.Model;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import com.selecttest.guiproperties.model.FileConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@Controller
//@Configuration
//@RefreshScope 
public class GuipropertiesController extends WebMvcConfigurerAdapter {

	@Autowired private FileConfig properties_file; 

	@Override
	public void addViewControllers(ViewControllerRegistry registry ) {
        registry.addRedirectViewController("/", "view/index.html");
    }

	/*@GetMapping(value="/")
	public String home(Model model){
		model.addAttribute("props", new FileConfig());
		List<String> params = properties_file.getParams();
		model.addAttribute("args", params);
		System.out.println(params + "from index");
		return "view/index";
	
	}*/

	//@GetMapping("/view/index.html")
	//public void GUIhome(){
	//}

	@RequestMapping("/hello")
	public String hello(){
		return "eh string";
	}

	/*@GetMapping( value ="/view/index.html?file=application.properties")
	public String list_args(Model model){
		model.addAttribute("file", new FileConfig());
		List<String> params = properties_file.getParams();
		model.addAttribute("params", params);
		return "view/index";
	}*/
	/*
	@RequestMapping("/view/index.html")
	public String list_args2(Model model){
		model.addAttribute("props", new FileConfig());
		List<String> params = properties_file.getParams();
		model.addAttribute("args", params);
		System.out.println(params + "from index");
		return "view/index";
	}*/


		/*@RequestMapping("/view/index.html?file=application.properties")
	public String list_args3(Model model){
		model.addAttribute("file", new FileConfig());
		List<String> params = properties_file.getParams();
		model.addAttribute("params", params);
		return "view/index";
	}

		@RequestMapping( value ="/view/index.html?file=application.properties")
	public String list_args4(Model model){
		model.addAttribute("file", new FileConfig());
		List<String> params = properties_file.getParams();
		model.addAttribute("params", params);
		return "view/index";
	}*/


	@PostMapping( value="/view/fileupload" )
	public String index(Model model){
		model.addAttribute("FileConfig", new FileConfig());
		List<String> params = properties_file.getParams();
		model.addAttribute("params", params);
		System.out.println(params+ "from upload");
		return "view/index";
	}
	/*
	@CrossOrigin
	@RequestMapping ( value = "/file_read_attributes", method = RequestMethod.GET)
	public @ResponseBody String fileRead() throws Excepiton {
		File file = new ClassPathResource("config.properties").getFile();

		FileInputStream fis = null;

		try {
			fis = new FileInputStream( file );
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if ( fis != null ) fis.close();
			}
			catch ( IOException ex ){
				ex.printStackTrace();
				return ex.getMessage();
			}
		}

		return "file readed";
	}
	
	
	/*public String list_file_params ( Model model ) {
		model.addAttribute( "attributes", prod )
		return "configFile";
	}*/
	/*
	@CrossOrigin
	@RequestMapping ( value = "/file_update", method = RequestMethod.POST)
	public @ResponseBody String fileUpdate () throws Excepiton {
		try {
			String content = "WRITUBT ";

			File file = new ClassPathResource( "config.properties" ).getFile();
			if (!file.exists())
			{
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsolutFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			return "done";

		} catch ( IOEsception e ) {
			return e.getMessage();
		}	
	}*/
	

}
