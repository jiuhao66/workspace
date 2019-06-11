package lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

/**
 *
 * TermQuery  精准查询   用于 直接用id 来查询的 或者单号
 *
 * @author LX
 * @date 2019/3/22 - 12:26
 */
public class lucene_test {

    public IndexWriter getIndexWriter() throws IOException {

        System.out.println();

        Directory directory = FSDirectory.open(new File("d://luceneIndex"));

        Analyzer analyzer = new IKAnalyzer();

        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_4, analyzer);

//        IndexWriter indexWriter =new IndexWriter(directory,config);

        IndexWriter indexWriter =new IndexWriter(directory,config);

        return indexWriter ;
    }

    /**
     * 根据 条件 删除  document
     */
    @Test
    public void delete() throws IOException {

        IndexWriter indexWriter = getIndexWriter();

        Query query = new TermQuery(new Term("filName", "java"));

        indexWriter.deleteDocuments(query);

        indexWriter.close();
    }

    /**
     * 修改
     * @throws IOException
     */
    @Test
    public void Update() throws IOException {

        System.out.println();

        IndexWriter indexWriter = getIndexWriter();

        Document document = new Document();

        document.add(new TextField("fileName","测试名", Field.Store.YES));

        document.add(new TextField("fileContent","测试文件内容", Field.Store.YES));

        indexWriter.updateDocument(new Term("fileName","lucene"), document,new IKAnalyzer());

        indexWriter.close();
    }

    // 获取  indexSearcher
    public IndexSearcher getIndexSearcher() throws IOException {

        Directory directory = FSDirectory.open(new File("d://luceneIndex"));

        IndexReader indexReader = DirectoryReader.open(directory);

        return new IndexSearcher(indexReader);
    }

    public void print(IndexSearcher indexSearcher , Query query) throws IOException {

        System.out.println();

        TopDocs search = indexSearcher.search(query, 10);

        ScoreDoc[] scoreDocs = search.scoreDocs;

        for (ScoreDoc scoreDoc : scoreDocs){

            Document document = indexSearcher.doc(scoreDoc.doc);

            String fileName = document.get("fileName");

            System.out.println(fileName);

            String fileContext = document.get("fileContent");

            System.out.println(fileContext);

            String filepath = document.get("filePath");

            System.out.println(filepath);

            String fileSize = document.get("fileSize");

            System.out.println(fileSize);
        }
    }
    /**
     * 查询全部
     */
    @Test
    public void searchAll() throws IOException {

        IndexSearcher indexSearcher = getIndexSearcher();

        Query query = new MatchAllDocsQuery();

        TopDocs search = indexSearcher.search(query, 20);

        print(indexSearcher, query);

        indexSearcher.getIndexReader().close();
    }

    //根据数值范围查询
    @Test
    public void numericRangeQuery() throws IOException {

        IndexSearcher indexSearcher = getIndexSearcher();

        Query query = NumericRangeQuery.newLongRange("fileSize", 20L, 30L, true, true);

        print(indexSearcher, query);

        indexSearcher.getIndexReader().close();
    }

    // 组合查询
    @Test
    public void test(){



    }
}
