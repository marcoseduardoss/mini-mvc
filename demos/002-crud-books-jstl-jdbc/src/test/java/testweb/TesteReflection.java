package testweb;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.me.mvc.util.JavaReflectionUtil;

class TesteReflection {

	@Test
	void test() {
			
			final String dirToList = System.getProperty("user.dir");
			Map<String, String> map = JavaReflectionUtil.INSTANCE.getClassesMap(dirToList);
	        
	        //final String dirToList ="C://projetos//java//testweb//src//main//java";
	        
	       // String dirToList = System.getProperty("user.home") + File.separator + "Documents";
	        
	        //Map<String, String> map = test.listDirectory(dirToList, 0, new HashMap<String, String>());
	        Collection<String> lista = map.values();
	        for (String key : lista) {
				System.out.println(key);
			}
	}

}
