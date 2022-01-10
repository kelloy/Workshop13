package tfip.ssf.Workshop13;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApp {
	
	public static void main(String[] args) throws IOException {
		SpringApplication myapp = new SpringApplication(MyApp.class);

		ApplicationArguments appArgs = new DefaultApplicationArguments(args);
		System.out.println(appArgs);

		List optVal = appArgs.getOptionValues("dataDir");
		System.out.println(optVal);

		if (optVal == null || args == null){
		System.out.println("System Error");
		System.exit(1);
		} else {
		String dirPath = (String) optVal.get(0);
		File dir = new File(dirPath);
		Path path = Paths.get(dirPath);
			if(dir.mkdir()){
				System.out.println("directory created");
				}
		}
		myapp.run(args);
	}
}


