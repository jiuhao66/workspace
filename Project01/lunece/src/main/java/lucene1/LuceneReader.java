package lucene1;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;

/**
 * @author LX
 * @date 2019/3/19 - 16:43
 */
public class LuceneReader {

    public static void test() throws IOException {

        // 第一步 创建一个  directory对象  也就是 索引库存放的位置
        Directory directory = FSDirectory.open(new File("D:\\luceneIndex\\index"));

        // 创建一个IndexReader对象 需要指定Directory
        IndexReader indexReader = DirectoryReader.open(directory);

        // 创建一个indexSearcher 对象 ,需要指定IndexReader 对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        // 创建一个  TermQuery对象  , 指定 查询 的域 和查询的关键词
        Query query = new TermQuery(new Term("fileContent","python"));

        TopDocs search = indexSearcher.search(query, 10);

        ScoreDoc[] scoreDocs = search.scoreDocs;

        for (ScoreDoc scoreDoc : scoreDocs){

            int doc = scoreDoc.doc;

            Document document = indexSearcher.doc(doc);

            String fileName = document.get("fileName");

            System.out.println(fileName);

            String fileContext = document.get("fileContent");

            System.out.println(fileContext);

            String filepath = document.get("filePath");

            System.out.println(filepath);

            String fileSize = document.get("fileSize");

            System.out.println(fileSize);
        }

        indexReader.close();

    }

    public static void main(String[] args) throws IOException {

        test();
    }
}
