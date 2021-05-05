package com.erreius.developer.dev2018.utils;


import android.os.AsyncTask;
import android.webkit.WebView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HtmlManager {
    public String pathSaveFiles = null;
    public WebView webView = null;
    public String readFromFile(String path, String doc) {
        StringBuilder text = new StringBuilder();
        try {
            File file = new File(path,doc+".txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close() ;
            System.out.println("----------------ARCHIVO LEIDO----------------------");
            System.out.println(String.valueOf(text));
            return String.valueOf(text);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private void saveHtmlFile(String path, String name, String context) {
        System.out.println( "----------FILE:---------- ");
        System.out.println(path);
        File file = new File(path, name+".txt");
        String html = context;
        try {
            FileOutputStream out = new FileOutputStream(file);
            byte[] data = html.getBytes();
            out.write(data);
            out.close();
            System.out.println( "HTML "+ name +" Guardado ");
            //readFromFile(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void listFiles(String path){
        List<String> item = new ArrayList<String>();
        System.out.println("TODOS LOS ARCHIVOS GUARDADOS");
        File f = new File(path);
        File[] files = f.listFiles();
        System.out.println(files.length);
        for (int i = 0; i < files.length; i++)
        {
            File file = files[i];
            if (file.isDirectory()) {
                item.add(file.getName() + "/");
            }
            else
                System.out.println("Archivo N° " + i + " " + file.getName());
            item.add(file.getName());
        }
    }

    public void save(String url){
        new BackGroundTask().execute(url);
    }
    private class BackGroundTask extends AsyncTask<String, String, Document> {
        String docName = "";
        String style = "<html><head>" +
                "<style> " +
                ".TextoCentradoNegritaNovedades {\n" +
                "  font-weight: bold;\n" +
                "text-align : center;" +
                "} " +
                "p.sangrianovedades {\n" +
                "    font-family: Calibri;\n" +
                "    font-size: 12pt;\n" +
                "    margin-top: 4pt;\n" +
                "    text-indent: 18px;\n" +
                "    text-align: justify;\n" +
                "    font-family: Verdana;\n" +
                "    font-size: 8pt;\n" +
                "}" +
                "span.negritanovedades {\n" +
                "    font-weight: bold;\n" +
                "}" +
                "" +
                "</style>" +
                "</head>" +
                "<body>";
        @Override
        protected Document doInBackground(String... strings) {
            final StringBuilder builder = new StringBuilder();
            String url = strings[0];
            ArrayList<String> returnString = new ArrayList<>();
            returnString.add(0,url);
            docName = url.substring(url.indexOf("=") + 1, url.length());
            try {
                Document doc = Jsoup.connect(url).get();
                ArrayList<Element> div = doc.getElementsByTag("body");
                returnString.add(1, "");
                return doc;
            } catch (IOException e) {
                builder.append("Error : ").append(e.getMessage()).append("\n");
            }
            return null;
        }
        @Override
        protected void onPostExecute(Document doc) {
            super.onPostExecute(doc);
            System.out.println("ONPOSTEXECUTE");
            String documento = style;
            for (Element e : doc.select("#documento")){
                documento +=e.outerHtml();
                e.select("span.destination1");
            }
            documento = documento.replaceAll("<span class=\"destination1\"", "<span style=\"display:none;\"");
            documento = documento.replaceAll("style=\"width:100%;margin-left:0; margin-right:0;\"","");
            documento+="</body></html>";
            System.out.println("");
            saveHtmlFile(pathSaveFiles,docName,documento);
            listFiles(pathSaveFiles);
        }
    }
}