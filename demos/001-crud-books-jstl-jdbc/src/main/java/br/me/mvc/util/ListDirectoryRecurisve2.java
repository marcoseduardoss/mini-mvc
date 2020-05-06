package br.me.mvc.util;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author marcos.eduardo
 *
 */
public class ListDirectoryRecurisve2 {
	
	
    public static Map<String, String> listDirectory(String dirPath, int level, Map<String, String> map) {
    	
    	File dir = new File(dirPath);
        File[] firstLevelFiles = dir.listFiles();
        
        if (firstLevelFiles != null && firstLevelFiles.length > 0) {
            for (File aFile : firstLevelFiles) {
            	
                String absolutePath = aFile.getAbsolutePath();
				
                if (aFile.isDirectory()) {
                    listDirectory(absolutePath, level + 1, map);
                } else {
                	
                		try {
                			
                			if(absolutePath.endsWith("class") && !absolutePath.contains("$")) {
                				
	                			String sufixpath = absolutePath.split("classes")[1].substring(1).replaceAll("\\\\", "\\.");
	                			sufixpath = sufixpath.replace(".class", "");
	                			String[] split = sufixpath.split("\\.");
								String fileName = split[split.length-1];
								map.put(fileName, sufixpath);
								
                			}
							
                		}catch (Exception e) {
                			//file not localizad - ignored
						}
                	}
            }
        }
        
        return map;
    }
    
    @SuppressWarnings("static-access")
	public static void main(String[] args) {
        ListDirectoryRecurisve2 test = new ListDirectoryRecurisve2();
        //final String dirToList ="C://projetos//java//testweb//src//main//java";
        
       // String dirToList = System.getProperty("user.home") + File.separator + "Documents";
        final String dirToList = System.getProperty("user.dir");
        Map<String, String> map = test.listDirectory(dirToList, 0, new HashMap<String, String>());
        Collection<String> lista = map.values();
        for (String key : lista) {
			System.out.println(key);
		}
    }
    
}