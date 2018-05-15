import java.io.IOException;  
import java.io.StringReader;  
import org.apache.lucene.analysis.Analyzer;  
import org.apache.lucene.analysis.TokenStream;  
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;  
import org.wltea.analyzer.lucene.IKAnalyzer;

public class CustomIKAnalyzer {  
    public static void main(String[] args) throws IOException {  
    	String text="";  

    	if (args.length > 0){
    		text = args[0];
    	}
        
        //创建分词对象  
        Analyzer an = new IKAnalyzer(true);       
        StringReader reader=new StringReader(text);  
        //分词  
        TokenStream ts=an.tokenStream("", reader);  
        CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);  
        //遍历分词数据  

        while(ts.incrementToken()){  
            System.out.println(term);  
        }  
        reader.close();  
    }
  
} 