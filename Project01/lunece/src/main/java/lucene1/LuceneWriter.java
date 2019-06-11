package lucene1;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

/**
 * @author LX
 * @date 2019/3/18 - 19:23
 */
public class LuceneWriter {

    public static void test() throws IOException {

        Directory directory = FSDirectory.open(new File("D:\\luceneIndex\\index"));

        Analyzer analyzer = new IKAnalyzer();

        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_4, analyzer);

//        IndexWriter indexWriter =new IndexWriter(directory,config);

        IndexWriter indexWriter =new IndexWriter(directory,config);

        File files = new File("d://lucene");

        File[] listFiles = files.listFiles();

        for (File file : listFiles){

            Document document = new Document();

            System.out.println(file.getName());
            //文件名字
            String file_name = file.getName();

            Field fileNameField = new TextField("fileName",file_name, Field.Store.YES);

            //文件路径
            String file_path = file.getPath();

            Field filePathField = new StoredField("filePath",file_path);

            //文件大小
            long file_size = FileUtils.sizeOf(file);

            Field fileSizeField = new LongField("fileSize",file_size, Field.Store.YES);

            //文件内容
            String file_Content = FileUtils.readFileToString(file);

            Field fileContentField = new TextField("fileContent",file_Content, Field.Store.YES);

            document.add(fileNameField);

            document.add(filePathField);

            document.add(fileSizeField);

            document.add(fileContentField);

            indexWriter.addDocument(document);
        }

        indexWriter.close();

    }

    public static void main(String[] args) throws IOException {

        test();

    }
}
