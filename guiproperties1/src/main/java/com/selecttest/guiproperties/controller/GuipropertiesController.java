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
import java.io.File;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException; 
import java.io.FileOutputStream; 
import java.util.ArrayList; 
@Controller
//@Configuration
//@RefreshScope 
public class GuipropertiesController extends WebMvcConfigurerAdapter {

	@Autowired private FileConfig properties_file; 

	@Override
	public void addViewControllers(ViewControllerRegistry registry ) {
        registry.addRedirectViewController("/", "view/index.html");
		//registry.addRedirectViewController("/view/fileupload", "view/index.html");
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
	public String index( @RequestParam("file") MultipartFile file , Model model) throws IOException{
		
		File convertFile = new File ("src\\main\\resources\\application.properties");
		convertFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convertFile); 
		fos.write(file.getBytes());
		fos.close(); 
		
		model.addAttribute("FileConfig", new FileConfig());
		List<String> params = properties_file.getParams();
		model.addAttribute("params", params);
		System.out.println(params+ "from upload");
		
		return "view/index";
	}

	@GetMapping("/view/index.html")
	public String home(Model model){
		model.addAttribute("FileConfig", new FileConfig());
		List<String> params = properties_file.getParams();
		model.addAttribute("params", params);
		System.out.println(params+ "from upload");
		return "view/index";
	}

	@GetMapping("/view/update")
	public String updateform(){
		return "view/update";
	}

	@PostMapping("/view/propsupdate")
	public String uphome (@RequestParam("DB_SID") String db_sid,
							@RequestParam("DB_IP") String db_ip, @RequestParam("DB_PORT") String db_port, 
							@RequestParam("DB_USER") String db_user, @RequestParam("DB_PASS") String db_pass, @RequestParam("DB_PARTS") String db_part, 
							@RequestParam("DB_MINCX") String db_mincx, @RequestParam("DB_MAXCX") String db_maxcx,
							@RequestParam("DB_PDF") String db_pdf, @RequestParam("DB_MAILS") String db_mails,
							Model model){
		List<String> params = new ArrayList<String> (10);
		params.add(db_sid);
		params.add(db_ip);
		params.add(db_port);
		params.add(db_user);
		params.add(db_pass);
		params.add(db_part);
		params.add(db_mincx);
		params.add(db_maxcx);
		params.add(db_pdf);
		params.add(db_mails);
		model.addAttribute("params", params);
		System.out.println("UPDATED");
		return "view/index";
	}
	/* Writing

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
