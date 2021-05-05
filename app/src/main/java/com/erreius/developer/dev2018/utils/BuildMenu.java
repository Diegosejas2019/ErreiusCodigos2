package com.erreius.developer.dev2018.utils;

import android.app.Activity;
import android.webkit.WebView;
import android.widget.Toast;

import com.erreius.developer.dev2018.R;
import com.unnamed.b.atv.model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public  class BuildMenu {

    private static HashMap<String,String> files = new HashMap<>();
    private static HashMap<String,TreeNode> nodoMap = new HashMap<>();
    private static final int ID = 0;
    private static final int PARENT_ID = 1;
    private static final int BRANCH_NAME = 2;
    private static List<String> docs = new ArrayList<>();
    public static Activity mActivity;

    public static TreeNode getMenu(final WebView wv , final String path, final Activity activity){
        mActivity = activity;
        TreeNode root = TreeNode.root();
        /*TreeNode myProfile = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_bookmark, "My Profile")).setViewHolder(new ProfileHolder(activity));
        TreeNode bruce = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_bookmark, "Bruce Wayne")).setViewHolder(new ProfileHolder(activity));
        TreeNode clark = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_bookmark, "Clark Kent")).setViewHolder(new ProfileHolder(activity));
        TreeNode barry = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_bookmark, "Barry Allen")).setViewHolder(new ProfileHolder(activity));
        addProfileData(myProfile);
        addProfileData(clark);
        addProfileData(bruce);
        addProfileData(barry);

        root.addChildren(myProfile, bruce, barry, clark);*/
        for (String line : menu.split("\n")) {
            String separador = Pattern.quote("|");
            String[] terceto = line.split(separador);
            //TreeNode currentNode = new TreeNode(terceto[BRANCH_NAME]);
            TreeNode currentNode = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_bookmark, terceto[BRANCH_NAME])).setViewHolder(new ProfileHolder(activity));
            nodoMap.put(terceto[ID], currentNode);
            if (!terceto[PARENT_ID].equals("0")) { //no tiene padre
                if(Pattern.matches("[0-9]*", terceto[BRANCH_NAME])){
                    if(!docs.contains(terceto[BRANCH_NAME])){
                        IconTreeItemHolder.IconTreeItem nodo = (IconTreeItemHolder.IconTreeItem) nodoMap.get(terceto[PARENT_ID]).getValue();
                        String name = nodo.text;
                        //String name = nodoMap.get(terceto[PARENT_ID]).getValue().toString();
                        files.put(name,terceto[BRANCH_NAME]);
                        nodoMap.get(terceto[PARENT_ID]).setClickListener(new TreeNode.TreeNodeClickListener() {
                            @Override
                            public void onClick(TreeNode node, Object value) {
//                                System.out.println(files.get((String)value));
                                HtmlManager ht = new HtmlManager();
                                IconTreeItemHolder.IconTreeItem test = (IconTreeItemHolder.IconTreeItem) value;
                                String documento=ht.readFromFile(path, files.get((String)test.text));
                                if (documento == null )
                                    documento = "<p>El documento : </p><h4>\" "+(String)test.text +" \" </h4> <p>no se encuentra guardado en el historial </p>";
                                wv.loadData(documento, "text/html", "UTF-8");
                            }
                        });
                    }
                }else{
                    nodoMap.get(terceto[PARENT_ID]).addChildren(currentNode);
                }
            } else {
                //TreeNode currentNode = new TreeNode(terceto[BRANCH_NAME]);
                root.addChildren(currentNode);
                //root.addChildren(currentNode);
            }
        }
        for (String line : menu1.split("\n")) {
            String separador = Pattern.quote("|");
            String[] terceto = line.split(separador);
            //TreeNode currentNode = new TreeNode(terceto[BRANCH_NAME]);
            TreeNode currentNode = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_bookmark, terceto[BRANCH_NAME])).setViewHolder(new ProfileHolder(activity));
            nodoMap.put(terceto[ID], currentNode);
            if (!terceto[PARENT_ID].equals("0")) { //no tiene padre
                if(Pattern.matches("[0-9]*", terceto[BRANCH_NAME])){
                    if(!docs.contains(terceto[BRANCH_NAME])){
                        IconTreeItemHolder.IconTreeItem nodo = (IconTreeItemHolder.IconTreeItem) nodoMap.get(terceto[PARENT_ID]).getValue();
                        String name = nodo.text;
                        //String name = nodoMap.get(terceto[PARENT_ID]).getValue().toString();
                        files.put(name,terceto[BRANCH_NAME]);
                        nodoMap.get(terceto[PARENT_ID]).setClickListener(new TreeNode.TreeNodeClickListener() {
                            @Override
                            public void onClick(TreeNode node, Object value) {
                                System.out.println(files.get((String)value));
                                HtmlManager ht = new HtmlManager();
                                String documento=ht.readFromFile(path, files.get((String)value));
                                if (documento == null )
                                    documento = "<p>El documento : </p><h4>\" "+(String)value+" \" </h4> <p>no se encuentra guardado en el historial </p>";
                                wv.loadData(documento, "text/html", "UTF-8");
                            }
                        });
                    }
                }else{
                    nodoMap.get(terceto[PARENT_ID]).addChildren(currentNode);
                }
            } else {
                root.addChildren(currentNode);
            }
        }
        for (String line : menu3.split("\n")) {
            String separador = Pattern.quote("|");
            String[] terceto = line.split(separador);
            TreeNode currentNode = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_bookmark, terceto[BRANCH_NAME])).setViewHolder(new ProfileHolder(activity));
            nodoMap.put(terceto[ID], currentNode);
            if (!terceto[PARENT_ID].equals("0")) { //no tiene padre
                if(Pattern.matches("[0-9]*", terceto[BRANCH_NAME])){
                    if(!docs.contains(terceto[BRANCH_NAME])){
                        IconTreeItemHolder.IconTreeItem nodo = (IconTreeItemHolder.IconTreeItem) nodoMap.get(terceto[PARENT_ID]).getValue();
                        String name = nodo.text;
                        //String name = nodoMap.get(terceto[PARENT_ID]).getValue().toString();
                        files.put(name,terceto[BRANCH_NAME]);
                        nodoMap.get(terceto[PARENT_ID]).setClickListener(new TreeNode.TreeNodeClickListener() {
                            @Override
                            public void onClick(TreeNode node, Object value) {
                                System.out.println(files.get((String)value));
                                HtmlManager ht = new HtmlManager();
                                String documento=ht.readFromFile(path, files.get((String)value));
                                if (documento == null )
                                    documento = "<p>El documento : </p><h4>\" "+(String)value+" \" </h4> <p>no se encuentra guardado en el historial </p>";
                                wv.loadData(documento, "text/html", "UTF-8");
                            }
                        });
                    }
                }else{
                    nodoMap.get(terceto[PARENT_ID]).addChildren(currentNode);
                }
            } else {
                root.addChildren(currentNode);
            }
        }
        for (String line : menu2.split("\n")) {
            String separador = Pattern.quote("|");
            String[] terceto = line.split(separador);
            TreeNode currentNode = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_bookmark, terceto[BRANCH_NAME])).setViewHolder(new ProfileHolder(activity));
            nodoMap.put(terceto[ID], currentNode);
            if (!terceto[PARENT_ID].equals("0")) { //no tiene padre
                if(Pattern.matches("[0-9]*", terceto[BRANCH_NAME])){
                    if(!docs.contains(terceto[BRANCH_NAME])){
                        IconTreeItemHolder.IconTreeItem nodo = (IconTreeItemHolder.IconTreeItem) nodoMap.get(terceto[PARENT_ID]).getValue();
                        String name = nodo.text;
                        //String name = nodoMap.get(terceto[PARENT_ID]).getValue().toString();
                        files.put(name,terceto[BRANCH_NAME]);
                        nodoMap.get(terceto[PARENT_ID]).setClickListener(new TreeNode.TreeNodeClickListener() {
                            @Override
                            public void onClick(TreeNode node, Object value) {
                                System.out.println(files.get((String)value));
                                HtmlManager ht = new HtmlManager();
                                String documento=ht.readFromFile(path, files.get((String)value));
                                if (documento == null )
                                    documento = "<p>El documento : </p><h4>\" "+(String)value+" \" </h4> <p>no se encuentra guardado en el historial </p>";
                                wv.loadData(documento, "text/html", "UTF-8");
                            }
                        });
                    }
                }else{
                    nodoMap.get(terceto[PARENT_ID]).addChildren(currentNode);
                }
            } else {
                root.addChildren(currentNode);
            }
        }
        for (String line : menu4.split("\n")) {
            String separador = Pattern.quote("|");
            String[] terceto = line.split(separador);
            TreeNode currentNode = new TreeNode(terceto[BRANCH_NAME]);
            nodoMap.put(terceto[ID], currentNode);
            if (!terceto[PARENT_ID].equals("0")) { //no tiene padre
                if(Pattern.matches("[0-9]*", terceto[BRANCH_NAME])){
                    if(!docs.contains(terceto[BRANCH_NAME])){
                        IconTreeItemHolder.IconTreeItem nodo = (IconTreeItemHolder.IconTreeItem) nodoMap.get(terceto[PARENT_ID]).getValue();
                        String name = nodo.text;
                        //String name = nodoMap.get(terceto[PARENT_ID]).getValue().toString();
                        files.put(name,terceto[BRANCH_NAME]);
                        nodoMap.get(terceto[PARENT_ID]).setClickListener(new TreeNode.TreeNodeClickListener() {
                            @Override
                            public void onClick(TreeNode node, Object value) {
                                System.out.println(files.get((String)value));
                                HtmlManager ht = new HtmlManager();
                                String documento=ht.readFromFile(path, files.get((String)value));
                                if (documento == null )
                                    documento = "<p>El documento : </p><h4>\" "+(String)value+" \" </h4> <p>no se encuentra guardado en el historial </p>";
                                wv.loadData(documento, "text/html", "UTF-8");
                            }
                        });
                    }
                }else{
                    nodoMap.get(terceto[PARENT_ID]).addChildren(currentNode);
                }
            } else {
                //root.addChildren(currentNode);
                TreeNode myProfile = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_bookmark, terceto[BRANCH_NAME])).setViewHolder(new ProfileHolder(activity));
                root.addChildren(myProfile);
            }
        }
       /* if (Pattern.matches("[0-9]*", s))
            System.out.println(s);
        else System.out.println("--");*/
        return root;
    }

    private static void addProfileData(TreeNode profile) {
        TreeNode socialNetworks = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_people, "Social")).setViewHolder(new HeaderHolder(mActivity));
        TreeNode places = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_place, "Places")).setViewHolder(new HeaderHolder(mActivity));

        profile.addChildren(socialNetworks, places);
    }
    private static String menu = new String("426|0|Civil y Comercial\n" +
            "24510|426|Título Preliminar. Arts. 1 a 18\n" +
            "24511|24510|Capítulo 1 - Derecho. Arts. 1 a 3\n" +
            "24512|24511|20141112125433544\n" +
            "24513|24512|20141112125433544\n" +
            "24514|24510|Capítulo 2 - Ley. Arts. 4 a 8\n" +
            "24515|24514|20141112125820546\n" +
            "24516|24515|20141112125820546\n" +
            "24517|24510|Capítulo 3 - Ejercicio de los derechos. Arts. 9 a 14\n" +
            "24518|24517|20141112021036547\n" +
            "24519|24518|20141112021036547\n" +
            "24520|24510|Capítulo 4 - Derechos y bienes. Arts. 15 a 18\n" +
            "24521|24520|20141112021228548\n" +
            "24522|24521|20141112021228548\n" +
            "24523|426|Libro Primero. Parte General. Arts. 19 a 400\n" +
            "24524|24523|Título I - Persona Humana. Arts. 19 a 140\n" +
            "24525|24524|Capítulo 1 - Comienzo de la existencia. Arts. 19 a 21\n" +
            "24526|24525|20141112021359549\n" +
            "24527|24526|20141112021359549\n" +
            "24528|24524|Capítulo 2 - Capacidad. Arts. 22 a 50\n" +
            "24529|24528|Sección 1ª. Principios generales\n" +
            "24530|24529|20141112021746550\n" +
            "24531|24530|20141112021746550\n" +
            "24532|24528|Sección 2ª. Persona menor de edad\n" +
            "24533|24532|20141112021944551\n" +
            "24534|24533|20141112021944551\n" +
            "24535|24528|Sección 3ª. Restricciones a la capacidad\n" +
            "24536|24535|Parágrafo 1°. Principios comunes\n" +
            "24537|24536|20141112022133552\n" +
            "24538|24535|Parágrafo 2°. Sistemas de apoyo al ejercicio de la capacidad\n" +
            "24539|24538|20141112022307553\n" +
            "24540|24535|Parágrafo 3°. Actos realizados por persona incapaz o con capacidad restringida\n" +
            "24541|24540|20141112022613554\n" +
            "24542|24535|Parágrafo 4°. Cese de la incapacidad y de las restricciones a la capacidad\n" +
            "24543|24542|20141112022753555\n" +
            "24544|24535|Parágrafo 5°. Inhabilitados\n" +
            "24545|24544|20141112022854556\n" +
            "24546|24524|Capítulo 3 - Derechos y actos personalísimos. Arts. 51 a 61\n" +
            "24547|24546|20141112023018557\n" +
            "24548|24547|20141112023018557\n" +
            "24549|24524|Capítulo 4 - Nombre. Arts. 62 a 72\n" +
            "24550|24549|20141112023147558\n" +
            "24551|24550|20141112023147558\n" +
            "24552|24524|Capítulo 5 - Domicilio. Arts. 73 a 78\n" +
            "24553|24552|20141112023258559\n" +
            "24554|24553|20141112023258559\n" +
            "24555|24524|Capítulo 6 - Ausencia. Arts. 79 a 84\n" +
            "24556|24555|20141112023421560\n" +
            "24557|24556|20141112023421560\n" +
            "24558|24524|Capítulo 7 - Presunción de fallecimiento. Arts. 85 a 92\n" +
            "24559|24558|20141112023532561\n" +
            "24560|24559|20141112023532561\n" +
            "24561|24524|Capítulo 8 - Fin de la existencia de las personas. Arts. 93 a 95\n" +
            "24562|24561|20141112023705562\n" +
            "24563|24562|20141112023705562\n" +
            "24564|24524|Capítulo 9 - Prueba del nacimiento, de la muerte y de la edad. Arts. 96 a 99\n" +
            "24565|24564|20141112024029563\n" +
            "24566|24565|20141112024029563\n" +
            "24567|24524|Capítulo 10 - Representación y asistencia. Tutela y curatela. Arts. 100 a 140\n" +
            "24568|24567|Sección 1ª. Representación y asistencia\n" +
            "24569|24568|20141112024757564\n" +
            "24570|24569|20141112024757564\n" +
            "24571|24567|Sección 2ª. Tutela\n" +
            "24572|24571|Parágrafo 1°. Disposiciones generales\n" +
            "24573|24572|20141112024931565\n" +
            "24574|24571|Parágrafo 2°. Discernimiento de la tutela\n" +
            "24575|24574|20141112025050566\n" +
            "24576|24571|Parágrafo 3°. Ejercicio de la tutela\n" +
            "24577|24576|20141112025204567\n" +
            "24578|24571|Parágrafo 4°. Cuentas de la tutela\n" +
            "24579|24578|20141112025327568\n" +
            "24580|24571|Parágrafo 5°. Terminación de la tutela\n" +
            "24581|24580|20141112025444569\n" +
            "24582|24567|Sección 3ª. Curatela\n" +
            "24583|24582|20141112025554570\n" +
            "24584|24583|20141112025554570\n" +
            "24585|24523|Título II - Persona Jurídica. Arts. 141 a 224\n" +
            "24586|24585|Capítulo 1 - Parte general. Arts. 141 a 167\n" +
            "24587|24586|Sección 1ª. Personalidad\n" +
            "24588|24587|. Personalidad. Composición\n" +
            "24589|24588|20141112025721571\n" +
            "24590|24586|Sección 2ª. Clasificación\n" +
            "24591|24590|20141112025830572\n" +
            "24592|24591|20141112025830572\n" +
            "24593|24586|Sección 3ª. Persona jurídica privada\n" +
            "24594|24593|Parágrafo 1°. Atributos y efectos de la personalidad jurídica\n" +
            "24595|24594|20141112030026573\n" +
            "24596|24586|Capítulo 1 - Parte general. Arts. 141 a 167\n" +
            "24597|24596|Parágrafo 2°. Funcionamiento\n" +
            "24598|24597|20141112030143574\n" +
            "24599|24596|Parágrafo 3°. Disolución. Liquidación\n" +
            "24600|24599|20141112030304575\n" +
            "24601|24585|Capítulo 2 - Asociaciones civiles. Arts. 168 a 192\n" +
            "24602|24601|Sección 1ª. Asociaciones civiles\n" +
            "24603|24602|20141112030422576\n" +
            "24604|24603|20141112030422576\n" +
            "24605|24601|Sección 2ª. Simples asociaciones\n" +
            "24606|24605|20141112030555577\n" +
            "24607|24606|20141112030555577\n" +
            "24608|24585|Capítulo 3 - Fundaciones. Arts. 193 a 224\n" +
            "24609|24608|Sección 1ª. Concepto, objeto, modo de constitución y patrimonio\n" +
            "24610|24609|20141112030648578\n" +
            "24611|24610|20141112030648578\n" +
            "24612|24608|Sección 2ª. Constitución y autorización\n" +
            "24613|24612|20141112030829579\n" +
            "24614|24613|20141112030829579\n" +
            "24615|24608|Sección 3ª. Gobierno y administración\n" +
            "24616|24615|20141112031025580\n" +
            "24617|24616|20141112031025580\n" +
            "24618|24608|Sección 4ª. Información y contralor\n" +
            "24619|24618|20141112031119581\n" +
            "24620|24619|20141112031119581\n" +
            "24621|24608|Sección 5ª. Reforma del estatuto y disolución\n" +
            "24622|24621|20141112031225582\n" +
            "24623|24622|20141112031225582\n" +
            "24624|24608|Sección 6ª. Fundaciones creadas por disposición testamentaria\n" +
            "24625|24624|20141112031328583\n" +
            "24626|24625|20141112031328583\n" +
            "24627|24608|Sección 7ª. Autoridad de contralor\n" +
            "24628|24627|20141112031425584\n" +
            "24629|24628|20141112031425584\n" +
            "24630|24523|Título III - Bienes. Arts. 225 a 256\n" +
            "24631|24630|Capítulo 1 - Bienes con relación a las personas y los derechos de incidencia colectiva. Arts. 225 a 241\n" +
            "24632|24631|Sección 1ª. Conceptos\n" +
            "24633|24632|20141112031542585\n" +
            "24634|24633|20141112031542585\n" +
            "24635|24631|Sección 2ª. Bienes con relación a las personas\n" +
            "24636|24635|20141112031713586\n" +
            "24637|24636|20141112031713586\n" +
            "24638|24631|Sección 3ª. Bienes con relación a los derechos de incidencia colectiva\n" +
            "24639|24638|20141112031831587\n" +
            "24640|24639|20141112031831587\n" +
            "24641|24630|Capítulo 2 - Función de garantía. Arts. 242 a 243\n" +
            "24642|24641|20141112031934588\n" +
            "24643|24642|20141112031934588\n" +
            "24644|24630|Capítulo 3 - Vivienda. Arts. 244 a 256\n" +
            "24645|24644|20141112032041589\n" +
            "24646|24645|20141112032041589\n" +
            "24647|24523|Título IV - Hechos y Actos Jurídicos. Arts. 257 a 397\n" +
            "24648|24647|Capítulo 1 - Disposiciones generales. Arts. 257 a 264\n" +
            "24649|24648|20141112032225590\n" +
            "24650|24649|20141112032225590\n" +
            "24651|24647|Capítulo 2 - Error como vicio de la voluntad. Arts. 265 a 270\n" +
            "24652|24651|20141112032508591\n" +
            "24653|24652|20141112032508591\n" +
            "24654|24647|Capítulo 3 - Dolo como vicio de la voluntad. Arts. 271 a 275\n" +
            "24655|24654|20141112032610592\n" +
            "24656|24655|20141112032610592\n" +
            "24657|24647|Capítulo 4 - Violencia como vicio de la voluntad. Arts. 276 a 278\n" +
            "24658|24657|20141112032733593\n" +
            "24659|24658|20141112032733593\n" +
            "24660|24647|Capítulo 5 - Actos jurídicos. Arts. 279 a 331\n" +
            "24661|24660|Sección 1ª. Objeto del acto jurídico\n" +
            "24662|24661|20141112032838594\n" +
            "24663|24662|20141112032838594\n" +
            "24664|24660|Sección 2ª. Causa del acto jurídico\n" +
            "24665|24664|20141112032936595\n" +
            "24666|24665|20141112032936595\n" +
            "24667|24660|Sección 3ª. Forma y prueba del acto jurídico\n" +
            "24668|24667|20141112033047596\n" +
            "24669|24668|20141112033047596\n" +
            "24670|24660|Sección 4ª. Instrumentos públicos\n" +
            "24671|24670|20141112033159597\n" +
            "24672|24671|20141112033159597\n" +
            "24673|24660|Sección 5ª. Escritura pública y acta\n" +
            "24674|24673|20141112033253598\n" +
            "24675|24674|20141112033253598\n" +
            "24676|24660|Sección 6ª. Instrumentos privados y particulares\n" +
            "24677|24676|20141112033403599\n" +
            "24678|24677|20141112033403599\n" +
            "24679|24660|Sección 7ª. Contabilidad y estados contables\n" +
            "24680|24679|20141112033518600\n" +
            "24681|24680|20141112033518600\n" +
            "24682|24647|Capítulo 6 - Vicios de los actos jurídicos. Arts. 332 a 342\n" +
            "24683|24682|Sección 1ª. Lesión\n" +
            "24684|24683|20141112033813601\n" +
            "24685|24684|20141112033813601\n" +
            "24686|24682|Sección 2ª. Simulación\n" +
            "24687|24686|20141112033910602\n" +
            "24688|24687|20141112033910602\n" +
            "24689|24682|Sección 3ª. Fraude\n" +
            "24690|24689|20141112034005603\n" +
            "24691|24690|20141112034005603\n" +
            "24692|24647|Capítulo 7 - Modalidades de los actos jurídicos. Arts. 343 a 357\n" +
            "24693|24692|Sección 1ª. Condición\n" +
            "24694|24693|20141113090654610\n" +
            "24695|24694|20141113090654610\n" +
            "24696|24692|Sección 2ª. Plazo\n" +
            "24697|24696|20141113090841611\n" +
            "24698|24697|20141113090841611\n" +
            "24699|24692|Sección 3ª. Cargo\n" +
            "24700|24699|20141113091025612\n" +
            "24701|24700|20141113091025612\n" +
            "24702|24647|Capítulo 8 - Representación. Arts. 358 a 381\n" +
            "24703|24702|Sección 1ª. Disposiciones generales\n" +
            "24704|24703|20141113091219613\n" +
            "24705|24704|20141113091219613\n" +
            "24706|24702|Sección 2ª. Representación voluntaria\n" +
            "24707|24706|20141113091316614\n" +
            "24708|24707|20141113091316614\n" +
            "24709|24647|Capítulo 9 - Ineficacia de los actos jurídicos. Arts. 382 a 397\n" +
            "24710|24709|Sección 1ª. Disposiciones generales\n" +
            "24711|24710|20141113091528615\n" +
            "24712|24711|20141113091528615\n" +
            "24713|24709|Sección 2ª. Nulidad absoluta y relativa\n" +
            "24714|24713|20141113091702616\n" +
            "24715|24714|20141113091702616\n" +
            "24716|24709|Sección 3ª. Nulidad total y parcial\n" +
            "24717|24716|20141113092059617\n" +
            "24718|24717|20141113092059617\n" +
            "24719|24709|Sección 4ª. Efectos de la nulidad\n" +
            "24720|24719|20141113092319618\n" +
            "24721|24720|20141113092319618\n" +
            "24722|24709|Sección 5ª. Confirmación\n" +
            "24723|24722|20141113092601619\n" +
            "24724|24723|20141113092601619\n" +
            "24725|24709|Sección 6ª. Inoponibilidad\n" +
            "24726|24725|20141113092841620\n" +
            "24727|24726|20141113092841620\n" +
            "24728|24523|Título V - Transmisión de los Derechos. Arts. 398 a 400\n" +
            "24729|24728|20141113092953621\n" +
            "24730|24729|20141113092953621\n" +
            "24731|426|Libro Segundo. Relaciones de Familia. Arts. 401 a 723\n" +
            "24732|24731|Título I - Matrimonio. Arts. 401 a 445\n" +
            "24733|24732|Capítulo 1 - Principios de libertad y de igualdad. Arts. 401 a 402\n" +
            "24734|24733|20141113093113622\n" +
            "24735|24734|20141113093113622\n" +
            "24736|24732|Capítulo 2 - Requisitos del matrimonio. Arts. 403 a 409\n" +
            "24737|24736|20141113093227623\n" +
            "24738|24737|20141113093227623\n" +
            "24739|24732|Capítulo 3 - Oposición a la celebración del matrimonio. Arts. 410 a 415\n" +
            "24740|24739|20141113093412624\n" +
            "24741|24740|20141113093412624\n" +
            "24742|24732|Capítulo 4 - Celebración del matrimonio. Arts. 416 a 422\n" +
            "24743|24742|Sección 1ª. Modalidad ordinaria de celebración\n" +
            "24744|24743|20141113093529625\n" +
            "24745|24744|20141113093529625\n" +
            "24746|24742|Sección 2ª. Modalidad extraordinaria de celebración\n" +
            "24747|24746|20141113093703626\n" +
            "24748|24747|20141113093703626\n" +
            "24749|24732|Capítulo 5 - Prueba del matrimonio. Art. 423\n" +
            "24750|24749|20141113093856627\n" +
            "24751|24750|20141113093856627\n" +
            "24752|24732|Capítulo 6 - Nulidad del matrimonio. Arts. 424 a 430\n" +
            "24753|24752|20141113094044628\n" +
            "24754|24753|20141113094044628\n" +
            "24755|24732|Capítulo 7 - Derechos y deberes de los cónyuges. Arts. 431 a 434\n" +
            "24756|24755|20141113094211629\n" +
            "24757|24756|20141113094211629\n" +
            "24758|24732|Capítulo 8 - Disolución del matrimonio. Arts. 435 a 445\n" +
            "24759|24758|Sección 1ª. Causales\n" +
            "24760|24759|20141113094331630\n" +
            "24761|24760|20141113094331630\n" +
            "24762|24758|Sección 2ª. Proceso de divorcio\n" +
            "24763|24762|20141113094545631\n" +
            "24764|24763|20141113094545631\n" +
            "24765|24758|Sección 3ª. Efectos del divorcio\n" +
            "24766|24765|20141113095345632\n" +
            "24767|24766|20141113095345632\n" +
            "24768|24731|Título II - Régimen Patrimonial del Matrimonio. Arts. 446 a 508\n" +
            "24769|24768|Capítulo 1- Disposiciones generales. Arts. 446 a 462\n" +
            "24770|24769|Sección 1ª. Convenciones matrimoniales\n" +
            "24771|24770|20141113095448633\n" +
            "24772|24771|20141113095448633\n" +
            "24773|24769|Sección 2ª. Donaciones por razón de matrimonio\n" +
            "24774|24773|20141113095547634\n" +
            "24775|24774|20141113095547634\n" +
            "24776|24769|Sección 3ª. Disposiciones comunes a todos los regímenes\n" +
            "24777|24776|20141113095643635\n" +
            "24778|24777|20141113095643635\n" +
            "24779|24768|Capítulo 2 - Régimen de comunidad. Arts. 463 a 504\n" +
            "24780|24779|Sección 1ª. Disposiciones generales\n" +
            "24781|24780|20141113095754636\n" +
            "24782|24781|20141113095754636\n" +
            "24783|24779|Sección 2ª. Bienes de los cónyuges\n" +
            "24784|24783|20141113100005637\n" +
            "24785|24784|20141113100005637\n" +
            "24786|24779|Sección 3ª. Deudas de los cónyuges\n" +
            "24787|24786|20141113100125638\n" +
            "24788|24787|20141113100125638\n" +
            "24789|24779|Sección 4ª. Gestión de los bienes en la comunidad\n" +
            "24790|24789|20141113100326639\n" +
            "24791|24790|20141113100326639\n" +
            "24792|24779|Sección 5ª. Extinción de la comunidad\n" +
            "24793|24792|20141113100435640\n" +
            "24794|24793|20141113100435640\n" +
            "24795|24779|Sección 6ª. Indivisión postcomunitaria\n" +
            "24796|24795|20141113100952641\n" +
            "24797|24796|20141113100952641\n" +
            "24798|24779|Sección 7ª. Liquidación de la comunidad\n" +
            "24799|24798|20141113101458642\n" +
            "24800|24799|20141113101458642\n" +
            "24801|24779|Sección 8ª. Partición de la comunidad\n" +
            "24802|24801|20141113115302643\n" +
            "24803|24802|20141113115302643\n" +
            "24804|24768|Capítulo 3 - Régimen de separación de bienes. Arts. 505 a 508\n" +
            "24805|24804|20141113115521644\n" +
            "24806|24805|20141113115521644\n" +
            "24807|24731|Título III - Uniones Convivenciales. Arts. 509 a 528\n" +
            "24808|24807|Capítulo 1 - Constitución y prueba. Arts. 509 a 512\n" +
            "24809|24808|20141113115740645\n" +
            "24810|24809|20141113115740645\n" +
            "24811|24807|Capítulo 2 - Pactos de convivencia. Arts. 513 a 517\n" +
            "24812|24811|20141113115859646\n" +
            "24813|24812|20141113115859646\n" +
            "24814|24807|Capítulo 3 - Efectos de las uniones convivenciales durante la convivencia. Arts. 518 a 522\n" +
            "24815|24814|20141113120005647\n" +
            "24816|24815|20141113120005647\n" +
            "24817|24807|Capítulo 4 - Cese de la convivencia. Efectos. Arts. 523 a 528\n" +
            "24818|24817|20141113120122648\n" +
            "24819|24818|20141113120122648\n" +
            "24820|24731|Título IV - Parentesco. Arts. 529 a 557\n" +
            "24821|24820|Capítulo 1 - Disposiciones generales. Arts. 529 a 536\n" +
            "24822|24821|20141113120311649\n" +
            "24823|24822|20141113120311649\n" +
            "24824|24820|Capítulo 2 - Deberes y derechos de los parientes. Arts. 537 a 557\n" +
            "24825|24824|Sección 1ª. Alimentos\n" +
            "24826|24825|20141113120544650\n" +
            "24827|24826|20141113120544650\n" +
            "24828|24824|Sección 2ª. Derecho de comunicación\n" +
            "24829|24828|20141113120654651\n" +
            "24830|24829|20141113120654651\n" +
            "24831|24731|Título V - Filiación. Arts. 558 a 593\n" +
            "24832|24831|Capítulo 1 - Disposiciones generales. Arts. 558 a 559\n" +
            "24833|24832|20141113120848652\n" +
            "24834|24833|20141113120848652\n" +
            "24835|24831|Capítulo 2 - Reglas generales relativas a la filiación por técnicas de reproducción humana asistida. Arts. 560 a 564\n" +
            "24836|24835|20141113121101653\n" +
            "24837|24836|20141113121101653\n" +
            "24838|24831|Capítulo 3 - Determinación de la maternidad. Art. 565\n" +
            "24839|24838|20141113121220654\n" +
            "24840|24839|20141113121220654\n" +
            "24841|24831|Capítulo 4 - Determinación de la filiación matrimonial. Arts. 566 a 569\n" +
            "24842|24841|20141113121327655\n" +
            "24843|24842|20141113121327655\n" +
            "24844|24831|Capítulo 5 - Determinación de la filiación extramatrimonial. Arts. 570 a 575\n" +
            "24845|24844|20141113121440656\n" +
            "24846|24845|20141113121440656\n" +
            "24847|24831|Capítulo 6 - Acciones de filiación. Disposiciones generales. Arts. 576 a 581\n" +
            "24848|24847|20141113121554657\n" +
            "24849|24848|20141113121554657\n" +
            "24850|24831|Capítulo 7 - Acciones de reclamación de filiación. Arts. 582 a 587\n" +
            "24851|24850|20141113121722658\n" +
            "24852|24851|20141113121722658\n" +
            "24853|24831|Capítulo 8 - Acciones de impugnación de filiación. Arts. 588 a 593\n" +
            "24854|24853|20141113122120659\n" +
            "24855|24854|20141113122120659\n" +
            "24856|24731|Título VI - Adopción. Arts. 594 a 637\n" +
            "24857|24856|Capítulo 1 - Disposiciones generales. Arts. 594 a 606\n" +
            "24858|24857|20141113122248660\n" +
            "24859|24858|20141113122248660\n" +
            "24860|24856|Capítulo 2 - Declaración judicial de la situación de adoptabilidad. Arts. 607 a 610\n" +
            "24861|24860|20141113122410661\n" +
            "24862|24861|20141113122410661\n" +
            "24863|24856|Capítulo 3 - Guarda con fines de adopción. Arts. 611 a 614\n" +
            "24864|24863|20141113122614662\n" +
            "24865|24864|20141113122614662\n" +
            "24866|24856|Capítulo 4 - Juicio de adopción. Arts. 615 a 618\n" +
            "24867|24866|20141113122724663\n" +
            "24868|24867|20141113122724663\n" +
            "24869|24856|Capítulo 5 - Tipos de adopción. Arts. 619 a 633\n" +
            "24870|24869|Sección 1ª. Disposiciones generales\n" +
            "24871|24870|20141113122912664\n" +
            "24872|24871|20141113122912664\n" +
            "24873|24869|Sección 2ª. Adopción plena\n" +
            "24874|24873|20141113123020665\n" +
            "24875|24874|20141113123020665\n" +
            "24876|24869|Sección 3ª. Adopción simple\n" +
            "24877|24876|20141113123742666\n" +
            "24878|24877|20141113123742666\n" +
            "24879|24869|Sección 4ª. Adopción de integración\n" +
            "24880|24879|20141113123845667\n" +
            "24881|24880|20141113123845667\n" +
            "24882|24856|Capítulo 6 - Nulidad e inscripción. Arts. 634 a 637\n" +
            "24883|24882|20141113123959668\n" +
            "24884|24883|20141113123959668\n" +
            "24885|24731|Título VII - Responsabilidad Parental. Arts. 638 a 704\n" +
            "24886|24885|Capítulo 1 - Principios generales de la responsabilidad parental. Arts. 638 a 640\n" +
            "24887|24886|20141113124103669\n" +
            "24888|24887|20141113124103669\n" +
            "24889|24885|Capítulo 2 - Titularidad y ejercicio de la responsabilidad parental. Arts. 641 a 645\n" +
            "24890|24889|20141113124212670\n" +
            "24891|24890|20141113124212670\n" +
            "24892|24885|Capítulo 3 - Deberes y derechos de los progenitores. Reglas generales. Arts. 646 a 647\n" +
            "24893|24892|20141113124334671\n" +
            "24894|24893|20141113124334671\n" +
            "24895|24885|Capítulo 4 - Deberes y derechos sobre el cuidado de los hijos. Arts. 648 a 657\n" +
            "24896|24895|20141113124429672\n" +
            "24897|24896|20141113124429672\n" +
            "24898|24885|Capítulo 5 - Deberes y derechos de los progenitores. Obligación de alimentos. Arts. 658 a 670\n" +
            "24899|24898|20141113124529673\n" +
            "24900|24899|20141113124529673\n" +
            "24901|24885|Capítulo 6 - Deberes de los hijos. Art. 671\n" +
            "24902|24901|20141113124630674\n" +
            "24903|24902|20141113124630674\n" +
            "24904|24885|Capítulo 7 - Deberes y derechos de los progenitores e hijos afines. Arts. 672 a 676\n" +
            "24905|24904|20141113124722675\n" +
            "24906|24905|20141113124722675\n" +
            "24907|24885|Capítulo 8 - Representación, disposición y administración de los bienes del hijo menor de edad. Arts. 677 a 698\n" +
            "24908|24907|20141113124819676\n" +
            "24909|24908|20141113124819676\n" +
            "24910|24885|Capítulo 9 - Extinción, privación, suspensión y rehabilitación de la responsabilidad parental. Arts. 699 a 704\n" +
            "24911|24910|20141113124925677\n" +
            "24912|24911|20141113124925677\n" +
            "24913|24731|Título VIII - Procesos de Familia. Arts. 705 a 723\n" +
            "24914|24913|Capítulo 1 - Disposiciones generales. Arts. 705 a 711\n" +
            "24915|24914|20141113125033678\n" +
            "24916|24915|20141113125033678\n" +
            "24917|24913|Capítulo 2 - Acciones de estado de familia. Arts. 712 a 715\n" +
            "24918|24917|20141113125122679\n" +
            "24919|24918|20141113125122679\n" +
            "24920|24913|Capítulo 3 - Reglas de competencia. Arts. 716 a 720\n" +
            "24921|24920|20141113125244680\n" +
            "24922|24921|20141113125244680\n" +
            "24923|24913|Capítulo 4 - Medidas provisionales. Arts. 721 a 723\n" +
            "24924|24923|20141113125338681\n" +
            "24925|24924|20141113125338681\n" +
            "24926|426|Libro Tercero. Derechos Personales. Arts. 724 a 1881\n" +
            "24927|24926|Título I - Obligaciones en General. Arts. 724 a 956\n" +
            "24928|24927|Capítulo 1 - Disposiciones generales. Arts. 724 a 735\n" +
            "24929|24928|20141113125714682\n" +
            "24930|24929|20141113125714682\n" +
            "24931|24927|Capítulo 2 - Acciones y garantía común de los acreedores. Arts. 736 a 745\n" +
            "24932|24931|Sección 1ª. Acción directa\n" +
            "24933|24932|20141113125912683\n" +
            "24934|24933|20141113125912683\n" +
            "24935|24931|Sección 2ª. Acción subrogatoria\n" +
            "24936|24935|20141113020338684\n" +
            "24937|24936|20141113020338684\n" +
            "24938|24931|Sección 3ª. Garantía común de los acreedores\n" +
            "24939|24938|20141113020458685\n" +
            "24940|24939|20141113020458685\n" +
            "24941|24927|Capítulo 3 - Clases de obligaciones. Arts. 746 a 864\n" +
            "24942|24941|Sección 1ª. Obligaciones de dar\n" +
            "24943|24942|Parágrafo 1°. Disposiciones generales\n" +
            "24944|24943|20141113020619686\n" +
            "24945|24942|Parágrafo 2°. Obligaciones de dar cosa cierta para constituir derechos reales\n" +
            "24946|24945|20141113020815687\n" +
            "24947|24942|Parágrafo 3°. Obligaciones de dar para restituir\n" +
            "24948|24947|20141113021025688\n" +
            "24949|24942|Parágrafo 4°. Obligaciones de género\n" +
            "24950|24949|20141113021125689\n" +
            "24951|24942|Parágrafo 5°. Obligaciones relativas a bienes que no son cosas\n" +
            "24952|24951|20141113021254690\n" +
            "24953|24942|Parágrafo 6°. Obligaciones de dar dinero\n" +
            "24954|24953|20141113021400691\n" +
            "24955|24941|Sección 2ª. Obligaciones de hacer y de no hacer\n" +
            "24956|24955|20141113021511692\n" +
            "24957|24956|20141113021511692\n" +
            "24958|24941|Sección 3ª. Obligaciones alternativas\n" +
            "24959|24958|20141113021613693\n" +
            "24960|24959|20141113021613693\n" +
            "24961|24941|Sección 4ª. Obligaciones facultativas\n" +
            "24962|24961|20141113021714694\n" +
            "24963|24962|20141113021714694\n" +
            "24964|24941|Sección 5ª. Obligaciones con cláusula penal y sanciones conminatorias\n" +
            "24965|24964|20141113021802695\n" +
            "24966|24965|20141113021802695\n" +
            "24967|24941|Sección 6ª. Obligaciones divisibles e indivisibles\n" +
            "24968|24967|Parágrafo 1°. Obligaciones divisibles\n" +
            "24969|24968|20141113021923696\n" +
            "24970|24967|Parágrafo 2°. Obligaciones indivisibles\n" +
            "24971|24970|20141113022029697\n" +
            "24972|24941|Sección 7ª. Obligaciones de sujeto plural\n" +
            "24973|24972|Parágrafo 1°. Obligaciones simplemente mancomunadas\n" +
            "24974|24973|20141113022121698\n" +
            "24975|24972|Parágrafo 2°. Obligaciones solidarias. Disposiciones generales\n" +
            "24976|24975|20141113022234699\n" +
            "24977|24972|Parágrafo 3°. Solidaridad pasiva\n" +
            "24978|24977|20141113022415700\n" +
            "24979|24972|Parágrafo 4°. Solidaridad activa\n" +
            "24980|24979|20141113022507701\n" +
            "24981|24941|Sección 8ª. Obligaciones concurrentes\n" +
            "24982|24981|20141113022607702\n" +
            "24983|24982|20141113022607702\n" +
            "24984|24941|Sección 9ª. Obligaciones disyuntivas\n" +
            "24985|24984|20141113022711703\n" +
            "24986|24985|20141113022711703\n" +
            "24987|24941|Sección 10ª. Obligaciones principales y accesorias\n" +
            "24988|24987|20141113022834704\n" +
            "24989|24988|20141113022834704\n" +
            "24990|24941|Sección 11ª. Rendición de cuentas\n" +
            "24991|24990|20141113022934705\n" +
            "24992|24991|20141113022934705\n" +
            "24993|24927|Capítulo 4 - Pago. Arts. 865 a 920\n" +
            "24994|24993|Sección 1ª. Disposiciones generales\n" +
            "24995|24994|20141113023035706\n" +
            "24996|24995|20141113023035706\n" +
            "24997|24993|Sección 2ª. Mora\n" +
            "24998|24997|20141113023133707\n" +
            "24999|24998|20141113023133707\n" +
            "25000|24993|Sección 3ª. Pago a mejor fortuna\n" +
            "25001|25000|20141113023226708\n" +
            "25002|25001|20141113023226708\n" +
            "25003|24993|Sección 4ª. Beneficio de competencia\n" +
            "25004|25003|20141113023311709\n" +
            "25005|25004|20141113023311709\n" +
            "25006|24993|Sección 5ª. Prueba del pago\n" +
            "25007|25006|20141113023427710\n" +
            "25008|25007|20141113023427710\n" +
            "25009|24993|Sección 6ª. Imputación del pago\n" +
            "25010|25009|20141113023524711\n" +
            "25011|25010|20141113023524711\n" +
            "25012|24993|Sección 7ª. Pago por consignación\n" +
            "25013|25012|Parágrafo 1°. Consignación judicial\n" +
            "25014|25013|20141113023615712\n" +
            "25015|25012|Parágrafo 2°. Consignación extrajudicial\n" +
            "25016|25015|20141113023707713\n" +
            "25017|24993|Sección 8ª. Pago por subrogación\n" +
            "25018|25017|20141113023755714\n" +
            "25019|25018|20141113023755714\n" +
            "25020|24927|Capítulo 5 - Otros modos de extinción. Arts. 921 a 956\n" +
            "25021|25020|Sección 1ª. Compensación\n" +
            "25022|25021|20141113023857715\n" +
            "25023|25022|20141113023857715\n" +
            "25024|25020|Sección 2ª. Confusión\n" +
            "25025|25024|20141113023949716\n" +
            "25026|25025|20141113023949716\n" +
            "25027|25020|Sección 3ª. Novación\n" +
            "25028|25027|20141113024137717\n" +
            "25029|25028|20141113024137717\n" +
            "25030|25020|Sección 4ª. Dación en pago\n" +
            "25031|25030|20141113024231718\n" +
            "25032|25031|20141113024231718\n" +
            "25033|25020|Sección 5ª. Renuncia y remisión\n" +
            "25034|25033|20141113024325719\n" +
            "25035|25034|20141113024325719\n" +
            "25036|25020|Sección 6ª. Imposibilidad de cumplimiento\n" +
            "25037|25036|20141113024417720\n" +
            "25038|25037|20141113024417720\n" +
            "25039|24926|Título II - Contratos en General. Arts. 957 a 1091\n" +
            "25040|25039|Capítulo 1 - Disposiciones generales. Arts. 957 a 965\n" +
            "25041|25040|20141113024512721\n" +
            "25042|25041|20141113024512721\n" +
            "25043|25039|Capítulo 2 - Clasificación de los contratos. Arts. 966 a 970\n" +
            "25044|25043|20141113024608722\n" +
            "25045|25044|20141113024608722\n" +
            "25046|25039|Capítulo 3 - Formación del consentimiento. Arts. 971 a 999\n" +
            "25047|25046|Sección 1ª. Consentimiento, oferta y aceptación\n" +
            "25048|25047|20141113024706723\n" +
            "25049|25048|20141113024706723\n" +
            "25050|25046|Sección 2ª. Contratos celebrados por adhesión a cláusulas generales predispuestas\n" +
            "25051|25050|20141113024758724\n" +
            "25052|25051|20141113024758724\n" +
            "25053|25046|Sección 3ª. Tentativas contractuales\n" +
            "25054|25053|20141113024903725\n" +
            "25055|25054|20141113024903725\n" +
            "25056|25046|Sección 4ª. Contratos preliminares\n" +
            "25057|25056|20141113024958726\n" +
            "25058|25057|20141113024958726\n" +
            "25059|25046|Sección 5ª. Pacto de preferencia y contrato sujeto a conformidad\n" +
            "25060|25059|20141113025051727\n" +
            "25061|25060|20141113025051727\n" +
            "25062|25039|Capítulo 4 - Incapacidad e inhabilidad para contratar. Arts. 1000 a 1002\n" +
            "25063|25062|20141113025140728\n" +
            "25064|25063|20141113025140728\n" +
            "25065|25039|Capítulo 5 - Objeto. Arts. 1003 a 1011\n" +
            "25066|25065|20141113025241729\n" +
            "25067|25066|20141113025241729\n" +
            "25068|25039|Capítulo 6 - Causa. Arts. 1012 a 1014\n" +
            "25069|25068|20141113025341730\n" +
            "25070|25069|20141113025341730\n" +
            "25071|25039|Capítulo 7 - Forma. Arts. 1015 a 1018\n" +
            "25072|25071|20141113025433731\n" +
            "25073|25072|20141113025433731\n" +
            "25074|25039|Capítulo 8 - Prueba. Arts. 1019 a 1020\n" +
            "25075|25074|20141113025548732\n" +
            "25076|25075|20141113025548732\n" +
            "25077|25039|Capítulo 9 - Efectos. Arts. 1021 a 1060\n" +
            "25078|25077|Sección 1ª. Efecto relativo\n" +
            "25079|25078|20141113025638733\n" +
            "25080|25079|20141113025638733\n" +
            "25081|25077|Sección 2ª. Incorporación de terceros al contrato\n" +
            "25082|25081|20141113025752734\n" +
            "25083|25082|20141113025752734\n" +
            "25084|25077|Sección 3ª. Suspensión del cumplimiento y fuerza mayor\n" +
            "25085|25084|20141113025842735\n" +
            "25086|25085|20141113025842735\n" +
            "25087|25077|Sección 4ª. Obligación de saneamiento\n" +
            "25088|25087|Parágrafo 1°. Disposiciones generales\n" +
            "25089|25088|20141113025946736\n" +
            "25090|25087|Parágrafo 2°. Responsabilidad por evicción\n" +
            "25091|25090|20141113030117737\n" +
            "25092|25087|Parágrafo 3°. Responsabilidad por vicios ocultos\n" +
            "25093|25092|20141113030203738\n" +
            "25094|25077|Sección 5ª. Señal\n" +
            "25095|25094|20141113030254739\n" +
            "25096|25095|20141113030254739\n" +
            "25097|25039|Capítulo 10 - Interpretación. Arts. 1061 a 1068\n" +
            "25098|25097|20141113030345740\n" +
            "25099|25098|20141113030345740\n" +
            "25100|25039|Capítulo 11 - Subcontrato. Arts. 1069 a 1072\n" +
            "25101|25100|20141113030435741\n" +
            "25102|25101|20141113030435741\n" +
            "25103|25039|Capítulo 12 - Contratos conexos. Arts. 1073 a 1075\n" +
            "25104|25103|20141113030526742\n" +
            "25105|25104|20141113030526742\n" +
            "25106|25039|Capítulo 13 - Extinción, modificación y adecuación del contrato. Arts. 1076 a 1091\n" +
            "25107|25106|20141113030618743\n" +
            "25108|25107|20141113030618743\n" +
            "25109|24926|Título III - Contratos de Consumo. Arts. 1092 a 1122\n" +
            "25110|25109|Capítulo 1 - Relación de consumo. Arts. 1092 a 1095\n" +
            "25111|25110|20141113030710744\n" +
            "25112|25111|20141113030710744\n" +
            "25113|25109|Capítulo 2 - Formación del consentimiento. Arts. 1096 a 1103\n" +
            "25114|25113|Sección 1ª. Prácticas abusivas\n" +
            "25115|25114|20141113030806745\n" +
            "25116|25115|20141113030806745\n" +
            "25117|25113|Sección 2ª. Información y publicidad dirigida a los consumidores\n" +
            "25118|25117|20141113030855746\n" +
            "25119|25118|20141113030855746\n" +
            "25120|25109|Capítulo 3 - Modalidades especiales. Arts. 1104 a 1116\n" +
            "25121|25120|20141113030938747\n" +
            "25122|25121|20141113030938747\n" +
            "25123|25109|Capítulo 4 - Cláusulas abusivas. Arts. 1116 a 1122\n" +
            "25124|25123|20141113031022748\n" +
            "25125|25124|20141113031022748\n" +
            "25126|24926|Título IV - Contratos en Particular. Arts. 1123 a 1707\n" +
            "25127|25126|Capítulo 1 - Compraventa. Arts. 1123 a 1171\n" +
            "25128|25127|Sección 1ª. Disposiciones generales\n" +
            "25129|25128|20141113031132749\n" +
            "25130|25129|20141113031132749\n" +
            "25131|25127|Sección 2ª. Cosa vendida\n" +
            "25132|25131|20141113031229750\n" +
            "25133|25132|20141113031229750\n" +
            "25134|25127|Sección 3ª. Precio\n" +
            "25135|25134|20141113031316751\n" +
            "25136|25135|20141113031316751\n" +
            "25137|25127|Sección 4ª. Obligaciones del vendedor\n" +
            "25138|25137|20141113031423752\n" +
            "25139|25138|20141113031423752\n" +
            "25140|25127|Sección 5ª. Obligaciones del comprador\n" +
            "25141|25140|20141113031515753\n" +
            "25142|25141|20141113031515753\n" +
            "25143|25127|Sección 6ª. Compraventa de cosas muebles\n" +
            "25144|25143|20141113031609754\n" +
            "25145|25144|20141113031609754\n" +
            "25146|25143|Parágrafo 1°. Precio\n" +
            "25147|25146|20141113031711755\n" +
            "25148|25143|Parágrafo 2°. Entrega de la documentación\n" +
            "25149|25148|20141113031816756\n" +
            "25150|25143|Parágrafo 3°. Entrega de la cosa\n" +
            "25151|25150|20141113031939757\n" +
            "25152|25143|Parágrafo 4°. Recepción de la cosa y pago del precio\n" +
            "25153|25152|20141113032029758\n" +
            "25154|25127|Sección 7ª. Algunas cláusulas que pueden ser agregadas al contrato de compraventa\n" +
            "25155|25154|20141113032119759\n" +
            "25156|25155|20141113032119759\n" +
            "25157|25127|Sección 8ª. Boleto de compraventa\n" +
            "25158|25157|20141113032208760\n" +
            "25159|25158|20141113032208760\n" +
            "25160|25126|Capítulo 2 - Permuta. Arts. 1172 a 1175\n" +
            "25161|25160|20141113032311761\n" +
            "25162|25161|20141113032311761\n" +
            "25163|25126|Capítulo 3 - Suministro. Arts. 1176 a 1186\n" +
            "25164|25163|20141113032410762\n" +
            "25165|25164|20141113032410762\n" +
            "25166|25126|Capítulo 4 - Locación. Arts. 1187 a 1226\n" +
            "25167|25166|Sección 1ª. Disposiciones generales\n" +
            "25168|25167|20141113032509763\n" +
            "25169|25168|20141113032509763\n" +
            "25170|25166|Sección 2ª. Objeto y destino\n" +
            "25171|25170|20141113032603764\n" +
            "25172|25171|20141113032603764\n" +
            "25173|25166|Sección 3ª. Tiempo de la locación\n" +
            "25174|25173|20141113032654765\n" +
            "25175|25174|20141113032654765\n" +
            "25176|25166|Sección 4ª. Efectos de la locación\n" +
            "25177|25176|Parágrafo 1°. Obligaciones del locador\n" +
            "25178|25177|20141113032748766\n" +
            "25179|25176|Parágrafo 2°. Obligaciones del locatario\n" +
            "25180|25179|20141113032837767\n" +
            "25181|25176|Parágrafo 3°. Régimen de mejoras\n" +
            "25182|25181|20141113032926768\n" +
            "25183|25166|Sección 5ª. Cesión y sublocación\n" +
            "25184|25183|20141113033027769\n" +
            "25185|25184|20141113033027769\n" +
            "25186|25166|Sección 6ª. Extinción\n" +
            "25187|25186|20141113033130770\n" +
            "25188|25187|20141113033130770\n" +
            "25189|25166|Sección 7ª. Efectos de la extinción\n" +
            "25190|25189|20141113033213771\n" +
            "25191|25190|20141113033213771\n" +
            "25192|25126|Capítulo 5 - Leasing. Arts. 1227 a 1250\n" +
            "25193|25192|20141113033253772\n" +
            "25194|25193|20141113033253772\n" +
            "25195|25126|Capítulo 6 - Obra y servicios. Arts. 1251 a 1279\n" +
            "25196|25195|Sección 1ª. Disposiciones comunes a la obras y a los servicios\n" +
            "25197|25196|20141113033343773\n" +
            "25198|25197|20141113033343773\n" +
            "25199|25195|Sección 2ª. Disposiciones especiales para las obras\n" +
            "25200|25199|20141113033434774\n" +
            "25201|25200|20141113033434774\n" +
            "25202|25195|Sección 3ª. Normas especiales para los servicios\n" +
            "25203|25202|20141113033543775\n" +
            "25204|25203|20141113033543775\n" +
            "25205|25126|Capítulo 7 - Transporte. Arts. 1280 a 1318\n" +
            "25206|25205|Sección 1ª. Disposiciones generales\n" +
            "25207|25206|20141113033642776\n" +
            "25208|25207|20141113033642776\n" +
            "25209|25205|Sección 2ª. Transporte de personas\n" +
            "25210|25209|20141113033730777\n" +
            "25211|25210|20141113033730777\n" +
            "25212|25205|Sección 3ª. Transporte de cosas\n" +
            "25213|25212|20141113033841778\n" +
            "25214|25213|20141113033841778\n" +
            "25215|25126|Capítulo 8 - Mandato. Arts. 1319 a 1334\n" +
            "25216|25215|20141113033934779\n" +
            "25217|25216|20141113033934779\n" +
            "25218|25126|Capítulo 9 - Contrato de consignación. Arts. 1335 a 1344\n" +
            "25219|25218|20141113034021780\n" +
            "25220|25219|20141113034021780\n" +
            "25221|25126|Capítulo 10 - Corretaje. Arts. 1345 a 1355\n" +
            "25222|25221|20141113034451781\n" +
            "25223|25222|20141113034451781\n" +
            "25224|25126|Capítulo 11 - Depósito. Arts. 1356 a 1377\n" +
            "25225|25224|Sección 1ª. Disposiciones generales\n" +
            "25226|25225|20141113034600782\n" +
            "25227|25226|20141113034600782\n" +
            "25228|25224|Sección 2ª. Depósito irregular\n" +
            "25229|25228|20141113034710783\n" +
            "25230|25229|20141113034710783\n" +
            "25231|25224|Sección 3ª. Depósito necesario\n" +
            "25232|25231|20141113034803784\n" +
            "25233|25232|20141113034803784\n" +
            "25234|25224|Sección 4ª. Casas de depósito\n" +
            "25235|25234|20141113034856785\n" +
            "25236|25235|20141113034856785\n" +
            "25237|25126|Capítulo 12 - Contratos bancarios. Arts. 1378 a 1420\n" +
            "25238|25237|Sección 1ª. Disposiciones generales\n" +
            "25239|25238|Parágrafo 1°. Transparencia de las condiciones contractuales\n" +
            "25240|25239|20141113035610788\n" +
            "25241|25238|Parágrafo 2°. Contratos bancarios con consumidores y usuarios\n" +
            "25242|25241|20141113035100787\n" +
            "25243|25237|Sección 2ª. Contratos en particular\n" +
            "25244|25243|Parágrafo 1°. Depósito bancario\n" +
            "25245|25244|20141113034951786\n" +
            "25246|25243|Parágrafo 2°. Cuenta corriente bancaria\n" +
            "25247|25246|20141113035727789\n" +
            "25248|25243|Parágrafo 3°. Préstamo y descuento bancario\n" +
            "25249|25248|20141113035827790\n" +
            "25250|25243|Parágrafo 4°. Apertura de crédito\n" +
            "25251|25250|20141113035927791\n" +
            "25252|25243|Parágrafo 5°. Servicio de caja de seguridad\n" +
            "25253|25252|20141113040013792\n" +
            "25254|25243|Parágrafo 6°. Custodia de títulos\n" +
            "25255|25254|20141113040102793\n" +
            "25256|25126|Capítulo 13 - Contrato de factoraje. Arts. 1421 a 1428\n" +
            "25257|25256|20141113040203794\n" +
            "25258|25257|20141113040203794\n" +
            "25259|25126|Capítulo 14 - Contratos celebrados en bolsa o mercado de comercio. Art. 1429\n" +
            "25260|25259|20141113040255795\n" +
            "25261|25260|20141113040255795\n" +
            "25262|25126|Capítulo 15 - Cuenta corriente. Arts. 1430 a 1441\n" +
            "25263|25262|20141113040346796\n" +
            "25264|25263|20141113040346796\n" +
            "25265|25126|Capítulo 16 - Contratos asociativos. Arts. 1442 a 1478\n" +
            "25266|25265|Sección 1ª. Disposiciones generales\n" +
            "25267|25266|20141113040447797\n" +
            "25268|25267|20141113040447797\n" +
            "25269|25265|Sección 2ª. Negocio en participación\n" +
            "25270|25269|20141113040539798\n" +
            "25271|25270|20141113040539798\n" +
            "25272|25265|Sección 3ª. Agrupaciones de colaboración\n" +
            "25273|25272|20141113040712799\n" +
            "25274|25273|20141113040712799\n" +
            "25275|25265|Sección 4ª. Uniones Transitorias\n" +
            "25276|25275|20141113040810800\n" +
            "25277|25276|20141113040810800\n" +
            "25278|25265|Sección 5ª. Consorcios de cooperación\n" +
            "25279|25278|20141113040902801\n" +
            "25280|25279|20141113040902801\n" +
            "25281|25126|Capítulo 17 - Agencia. Arts. 1479 a 1501\n" +
            "25282|25281|20141113040959802\n" +
            "25283|25282|20141113040959802\n" +
            "25284|25126|Capítulo 18 - Concesión. Arts. 1502 a 1511\n" +
            "25285|25284|20141113041051803\n" +
            "25286|25285|20141113041051803\n" +
            "25287|25126|Capítulo 19 - Franquicia. Arts. 1512 a 1524\n" +
            "25288|25287|20141113041141804\n" +
            "25289|25288|20141113041141804\n" +
            "25290|25126|Capítulo 20 - Mutuo. Arts. 1525 a 1532\n" +
            "25291|25290|20141113041248805\n" +
            "25292|25291|20141113041248805\n" +
            "25293|25126|Capítulo 21 - Comodato. Arts. 1533 a 1541\n" +
            "25294|25293|20141113041340806\n" +
            "25295|25294|20141113041340806\n" +
            "25296|25126|Capítulo 22 - Donación. Arts. 1542 a 1573\n" +
            "25297|25296|Sección 1ª. Disposiciones generales\n" +
            "25298|25297|20141113041500807\n" +
            "25299|25298|20141113041500807\n" +
            "25300|25296|Sección 2ª. Efectos\n" +
            "25301|25300|20141113041555808\n" +
            "25302|25301|20141113041555808\n" +
            "25303|25296|Sección 3ª. Algunas donaciones en particular\n" +
            "25304|25303|20141113041703809\n" +
            "25305|25304|20141113041703809\n" +
            "25306|25296|Sección 4ª. Reversión y revocación\n" +
            "25307|25306|20141113041755810\n" +
            "25308|25307|20141113041755810\n" +
            "25309|25126|Capítulo 23 - Fianza. Arts 1574 a 1598\n" +
            "25310|25309|Sección 1ª. Disposiciones generales\n" +
            "25311|25310|20141113041851811\n" +
            "25312|25311|20141113041851811\n" +
            "25313|25309|Sección 2ª. Efectos entre el fiador y el acreedor\n" +
            "25314|25313|20141113041948812\n" +
            "25315|25314|20141113041948812\n" +
            "25316|25309|Sección 3ª. Efectos entre el deudor y el fiador\n" +
            "25317|25316|20141113042050813\n" +
            "25318|25317|20141113042050813\n" +
            "25319|25309|Sección 4ª. Efectos entre los cofiadores\n" +
            "25320|25319|20141113042142814\n" +
            "25321|25320|20141113042142814\n" +
            "25322|25309|Sección 5ª. Extinción de la fianza\n" +
            "25323|25322|20141113042235815\n" +
            "25324|25323|20141113042235815\n" +
            "25325|25126|Capítulo 24 - Contrato oneroso de renta vitalicia. Arts. 1599 a 1608\n" +
            "25326|25325|20141113042331816\n" +
            "25327|25326|20141113042331816\n" +
            "25328|25126|Capítulo 25 - Contratos de juego y de apuesta. Arts. 1609 a 1613\n" +
            "25329|25328|20141113042433817\n" +
            "25330|25329|20141113042433817\n" +
            "25331|25126|Capítulo 26 - Cesión de derechos. Arts. 1614 a 1635\n" +
            "25332|25331|Sección 1ª. Disposiciones generales\n" +
            "25333|25332|20141113042524818\n" +
            "25334|25333|20141113042524818\n" +
            "25335|25331|Sección 2ª. Cesión de deudas\n" +
            "25336|25335|20141113042614819\n" +
            "25337|25336|20141113042614819\n" +
            "25338|25126|Capítulo 27 - Cesión de la posición contractual. Arts. 1636 a 1640\n" +
            "25339|25338|20141113042713820\n" +
            "25340|25339|20141113042713820\n" +
            "25341|25126|Capítulo 28 - Transacción. Arts. 1641 a 1648\n" +
            "25342|25341|20141113042807821\n" +
            "25343|25342|20141113042807821\n" +
            "25344|25126|Capítulo 29 - Contrato de arbitraje. Arts. 1648 a 1665\n" +
            "25345|25344|20141113042858822\n" +
            "25346|25345|20141113042858822\n" +
            "25347|25126|Capítulo 30 - Contrato de fideicomiso. Arts. 1666 a 1700\n" +
            "25348|25347|Sección 1ª. Disposiciones generales\n" +
            "25349|25348|20141113044545823\n" +
            "25350|25349|20141113044545823\n" +
            "25351|25347|Sección 2ª. Sujetos\n" +
            "25352|25351|20141113044643824\n" +
            "25353|25352|20141113044643824\n" +
            "25354|25347|Sección 3ª. Efectos\n" +
            "25355|25354|20141113044749825\n" +
            "25356|25355|20141113044749825\n" +
            "25357|25347|Sección 4ª. Fideicomiso financiero\n" +
            "25358|25357|20141113044841826\n" +
            "25359|25358|20141113044841826\n" +
            "25360|25347|Sección 5ª. Certificados de participación y títulos de deuda\n" +
            "25361|25360|20141113044939827\n" +
            "25362|25361|20141113044939827\n" +
            "25363|25347|Sección 6ª. Asambleas de tenedores de títulos representativos de deuda o certificados de participación\n" +
            "25364|25363|20141113045033828\n" +
            "25365|25364|20141113045033828\n" +
            "25366|25347|Sección 7ª. Extinción del fideicomiso\n" +
            "25367|25366|20141113045145829\n" +
            "25368|25367|20141113045145829\n" +
            "25369|25347|Sección 8ª. Fideicomiso testamentario\n" +
            "25370|25369|20141113045233830\n" +
            "25371|25370|20141113045233830\n" +
            "25372|25126|Capítulo 31 - Dominio fiduciario. Arts. 1701 a 1707\n" +
            "25373|25372|20141113045328831\n" +
            "25374|25373|20141113045328831\n" +
            "25375|24926|Título V - Otras Fuentes de las Obligaciones. Arts. 1708 a 1881\n" +
            "25376|25375|Capítulo 1 - Responsabilidad civil. Arts. 1708 a 1780\n" +
            "25377|25376|Sección 1ª. Disposiciones generales\n" +
            "25378|25377|20141113045728832\n" +
            "25379|25378|20141113045728832\n" +
            "25380|25376|Sección 2ª. Función preventiva y punición excesiva\n" +
            "25381|25380|20141113045832833\n" +
            "25382|25381|20141113045832833\n" +
            "25383|25376|Sección 3ª. Función resarcitoria\n" +
            "25384|25383|20141113045938834\n" +
            "25385|25384|20141113045938834\n" +
            "25386|25376|Sección 4ª. Daño resarcible\n" +
            "25387|25386|20141113050043835\n" +
            "25388|25387|20141113050043835\n" +
            "25389|25376|Sección 5ª. Responsabilidad directa\n" +
            "25390|25389|20141113050134836\n" +
            "25391|25390|20141113050134836\n" +
            "25392|25376|Sección 6ª. Responsabilidad por el hecho de terceros\n" +
            "25393|25392|20141113050219837\n" +
            "25394|25393|20141113050219837\n" +
            "25395|25376|Sección 7ª. Responsabilidad derivada de la intervención de cosas y de ciertas actividades\n" +
            "25396|25395|20141113050306838\n" +
            "25397|25396|20141113050306838\n" +
            "25398|25376|Sección 8ª. Responsabilidad colectiva y anónima\n" +
            "25399|25398|20141113050658839\n" +
            "25400|25399|20141113050658839\n" +
            "25401|25376|Sección 9ª. Supuestos especiales de responsabilidad\n" +
            "25402|25401|20141113050753840\n" +
            "25403|25402|20141113050753840\n" +
            "25404|25376|Sección 10ª. Ejercicio de las acciones de responsabilidad\n" +
            "25405|25404|20141113050838841\n" +
            "25406|25405|20141113050838841\n" +
            "25407|25376|Sección 11ª. Acciones civil y penal\n" +
            "25408|25407|20141113050920842\n" +
            "25409|25408|20141113050920842\n" +
            "25410|25375|Capítulo 2 - Gestión de negocios. Arts. 1781 a 1790\n" +
            "25411|25410|20141113051012843\n" +
            "25412|25411|20141113051012843\n" +
            "25413|25375|Capítulo 3 - Empleo útil. Arts. 1791 a 1793\n" +
            "25414|25413|20141113051057844\n" +
            "25415|25414|20141113051057844\n" +
            "25416|25375|Capítulo 4 - Enriquecimiento sin causa. Arts. 1794 a 1799\n" +
            "25417|25416|Sección 1ª. Disposiciones generales\n" +
            "25418|25417|20141114082735847\n" +
            "25419|25418|20141114082735847\n" +
            "25420|25416|Sección 2ª. Pago indebido\n" +
            "25421|25420|20141114082832848\n" +
            "25422|25421|20141114082832848\n" +
            "25423|25375|Capítulo 5 - Declaración unilateral de voluntad. Arts. 1800 a 1814\n" +
            "25424|25423|Sección 1ª. Disposiciones generales\n" +
            "25425|25424|20141114082948849\n" +
            "25426|25425|20141114082948849\n" +
            "25427|25423|Sección 2ª. Promesa pública de recompensa\n" +
            "25428|25427|20141114083040850\n" +
            "25429|25428|20141114083040850\n" +
            "25430|25423|Sección 3ª. Concurso público\n" +
            "25431|25430|20141114083133851\n" +
            "25432|25431|20141114083133851\n" +
            "25433|25423|Sección 4ª. Garantías unilaterales\n" +
            "25434|25433|20141114083229852\n" +
            "25435|25434|20141114083229852\n" +
            "25436|25375|Capítulo 6 - Títulos valores. Arts. 1815 a 1881\n" +
            "25437|25436|Sección 1ª. Disposiciones generales\n" +
            "25438|25437|20141114083328853\n" +
            "25439|25438|20141114083328853\n" +
            "25440|25436|Sección 2ª. Títulos valores cartulares\n" +
            "25441|25440|20141114083416854\n" +
            "25442|25441|20141114083416854\n" +
            "25443|25440|Parágrafo 1°. Títulos valores al portador\n" +
            "25444|25443|20141114083524855\n" +
            "25445|25440|Parágrafo 2°. Títulos valores a la orden\n" +
            "25446|25445|20141114083614856\n" +
            "25447|25440|Parágrafo 3°. Títulos valores nominativos endosables\n" +
            "25448|25447|20141114083705857\n" +
            "25449|25440|Parágrafo 4°. Títulos valores nominativos no endosables\n" +
            "25450|25449|20141114083752858\n" +
            "25451|25436|Sección 3ª. Títulos valores no cartulares\n" +
            "25452|25451|20141114083842859\n" +
            "25453|25452|20141114083842859\n" +
            "25454|25436|Sección 4ª. Deterioro, sustracción, pérdida y destrucción de títulos valores o de sus registros\n" +
            "25455|25454|Parágrafo 1°. Normas comunes para títulos valores\n" +
            "25456|25455|20141114083935860\n" +
            "25457|25454|Parágrafo 2°. Normas aplicables a títulos valores en serie\n" +
            "25458|25457|20141114084017861\n" +
            "25459|25454|Parágrafo 3°. Normas aplicables a los títulos valores individuales\n" +
            "25460|25459|20141114084101862\n" +
            "25461|25454|Parágrafo 4°. Sustracción, pérdida o destrucción de los libros de registro\n" +
            "25462|25461|20141114084246863\n" +
            "25463|426|Libro Cuarto. Derechos Reales. Arts. 1882 a 2276\n" +
            "25464|25463|Título I - Disposiciones Generales. Arts. 1882 a 1907\n" +
            "25465|25464|Capítulo 1 - Principios comunes. Arts. 1882 a 1891\n" +
            "25466|25465|20141114084407864\n" +
            "25467|25466|20141114084407864\n" +
            "25468|25464|Capítulo 2 - Adquisición, transmisión, extinción y oponibilidad. Arts. 1892 a 1907\n" +
            "25469|25468|20141114084459865\n" +
            "25470|25469|20141114084459865\n" +
            "25471|25463|Título II - Posesión y Tenencia. Arts. 1908 a 1940\n" +
            "25472|25471|Capítulo 1 - Disposiciones generales. Arts. 1908 a 1921\n" +
            "25473|25472|20141114084555866\n" +
            "25474|25473|20141114084555866\n" +
            "25475|25471|Capítulo 2 - Adquisición, ejercicio, conservación y extinción. Arts. 1922 a 1931\n" +
            "25476|25475|20141114084821867\n" +
            "25477|25476|20141114084821867\n" +
            "25478|25471|Capítulo 3 - Efectos de las relaciones de poder. Arts. 1932 a 1940\n" +
            "25479|25478|20141114084907868\n" +
            "25480|25479|20141114084907868\n" +
            "25481|25463|Título III - Dominio. Arts. 1941 a 1982\n" +
            "25482|25481|Capítulo 1 - Disposiciones generales. Arts. 1941 a 1946\n" +
            "25483|25482|20141114085007869\n" +
            "25484|25483|20141114085007869\n" +
            "25485|25481|Capítulo 2 - Modos especiales de adquisición del dominio. Arts. 1947 a 1963\n" +
            "25486|25485|Sección 1ª. Apropiación\n" +
            "25487|25486|20141114085101870\n" +
            "25488|25487|20141114085101870\n" +
            "25489|25485|Sección 2ª. Adquisición de un tesoro\n" +
            "25490|25489|20141114085230871\n" +
            "25491|25490|20141114085230871\n" +
            "25492|25485|Sección 3ª. Régimen de cosas perdidas\n" +
            "25493|25492|20141114085330872\n" +
            "25494|25493|20141114085330872\n" +
            "25495|25485|Sección 4ª. Transformación y accesión de cosas muebles\n" +
            "25496|25495|20141114085435873\n" +
            "25497|25496|20141114085435873\n" +
            "25498|25485|Sección 5ª. Accesión de cosas inmuebles\n" +
            "25499|25498|20141114085530874\n" +
            "25500|25499|20141114085530874\n" +
            "25501|25481|Capítulo 3 - Dominio imperfecto. Arts. 1964 a 1969\n" +
            "25502|25501|20141114085629875\n" +
            "25503|25502|20141114085629875\n" +
            "25504|25481|Capítulo 4 - Límites al dominio. Arts. 1970 a 1982\n" +
            "25505|25504|20141114085729876\n" +
            "25506|25505|20141114085729876\n" +
            "25507|25463|Título IV - Condominio. Arts. 1983 a 2036\n" +
            "25508|25507|Capítulo 1 - Disposiciones generales. Arts. 1983 a 1992\n" +
            "25509|25508|20141114090005877\n" +
            "25510|25509|20141114090005877\n" +
            "25511|25507|Capítulo 2 - Administración. Arts. 1993 a 1995\n" +
            "25512|25511|20141114090107878\n" +
            "25513|25512|20141114090107878\n" +
            "25514|25507|Capítulo 3 - Condominio sin indivisión forzosa. Arts. 1996 a 1998\n" +
            "25515|25514|Sección única - Partición\n" +
            "25516|25515|20141114090504879\n" +
            "25517|25516|20141114090504879\n" +
            "25518|25507|Capítulo 4 - Condominio con indivisión forzosa temporaria. Arts. 1999 a 2003\n" +
            "25519|25518|20141114090655880\n" +
            "25520|25519|20141114090655880\n" +
            "25521|25507|Capítulo 5 - Condominio con indivisión forzosa perdurable. Arts. 2004 a 2036\n" +
            "25522|25521|Sección 1ª. Condominio sobre accesorios indispensables\n" +
            "25523|25522|20141114090751881\n" +
            "25524|25523|20141114090751881\n" +
            "25525|25521|Sección 2ª. Condominio sobre muros, cercos y fosos\n" +
            "25526|25525|20141114090912882\n" +
            "25527|25526|20141114090912882\n" +
            "25528|25463|Título V - Propiedad Horizontal. Arts. 2037 a 2072\n" +
            "25529|25528|Capítulo 1 - Disposiciones generales. Arts. 2037 a 2044\n" +
            "25530|25529|20141114091018883\n" +
            "25531|25530|20141114091018883\n" +
            "25532|25528|Capítulo 2 - Facultades y obligaciones de los propietarios. Arts. 2045 a 2050\n" +
            "25533|25532|20141114091127884\n" +
            "25534|25533|20141114091127884\n" +
            "25535|25528|Capítulo 3 - Modificaciones en cosas y partes comunes. Arts. 2051 a 2055\n" +
            "25536|25535|20141114091219885\n" +
            "25537|25536|20141114091219885\n" +
            "25538|25528|Capítulo 4 - Reglamento de propiedad horizontal. Arts. 2056 a 2057\n" +
            "25539|25538|20141114091324886\n" +
            "25540|25539|20141114091324886\n" +
            "25541|25528|Capítulo 5 - Asambleas. Arts. 2058 a 2063\n" +
            "25542|25541|20141114091406887\n" +
            "25543|25542|20141114091406887\n" +
            "25544|25528|Capítulo 6 - Consejo de propietarios. Art. 2064\n" +
            "25545|25544|20141114091456888\n" +
            "25546|25545|20141114091456888\n" +
            "25547|25528|Capítulo 7 - Administrador. Arts. 2065 a 2067\n" +
            "25548|25547|20141114091552889\n" +
            "25549|25548|20141114091552889\n" +
            "25550|25528|Capítulo 8 - Subconsorcios. Art. 2068\n" +
            "25551|25550|20141114091645890\n" +
            "25552|25551|20141114091645890\n" +
            "25553|25528|Capítulo 9 - Infracciones. Art. 2069\n" +
            "25554|25553|20141114091735891\n" +
            "25555|25554|20141114091735891\n" +
            "25556|25528|Capítulo 10 - Prehorizontalidad. Arts. 2070 a 2072\n" +
            "25557|25556|20141114091820892\n" +
            "25558|25557|20141114091820892\n" +
            "25559|25463|Título VI - Conjuntos Inmobiliarios. Arts. 2073 a 2113\n" +
            "25560|25559|Capítulo 1 - Conjuntos inmobiliarios. Arts. 2073 a 2086\n" +
            "25561|25560|20141114091914893\n" +
            "25562|25561|20141114091914893\n" +
            "25563|25559|Capítulo 2 - Tiempo compartido. Arts. 2087 a 2102\n" +
            "25564|25563|20141114092008894\n" +
            "25565|25564|20141114092008894\n" +
            "25566|25559|Capítulo 3 - Cementerios privados. Arts. 2103 a 2113\n" +
            "25567|25566|20141114092057895\n" +
            "25568|25567|20141114092057895\n" +
            "25569|25463|Título VII - Superficie. Arts. 2114 a 2128\n" +
            "25570|25569|20141114092144896\n" +
            "25571|25570|20141114092144896\n" +
            "25572|25463|Título VIII - Usufructo. Arts. 2129 a 2153\n" +
            "25573|25572|Capítulo 1 - Disposiciones generales. Arts. 2129 a 2140\n" +
            "25574|25573|20141114092235897\n" +
            "25575|25574|20141114092235897\n" +
            "25576|25572|Capítulo 2 - Derechos del usufructuario. Arts. 2141 a 2144\n" +
            "25577|25576|20141114092322898\n" +
            "25578|25577|20141114092322898\n" +
            "25579|25572|Capítulo 3 - Obligaciones del usufructuario. Arts. 2145 a 2150\n" +
            "25580|25579|20141114092403899\n" +
            "25581|25580|20141114092403899\n" +
            "25582|25572|Capítulo 4 - Derechos y deberes del nudo propietario. Art. 2151\n" +
            "25583|25582|20141114092454900\n" +
            "25584|25583|20141114092454900\n" +
            "25585|25572|Capítulo 5 - Extinción. Arts. 2152 a 2153\n" +
            "25586|25585|20141114092542901\n" +
            "25587|25586|20141114092542901\n" +
            "25588|25463|Título IX - Uso. Arts. 2154 a 2157\n" +
            "25589|25588|20141114092630902\n" +
            "25590|25589|20141114092630902\n" +
            "25591|25463|Título X - Habitación. Arts. 2158 a 2161\n" +
            "25592|25591|20141114092716903\n" +
            "25593|25592|20141114092716903\n" +
            "25594|25463|Título XI - Servidumbre. Arts. 2162 a 2183\n" +
            "25595|25594|Capítulo 1 - Disposiciones generales. Arts. 2162 a 2172\n" +
            "25596|25595|20141114092809904\n" +
            "25597|25596|20141114092809904\n" +
            "25598|25594|Capítulo 2 - Derechos y obligaciones del titular dominante. Arts. 2173 a 2179\n" +
            "25599|25598|20141114092856905\n" +
            "25600|25599|20141114092856905\n" +
            "25601|25594|Capítulo 3 - Derechos del titular sirviente. Arts. 2180 a 2181\n" +
            "25602|25601|20141114093006906\n" +
            "25603|25602|20141114093006906\n" +
            "25604|25594|Capítulo 4 - Extinción de la servidumbre. Arts. 2182 a 2183\n" +
            "25605|25604|20141114093056907\n" +
            "25606|25605|20141114093056907\n" +
            "25607|25463|Título XII - Derechos Reales de Garantía. Arts. 2184 a 2237\n" +
            "25608|25607|Capítulo 1 - Disposiciones comunes. Arts. 2184 a 2204\n" +
            "25609|25608|20141114093242908\n" +
            "25610|25609|20141114093242908\n" +
            "25611|25607|Capítulo 2 - Hipoteca. Arts. 2205 a 2211\n" +
            "25612|25611|20141114093558910\n" +
            "25613|25612|20141114093558910\n" +
            "25614|25607|Capítulo 3 - Anticresis. Arts. 2212 a 2218\n" +
            "25615|25614|20141114093652911\n" +
            "25616|25615|20141114093652911\n" +
            "25617|25607|Capítulo 4 - Prenda. Arts. 2219 a 2237\n" +
            "25618|25617|Sección 1ª. Disposiciones generales\n" +
            "25619|25618|20141114093744912\n" +
            "25620|25619|20141114093744912\n" +
            "25621|25617|Sección 2ª. Prenda de cosas\n" +
            "25622|25621|20141114093836913\n" +
            "25623|25622|20141114093836913\n" +
            "25624|25617|Sección 3ª. Prenda de créditos\n" +
            "25625|25624|20141114093926914\n" +
            "25626|25625|20141114093926914\n" +
            "25627|25463|Título XIII - Acciones posesorias y acciones reales. Arts. 2238 a 2276\n" +
            "25628|25627|Capítulo 1 - Defensas de la posesión y la tenencia. Arts. 2238 a 2246\n" +
            "25629|25628|20141114094018915\n" +
            "25630|25629|20141114094018915\n" +
            "25631|25627|Capítulo 2 - Defensas del derecho real. Arts. 2247 a 2268\n" +
            "25632|25631|Sección 1ª. Disposiciones generales\n" +
            "25633|25632|20141114094113916\n" +
            "25634|25633|20141114094113916\n" +
            "25635|25631|Sección 2ª. Acción reivindicatoria\n" +
            "25636|25635|20141114094207917\n" +
            "25637|25636|20141114094207917\n" +
            "25638|25631|Sección 3ª. Acción negatoria\n" +
            "25639|25638|20141114094252918\n" +
            "25640|25639|20141114094252918\n" +
            "25641|25631|Sección 4ª. Acción confesoria\n" +
            "25642|25641|20141114094338919\n" +
            "25643|25642|20141114094338919\n" +
            "25644|25631|Sección 5ª. Acción de deslinde\n" +
            "25645|25644|20141114094432920\n" +
            "25646|25645|20141114094432920\n" +
            "25647|25627|Capítulo 3 - Relaciones entre las acciones posesorias y las acciones reales. Arts. 2269 a 2276\n" +
            "25648|25647|20141114094518921\n" +
            "25649|25648|20141114094518921\n" +
            "25650|426|Libro Quinto. Transmisión de Derechos por Causa de Muerte. Arts. 2277 a 2531\n" +
            "25651|25650|Título I - Sucesiones. Arts. 2277 a 2285\n" +
            "25652|25651|Capítulo 1 - Disposiciones generales. Arts. 2277 a 2280\n" +
            "25653|25652|20141114094644922\n" +
            "25654|25653|20141114094644922\n" +
            "25655|25651|Capítulo 2 - Indignidad. Arts. 2281 a 2285\n" +
            "25656|25655|20141114093331909\n" +
            "25657|25656|20141114093331909\n" +
            "25658|25650|Título II - Aceptación y Renuncia de la Herencia. Arts. 2286 a 2301\n" +
            "25659|25658|Capítulo 1 - Derecho de opción. Arts. 2286 a 2292\n" +
            "25660|25659|20141114094744923\n" +
            "25661|25660|20141114094744923\n" +
            "25662|25658|Capítulo 2 - Aceptación de la herencia. Arts. 2293 a 2297\n" +
            "25663|25662|20141114094923924\n" +
            "25664|25663|20141114094923924\n" +
            "25665|25658|Capítulo 3 - Renuncia de la herencia. Arts. 2298 a 2301\n" +
            "25666|25665|20141114095053925\n" +
            "25667|25666|20141114095053925\n" +
            "25668|25650|Título III - Cesión de Herencia. Arts. 2302 a 2309\n" +
            "25669|25668|20141114095145926\n" +
            "25670|25669|20141114095145926\n" +
            "25671|25650|Título IV - Petición de Herencia. Arts. 2310 a 2315\n" +
            "25672|25671|20141114095233927\n" +
            "25673|25672|20141114095233927\n" +
            "25674|25650|Título V - Responsabilidad de los Herederos y Legatarios. Liquidación del Pasivo. Arts. 2316 a 2322\n" +
            "25675|25674|20141114095321928\n" +
            "25676|25675|20141114095321928\n" +
            "25677|25650|Título VI - Estado de Indivisión. Arts. 2323 a 2334\n" +
            "25678|25677|Capítulo 1 - Administración extrajudicial. Arts. 2323 a 2329\n" +
            "25679|25678|20141114095425929\n" +
            "25680|25679|20141114095425929\n" +
            "25681|25677|Capítulo 2 - Indivisión forzosa. Arts. 2330 a 2334\n" +
            "25682|25681|20141114095523930\n" +
            "25683|25682|20141114095523930\n" +
            "25684|25650|Título VII - Proceso Sucesorio. Arts. 2335 a 2362\n" +
            "25685|25684|Capítulo 1 - Disposiciones generales. Arts. 2335 a 2336\n" +
            "25686|25685|20141114095655931\n" +
            "25687|25686|20141114095655931\n" +
            "25688|25684|Capítulo 2 - Investidura de la calidad de heredero. Arts. 2337 a 2340\n" +
            "25689|25688|20141114095821932\n" +
            "25690|25689|20141114095821932\n" +
            "25691|25684|Capítulo 3 - Inventario y avalúo. Arts. 2341 a 2344\n" +
            "25692|25691|20141114095931933\n" +
            "25693|25692|20141114095931933\n" +
            "25694|25684|Capítulo 4 - Administración judicial de la sucesión. Arts. 2345 a 2355\n" +
            "25695|25694|Sección 1ª. Designación, derechos y deberes del administrador\n" +
            "25696|25695|20141114100026934\n" +
            "25697|25696|20141114100026934\n" +
            "25698|25694|Sección 2ª. Funciones del administrador\n" +
            "25699|25698|20141114100133935\n" +
            "25700|25699|20141114100133935\n" +
            "25701|25684|Capítulo 5 - Pago de deudas y legados. Arts. 2356 a 2360\n" +
            "25702|25701|20141114100245936\n" +
            "25703|25702|20141114100245936\n" +
            "25704|25684|Capítulo 6 - Conclusión de la administración judicial. Arts. 2361 a 2362\n" +
            "25705|25704|20141114100337937\n" +
            "25706|25705|20141114100337937\n" +
            "25707|25650|Título VIII - Partición. Arts. 2363 a 2423\n" +
            "25708|25707|Capítulo 1 - Acción de partición. Arts. 2363 a 2368\n" +
            "25709|25708|20141114100526938\n" +
            "25710|25709|20141114100526938\n" +
            "25711|25707|Capítulo 2 - Modos de hacer la partición. Arts. 2369 a 2384\n" +
            "25712|25711|20141114100724939\n" +
            "25713|25712|20141114100724939\n" +
            "25714|25707|Capítulo 3 - Colación de donaciones. Arts. 2385 a 2396\n" +
            "25715|25714|20141114100825940\n" +
            "25716|25715|20141114100825940\n" +
            "25717|25707|Capítulo 4 - Colación de deudas. Arts. 2397 a 2402\n" +
            "25718|25717|20141114100924941\n" +
            "25719|25718|20141114100924941\n" +
            "25720|25707|Capítulo 5 - Efectos de la partición. Arts. 2403 a 2407\n" +
            "25721|25720|20141114101027942\n" +
            "25722|25721|20141114101027942\n" +
            "25723|25707|Capítulo 6 - Nulidad y reforma de la partición. Arts. 2408 a 2410\n" +
            "25724|25723|20141114101127943\n" +
            "25725|25724|20141114101127943\n" +
            "25726|25707|Capítulo 7 - Partición por los ascendientes. Arts. 2411 a 2423\n" +
            "25727|25726|Sección 1ª. Disposiciones generales\n" +
            "25728|25727|20141114101350944\n" +
            "25729|25728|20141114101350944\n" +
            "25730|25726|Sección 2ª. Partición por donación\n" +
            "25731|25730|20141114102402945\n" +
            "25732|25731|20141114102402945\n" +
            "25733|25726|Sección 3ª. Partición por testamento\n" +
            "25734|25733|20141114102516946\n" +
            "25735|25734|20141114102516946\n" +
            "25736|25650|Título IX - Sucesiones Intestadas. Arts. 2424 a 2443\n" +
            "25737|25736|Capítulo 1 - Disposiciones generales. Arts. 2424 a 2425\n" +
            "25738|25737|20141114102919947\n" +
            "25739|25738|20141114102919947\n" +
            "25740|25736|Capítulo 2 - Sucesión de los descendientes. Arts. 2426 a 2430\n" +
            "25741|25740|20141114103027948\n" +
            "25742|25741|20141114103027948\n" +
            "25743|25736|Capítulo 3 - Sucesión de los ascendientes. Arts. 2431 a 2432\n" +
            "25744|25743|20141114103126949\n" +
            "25745|25744|20141114103126949\n" +
            "25746|25736|Capítulo 4 - Sucesión del cónyuge. Arts. 2433 a 2437\n" +
            "25747|25746|20141114103233950\n" +
            "25748|25747|20141114103233950\n" +
            "25749|25736|Capítulo 5 - Sucesión de los colaterales. Arts. 2438 a 2440\n" +
            "25750|25749|20141114103328951\n" +
            "25751|25750|20141114103328951\n" +
            "25752|25736|Capítulo 6 - Derechos del Estado. Arts. 2441 a 2443\n" +
            "25753|25752|20141114103411952\n" +
            "25754|25753|20141114103411952\n" +
            "25755|25650|Título X - Porción Legítima. Arts. 2444 a 2461\n" +
            "25756|25755|20141114103516953\n" +
            "25757|25756|20141114103516953\n" +
            "25758|25650|Título XI - Sucesiones Testamentarias. Arts. 2462 a 2531\n" +
            "25759|25758|Capítulo 1 - Disposiciones generales. Arts. 2462 a 2471\n" +
            "25760|25759|20141114103637954\n" +
            "25761|25760|20141114103637954\n" +
            "25762|25758|Capítulo 2 - Formas de los testamentos. Arts. 2472 a 2481\n" +
            "25763|25762|Sección 1ª. Disposiciones generales\n" +
            "25764|25763|20141114104016955\n" +
            "25765|25764|20141114104016955\n" +
            "25766|25762|Sección 2ª. Testamento ológrafo\n" +
            "25767|25766|20141114104123956\n" +
            "25768|25767|20141114104123956\n" +
            "25769|25762|Sección 3ª. Testamento por acto público\n" +
            "25770|25769|20141114104220957\n" +
            "25771|25770|20141114104220957\n" +
            "25772|25758|Capítulo 3 - Inhabilidad para suceder por testamento. Arts. 2482 a 2483\n" +
            "25773|25772|20141114104500958\n" +
            "25774|25773|20141114104500958\n" +
            "25775|25758|Capítulo 4 - Institución y sustitución de herederos y legatarios. Arts. 2484 a 2493\n" +
            "25776|25775|20141114104549959\n" +
            "25777|25776|20141114104549959\n" +
            "25778|25758|Capítulo 5 - Legados. Arts. 2494 a 2510\n" +
            "25779|25778|20141114104644960\n" +
            "25780|25779|20141114104644960\n" +
            "25781|25758|Capítulo 6 - Revocación y caducidad de las disposiciones testamentarias. Arts. 2511 a 2522\n" +
            "25782|25781|20141114104731961\n" +
            "25783|25782|20141114104731961\n" +
            "25784|25758|Capítulo 7 - Albaceas. Arts. 2523 a 2531\n" +
            "25785|25784|20141114104829962\n" +
            "25786|25785|20141114104829962\n" +
            "25787|426|Libro Sexto. Disposiciones Comunes a los Derechos Personales y Reales. Arts. 2532 a 2671\n" +
            "25788|25787|Título I - Prescripción y Caducidad. Arts. 2532 a 2572\n" +
            "25789|25788|Capítulo 1 - Disposiciones comunes a la prescripción liberatoria y adquisitiva. Arts. 2532 a 2553\n" +
            "25790|25789|Sección 1ª. Normas generales\n" +
            "25791|25790|20141114104937963\n" +
            "25792|25791|20141114104937963\n" +
            "25793|25789|Sección 2ª. Suspenso de la prescripción\n" +
            "25794|25793|20141114105038964\n" +
            "25795|25794|20141114105038964\n" +
            "25796|25789|Sección 3ª. Interrupción de la prescripción\n" +
            "25797|25796|20141114105136965\n" +
            "25798|25797|20141114105136965\n" +
            "25799|25789|Sección 4ª. Dispensa de la prescripción\n" +
            "25800|25799|20141114105235966\n" +
            "25801|25800|20141114105235966\n" +
            "25802|25789|Sección 5ª. Disposiciones procesales relativas a la prescripción\n" +
            "25803|25802|20141114105327967\n" +
            "25804|25803|20141114105327967\n" +
            "25805|25788|Capítulo 2 - Prescripción liberatoria. Arts. 2554 a 2564\n" +
            "25806|25805|Sección 1ª. Comienzo del cómputo\n" +
            "25807|25806|20141114105416968\n" +
            "25808|25807|20141114105416968\n" +
            "25809|25805|Sección 2ª. Plazos de prescripción\n" +
            "25810|25809|20141114105501969\n" +
            "25811|25810|20141114105501969\n" +
            "25812|25788|Capítulo 3 - Prescripción adquisitiva. Art. 2565\n" +
            "25813|25812|20141114105658970\n" +
            "25814|25813|20141114105658970\n" +
            "25815|25788|Capítulo 4 - Caducidad de los derechos. Arts. 2566 a 2572\n" +
            "25816|25815|20141114105742971\n" +
            "25817|25816|20141114105742971\n" +
            "25818|25787|Título II - Privilegios. Arts. 2573 a 2586\n" +
            "25819|25818|Capítulo 1 - Disposiciones generales. Arts. 2573 a 2581\n" +
            "25820|25819|20141114105836972\n" +
            "25821|25820|20141114105836972\n" +
            "25822|25818|Capítulo 2 - Privilegios especiales. Arts. 2582 a 2586\n" +
            "25823|25822|20141114105930973\n" +
            "25824|25823|20141114105930973\n" +
            "25825|25787|Título III - Derecho de Retención. Arts. 2587 a 2593\n" +
            "25826|25825|20141114110015974\n" +
            "25827|25826|20141114110015974\n" +
            "25828|25787|Título IV - Disposiciones de Derecho Internacional Privado. Arts. 2594 a 2671\n" +
            "25829|25828|Capítulo 1 - Disposiciones generales. Arts. 2594 a 2600\n" +
            "25830|25829|20141114110128975\n" +
            "25831|25830|20141114110128975\n" +
            "25832|25828|Capítulo 2 - Jurisdicción internacional. Arts. 2601 a 2612\n" +
            "25833|25832|20141114110216976\n" +
            "25834|25833|20141114110216976\n" +
            "25835|25828|Capítulo 3 - Parte especial. Arts. 2613 a 2671\n" +
            "25836|25835|Sección 1ª. Personas humanas\n" +
            "25837|25836|20141114110303977\n" +
            "25838|25837|20141114110303977\n" +
            "25839|25835|Sección 2ª. Matrimonio\n" +
            "25840|25839|20141114110347978\n" +
            "25841|25840|20141114110347978\n" +
            "25842|25835|Sección 3ª. Unión convivencial\n" +
            "25843|25842|20141114110434979\n" +
            "25844|25843|20141114110434979\n" +
            "25845|25835|Sección 4ª. Alimentos\n" +
            "25846|25845|20141114110519980\n" +
            "25847|25846|20141114110519980\n" +
            "25848|25835|Sección 5ª. Filiación por naturaleza y por técnicas de reproducción humana asistida\n" +
            "25849|25848|20141114110612981\n" +
            "25850|25849|20141114110612981\n" +
            "25851|25835|Sección 6ª. Adopción\n" +
            "25852|25851|20141114110713982\n" +
            "25853|25852|20141114110713982\n" +
            "25854|25835|Sección 7ª. Responsabilidad parental e instituciones de protección\n" +
            "25855|25854|20141114110818983\n" +
            "25856|25855|20141114110818983\n" +
            "25857|25835|Sección 8ª. Restitución internacional de niños\n" +
            "25858|25857|20141114110913984\n" +
            "25859|25858|20141114110913984\n" +
            "25860|25835|Sección 9ª. Sucesiones\n" +
            "25861|25860|20141114110955985\n" );
    private static String menu1 =new String("25862|25861|20141114110955985\n" +
            "25863|25835|Sección 10ª. Forma de los actos jurídicos\n" +
            "25864|25863|20141114111043986\n" +
            "25865|25864|20141114111043986\n" +
            "25866|25835|Sección 11ª. Contratos\n" +
            "25867|25866|20141114111147987\n" +
            "25868|25867|20141114111147987\n" +
            "25869|25835|Sección 12ª. Contratos de consumo\n" +
            "25870|25869|20141114111244988\n" +
            "25871|25870|20141114111244988\n" +
            "25872|25835|Sección 13ª. Responsabilidad civil\n" +
            "25873|25872|20141114111330989\n" +
            "25874|25873|20141114111330989\n" +
            "25875|25835|Sección 14ª. Títulos valores\n" +
            "25876|25875|20141114111429990\n" +
            "25877|25876|20141114111429990\n" +
            "25878|25835|Sección 15ª. Derechos reales\n" +
            "25879|25878|20141114111513991\n" +
            "25880|25879|20141114111513991\n" +
            "25881|25835|Sección 16ª. Prescripción\n" +
            "25882|25881|20141114111603992\n" +
            "25883|25882|20141114111603992\n" +
            "25884|426|Normas Complementarias\n" +
            "25885|25884|Ley 163 - Intervención de Cónsules Extranjeros en las Sucesiones\n" +
            "25886|25885|20100922064810996\n" +
            "25887|25886|20100922064810996\n" +
            "25888|25884|Ley 928 - Warrants y Certificados de Depósito\n" +
            "25889|25888|20100922064833543\n" +
            "25890|25889|20100922064833543\n" +
            "25891|25884|Ley 3192 - Tratado de Derecho Civil Internacional. Montevideo 1889\n" +
            "25892|25891|20100922063959159\n" +
            "25893|25892|20100922063959159\n" +
            "25894|25884|Ley 4124 - Redención de Capellanías\n" +
            "25895|25894|20100922064224469\n" +
            "25896|25895|20100922064224469\n" +
            "25897|25884|Ley 9643 - Operaciones de Crédito Mobiliario sobre Frutos o Productos\n" +
            "25898|25897|20100922064834074\n" +
            "25899|25898|20100922064834074\n" +
            "25900|25884|Ley 9644 - Prenda Agraria\n" +
            "25901|25900|20100922064558217\n" +
            "25902|25901|20100922064558217\n" +
            "25903|25884|Ley 11723 - Propiedad Intelectual\n" +
            "25904|25903|20100922064620545\n" +
            "25905|25904|20100922064620545\n" +
            "25906|25884|Ley 11867 - Transferencia de Fondo de Comercio\n" +
            "25907|25906|20100922064154439\n" +
            "25908|25907|20100922064154439\n" +
            "25909|25884|Ley 12331 - Profilaxis de Enfermedades Venéreas\n" +
            "25910|25909|20100922064421343\n" +
            "25911|25910|20100922064421343\n" +
            "25912|25884|Ley 13246 - Arrendamientos y Aparcerías\n" +
            "25913|25912|20100922063528459\n" +
            "25914|25913|20100922063528459\n" +
            "25915|25884|Ley 13944 - Sanciones por Incumplimiento de Obligaciones Alimentarias\n" +
            "25916|25915|20100922063528537\n" +
            "25917|25916|20100922063528537\n" +
            "25918|25884|Ley 14005 - Venta de Lotes a Plazos\n" +
            "25919|25918|20100922064232172\n" +
            "25920|25919|20100922064232172\n" +
            "25921|25884|Ley 14159 - Procedimiento de Prescripción Adquisitiva\n" +
            "25922|25921|20100922064230360\n" +
            "25923|25922|20100922064230360\n" +
            "25924|25884|Ley 14586 - Registro de las Personas de la Ciudad de Buenos Aires\n" +
            "25925|25924|20100922064637138\n" +
            "25926|25925|20100922064637138\n" +
            "25927|25884|Ley 16668 - Certificado Prenupcial Femenino\n" +
            "25928|25927|20100922064421327\n" +
            "25929|25928|20100922064421327\n" +
            "25930|25884|Ley 17011 - Convenio de Protección de la Propiedad Industrial. París 1883\n" +
            "25931|25930|20100922063946284\n" +
            "25932|25931|20100922063946284\n" +
            "25933|25884|Ley 17048 - Convenio de Responsabilidad Civil por Daños Nucleares\n" +
            "25934|25933|20100922063914753\n" +
            "25935|25934|20100922063914753\n" +
            "25936|25884|Ley 17094 - Soberanía sobre el Mar Territorial\n" +
            "25937|25936|20100922064417405\n" +
            "25938|25937|20100922064417405\n" +
            "25939|25884|Ley 17251 - Convenio sobre Protección de Obras Artísticas y Literarias. Berna 1886\n" +
            "25940|25939|20100922063946815\n" +
            "25941|25940|20100922063946815\n" +
            "25942|25884|Ley 17418 - Seguros\n" +
            "25943|25942|20100922064725200\n" +
            "25944|25943|20100922064725200\n" +
            "25945|25884|Ley 17562 - Extinción del Derecho a Pensión\n" +
            "25946|25945|20100922064303922\n" +
            "25947|25946|20100922064303922\n" +
            "25948|25884|Ley 17671 - Registro Nacional de las Personas\n" +
            "25949|25948|20100922064645638\n" +
            "25950|25949|20100922064645638\n" +
            "25951|25884|Ley 17722 - Convenio de Eliminación de la Discriminación Racial en Todas sus Formas\n" +
            "25952|25951|20100922063303133\n" +
            "25953|25952|20100922063303133\n" +
            "25954|25884|Ley 17801 - Registro de la Propiedad Inmueble\n" +
            "25955|25954|20100922064633357\n" +
            "25956|25955|20100922064633357\n" +
            "25957|25884|Ley 18444 - Convenio sobre Capacidad para Prestar Consentimiento Matrimonial\n" +
            "25958|25957|20100922063903644\n" +
            "25959|25958|20100922063903644\n" +
            "25960|25884|Ley 18924 - Autorización de Casas y Agencias de Cambio\n" +
            "25961|25960|20100922063542193\n" +
            "25962|25961|20100922063542193\n" +
            "25963|25884|Ley 19060 - Emisión de Acciones Societarias por Debajo de la Par\n" +
            "25964|25963|20121002111140982\n" +
            "25965|25964|20121002111140982\n" +
            "25966|25884|Ley 19550 - Ley General de Sociedades\n" +
            "25967|25966|20100922064753106\n" +
            "25968|25967|20100922064753106\n" +
            "25969|25884|Ley 19552 - Servidumbre de Electroducto\n" +
            "25970|25969|20100922064743887\n" +
            "25971|25970|20100922064743887\n" +
            "25972|25884|Ley 20091 - Ejercicio de la Actividad de las Entidades Aseguradoras\n" +
            "25973|25972|20100922064728231\n" +
            "25974|25973|20100922064728231\n" +
            "25975|25884|Ley 20094 - Ley de la Navegación\n" +
            "25976|25975|20100922064451608\n" +
            "25977|25976|20100922064451608\n" +
            "25978|25884|Ley 20266 - Corredores y Martilleros\n" +
            "25979|25978|20100922064007674\n" +
            "25980|25979|20100922064007674\n" +
            "25981|25884|Ley 20321 - Asociaciones Civiles y Mutuales\n" +
            "25982|25981|20100922064450421\n" +
            "25983|25982|20100922064450421\n" +
            "25984|25884|Ley 20337 - Cooperativas\n" +
            "25985|25984|20100922064006627\n" +
            "25986|25985|20100922064006627\n" +
            "25987|25884|Ley 20396 - Prescripción Adquisitiva de Inmuebles del Dominio Privado del Estado\n" +
            "25988|25987|20100922064229829\n" +
            "25989|25988|20100922064229829\n" +
            "25990|25884|Ley 20643 - Títulos Valores Privados\n" +
            "25991|25990|20100922064820324\n" +
            "25992|25991|20100922064820324\n" +
            "25993|25884|Ley 20663 - Depósitos a Plazo Fijo\n" +
            "25994|25993|20100922064131236\n" +
            "25995|25994|20100922064131236\n" +
            "25996|25884|Ley 20680 - Ley de Abastecimiento\n" +
            "25997|25996|20100922063405460\n" +
            "25998|25997|20100922063405460\n" +
            "25999|25884|Ley 20705 - Sociedades del Estado\n" +
            "26000|25999|20100922064809887\n" +
            "26001|26000|20100922064809887\n" +
            "26002|25884|Ley 21309 - Cláusulas de Estabilización o Reajuste de Hipotecas o Prendas con Registro\n" +
            "26003|26002|20100922064207438\n" +
            "26004|26003|20100922064207438\n" +
            "26005|25884|Ley 21382 - Régimen de Inversiones Extranjeras\n" +
            "26006|26005|20100922064257610\n" +
            "26007|26006|20100922064257610\n" +
            "26008|25884|Ley 21477 - Inmuebles del Dominio Privado del Estado Provincial y Municipal\n" +
            "26009|26008|20100922064138517\n" +
            "26010|26009|20100922064138517\n" +
            "26011|25884|Ley 21499 - Régimen de Expropiación\n" +
            "26012|26011|20100922064144814\n" +
            "26013|26012|20100922064144814\n" +
            "26014|25884|Ley 21526 - Entidades Financieras\n" +
            "26015|26014|20100922064132876\n" +
            "26016|26015|20100922064132876\n" +
            "26017|25884|Ley 21546 - Convenio Internacional de Prevención de Abordajes\n" +
            "26018|26017|20100922063912206\n" +
            "26019|26018|20100922063912206\n" +
            "26020|25884|Ley 21768 - Registro de Contratos Constitutivos de Sociedades Comerciales\n" +
            "26021|26020|20100922064759356\n" +
            "26022|26021|20100922064759356\n" +
            "26023|25884|Ley 21799 - Carta Orgánica del Banco de la Nación Argentina\n" +
            "26024|26023|20100922063536693\n" +
            "26025|26024|20100922063536693\n" +
            "26026|25884|Ley 22169 - Facultades de la CNV para el Control de Sociedades por Acciones\n" +
            "26027|26026|20100922063829644\n" +
            "26028|26027|20100922063829644\n" +
            "26029|25884|Ley 22195 - Convenio Internacional sobre Propiedad Intelectual\n" +
            "26030|26029|20100922063942065\n" +
            "26031|26030|20100922063942065\n" +
            "26032|25884|Ley 22231 - Recursos ante la Denegatoria de Inscripción Registral\n" +
            "26033|26032|20100922064630091\n" +
            "26034|26033|20100922064630091\n" +
            "26035|25884|Ley 22232 - Carta Orgánica del Banco Hipotecario Nacional\n" +
            "26036|26035|20100922063537209\n" +
            "26037|26036|20100922063537209\n" +
            "26038|25884|Ley 22315 - Inspección General de Justicia\n" +
            "26039|26038|20100922064240875\n" +
            "26040|26039|20100922064240875\n" +
            "26041|25884|Ley 22362 - Marcas y Designaciones\n" +
            "26042|26041|20100922064419140\n" +
            "26043|26042|20100922064419140\n" +
            "26044|25884|Ley 22400 - Productor Asesor de Seguros\n" +
            "26045|26044|20100922064724575\n" +
            "26046|26045|20100922064724575\n" +
            "26047|25884|Ley 22423 - Venta de Inmuebles del Dominio Privado del Estado Nacional\n" +
            "26048|26047|20100922064137939\n" +
            "26049|26048|20100922064137939\n" +
            "26050|25884|Ley 22426 - Transferencia de Tecnología\n" +
            "26051|26050|20100922064822059\n" +
            "26052|26051|20100922064822059\n" +
            "26053|25884|Ley 22427 - Inscripción Registral de Constitución y Transferencia de Derechos Reales\n" +
            "26054|26053|20100922064630107\n" +
            "26055|26054|20100922064630107\n" +
            "26056|25884|Ley 22550 - Convenio Internacional sobre Utilización de Poderes en el Extranjero\n" +
            "26057|26056|20100922063939768\n" +
            "26058|26057|20100922063939768\n" +
            "26059|25884|Ley 22691 - Convenio Internacional sobre Títulos Valores\n" +
            "26060|26059|20100922063957268\n" +
            "26061|26060|20100922063957268\n" +
            "26062|25884|Ley 22718 - Convenio de Atenas relativo al Transporte de Pasajeros por Mar\n" +
            "26063|26062|20100922063911113\n" +
            "26064|26063|20100922063911113\n" +
            "26065|25884|Ley 22765 - Convenio Internacional de Prescripción de Contratos de Compraventa de Mercaderías. Viena 1980\n" +
            "26066|26065|20100922063904175\n" +
            "26067|26066|20100922063904175\n" +
            "26068|25884|Ley 22939 - Marcas y Señales\n" +
            "26069|26068|20100922064157189\n" +
            "26070|26069|20100922064157189\n" +
            "26071|25884|Ley 22990 - Sistema Nacional de Sangre\n" +
            "26072|26071|20100922064710231\n" +
            "26073|26072|20100922064710231\n" +
            "26074|25884|Ley 23054 - Pacto de San José de Costa Rica. Convención Americana sobre Derechos Humanos\n" +
            "26075|26074|20100922063920347\n" +
            "26076|26075|20100922063920347\n" +
            "26077|25884|Ley 23073 - Edificación Económica para la Habitación Única y Permanente\n" +
            "26078|26077|20100922064832933\n" +
            "26079|26078|20100922064832933\n" +
            "26080|25884|Ley 23179 - Convenio sobre Eliminación de Todas las Formas de Discriminación contra la Mujer\n" +
            "26081|26080|20100922063921487\n" +
            "26082|26081|20100922063921487\n" +
            "26083|25884|Ley 23184 - Responsabilidad Civil por Hechos de Violencia en Espectáculos Deportivos\n" +
            "26084|26083|20100922064026096\n" +
            "26085|26084|20100922064026096\n" +
            "26086|25884|Ley 23271 - Excepción al Secreto Bancario y Bursátil\n" +
            "26087|26086|20100922064136704\n" +
            "26088|26087|20100922064136704\n" +
            "26089|25884|Ley 23313 - Pacto Internacional de Derechos Económicos, Sociales y Culturales. Pacto Internacional de Derechos Civiles y Políticos\n" +
            "26090|26089|20100922063918691\n" +
            "26091|26090|20100922063918691\n" +
            "26092|25884|Ley 23370 - Refinanciación de Créditos para Vivienda\n" +
            "26093|26092|20100922064832902\n" +
            "26094|26093|20100922064832902\n" +
            "26095|25884|Ley 23511 - Banco Nacional de Datos Genéticos\n" +
            "26096|26095|20100922064150032\n" +
            "26097|26096|20100922064150032\n" +
            "26098|25884|Ley 23576 - Obligaciones Negociables\n" +
            "26099|26098|20100922064457389\n" +
            "26100|26099|20100922064457389\n" +
            "26101|25884|Ley 23592 - Protección contra la Discriminación\n" +
            "26102|26101|20100922064032127\n" +
            "26103|26102|20100922064032127\n" +
            "26104|25884|Ley 23849 - Convención sobre los Derechos del Niño\n" +
            "26105|26104|20100922063917550\n" +
            "26106|26105|20100922063917550\n" +
            "26107|25884|Ley 23916 - Convención Internacional sobre Compraventa de Mercaderías\n" +
            "26108|26107|20100922063903113\n" +
            "26109|26108|20100922063903113\n" +
            "26110|25884|Ley 23928 - Ley de Convertibilidad del Austral\n" +
            "26111|26110|20100922064449858\n" +
            "26112|26111|20100922064449858\n" +
            "26113|25884|Ley 23968 - Soberanía Argentina sobre Aguas Interiores, Mar Territorial, Zona Económica Exclusiva y Plataforma Continental\n" +
            "26114|26113|20100922064417421\n" +
            "26115|26114|20100922064417421\n" +
            "26116|25884|Ley 24051 - Registro de Generadores y Operadores de Residuos Peligrosos\n" +
            "26117|26116|20100922064438890\n" +
            "26118|26117|20100922064438890\n" +
            "26119|25884|Ley 24083 - Fondos Comunes de Inversión\n" +
            "26120|26119|20100922064153892\n" +
            "26121|26120|20100922064153892\n" +
            "26122|25884|Ley 24106 - Convenio Internacional sobre Responsabilidad Civil Emergente de Accidentes de Tránsito\n" +
            "26123|26122|20100922063952049\n" +
            "26124|26123|20100922063952049\n" +
            "26125|25884|Ley 24144 - Carta Orgánica del Banco Central de la República Argentina\n" +
            "26126|26125|20100922063535568\n" +
            "26127|26126|20100922063535568\n" +
            "26128|25884|Ley 24240 - Ley de Defensa del Consumidor\n" +
            "26129|26128|20100922064016987\n" +
            "26130|26129|20100922064016987\n" +
            "26131|25884|Ley 24283 - Ley de Desindexación\n" +
            "26132|26131|20100922064032096\n" +
            "26133|26132|20100922064032096\n" +
            "26134|25884|Ley 24318 - Sindicatura de Procesos de Quiebra de Entidades Financieras Liquidadas con Anterioridad a la Vigencia de la Ley 24144\n" +
            "26135|26134|20100922064137298\n" +
            "26136|26135|20100922064137298\n" +
            "26137|25884|Ley 24321 - Desaparición Forzada de Personas\n" +
            "26138|26137|20100922064029877\n" +
            "26139|26138|20100922064029877\n" +
            "26140|25884|Ley 24374 - Regulación Dominial de Casa Habitación Única y Permanente\n" +
            "26141|26140|20100922064228219\n" +
            "26142|26141|20100922064228219\n" +
            "26143|25884|Ley 24409 - Convenio Internacional sobre Reconocimiento de la Personería Jurídica de Sociedades, Asociaciones y Fundaciones Extranjeras\n" +
            "26144|26143|20100922063949721\n" +
            "26145|26144|20100922063949721\n" +
            "26146|25884|Ley 24411 - Beneficios para Causahabientes por Desaparición Forzada de Personas\n" +
            "26147|26146|20100922064030424\n" +
            "26148|26147|20100922064030424\n" +
            "26149|25884|Ley 24417 - Violencia Familiar\n" +
            "26150|26149|20100922063531193\n" +
            "26151|26150|20100922063531193\n" +
            "26152|25884|Ley 24441 - Fideicomiso, Leasing e Hipotecas\n" +
            "26153|26152|20100922064832980\n" +
            "26154|26153|20100922064832980\n" +
            "26155|25884|Ley 24449 - Ley Nacional de Tránsito\n" +
            "26156|26155|20100922064827152\n" +
            "26157|26156|20100922064827152\n" +
            "26158|25884|Ley 24452 - Ley de Cheques\n" +
            "26159|26158|20100922063548318\n" +
            "26160|26159|20100922063548318\n" +
            "26161|25884|Ley 24467 - Régimen de Promoción para el Crecimiento y Desarrollo de la Pequeña y Mediana Empresa\n" +
            "26162|26161|20100922064507874\n" +
            "26163|26162|20100922064507874\n" +
            "26164|25884|Ley 24481 - Patentes de Invención\n" +
            "26165|26164|20100922064501014\n" +
            "26166|26165|20100922064501014\n" +
            "26167|25884|Ley 24483 - Personería Jurídica de Institutos de Vida Consagrada y Sociedades de Vida Apostólica\n" +
            "26168|26167|20100922063532787\n" +
            "26169|26168|20100922063532787\n" +
            "26170|25884|Ley 24485 - Seguro de Garantía para Depósitos Bancarios\n" +
            "26171|26170|20100922064130736\n" +
            "26172|26171|20100922064130736\n" +
            "26173|25884|Ley 24522 - Ley de Concursos y Quiebras\n" +
            "26174|26173|20100922063835191\n" +
            "26175|26174|20100922063835191\n" +
            "26176|25884|Ley 24540 - Identificación Registral de Recién Nacidos\n" +
            "26177|26176|20100922064646279\n" +
            "26178|26177|20100922064646279\n" +
            "26179|25884|Ley 24587 - Nominatividad de Títulos Valores Privados\n" +
            "26180|26179|20100922064812184\n" +
            "26181|26180|20100922064812184\n" +
            "26182|25884|Ley 24658 - Convención Interamericana sobre Derechos Humanos en Materia de Derechos Económicos, Sociales y Culturales\n" +
            "26183|26182|20100922063905472\n" +
            "26184|26183|20100922063905472\n" +
            "26185|25884|Ley 24754 - Cobertura Médica Obligatoria de Medicina Prepaga\n" +
            "26186|26185|20100922064425749\n" +
            "26187|26186|20100922064425749\n" +
            "26188|25884|Ley 24760 - Factura de Crédito\n" +
            "26189|26188|20100922064146642\n" +
            "26190|26189|20100922064146642\n" +
            "26191|25884|Ley 24766 - Confidencialidad de la Información\n" +
            "26192|26191|20100922064158345\n" +
            "26193|26192|20100922064158345\n" +
            "26194|25884|Ley 24871 - Inaplicabilidad de Legislación Extranjera que Restrinja el Libre Ejercicio del Comercio y la Circulación de Capitales\n" +
            "26195|26194|20100922064413343\n" +
            "26196|26195|20100922064413343\n" +
            "26197|25884|Ley 24921 - Transporte de Carga\n" +
            "26198|26197|20100922064830418\n" +
            "26199|26198|20100922064830418\n" +
            "26200|25884|Ley 25027 - Decisiones de Asambleas o Consejos de Administración de Cooperativas\n" +
            "26201|26200|20100922064005502\n" +
            "26202|26201|20100922064005502\n" +
            "26203|25884|Ley 25065 - Tarjeta de Crédito\n" +
            "26204|26203|20100922064813231\n" +
            "26205|26204|20100922064813231\n" +
            "26206|25884|Ley 25093 - Escrituras Traslativas de Dominio Suscriptas por Entidades Financieras\n" +
            "26207|26206|20100922064016955\n" +
            "26208|26207|20100922064016955\n" +
            "26209|25884|Ley 25113 - Contrato de Maquila\n" +
            "26210|26209|20100922063437288\n" +
            "26211|26210|20100922063437288\n" +
            "26212|25884|Ley 25169 - Contrato de Explotación Tambera\n" +
            "26213|26212|20100922064157142\n" +
            "26214|26213|20100922064157142\n" +
            "26215|25884|Ley 25179 - Convenio Internacional sobre Tráfico de Menores\n" +
            "26216|26215|20100922063957799\n" +
            "26217|26216|20100922063957799\n" +
            "26218|25884|Ley 25219 - Exención de Sanciones por Infracciones a las Normas sobre Identificación, Registro y Clasificación del Potencial Humano Nacional\n" +
            "26219|26218|20100922064645622\n" +
            "26220|26219|20100922064645622\n" +
            "26221|25884|Ley 25248 - Leasing\n" +
            "26222|26221|20100922064411624\n" +
            "26223|26222|20100922064411624\n" +
            "26224|25884|Ley 25284 - Administración de Entidades Deportivas con Dificultades Económicas. Fideicomiso de Administración\n" +
            "26225|26224|20100922064020924\n" +
            "26226|26225|20100922064020924\n" +
            "26227|25884|Ley 25300 - Régimen de Fortalecimiento Competitivo de las Micro, Pequeñas y Medianas Empresas (MIPyMEs)\n" +
            "26228|26227|20100922064509077\n" +
            "26229|26228|20100922064509077\n" +
            "26230|25884|Ley 25326 - Hábeas Data y Protección de Datos Personales\n" +
            "26231|26230|20100922064203829\n" +
            "26232|26231|20100922064203829\n" +
            "26233|25884|Ley 25344 - Declaración de Emergencia Económico-Financiera del Estado Nacional\n" +
            "26234|26233|20100922064058783\n" +
            "26235|26234|20100922064058783\n" +
            "26236|25884|Ley 25345 - Ley de Prevención de la Evasión Fiscal\n" +
            "26237|26236|20100922064142736\n" +
            "26238|26237|20100922064142736\n" +
            "26239|25884|Ley 25358 - Convenio sobre Restitución Internacional de Menores\n" +
            "26240|26239|20100922063933878\n" +
            "26241|26240|20100922063933878\n" +
            "26242|25884|Ley 25392 - Registro de Donantes de Células Progenitoras Hematopéyicas\n" +
            "26243|26242|20100922064038658\n" +
            "26244|26243|20100922064038658\n" +
            "26245|25884|Ley 25413 - Impuesto sobre Débitos y Créditos Bancarios\n" +
            "26246|26245|20100922064215673\n" +
            "26247|26246|20100922064215673\n" +
            "26248|25884|Ley 25466 - Intangibilidad de Depósitos Financieros\n" +
            "26249|26248|20100922064130158\n" +
            "26250|26249|20100922064130158\n" +
            "26251|25884|Ley 25506 - Firma Digital\n" +
            "26252|26251|20100922064152267\n" +
            "26253|26252|20100922064152267\n" +
            "26254|25884|Ley 25561 - Emergencia Pública en Materia Social, Económica, Administrativa, Financiera y Cambiaria\n" +
            "26255|26254|20100922064106049\n" +
            "26256|26255|20100922064106049\n" +
            "26257|25884|Ley 25675 - Ley General del Ambiente\n" +
            "26258|26257|20100922064428952\n" +
            "26259|26258|20100922064428952\n" +
            "26260|25884|Ley 25713 - Coeficiente de Estabilización de Referencia (CER)\n" +
            "26261|26260|20100922063615037\n" +
            "26262|26261|20100922063615037\n" +
            "26263|25884|Ley 25730 - Sanciones para el Librador de un Cheque Rechazado\n" +
            "26264|26263|20100922063547771\n" +
            "26265|26264|20100922063547771\n" +
            "26266|25884|Ley 25738 - Deber de Información de las Entidades Financieras Locales de Capital Extranjero y las Sucursales de Entidades Financieras Extranjeras\n" +
            "26267|26266|20100922064122080\n" +
            "26268|26267|20100922064122080\n" +
            "26269|25884|Ley 25743 - Protección de Bienes Arqueológicos y Paleontológicos\n" +
            "26270|26269|20100922064502264\n" +
            "26271|26270|20100922064502264\n" +
            "26272|25884|Ley 25746 - Registro Nacional de Información de Personas Menores Extraviadas\n" +
            "26273|26272|20100922064651122\n" +
            "26274|26273|20100922064651122\n" +
            "26275|25884|Ley 25750 - Ley de Preservación del Patrimonio Histórico y Cultural del Estado\n" +
            "26276|26275|20100922064503967\n" +
            "26277|26276|20100922064503967\n" +
            "26278|25884|Ley 25761 - Desarmado y Venta de Autopartes\n" +
            "26279|26278|20100922063533412\n" +
            "26280|26279|20100922063533412\n" +
            "26281|25884|Ley 25796 - Régimen de Compensación a Entidades Financieras\n" +
            "26282|26281|20100922064124220\n" +
            "26283|26282|20100922064124220\n" +
            "26284|25884|Ley 25798 - Sistema de Refinanciación Hipotecaria\n" +
            "26285|26284|20100922064044596\n" +
            "26286|26285|20100922064044596\n" +
            "26287|25884|Ley 25819 - Inscripción Registral de Nacimientos de Menores de hasta Diez Años de Edad\n" +
            "26288|26287|20100922064638435\n" +
            "26289|26288|20100922064638435\n" +
            "26290|25884|Ley 25854 - Registro Único de Aspirantes a Guarda con Fines Adoptivos\n" +
            "26291|26290|20100922063412132\n" +
            "26292|26291|20100922063412132\n" +
            "26293|25884|Ley 25914 - Indemnización para Personas Secuestradas y/o Nacidas en Cautiverio\n" +
            "26294|26293|20100922064028268\n" +
            "26295|26294|20100922064028268\n" +
            "26296|25884|Ley 26032 - Libertad de Expresión en Internet\n" +
            "26297|26296|20100922064157720\n" +
            "26298|26297|20100922064157720\n" +
            "26299|25884|Ley 26047 - Registro Nacional de Sociedades por Acciones\n" +
            "26300|26299|20100922064759934\n" +
            "26301|26300|20100922064759934\n" +
            "26302|25884|Ley 26061 - Protección Integral de Menores\n" +
            "26303|26302|20100922064441140\n" +
            "26304|26303|20100922064441140\n" +
            "26305|25884|Ley 26130 - Intervenciones de Contracepción Quirúrgica (Ligadura de Trompas y Vasectomía)\n" +
            "26306|26305|20100922064708575\n" +
            "26307|26306|20100922064708575\n" +
            "26308|25884|Ley 26167 - Interpretación de Normas de Emergencia Pública\n" +
            "26309|26308|20100922064109283\n" +
            "26310|26309|20100922064109283\n" +
            "26311|25884|Ley 26209 - Ley Nacional de Catastro\n" +
            "26312|26311|20100922064229844\n" +
            "26313|26312|20100922064229844\n" +
            "26314|25884|Ley 26355 - Marca Colectiva\n" +
            "26315|26314|20100922064417437\n" +
            "26316|26315|20100922064417437\n" +
            "26317|25884|Ley 26356 - Sistemas Turísticos de Tiempo Compartido (STTC)\n" +
            "26318|26317|20100922064232141\n" +
            "26319|26318|20100922064232141\n" +
            "26320|25884|Ley 26378 - Convención sobre los Derechos de las Personas con Discapacidad\n" +
            "26321|26320|20100922063909534\n" +
            "26322|26321|20100922063909534\n" +
            "26323|25884|Ley 26413 - Funcionamiento del Registro del Estado Civil y Capacidad de las Personas\n" +
            "26324|26323|20100922064640810\n" +
            "26325|26324|20100922064640810\n" +
            "26326|25884|Ley 26485 - Protección contra la Violencia de Género\n" +
            "26327|26326|20100922063530647\n" +
            "26328|26327|20100922063530647\n" +
            "26329|25884|Ley 26529 - Derechos del Paciente\n" +
            "26330|26329|20100922084735643\n" +
            "26331|26330|20100922084735643\n" +
            "26332|25884|Ley 26564 - Ampliación de Beneficios para Causahabientes por Desaparición Forzada de Personas\n" +
            "26333|26332|20100922064030940\n" +
            "26334|26333|20100922064030940\n" +
            "26335|25884|Ley 26589 - Mediación Prejudicial Obligatoria\n" +
            "26336|26335|20100922081634163\n" +
            "26337|26336|20100922081634163\n" +
            "26338|25884|Ley 26637 - Medidas Mínimas de Seguridad para Entidades Financieras\n" +
            "26339|26338|20101221102824187\n" +
            "26340|26339|20101221102824187\n" +
            "26341|25884|Ley 26657 - Protección de la Salud Mental\n" +
            "26342|26341|20101220052929170\n" +
            "26343|26342|20101220052929170\n" +
            "26344|25884|Ley 26682 - Marco Regulatorio de la Medicina Prepaga\n" +
            "26345|26344|20110517091023375\n" +
            "26346|26345|20110517091023375\n" +
            "26347|25884|Ley 26687 - Ley Antitabaco\n" +
            "26348|26347|20110614084158899\n" +
            "26349|26348|20110614084158899\n" +
            "26350|25884|Ley 26736 - Marco Regulatorio de la Fabricación, Comercialización y Distribución de Papel para Diarios\n" +
            "26351|26350|20111228120147207\n" +
            "26352|26351|20111228120147207\n" +
            "26353|25884|Ley 26737 - Tierras Rurales\n" +
            "26354|26353|20111228120421208\n" +
            "26355|26354|20111228120421208\n" +
            "26356|25884|Ley 26743 - Identidad de Género\n" +
            "26357|26356|20120524093427948\n" +
            "26358|26357|20120524093427948\n" +
            "26359|25884|Ley 26831 - Mercado de Capitales\n" +
            "26360|26359|20121228095809656\n" +
            "26361|26360|20121228095809656\n" +
            "26362|25884|Ley 26854 - Medidas Cautelares en Causas en que el Estado sea Parte\n" +
            "26363|26362|20130430094323720\n" +
            "26364|26363|20130430094323720\n" +
            "26365|25884|Ley 26858 - Garantía de Libre Circulación y Permanencia de Perros Guía para Personas con Discapacidad Visual\n" +
            "26366|26365|20130614090359582\n" +
            "26367|26366|20130614090359582\n" +
            "26368|25884|Ley 26860 - Régimen de Exteriorización Voluntaria de Divisas\n" +
            "26369|26368|20130603100750343\n" +
            "26370|26369|20130603100750343\n" +
            "26371|25884|Ley 26862 - Garantía de Acceso Integral a Técnicas de Fertilización Asistida\n" +
            "26372|26371|20130626083843177\n" +
            "26373|26372|20130626083843177\n" +
            "26374|25884|Ley 26944 - Responsabilidad del Estado\n" +
            "26375|26374|20140808101831779\n" +
            "26376|26375|20140808101831779\n" +
            "26377|25884|Ley 26951 - Registro Nacional No Llame\n" +
            "26378|26377|20140805094223702\n" +
            "26379|26378|20140805094223702\n" +
            "26380|25884|Ley 26994 - Código Civil y Comercial de la Nación\n" +
            "26381|26380|20141008075445113\n" +
            "26382|26381|20141008075445113\n" +
            "26383|25884|Ley 27210 - Cuerpo de Abogados del Estado para Víctimas de Violencia de Género\n" +
            "26384|26383|20151126082320420\n" +
            "26385|26384|20151126082320420\n" +
            "26386|25884|Ley 27221 - Contrato de Hospedaje\n" +
            "26387|26386|20151222080250326\n" +
            "26388|26387|20151222080250326\n" +
            "26389|25884|Ley 27237 - Convención Relativa a la Competencia, Ley Aplicable, Reconocimiento, Ejecución y Cooperación en Materia de Responsabilidad Parental y Medidas de Protección de Menores\n" +
            "26390|26389|20151223125058992\n" +
            "26391|26390|20151223125058992\n" +
            "26392|25884|Ley 27260 - Programa de Reparación Histórica para Jubilados y Pensionados. Régimen de Sinceramiento Fiscal\n" +
            "26393|26392|20160707102430732\n" +
            "26394|26393|20160707102430732\n" +
            "26395|25884|Ley 27269 - Deber de Información con la Entrega del Certificado Único de Discapacidad\n" +
            "26396|26395|20160831082232522\n" +
            "26397|26396|20160831082232522\n" +
            "26398|25884|Ley 27271 - Sistema para el Fomento de la Inversión en Vivienda 'Casa de Ahorro'\n" +
            "26399|26398|20160915075817805\n" +
            "26400|26399|20160915075817805\n" +
            "26401|25884|Ley 27275 - Derecho de Acceso a la Información Pública\n" +
            "26402|26401|20160929074637707\n" +
            "26403|26402|20160929074637707\n" +
            "26404|25884|Ley 27349 - Ley de Apoyo al Capital Emprendedor. Sistemas de Financiamiento Colectivo. Sociedad por Acciones Simplificada (SAS)\n" +
            "26405|26404|20170412074427670\n" +
            "26406|26405|20170412074427670\n" +
            "26407|25884|Ley 27350 - Investigación Médica y Científica del Uso Medicinal de la Planta de Cannabis y sus Derivados\n" +
            "26408|26407|20170419073927670\n" +
            "26409|26408|20170419073927670\n" +
            "26410|25884|Ley 27351 - Régimen de Beneficios para Electrodependientes\n" +
            "26411|26410|20170517074103571\n" +
            "26412|26411|20170517074103571\n" +
            "26413|25884|Ley 27360 - Convención Interamericana sobre Protección de los Derechos Humanos de las Personas Mayores\n" +
            "26414|26413|20170531073142173\n" +
            "26415|26414|20170531073142173\n" +
            "26416|25884|Ley 27437 - Ley de Compre Argentino y Desarrollo de Proveedores\n" +
            "26417|26416|20180510062506959\n" +
            "26418|25884|Ley 27440 - Ley de Financiamiento Productivo\n" +
            "26419|26418|20180511074710637\n" +
            "26420|26419|20180511074710637\n" +
            "26421|25884|Ley 27442 - Nueva Ley de Defensa de la Competencia\n" +
            "26422|26421|20180515065023759\n" +
            "26423|26422|20180515065023759\n" +
            "26424|25884|Ley 27444 - Ley de Simplificación y Desburocratización para el Desarrollo Productivo de la Nación\n" +
            "26425|26424|20180618080938673\n" +
            "26426|25884|Ley 27447 - Ley de Trasplante de Órganos, Tejidos y Células. Ley Justina\n" +
            "26427|26426|20180726062943174\n" +
            "26428|25884|Ley 27449 - Ley de Arbitraje Comercial Internacional\n" +
            "26429|26428|20180726063351752\n" +
            "26430|25884|Ley 27452 - Régimen de Reparación Económica para las Niñas, Niños y Adolescentes. “Ley Brisa”\n" +
            "26431|26430|20180726063816497\n" +
            "26432|25884|Ley 27483 - Convenio para la Protección de las Personas con respecto al Tratamiento Automatizado de Datos de Carácter Personal. Estrasburgo, República Francesa, 1981\n" +
            "26433|26432|20190102081500074\n" +
            "26434|26433|20190102081500074\n" +
            "26435|25884|Ley 27486 - Contribución Extraordinaria sobre el Capital de Cooperativas y Mutuales de Ahorro, de Crédito y/o Financieras, de Seguros y/o Reaseguro\n" +
            "26436|26435|20190108062018176\n" +
            "26437|26436|20190108062018176\n" +
            "26438|25884|Ley 27491 - Política Pública de Control de las Enfermedades Prevenibles por Vacunación\n" +
            "26439|26438|20190104073207748\n" +
            "26440|26439|20190104073207748\n" +
            "26441|25884|Ley 27512 - Ley General de Reconocimiento y Protección de las Personas Apátridas\n" +
            "26442|26441|20190828073125368\n" +
            "26443|26442|20190828073125368\n" +
            "26444|25884|Ley 27541 - Ley de Solidaridad Social y Reactivación Productiva en el Marco de la Emergencia Pública\n" +
            "26445|26444|20191224061705047\n" +
            "26446|26445|20191224061705047\n" +
            "26447|25884|Decreto Ley 15348/1946 - Prenda con Registro\n" +
            "26448|26447|20100922064558732\n" +
            "26449|26448|20100922064558732\n" +
            "26450|25884|Decreto Ley 15349/1946 - Sociedades de Economía Mixta\n" +
            "26451|26450|20100922064749871\n" +
            "26452|26451|20100922064749871\n" +
            "26453|25884|Decreto Ley 7771/1956 - Tratado de Montevideo de 1940\n" +
            "26454|26453|20100922064001893\n" +
            "26455|26454|20100922064001893\n" +
            "26456|25884|Decreto Ley 9982/1957 - Convenio sobre Nacionalidad de la Mujer\n" +
            "26457|26456|20100922063937643\n" +
            "26458|26457|20100922063937643\n" +
            "26459|25884|Decreto Ley 9983/1957 - Convenio sobre Derechos Civiles y Políticos de la Mujer\n" +
            "26460|26459|20100922063916987\n" +
            "26461|26460|20100922063916987\n" +
            "26462|25884|Decreto Ley 6582/1958 - Registro de la Propiedad Automotor\n" +
            "26463|26462|20100922064627404\n" +
            "26464|26463|20100922064627404\n" +
            "26465|25884|Decreto Ley 5965/1963 - Letra de Cambio y Pagaré\n" +
            "26466|26465|20100922064819121\n" +
            "26467|26466|20100922064819121\n" +
            "26468|25884|Decreto Ley 6673/1963 - Derecho de Propiedad Intelectual sobre Diseños Industriales\n" +
            "26469|26468|20100922064619341\n" +
            "26470|26469|20100922064619341\n" +
            "26471|25884|Decreto 41233/1934 - Inscripción y Registración de Obras en el Registro Nacional de la Propiedad Intelectual\n" +
            "26472|26471|20100922064619404\n" +
            "26473|26472|20100922064619404\n" +
            "26474|25884|Decreto 18734/1949 - Contenido e Inscripción del  Reglamento de Copropiedad y Administración del Régimen de Propiedad Horizontal\n" +
            "26475|26474|20100922064617748\n" +
            "26476|26475|20100922064617748\n" +
            "26477|25884|Decreto 8330/1963 - Reglamentación de la Ley de Arrendamientos y Aparcerías Rurales\n" +
            "26478|26477|20100922063528490\n" +
            "26479|26478|20100922063528490\n" +
            "26480|25884|Decreto 1671/1974 - Representación de Intérpretes Argentinos y Extranjeros para la Percepción y Administración de Retribuciones por sus Interpretaciones\n" +
            "26481|26480|20100922064619982\n" +
            "26482|26481|20100922064619982\n" +
            "26483|25884|Decreto 2080/1980 - Reglamentación del Registro de la Propiedad Inmueble\n" +
            "26484|26483|20100922064634451\n" +
            "26485|26484|20100922064634451\n" +
            "26486|25884|Decreto 580/1981 - Reglamentación del Régimen de Transferencia de Tecnología\n" +
            "26487|26486|20100922064822590\n" +
            "26488|26487|20100922064822590\n" +
            "26489|25884|Decreto 1493/1982 - Organización y Funcionamiento de la Inspección General de Justicia\n" +
            "26490|26489|20100922064243813\n" +
            "26491|26490|20100922064243813\n" +
            "26492|25884|Decreto 156/1989 - Reglamentación del Régimen de Obligaciones Negociables\n" +
            "26493|26492|20100922064457952\n" +
            "26494|26493|20100922064457952\n" +
            "26495|25884|Decreto 288/1990 - Forma de Emisión de Obligaciones Negociables\n" +
            "26496|26495|20100922064457374\n" +
            "26497|26496|20100922064457374\n" +
            "26498|25884|Decreto 289/1990 - Creación y Negociación de Títulos Valores\n" +
            "26499|26498|20100922064820246\n" +
            "26500|26499|20100922064820246\n" +
            "26501|25884|Decreto 2284/1991 - Desregulación del Comercio Interior y Exterior de Bienes y Servicios\n" +
            "26502|26501|20100922063620193\n" +
            "26503|26502|20100922063620193\n" +
            "26504|25884|Decreto 174/1993 - Fondos Comunes de Inversión\n" +
            "26505|26504|20100922064154407\n" +
            "26506|26505|20100922064154407\n" +
            "26507|25884|Decreto 165/1994 - Régimen de Propiedad Intelectual por Obras de Software\n" +
            "26508|26507|20100922064621998\n" +
            "26509|26508|20100922064621998\n" +
            "26510|25884|Decreto 1226/1994 - Reglamentación de la Quiebra de Entidades Financieras\n" +
            "26511|26510|20100922075906270\n" +
            "26512|26511|20100922075906270\n" +
            "26513|25884|Decreto 1798/1994 - Reglamentación de la Ley de Defensa del Consumidor\n" +
            "26514|26513|20100922064018674\n" +
            "26515|26514|20100922064018674\n" +
            "26516|25884|Decreto 67/1996 - Tasas por Servicios de la Inspección General de Justicia\n" +
            "26517|26516|20100922081312993\n" +
            "26518|26517|20100922081312993\n" +
            "26519|25884|Decreto 259/1996 - Reglamentación del Régimen de Nominatividad de Títulos Valores\n" +
            "26520|26519|20100922064444546\n" +
            "26521|26520|20100922064444546\n" +
            "26522|25884|Decreto 367/1996 - Defensa del Crédito del Estado en Procesos Concursales\n" +
            "26523|26522|20100922063835050\n" +
            "26524|26523|20100922063835050\n" +
            "26525|25884|Decreto 1153/1997 - Pautas de Publicidad en los Juegos de Azar\n" +
            "26526|26525|20100922064410968\n" +
            "26527|26526|20100922064410968\n" +
            "26528|25884|Decreto 276/1998 - Sistema de Arbitraje del Consumo\n" +
            "26529|26528|20100922064012627\n" +
            "26530|26529|20100922064012627\n" +
            "26531|25884|Decreto 466/1999 - Reglamento de la Ley del Registro de la Propiedad Inmueble para la Capital Federal\n" +
            "26532|26531|20100922064633919\n" +
            "26533|26532|20100922064633919\n" +
            "26534|25884|Decreto 1038/2000 - Reglamentación del Contrato de Leasing\n" +
            "26535|26534|20100922064412140\n" +
            "26536|26535|20100922064412140\n" +
            "26537|25884|Decreto 1406/2001 - Régimen Legal de la Sociedad Laboral\n" +
            "26538|26537|20100922064809902\n" +
            "26539|26538|20100922064809902\n" +
            "26540|25884|Decreto 1558/2001 - Reglamentación de la Ley de Protección de Datos Personales\n" +
            "26541|26540|20100922064158923\n" +
            "26542|26541|20100922064158923\n" +
            "26543|25884|Decreto 214/2002 - Pesificación de Obligaciones en Moneda Extranjera\n" +
            "26544|26543|20100922064105517\n" +
            "26545|26544|20100922064105517\n" +
            "26546|25884|Decreto 267/2003 - Reglamentación del Registro de Donantes de Células Progenitoras Hematopéyicas\n" +
            "26547|26546|20100922064039174\n" +
            "26548|26547|20100922064039174\n" +
            "26549|25884|Decreto 1085/2003 - Reglamentación de las Sanciones para Libradores de Cheques Rechazados\n" +
            "26550|26549|20100922063547787\n" +
            "26551|26550|20100922063547787\n" +
            "26552|25884|Decreto 1384/2008 - Reglamentación de la Marca Colectiva\n" +
            "26553|26552|20100922064417515\n" +
            "26554|26553|20100922064417515\n" +
            "26555|25884|Decreto 1328/2009 - Reglamentación del Registro Único de Aspirantes a Guarda con Fines Adoptivos\n" +
            "26556|26555|20100922070609670\n" +
            "26557|26556|20100922070609670\n" +
            "26558|25884|Decreto 1011/2010 - Reglamentación del Régimen de Protección contra la Violencia de Género\n" +
            "26559|26558|20100922063529615\n" +
            "26560|26559|20100922063529615\n" +
            "26561|25884|Decreto 1993/2011 - Reglamentación del Marco Regulatorio de la Medicina Prepaga\n" +
            "26562|26561|20111201090909029\n" +
            "26563|26562|20111201090909029\n" +
            "26564|25884|Decreto 274/2012 - Reglamentación de la Ley de Tierras Rurales\n" +
            "26565|26564|20120229095103178\n" +
            "26566|26565|20120229095103178\n" +
            "26567|25884|Decreto 1007/2012 - Procedimiento para la Rectificación Registral de Sexo y Cambio de Nombres en el Marco del Régimen de Respeto por la Identidad de Género\n" +
            "26568|26567|20120703094637149\n" +
            "26569|26568|20120703094637149\n" +
            "26570|25884|Decreto 1089/2012 - Reglamentación de los Derechos del Paciente\n" +
            "26571|26570|20120706095243638\n" +
            "26572|26571|20120706095243638\n" +
            "26573|25884|Decreto 956/2013 - Reglamentación de la Garantía de Acceso Integral a Técnicas de Fertilización Asistida\n" +
            "26574|26573|20130723081004195\n" +
            "26575|26574|20130723081004195\n" +
            "26576|25884|Decreto 1023/2013 - Reglamentación de la Ley de Mercado de Capitales\n" +
            "26577|26576|20130801084526206\n" +
            "26578|26577|20130801084526206\n" +
            "26579|25884|Decreto 903/2015 - Reglamentación del Derecho a la Identidad de Género\n" +
            "26580|26579|20150529082019588\n" +
            "26581|26580|20150529082019588\n" +
            "26582|25884|Decreto 207/2016 - Validez de la Edición Electrónica del Boletín Oficial de la República Argentina\n" +
            "26583|26582|20160120081521176\n" +
            "26584|26583|20160120081521176\n" +
            "26585|25884|Decreto 718/2016 - Facultades de la Secretaría de Comercio como Autoridad de Aplicación de la Ley de Defensa de la Competencia\n" +
            "26586|26585|20160530080244427\n" +
            "26587|26586|20160530080244427\n" +
            "26588|25884|Decreto 894/2016 - Reglamentación del Programa Nacional de Reparación Histórica para Jubilados y Pensionados\n" +
            "26589|26588|20160728082333664\n" +
            "26590|26589|20160728082333664\n" +
            "26591|25884|Decreto 895/2016 - Reglamentación del Régimen de Sinceramiento Fiscal\n" +
            "26592|26591|20160728083224432\n" +
            "26593|26592|20160728083224432\n" +
            "26594|25884|Decreto 738/2017 - Reglamentación del Marco Regulatorio para la Investigación Médica y Científica del Uso Medicinal de la Planta de Cannabis y sus Derivados\n" +
            "26595|26594|20170922073653832\n" +
            "26596|26595|20170922073653832\n" +
            "26597|25884|Decreto 182/2018 - Creación de la Comisión para la Modificación Parcial del Código Civil y Comercial de la Nación\n" +
            "26598|26597|20180307073407748\n" +
            "26599|25884|Decreto 471/2018 - Reglamentación de las Leyes de Financiamiento Productivo y de Mercado de Capitales\n" +
            "26600|26599|20180518074943659\n" +
            "26601|25884|Decreto 480/2018 - Reglamentación de la Ley de Defensa de la Competencia\n" +
            "26602|26601|20180524062702050\n" +
            "26603|26602|20180524062702050\n" +
            "26604|25884|Decreto 699/2018 - Reglamentación del Sistema de Sociedades de Garantía Recíproca\n" +
            "26605|26604|20180726064148177\n" +
            "26606|25884|Decreto 871/2018 - Reglamentación del Régimen de Reparación Económica para las Niñas, Niños y Adolescentes (Ley Brisa)\n" +
            "26607|26606|20181001074648663\n" +
            "26608|25884|Decreto 16/2019 - Reglamentación de la Ley de Trasplante de Órganos, Tejidos y Células. Ley Justina\n" +
            "26609|26608|20190107080113951\n" +
            "26610|25884|Decreto 34/2019 - Doble Indemnización por Despido sin Causa\n" +
            "26611|26610|20191216082750793\n" +
            "26612|26611|20191216082750793\n" +
            "26613|25884|Decreto 62/2019 - Régimen Procesal de la Acción Civil de Extinción de Dominio\n" +
            "26614|26613|20190122061237505\n" +
            "26615|25884|Decreto 99/2019 - Reglamentación de la Ley de Solidaridad Social y Reactivación Productiva\n" +
            "26616|26615|20191230075136259\n" +
            "26617|26616|20191230075136259\n" +
            "26618|25884|Decreto 182/2019 - Reglamentación de la Ley de Firma Digital\n" +
            "26619|26618|20190312061849856\n" +
            "26620|25884|Decreto 242/2019 - Reglamentación del Régimen de Marcas y Designaciones\n" +
            "26621|26620|20190403073733567\n" +
            "26622|25884|Decreto 274/2109 - Régimen de Control de Conductas en el Mercado, Complementario de la Ley de Defensa de la Competencia. Regulación Integral y Sistematizada de la Competencia Desleal\n" +
            "26623|26622|20190422080411313\n" +
            "26624|25884|Decreto 353/2019 - Reglamentación del Derecho de Propiedad Intelectual sobre Diseños Industriales\n" +
            "26625|26624|20190514061256256\n" +
            "26626|26625|20190514061256256\n" +
            "26627|25884|Decreto 792/2019 - Reglamentación de la Ley de Derecho al Acceso, Deambulación y Permanencia a Lugares y Transportes Públicos a Personas con Discapacidad Acompañadas por un Perro Guía\n" +
            "26628|26627|20191128075211640\n" +
            "26629|26628|20191128075211640\n" +
            "26630|25884|Resolución General  (CNV) 271/1995 - Régimen de Fideicomiso Financiero\n" +
            "26631|26630|20100922064148329\n" +
            "26632|26631|20100922064148329\n" +
            "26633|25884|Resolución General  (CNV) 622/2013 - Normas NT 2013 de la Comisión Nacional de Valores\n" +
            "26634|26633|20130909082045583\n" +
            "26635|26634|20130909082045583\n" +
            "26636|25884|Resolución (IGJ) 7/2005 - Cuarpo Normativo de la Inspección General de Justicia\n" +
            "26637|26636|20100922064234688\n" +
            "26638|26637|20100922064234688\n" +
            "26639|25884|Resolución (IGJ) 7/2015 - Normas de la Inspección General de Justicia\n" +
            "26640|26639|20150922123548455\n" +
            "26641|26640|20150922123548455\n" +
            "26642|25884|Resolución (SCI) 248/2019 - Contralor y Vigilancia del Régimen de Lealtad Comercial y de la Regulación Integral y Sistematizada de la Competencia Desleal\n" +
            "26643|26642|20190524074437953\n" +
            "26644|26643|20190524074437953\n" +
            "4005|0|Procesal civil y comercial\n" +
            "28147|4005|Parte General - Libro Primero - Disposiciones Generales. Competencia. Arts. 1 a 6\n" +
            "28148|28147|20151015045958532\n" +
            "28149|28148|20151015045958532\n" +
            "28150|4005|Parte General - Libro Primero - Disposiciones Generales. Cuestiones de competencia. Arts. 7 a 13\n" +
            "28151|28150|20151015050043534\n" +
            "28152|28151|20151015050043534\n" +
            "28153|4005|Parte General - Libro Primero - Disposiciones Generales. Recusaciones y excusaciones. Arts. 14 a 33\n" +
            "28154|28153|20151015050045535\n" +
            "28155|28154|20151015050045535\n" +
            "28156|4005|Parte General - Libro Primero - Disposiciones Generales. Deberes y facultades de los jueces. Arts. 34 a 37\n" +
            "28157|28156|20151015050045536\n" +
            "28158|28157|20151015050045536\n" +
            "28159|4005|Parte General - Libro Primero - Disposiciones Generales. Secretarios. Oficiales Primeros. Arts. 38 a 39\n" +
            "28160|28159|20151015050046537\n" +
            "28161|28160|20151015050046537\n" +
            "28162|4005|Parte General - Libro Primero - Disposiciones Generales. Reglas generales. Arts. 40 a 45\n" +
            "28163|28162|20151015050047538\n" +
            "28164|28163|20151015050047538\n" +
            "28165|4005|Parte General - Libro Primero - Disposiciones Generales. Representación procesal. Arts. 46 a 55\n" +
            "28166|28165|20151015050050539\n" +
            "28167|28166|20151015050050539\n" +
            "28168|4005|Parte General - Libro Primero - Disposiciones Generales. Patrocinio letrado. Arts. 56 a 58\n" +
            "28169|28168|20151015050049540\n" +
            "28170|28169|20151015050049540\n" +
            "28171|4005|Parte General - Libro Primero - Disposiciones Generales. Rebeldía. Arts. 59 a 67\n" +
            "28172|28171|20151015050050541\n" +
            "28173|28172|20151015050050541\n" +
            "28174|4005|Parte General - Libro Primero - Disposiciones Generales. Costas. Arts. 68 a 77\n" +
            "28175|28174|20151015050042533\n" +
            "28176|28175|20151015050042533\n" +
            "28177|4005|Parte General - Libro Primero - Disposiciones Generales. Beneficio de litigar sin gastos. Arts. 78 a 86\n" +
            "28178|28177|20151015050133542\n" +
            "28179|28178|20151015050133542\n" +
            "28180|4005|Parte General - Libro Primero - Disposiciones Generales. Acumulación de acciones y litisconsorcio. Arts. 87 a 89\n" +
            "28181|28180|20151015050132543\n" +
            "28182|28181|20151015050132543\n" +
            "28183|4005|Parte General - Libro Primero - Disposiciones Generales. Intervención de terceros. Arts. 90 a 96\n" +
            "28184|28183|20151015050133544\n" +
            "28185|28184|20151015050133544\n" +
            "28186|4005|Parte General - Libro Primero - Disposiciones Generales. Tercerías. Arts. 97 a 104\n" +
            "28187|28186|20151015050134545\n" +
            "28188|28187|20151015050134545\n" +
            "28189|4005|Parte General - Libro Primero - Disposiciones Generales. Citación de evicción. Arts. 105 a 110\n" +
            "28190|28189|20151015050136546\n" +
            "28191|28190|20151015050136546\n" );
    private static String menu3 =new String("28192|4005|Parte General - Libro Primero - Disposiciones Generales. Acción subrogatoria. Arts. 111 a 114\n" +
            "28193|28192|20151015050137547\n" +
            "28194|28193|20151015050137547\n" +
            "28195|4005|Parte General - Libro Primero - Disposiciones Generales. Actuaciones en general. Arts. 115 a 117\n" +
            "28196|28195|20151015050138548\n" +
            "28197|28196|20151015050138548\n" +
            "28198|4005|Parte General - Libro Primero - Disposiciones Generales. Escritos. Arts. 118 a 124\n" +
            "28199|28198|20151015050139549\n" +
            "28200|28199|20151015050139549\n" +
            "28201|4005|Parte General - Libro Primero - Disposiciones Generales. Audiencias. Arts. 125 a 126\n" +
            "28202|28201|20151015050139550\n" +
            "28203|28202|20151015050139550\n" +
            "28204|4005|Parte General - Libro Primero - Disposiciones Generales. Expedientes. Arts. 127 a 130\n" +
            "28205|28204|20151015050139551\n" +
            "28206|28205|20151015050139551\n" +
            "28207|4005|Parte General - Libro Primero - Disposiciones Generales. Oficios y exhortos. Arts. 131 a 132\n" +
            "28208|28207|20151015050140552\n" +
            "28209|28208|20151015050140552\n" +
            "28210|4005|Parte General - Libro Primero - Disposiciones Generales. Notificaciones. Arts. 133 a 149\n" +
            "28211|28210|20151015050142553\n" +
            "28212|28211|20151015050142553\n" +
            "28213|4005|Parte General - Libro Primero - Disposiciones Generales. Vistas y traslados. Arts. 150 a 151\n" +
            "28214|28213|20151015050143554\n" +
            "28215|28214|20151015050143554\n" +
            "28216|4005|Parte General - Libro Primero - Disposiciones Generales. Sección primera. Tiempo hábil. Arts. 152 a 154\n" +
            "28217|28216|20151015050144555\n" +
            "28218|28217|20151015050144555\n" +
            "28219|4005|Parte General - Libro Primero - Disposiciones Generales. Sección segunda. Plazos. Arts. 155 a 159\n" +
            "28220|28219|20151015050143556\n" +
            "28221|28220|20151015050143556\n" +
            "28222|4005|Parte General - Libro Primero - Disposiciones Generales. Resoluciones judiciales. Arts. 160 a 168\n" +
            "28223|28222|20151015050144557\n" +
            "28224|28223|20151015050144557\n" +
            "28225|4005|Parte General - Libro Primero - Disposiciones Generales. Nulidad de los actos procesales. Arts. 169 a 174\n" +
            "28226|28225|20151015050145558\n" +
            "28227|28226|20151015050145558\n" +
            "28228|4005|Parte General - Libro Primero - Disposiciones Generales. Incidentes. Arts. 175 a 187\n" +
            "28229|28228|20151015050146559\n" +
            "28230|28229|20151015050146559\n" +
            "28231|4005|Parte General - Libro Primero - Disposiciones Generales. Acumulación de procesos. Arts. 188 a 194\n" +
            "28232|28231|20151015050147560\n" +
            "28233|28232|20151015050147560\n" +
            "28234|4005|Parte General - Libro Primero - Disposiciones Generales Sección primera. Normas generales. Arts. 195 a 208\n" +
            "28235|28234|20151015050148561\n" +
            "28236|28235|20151015050148561\n" +
            "28237|4005|Parte General - Libro Primero - Disposiciones Generales Sección segunda. Embargo preventivo. Arts. 209 a 220\n" +
            "28238|28237|20151015050150562\n" +
            "28239|28238|20151015050150562\n" +
            "28240|4005|Parte General - Libro Primero - Disposiciones Generales Sección tercera. Secuestro. Art. 221\n" +
            "28241|28240|20151015050151563\n" +
            "28242|28241|20151015050151563\n" +
            "28243|4005|Parte General - Libro Primero - Disposiciones Generales Sección cuarta. Intervención judicial. Arts. 222 a 227\n" +
            "28244|28243|20151015050152564\n" +
            "28245|28244|20151015050152564\n" +
            "28246|4005|Parte General - Libro Primero - Disposiciones Generales Sección quinta. Inhibición general de bienes y anotación de litis. Arts. 228 a 229\n" +
            "28247|28246|20151015050153565\n" +
            "28248|28247|20151015050153565\n" +
            "28249|4005|Parte General - Libro Primero - Disposiciones Generales Sección sexta. Prohibición de innovar. Prohibición de contratar. Arts. 230 a 231\n" +
            "28250|28249|20151015050154566\n" +
            "28251|28250|20151015050154566\n" +
            "28252|4005|Parte General - Libro Primero - Disposiciones Generales Sección séptima. Medidas cautelares genéricas y normas subsidiarias. Arts. 232 a 233\n" +
            "28253|28252|20151015050153567\n" +
            "28254|28253|20151015050153567\n" +
            "28255|4005|Parte General - Libro Primero - Disposiciones Generales Sección octava. Protección de personas. Arts. 234 a 237\n" +
            "28256|28255|20151015050154568\n" +
            "28257|28256|20151015050154568\n" +
            "28258|4005|Parte General - Libro Primero - Disposiciones Generales Sección primera. Reposición. Arts. 238 a 241\n" +
            "28259|28258|20151015050156569\n" +
            "28260|28259|20151015050156569\n" +
            "28261|4005|Parte General - Libro Primero - Disposiciones Generales Sección segunda. Recurso de apelación. Recurso de nulidad. Consulta. Arts. 242 a 253 bis\n" +
            "28262|28261|20151015050156570\n" +
            "28263|28262|20151015050156570\n" +
            "28264|4005|Parte General - Libro Primero - Disposiciones Generales Sección tercera. Apelación ordinaria ante la Corte Suprema. Arts. 254 a 255\n" +
            "28265|28264|20151015050157571\n" +
            "28266|28265|20151015050157571\n" +
            "28267|4005|Parte General - Libro Primero - Disposiciones Generales Sección cuarta. Apelación extraordinaria ante la Corte Suprema. Arts. 256 a 258\n" +
            "28268|28267|20151015050158572\n" +
            "28269|28268|20151015050158572\n" +
            "28270|4005|Parte General - Libro Primero - Disposiciones Generales Sección quinta. Procedimiento ordinario en segunda instancia. Arts. 259 a 279\n" +
            "28271|28270|20151015050200573\n" +
            "28272|28271|20151015050200573\n" +
            "28273|4005|Parte General - Libro Primero - Disposiciones Generales Sección sexta. Procedimiento ante la Corte Suprema. Arts. 280 a 281\n" +
            "28274|28273|20151015050201574\n" +
            "28275|28274|20151015050201574\n" +
            "28276|4005|Parte General - Libro Primero - Disposiciones Generales Sección séptima. Queja por recurso denegado. Arts. 282 a 287\n" +
            "28277|28276|20151015050202575\n" +
            "28278|28277|20151015050202575\n" +
            "28279|4005|Parte General - Libro Primero - Disposiciones Generales Sección octava. Recursos de casación, de inconstitucionalidad y de revisión. Arts. 288 a 303\n" +
            "28280|28279|20151015050201576\n" +
            "28281|28280|20151015050201576\n" +
            "28282|4005|Parte General - Libro Primero - Disposiciones Generales Desistimiento. Arts. 304 a 306\n" +
            "28283|28282|20151015050202577\n" +
            "28284|28283|20151015050202577\n" +
            "28285|4005|Parte General - Libro Primero - Disposiciones Generales Conciliación. Art. 309\n" +
            "28286|28285|20151015050206580\n" +
            "28287|28286|20151015050206580\n" +
            "28288|4005|Parte General - Libro Primero - Disposiciones Generales Caducidad de la instancia. Arts. 310 a 318\n" +
            "28289|28288|20151015050207581\n" +
            "28290|28289|20151015050207581\n" +
            "28291|4005|Parte Especial - Libro Segundo - Procesos de Conocimiento Título I - Disposiciones generales\n" +
            "28292|28291|Clases. Arts. 319 a 322\n" +
            "28293|28292|20151015050207582\n" +
            "28294|28293|20151015050207582\n" +
            "28295|28291|Diligencias preliminares. Arts. 323 a 329\n" +
            "28296|28295|20151015050207583\n" +
            "28297|28296|20151015050207583\n" +
            "28298|4005|Parte Especial - Libro Segundo - Procesos de Conocimiento Título II - Proceso Ordinario\n" +
            "28299|28298|Demanda. Arts. 330 a 338\n" +
            "28300|28299|20151015050208584\n" +
            "28301|28300|20151015050208584\n" +
            "28302|28298|Citación del demandado. Arts. 339 a 345\n" +
            "28303|28302|20151015050210585\n" +
            "28304|28303|20151015050210585\n" +
            "28305|28298|Excepciones previas. Arts. 346 a 354 bis\n" +
            "28306|28305|20151015050211586\n" +
            "28307|28306|20151015050211586\n" +
            "28308|28298|Contestación a la demanda y reconvención. Arts. 355 a 359\n" +
            "28309|28308|20151015050212587\n" +
            "28310|28309|20151015050212587\n" +
            "28311|28298|Sección primera. Normas generales. Arts. 360 a 386\n" +
            "28312|28311|20151015050213588\n" +
            "28313|28312|20151015050213588\n" +
            "28314|28298|Sección segunda. Prueba documental. Arts. 387 a 395\n" +
            "28315|28314|20151015050214589\n" +
            "28316|28315|20151015050214589\n" +
            "28317|28298|Sección tercera. Prueba de informes. Requerimiento de expedientes. Arts. 396 a 403\n" +
            "28318|28317|20151015050215590\n" +
            "28319|28318|20151015050215590\n" +
            "28320|28298|Sección cuarta. Prueba de confesión. Arts. 404 a 425\n" +
            "28321|28320|20151015050250592\n" +
            "28323|28298|Sección quinta. Prueba de testigos. Arts. 426 a 456\n" +
            "28324|28323|20151015050251593\n" +
            "28325|28324|20151015050251593\n" +
            "28326|28298|Sección sexta. Prueba de peritos. Arts. 457 a 478\n" +
            "28327|28326|20151015050253594\n" +
            "28328|28327|20151015050253594\n" +
            "28329|28298|Sección séptima. Reconocimiento judicial. Arts. 479 a 480\n" +
            "28330|28329|20151015050254595\n" +
            "28331|28330|20151015050254595\n" +
            "28332|28298|Sección octava. Conclusión de la causa para definitiva. Arts. 481 a 485\n" +
            "28333|28332|20151015050255596\n" +
            "28334|28333|20151015050255596\n" +
            "28335|4005|Parte Especial - Libro Segundo - Procesos de Conocimiento Título III - Procesos sumario y sumarísimo\n" +
            "28336|28335|Proceso sumario. Arts. 486 a 497\n" +
            "28337|28336|20151015050256597\n" +
            "28338|28337|20151015050256597\n" +
            "28339|28335|Proceso sumarísimo. Art. 498\n" +
            "28340|28339|20151015050257598\n" +
            "28341|28340|20151015050257598\n" +
            "28342|4005|Parte Especial - Libro Tercero - Procesos de Ejecución Título I - Ejecución de sentencias\n" +
            "28343|28342|Sentencias de tribunales argentinos. Arts. 499 a 516\n" +
            "28344|28343|20151015050256599\n" +
            "28345|28344|20151015050256599\n" +
            "28346|28342|Sentencias de tribunales extranjeros. Laudos de tribunales arbitrales extranjeros. Arts. 517 a 519 bis\n" +
            "28347|28346|20151015050257600\n" +
            "28348|28347|20151015050257600\n" +
            "28349|4005|Parte Especial - Libro Tercero - Procesos de Ejecución Título II - Juicio Ejecutivo\n" +
            "28350|28349|Disposiciones generales. Arts. 520 a 530\n" +
            "28351|28350|20151015050259601\n" +
            "28352|28351|20151015050259601\n" +
            "28353|28349|Embargo y excepciones. Arts. 531 a 558 bis\n" +
            "28354|28353|20151015050300602\n" +
            "28355|28354|20151015050300602\n" +
            "28356|28349|Sección primera. Ámbito. Recursos. Dinero embargado. Liquidación. Pago inmediato. Títulos o acciones. Arts. 559 a 562\n" +
            "28357|28356|20151015050301603\n" +
            "28358|28357|20151015050301603\n" +
            "28359|28349|Sección segunda. Disposiciones comunes a la subasta de muebles, semovientes o inmuebles. Arts. 563 a 572\n" +
            "28360|28359|20151015050301604\n" +
            "28361|28360|20151015050301604\n" +
            "28362|28349|Sección tercera. Subasta de muebles o semovientes. Arts. 573 a 574\n" +
            "28363|28362|20151015050302605\n" +
            "28364|28363|20151015050302605\n" +
            "28365|28349|Sección cuarta. Subasta de inmuebles. Arts. 575 a 589\n" +
            "28366|28365|20151015050304606\n" +
            "28367|28366|20151015050304606\n" +
            "28368|28349|Sección quinta. Preferencias. Liquidación. Pago. Fianza. Arts. 590 a 591\n" +
            "28369|28368|20151015050305607\n" +
            "28370|28369|20151015050305607\n" +
            "28371|28349|Sección sexta. Nulidad de la subasta. Arts. 592 a 593\n" +
            "28372|28371|20151015050306608\n" +
            "28373|28372|20151015050306608\n" +
            "28374|28349|Sección séptima. Temeridad. Art. 594\n" +
            "28375|28374|20151015050305609\n" +
            "28376|28375|20151015050305609\n" +
            "28377|4005|Parte Especial - Libro Tercero - Ejecuciones especiales Título III - Ejecuciones especiales\n" +
            "28378|28377|Disposiciones generales. Arts. 595 a 596\n" +
            "28379|28378|20151015050306610\n" +
            "28380|28379|20151015050306610\n" +
            "28381|28377|Sección primera. Ejecución hipotecaria. Arts. 597 a 599\n" +
            "28382|28381|20151015050308611\n" +
            "28383|28382|20151015050308611\n" +
            "28384|28377|Sección segunda. Ejecución prendaria. Arts. 600 a 601\n" +
            "28385|28384|20151015050309612\n" +
            "28386|28385|20151015050309612\n" +
            "28387|28377|Sección tercera. Ejecución comercial. Arts. 602 a 603\n" +
            "28388|28387|20151015050309613\n" +
            "28389|28388|20151015050309613\n" +
            "28390|28377|Sección cuarta. Ejecución fiscal. Arts. 604 a 605\n" +
            "28391|28390|20151015050309614\n" +
            "28392|28391|20151015050309614\n" +
            "28393|4005|Parte Especial - Libro Cuarto - Procesos Especiales Título I - Interdictos y acciones posesorias. Denuncia de daño temido. Reparaciones urgentes\n" +
            "28394|28393|Interdictos. Art. 606\n" +
            "28395|28394|20151015050310615\n" +
            "28396|28395|20151015050310615\n" +
            "28397|28393|Interdicto de retener. Arts. 610 a 613\n" +
            "28398|28397|20151015050313617\n" +
            "28399|28398|20151015050313617\n" +
            "28400|28393|Interdicto de recobrar. Arts. 614 a 618\n" +
            "28401|28400|20151015050314618\n" +
            "28402|28401|20151015050314618\n" +
            "28403|28393|Disposiciones comunes a los interdictos. Arts. 621 a 622\n" +
            "28404|28403|20151015050314620\n" +
            "28405|28404|20151015050314620\n" +
            "28406|28393|Denuncia de daño temido. Oposición a la ejecución de reparaciones urgentes. Arts. 623 bis a 623 ter\n" +
            "28407|28406|20151015050316622\n" +
            "28408|28407|20151015050316622\n" +
            "28409|4005|Parte Especial - Libro Cuarto - Procesos Especiales Título II - Procesos de declaración de incapacidad y de inhabilitación\n" +
            "28410|28409|Declaración de demencia. Arts. 624 a 636\n" +
            "28411|28410|20151015050318623\n" +
            "28412|28411|20151015050318623\n" +
            "28413|28409|Declaración de sordomudez. Art. 637\n" +
            "28414|28413|20151015050319624\n" +
            "28415|28414|20151015050319624\n" +
            "28416|28409|Declaración de inhabilitación. Arts. 637 bis a 637 quinquies\n" +
            "28417|28416|20151015050320625\n" +
            "28418|28417|20151015050320625\n" +
            "28419|4005|Parte Especial - Libro Cuarto - Procesos Especiales Título III - Alimentos y litisexpensas\n" +
            "28420|28419|Alimentos y litisexpensas. Arts. 638 a 651\n" +
            "28421|28420|20151015050321626\n" +
            "28422|28421|20151015050321626\n" +
            "28423|4005|Parte Especial - Libro Cuarto - Procesos Especiales Título IV - Rendición de cuentas\n" +
            "28424|28423|Rendición de cuentas. Arts. 652 a 657\n" +
            "28425|28424|20151015050320627\n" +
            "28426|28425|20151015050320627\n" +
            "28427|4005|Parte Especial - Libro Cuarto - Procesos Especiales Título V - Mensura y deslinde\n" +
            "28428|28427|Mensura. Arts. 658 a 672\n" +
            "28429|28428|20151015050321628\n" +
            "28430|28429|20151015050321628\n" +
            "28431|28427|Deslinde. Arts. 673 a 675\n" +
            "28432|28431|20151015050322629\n" +
            "28433|28432|20151015050322629\n" +
            "28434|4005|Parte Especial - Libro Cuarto - Procesos Especiales Título VI - División de cosas comunes\n" +
            "28435|28434|División de cosas comunes. Arts. 676 a 678\n" +
            "28436|28435|20151015050323630\n" +
            "28437|28436|20151015050323630\n" +
            "28438|4005|Parte Especial - Libro Cuarto - Procesos Especiales Título VII - Desalojo\n" +
            "28439|28438|Desalojo. Arts. 679 a 688\n" +
            "28440|28439|20151015050325631\n" +
            "28441|28440|20151015050325631\n" +
            "28442|4005|Parte Especial - Libro Quinto - Procesos Universales Título único - Proceso sucesorio\n" +
            "28443|28442|Disposiciones generales. Arts. 689 a 698\n" +
            "28444|28443|20151015050250591\n" +
            "28445|28444|20151015050250591\n" +
            "28446|28442|Sucesiones ab intestato. Arts. 699 a 703\n" +
            "28447|28446|20151015050344632\n" +
            "28448|28447|20151015050344632\n" +
            "28449|28442|Sección primera. Protocolización de testamento. Arts. 704 a 706\n" +
            "28450|28449|20151015050345633\n" +
            "28451|28450|20151015050345633\n" +
            "28452|28442|Sección segunda. Disposiciones especiales. Arts. 707 a 708\n" +
            "28453|28452|20151015050346634\n" +
            "28454|28453|20151015050346634\n" +
            "28455|28442|Administración. Arts. 709 a 715\n" +
            "28456|28455|20151015050347635\n" +
            "28457|28456|20151015050347635\n" +
            "28458|28442|Inventario y avalúo. Arts. 716 a 725\n" +
            "28459|28458|20151015050347636\n" +
            "28460|28459|20151015050347636\n" +
            "28461|28442|Partición y adjudicación. Arts. 726 a 732\n" +
            "28462|28461|20151015050347637\n" +
            "28463|28462|20151015050347637\n" +
            "28464|28442|Herencia vacante. Arts. 733 a 735\n" +
            "28465|28464|20151015050348638\n" +
            "28466|28465|20151015050348638\n" +
            "28467|4005|Parte Especial - Libro Sexto. Proceso Arbitral Título I - Juicio arbitral\n" +
            "28468|28467|Juicio arbitral. Arts. 736 a 765\n" +
            "28469|28468|20151015050350639\n" +
            "28470|28469|20151015050350639\n" +
            "28471|4005|Parte Especial - Libro Sexto. Proceso Arbitral Título II - Juicio de amigables componedores\n" +
            "28472|28471|Juicio de amigables componedores. Arts. 766 a 772\n" +
            "28473|28472|20151015050351640\n" +
            "28474|28473|20151015050351640\n" +
            "28475|4005|Parte Especial - Libro Sexto. Proceso Arbitral Título III - Pericia arbitral\n" +
            "28476|28475|Pericia arbitral. Art. 773\n" +
            "28477|28476|20151015050351641\n" +
            "28478|28477|20151015050351641\n" +
            "28479|4005|Parte Especial - Libro Séptimo. Procesos Voluntarios Capítulo I - Autorización para contraer matrimonio\n" +
            "28480|28479|Autorización para contraer matrimonio. Arts. 774 a 775\n" +
            "28481|28480|20151015050352642\n" +
            "28482|28481|20151015050352642\n" +
            "28483|4005|Parte Especial - Libro Séptimo. Procesos Voluntarios Capítulo II - Tutela. Curatela\n" +
            "28484|28483|Tutela. Curatela. Arts. 776 a 777\n" +
            "28485|28484|20151015050354643\n" +
            "28486|28485|20151015050354643\n" +
            "28487|4005|Parte Especial - Libro Séptimo. Procesos Voluntarios Capítulo III - Copia y renovación de títulos\n" +
            "28488|28487|Copia y renovación de títulos. Arts. 778 a 779\n" +
            "28489|28488|20151015050355644\n" +
            "28490|28489|20151015050355644\n" +
            "28491|4005|Parte Especial - Libro Séptimo. Procesos Voluntarios Capítulo IV - Autorización para comparecer en juicio y ejercer actos jurídicos\n" +
            "28492|28491|Autorización para comparecer en juicio y ejercer actos jurídicos. Art. 780\n" +
            "28493|28492|20151015050356645\n" +
            "28494|28493|20151015050356645\n" +
            "28495|4005|Parte Especial - Libro Séptimo. Procesos Voluntarios Capítulo V - Examen de los libros por el socio\n" +
            "28496|28495|Examen de libros por el socio. Art. 781\n" +
            "28497|28496|20151015050355646\n" +
            "28498|28497|20151015050355646\n" +
            "28499|4005|Parte Especial - Libro Séptimo. Procesos Voluntarios Capítulo VI - Reconocimiento, adquisición y venta de mercaderías\n" +
            "28500|28499|Reconocimiento, adquisición y venta de mercaderías. Arts. 782 a 784\n" +
            "28501|28500|20151015050356647\n" +
            "28502|28501|20151015050356647\n" +
            "28503|4005|Normas Complementarias\n" +
            "28504|28503|Ley 27 - Organización de la Justicia Nacional\n" +
            "28505|28504|20100922064542170\n" +
            "28506|28505|20100922064542170\n" +
            "28507|28503|Ley 48 - Jurisdicción y Competencia de la Justicia Nacional\n" +
            "28508|28507|20100922064530545\n" +
            "28509|28508|20100922064530545\n" +
            "28510|28503|Ley 3952 - Demandas contra la Nación\n" +
            "28511|28510|20100922064605873\n" +
            "28512|28511|20100922064605873\n" +
            "28513|28503|Ley 4055 - Ley Orgánica del Poder Judicial\n" +
            "28514|28513|20100922064545873\n" +
            "28515|28514|20100922064545873\n" +
            "28516|28503|Ley 4162 - Integración de la Corte Suprema de Justicia de la Nación\n" +
            "28517|28516|20100922064541608\n" +
            "28518|28517|20100922064541608\n" +
            "28519|28503|Ley 9667 - Depósitos Judiciales\n" +
            "28520|28519|20100922064540967\n" +
            "28521|28520|20100922064540967\n" +
            "28522|28503|Ley 10996 - Ejercicio Profesional de los Procuradores\n" +
            "28523|28522|20100922064615732\n" +
            "28524|28523|20100922064615732\n" +
            "28525|28503|Ley 11672 - Honorarios de Peritos\n" +
            "28526|28525|20100922064550889\n" +
            "28527|28526|20100922064550889\n" +
            "28528|28503|Ley 16986 - Procedimiento Judicial de Amparo\n" +
            "28529|28528|20100922064603123\n" +
            "28530|28529|20100922064603123\n" +
            "28531|28503|Ley 17801 - Registro de la Propiedad Inmueble\n" +
            "28532|28531|20100922064633357\n" +
            "28533|28532|20100922064633357\n" +
            "28534|28503|Ley 18345 - Procedimiento Laboral. Organización de la Justicia del Trabajo\n" +
            "28535|28534|20100922064344515\n" +
            "28536|28535|20100922064344515\n" +
            "28537|28503|Ley 20243 - Ejercicio Profesional de los Calígrafos Públicos\n" +
            "28538|28537|20100922063541631\n" +
            "28539|28538|20100922063541631\n" +
            "28540|28503|Ley 20266 - Ejercicio Profesional de los Corredores y Martilleros\n" +
            "28541|28540|20100922064007674\n" +
            "28542|28541|20100922064007674\n" +
            "28543|28503|Ley 20305 - Ejercicio Profesional de los Traductores Públicos\n" +
            "28544|28543|20100922064821512\n" +
            "28545|28544|20100922064821512\n" +
            "28546|28503|Ley 21342 - Locación de Inmuebles Urbanos\n" +
            "28547|28546|20100922064415921\n" +
            "28548|28547|20100922064415921\n" +
            "28549|28503|Ley 21499 - Régimen de Expropiación\n" +
            "28550|28549|20100922064144814\n" +
            "28551|28550|20100922064144814\n" +
            "28552|28503|Ley 21626 - Tribunal de Tasaciones de la Nación\n" +
            "28553|28552|20100922064831715\n" +
            "28554|28553|20100922064831715\n" +
            "28555|28503|Ley 21628 - Creación de la Cámara Nacional de Apelaciones en lo Civil y Comercial Federal\n" +
            "28556|28555|20100922064530483\n" +
            "28557|28556|20100922064530483\n" +
            "28558|28503|Ley 22172 - Convenio entre el Poder Ejecutivo Nacional y el Poder Ejecutivo de la Provincia de Santa Fe, sobre Comunicaciones entre Tribunales de Distinta Jurisdicción Territorial\n" +
            "28559|28558|20100922063846019\n" +
            "28560|28559|20100922063846019\n" +
            "28561|28503|Ley 22231 - Denegatoria Registral de Inscripciones o Anotaciones\n" +
            "28562|28561|20100922064630091\n" +
            "28563|28562|20100922064630091\n" +
            "28564|28503|Ley 22427 - Inscripción Registral de Derechos Reales\n" +
            "28565|28564|20100922064630107\n" +
            "28566|28565|20100922064630107\n" +
            "28567|28503|Ley 22550 - Utilización de Poderes en el Extranjero\n" +
            "28568|28567|20100922063939768\n" +
            "28569|28568|20100922063939768\n" +
            "28570|28503|Ley 23187 - Ejercicio Profesional de la Abogacía\n" +
            "28571|28570|20100922063406038\n" +
            "28572|28571|20100922063406038\n" +
            "28573|28503|Ley 23458 - Supresión de Exigencia de Legalización de Documentos Públicos\n" +
            "28574|28573|20100922063956674\n" +
            "28575|28574|20100922063956674\n" +
            "28576|28503|Ley 23480 - Obtención de Pruebas en el Extranjero\n" +
            "28577|28576|20100922063938190\n" +
            "28578|28577|20100922063938190\n" +
            "28579|28503|Ley 23481 - Recepción de Pruebas en el Extranjero\n" +
            "28580|28579|20100922063949190\n" +
            "28581|28580|20100922063949190\n" +
            "28582|28503|Ley 23502 - Convención Internacional sobre Procedimiento Civil\n" +
            "28583|28582|20100922063940284\n" +
            "28584|28583|20100922063940284\n" +
            "28585|28503|Ley 23503 - Convenio Internacional sobre Exhortos y Cartas Rogatorias\n" +
            "28586|28585|20100922063923815\n" +
            "28587|28586|20100922063923815\n" +
            "28588|28503|Ley 23506 - Convención Interamericana sobre Prueba e Información acerca del Derecho Extranjero\n" +
            "28589|28588|20100922063908456\n" +
            "28590|28589|20100922063908456\n" +
            "28591|28503|Ley 23619 - Convención sobre Reconocimiento y Ejecución de Sentencias Arbitrales Extranjeras\n" +
            "28592|28591|20100922063908988\n" +
            "28593|28592|20100922063908988\n" +
            "28594|28503|Ley 23637 - Unificación de la Justicia Nacional en lo Civil de la Capital Federal y la Justicia Nacional Especial en lo Civil y Comercial de la Capital Federal\n" +
            "28595|28594|20100922064543936\n" +
            "28596|28595|20100922064543936\n" +
            "28597|28503|Ley 23898 - Tasas Judiciales\n" +
            "28598|28597|20100922064816262\n" +
            "28599|28598|20100922064816262\n" +
            "28600|28503|Ley 24037 - Convención Interamericana sobre Recepción de Prueba en el Extranjero\n" +
            "28601|28600|20100922063948518\n" +
            "28602|28601|20100922063948518\n" +
            "28603|28503|Ley 24283 - Indexación de Valores, Bienes o Prestaciones\n" +
            "28604|28603|20100922064032096\n" +
            "28605|28604|20100922064032096\n" +
            "28606|28503|Ley 24321 - Declaración de Ausencia por Desaparición Forzada de Personas\n" +
            "28607|28606|20100922064029877\n" +
            "28608|28607|20100922064029877\n" +
            "28609|28503|Ley 24432 - Honorarios Profesionales en Procesos Arbitrales\n" +
            "28610|28609|20100922064207532\n" +
            "28611|28610|20100922064207532\n" +
            "28612|28503|Ley 24488 - Inmudidad Jurisdiccional de Estados Extranjeros\n" +
            "28613|28612|20100922064541561\n" +
            "28614|28613|20100922064541561\n" +
            "28615|28503|Ley 24578 - Protocolo de Cooperación y Asistencia Jurisdiccional en Materia Civil, Comercial, Laboral y Administrativa del MERCOSUR\n" +
            "28616|28615|20100922063936097\n" +
            "28617|28616|20100922063936097\n" +
            "28618|28503|Ley 24579 - Protocolo de Medidas Cautelares del MERCOSUR\n" +
            "28619|28618|20100922063932503\n" +
            "28620|28619|20100922063932503\n" +
            "28621|28503|Ley 24669 - Protocolo sobre Jurisdicción Internacional en Materia Contractual\n" +
            "28622|28621|20100922063902581\n" +
            "28623|28622|20100922063902581\n" +
            "28624|28503|Ley 24871 - Inaplicabilidad de Legislación Extranjera que Restrinja el Libre Ejercicio del Comercio y la Circulación de Capitales\n" +
            "28625|28624|20100922064413343\n" +
            "28626|28625|20100922064413343\n" +
            "28627|28503|Ley 24937 - Organización e Integración del Consejo de la Magistratura\n" +
            "28628|28627|20100922064533389\n" +
            "28629|28628|20100922064533389\n" +
            "28630|28503|Ley 24946 - Organización e Integración del Ministerio Público\n" +
            "28631|28630|20100922064546404\n" +
            "28632|28631|20100922064546404\n" +
            "28633|28503|Ley 25097 - Convenio sobre la Comunicación y Notificación en el Extranjero de Documentos Judiciales y Extrajudiciales en Materia Civil y Comercial\n" +
            "28634|28633|20100922063922081\n" +
            "28635|28634|20100922063922081\n" +
            "28636|28503|Ley 25222 - Acuerdo Complementario al Protocolo de Cooperación y Asistencia Jurisdiccional en Materia Civil, Comercial, Laboral y Administrativa del MERCOSUR\n" +
            "28637|28636|20100922063940925\n" +
            "28638|28637|20100922063940925\n" +
            "28639|28503|Ley 25223 - Acuerdo sobre Arbitraje Comercial Internacional del MERCOSUR\n" +
            "28640|28639|20100922063852722\n" +
            "28641|28640|20100922063852722\n" +
            "28642|28503|Ley 25326 - Ley de Hábeas Data y Protección de Datos Personales\n" +
            "28643|28642|20100922064203829\n" +
            "28644|28643|20100922064203829\n" +
            "28645|28503|Ley 25344 - Declaración de Emergencia Económico-Financiera del Estado Nacional\n" +
            "28646|28645|20100922064058783\n" +
            "28647|28646|20100922064058783\n" +
            "28648|28503|Ley 25563 - Declaración de Emergencia Productiva y Crediticia\n" +
            "28649|28648|20100922064104439\n" +
            "28650|28649|20100922064104439\n" +
            "28651|28503|Ley 25587 - Efectos de las Medidas Cautelares contra el Estado\n" +
            "28652|28651|20100922064137954\n" +
            "28653|28652|20100922064137954\n" +
            "28654|28503|Ley 25737 - Suspensión de Ejecuciones Hipotecarias de Vivienda Única Familiar\n" +
            "28655|28654|20100922064607967\n" +
            "28656|28655|20100922064607967\n" +
            "28657|28503|Ley 25819 - Inscripción Registral de Menores de hasta Diez Años\n" +
            "28658|28657|20100922064638435\n" +
            "28659|28658|20100922064638435\n" +
            "28660|28503|Ley 26061 - Protección Integral de Menores\n" +
            "28661|28660|20100922064441140\n" +
            "28662|28661|20100922064441140\n" +
            "28663|28503|Ley 26413 - Funcionamiento del Registro del Estado Civil y Capacidad de las Personas\n" +
            "28664|28663|20100922064640810\n" +
            "28665|28664|20100922064640810\n" +
            "28666|28503|Ley 26589 - Mediación Prejudicial Obligatoria\n" +
            "28667|28666|20100922081634163\n" +
            "28668|28667|20100922081634163\n" +
            "28669|28503|Ley 26657 - Proección de la Salud Mental\n" +
            "28670|28669|20101220052929170\n" +
            "28671|28670|20101220052929170\n" +
            "28672|28503|Ley 26674 - Día del Trabajador Judicial Argentino\n" +
            "28673|28672|20110518083526516\n" +
            "28674|28673|20110518083526516\n" +
            "28675|28503|Ley 26685 - Autorización de Expedientes Digitales\n" +
            "28676|28675|20110707085201795\n" +
            "28677|28676|20110707085201795\n" +
            "28678|28503|Ley 26764 - Ley de Depósitos Judiciales de los Tribunales Nacionales y Federales\n" +
            "28681|28503|Ley 26853 - Creación de las Cámaras Federales de Casación\n" +
            "28682|28681|20130517091944709\n" +
            "28683|28682|20130517091944709\n" +
            "28684|28503|Ley 26854 - Medidas Cautelares en las Causas en las que es Parte o Interviene el Estado Nacional\n" +
            "28687|28503|Ley 26856 - Publicación de Acordadas y Resoluciones Judiciales\n" +
            "28688|28687|20130523094340270\n" +
            "28689|28688|20130523094340270\n" +
            "28690|28503|Ley 26861 - Ingreso Democrático e Igualitario al Poder Judicial\n" +
            "28691|28690|20130603100249869\n" +
            "28692|28691|20130603100249869\n" +
            "28693|28503|Ley 26939 - Digesto Jurídico Argentino\n" +
            "28694|28693|20140616093736982\n" +
            "28695|28694|20140616093736982\n" +
            "28696|28503|Ley 26993 - Sistema de Resolución de Conflictos en las Relaciones de Consumo\n" +
            "28697|28696|20140919074942610\n" +
            "28698|28697|20140919074942610\n" +
            "28699|28503|Ley 27148 - Ley Orgánica del Ministerio Público Fiscal\n" +
            "28700|28699|20150618082206128\n" +
            "28701|28700|20150618082206128\n" +
            "28702|28503|Ley 27149 - Ley Orgánica del Ministerio Público de la Defensa\n" +
            "28703|28702|20150618082417875\n" +
            "28704|28703|20150618082417875\n" +
            "28705|28503|Ley 27423 - Ley de Honorarios Profesionales de Abogados, Procuradores y Auxiliares de la Justicia Nacional y Federal\n" +
            "28706|28705|20171222074828016\n" +
            "28707|28706|20171222074828016\n" +
            "28708|28503|Ley 27439 - Régimen de Subrogancias para los Juzgados y Tribunales del Poder Judicial de la Nación\n" +
            "28709|28708|20180606074255731\n" +
            "28710|28709|20180606074255731\n" +
            "28711|28503|Ley 27449 - Ley de Arbitraje Comercial Internacional\n" +
            "28712|28711|20180726063351752\n" +
            "28713|28712|20180726063351752\n" +
            "28714|28503|Ley 27541 - Ley de Solidaridad Social y Reactivación Productiva en el Marco de la Emergencia Pública\n" +
            "28715|28714|20191224061705047\n" +
            "28716|28715|20191224061705047\n" +
            "28717|28503|Decreto Ley 3003/1956 - Registro de Juicios Universales\n" +
            "28718|28717|20100922064648794\n" +
            "28719|28718|20100922064648794\n" +
            "28720|28503|Decreto Ley 7771/1956 - Tratado de Montevideo de 1940\n" +
            "28721|28720|20100922064001893\n" +
            "28722|28721|20100922064001893\n" +
            "28723|28503|Decreto Ley 14983/1957 - Autenticidad de los Actos de Gobierno\n" +
            "28724|28723|20100922063406663\n" +
            "28725|28724|20100922063406663\n" +
            "28726|28503|Decreto Ley 16005/1957 - Publicación de Edictos Judiciales\n" +
            "28727|28726|20100922064605888\n" +
            "28728|28727|20100922064605888\n" +
            "28729|28503|Decreto Ley 1285/1958 - Organización del Poder Judicial\n" +
            "28730|28729|20100922064549107\n" +
            "28731|28730|20100922064549107\n" +
            "28732|28503|Decreto Ley 6582/1958 - Registro de la Propiedad Automotor\n" +
            "28733|28732|20100922064627404\n" +
            "28734|28733|20100922064627404\n" +
            "28735|28503|Decreto Ley 6848/1963 - Archivo de Actuaciones Judiciales\n" +
            "28736|28735|20100922064605857\n" +
            "28737|28736|20100922064605857\n" +
            "28738|28503|Decreto 6754/1943 - Inembargabilidad de Sueldos, Jubilaciones y Pensiones\n" +
            "28739|28738|20100922064054455\n" +
            "28740|28739|20100922064054455\n" +
            "28741|28503|Decreto 21653/1945 - Honorarios de los Juicios en los que la Nación sea Parte\n" +
            "28742|28741|20100922064207485\n" +
            "28743|28742|20100922064207485\n" +
            "28744|28503|Decreto 2080/1980 - Reglamentación del Registro de la Propiedad Inmueble\n" +
            "28745|28744|20100922064634451\n" +
            "28746|28745|20100922064634451\n" +
            "28747|28503|Decreto 484/1987 - Límite de Embargabilidad de Remuneraciones\n" +
            "28748|28747|20100922064651653\n" +
            "28749|28748|20100922064651653\n" +
            "28750|28503|Decreto 1813/1992 - Pautas Especiales de Regulación de Honorarios de Peritos\n" +
            "28751|28750|20100922064552092\n" +
            "28752|28751|20100922064552092\n" +
            "28753|28503|Decreto 2293/1992 - Ejercico de Actividades Profesionales\n" +
            "28754|28753|20100922064616623\n" +
            "28755|28754|20100922064616623\n" +
            "28756|28503|Decreto 202/1997 - Represantación Judicial de la Administración Pública\n" +
            "28757|28756|20100922063408945\n" +
            "28758|28757|20100922063408945\n");
    private static String menu2 =new String("28759|28503|Decreto 240/1999 - Desregulación de Honorarios Profesionales\n" +
            "28760|28759|20100922064207548\n" +
            "28761|28760|20100922064207548\n" +
            "28762|28503|Decreto 1116/2000 - Reglamentación de la Emergencia Económica\n" +
            "28763|28762|20100922064059392\n" +
            "28764|28763|20100922064059392\n" +
            "28765|28503|Decreto 1204/2001 - Registro de Abogados del Estado\n" +
            "28766|28765|20100922063408382\n" +
            "28767|28766|20100922063408382\n" +
            "28768|28503|Decreto 1558/2001 - Reglamentación de la Ley de Hábeas Data y Protección de Datos Personales\n" +
            "28769|28768|20100922064158923\n" +
            "28770|28769|20100922064158923\n" +
            "28771|28503|Decreto 214/2002 - Pesificación de Obligaciones en Moneda Extranjera\n" +
            "28772|28503|Decreto 348/2002 - Comunicaciones en los Juicios contra la Administración Pública\n" +
            "28773|28772|20100922064137986\n" +
            "28774|28773|20100922064137986\n" +
            "28775|28503|Decreto 1316/2002 - Suspensión de Medidas Cautelares y Sentencias definitivas contra el Estado\n" +
            "28776|28775|20100922064608498\n" +
            "28777|28776|20100922064608498\n" +
            "28778|28503|Decreto 2415/2002 - Ejecuciones Judiciales o Extrajudiciales Promovidas por Acreedores que no sean Entidades Financieras, contra Personas Físicas por Deudas cuya Causa no sea la Ejecución de Títulos de Crédito\n" +
            "28779|28778|20100922064607982\n" +
            "28780|28779|20100922064607982\n" +
            "28781|28503|Decreto 2589/2002 - Reclamos Administrativos en Causas Judiciales Derivados de Contratos de Obras o Servicios Públicos\n" +
            "28782|28781|20100922064529389\n" +
            "28783|28782|20100922064529389\n" +
            "28784|28503|Decreto 204/2003 - Unidades de Emergencias Legales\n" +
            "28785|28784|20100922064049361\n" +
            "28786|28785|20100922064049361\n" +
            "28787|28503|Decreto 247/2003 - Registro de Ejecuciones Hipotecarias de Vivienda Única\n" +
            "28788|28787|20100922064607451\n" +
            "28789|28788|20100922064607451\n" +
            "28790|28503|Decreto 1467/2011 - Reglamentación de la Ley de Mediación Prejudicial Obligatoria\n" +
            "28791|28790|20110928085718558\n" +
            "28792|28791|20110928085718558\n" +
            "28793|28503|Decreto 202/2015 - Régimen Disciplinario para Conciliadores en las Relaciones de Consumo\n" +
            "28794|28793|20150212080528264\n" +
            "28795|28794|20150212080528264\n" +
            "28796|28503|Decreto 2536/2015 - Unidad de Honorarios de Mediación Prejudicial Obligatoria\n" +
            "28797|28796|20151130080116278\n" +
            "28798|28797|20151130080116278\n" +
            "28799|28503|Decreto 34/2019 - Doble Indemnización por Despido sin Causa\n" +
            "28800|28799|20191216082750793\n" +
            "28801|28800|20191216082750793\n" +
            "28802|28503|Decreto 62/2019 - Régimen Procesal de la Acción Civil de Extinción de Dominio\n" +
            "28803|28802|20190122061237505\n" +
            "28804|28803|20190122061237505\n" +
            "28805|28503|Decreto 99/2019 - Reglamentación de la Ley de Solidaridad Social y Reactivación Productiva\n" +
            "28806|28805|20191230075136259\n" +
            "28807|28806|20191230075136259\n" +
            "28808|28503|Decreto 172/2019 - Sistema de Gestión Documental Electrónica - GDE. Legalización de Documentación. Implementación de la Apostilla Electrónica\n" +
            "28809|28808|20190308075311356\n" +
            "28810|28809|20190308075311356\n" +
            "28811|28503|Resolución (MJyDH) 465/1999 - Registro de Mediadores\n" +
            "28812|28811|20100922064425733\n" +
            "28813|28812|20100922064425733\n" +
            "28814|28503|Resolución (MJyDH) 890/2000 - Reglamento de Actuación Disciplinaria para Mediadores y Conciliadores\n" +
            "28815|28814|20100922064422468\n" +
            "28816|28815|20100922064422468\n" +
            "28817|28503|Resolución (MJyDH) 1196/2012 - Matrículas y Aranceles de Mediación\n" +
            "28818|28817|20120626091748875\n" +
            "28819|28818|20120626091748875\n" +
            "28820|28503|Resolución (MJyDH) 2740/2012 - Reglamento del Registro de Mediadores\n" +
            "28821|28820|20121206094841087\n" +
            "28822|28821|20121206094841087\n" +
            "28823|28503|Resolución (MJyDH) 1196/2013 - Sistema MEPRE para Mediadores\n" +
            "28824|28823|20130801083729731\n" +
            "28825|28824|20130801083729731\n" +
            "28826|28503|Resolución (MJyDH) 2689/2013 - Multa por Conclusión de la Mediación ante Incmparecencia Injustificada de una Parte\n" +
            "28827|28826|20140116095746979\n" +
            "28828|28827|20140116095746979\n" +
            "28829|28503|Resolución (MJyDH) 829-E/2017 - Bases para la Reforma Procesal Civil y Comercial\n" +
            "28830|28829|20171101074647912\n" +
            "28831|28830|20171101074647912\n" +
            "28832|28503|Resolución (MJyDH) 542/2018 - Aplicación de la Unidad de Honorarios de Mediación (UHOM) para la Fijación de Montos de Matrículas, Aranceles y Gastos Relacionados con el Procedimiento de Mediación\n" +
            "28833|28832|20180718075201116\n" +
            "28834|28833|20180718075201116\n" +
            "28835|28503|Resolución (MJyDH) 1283/2019 - Protocolo de Actuación de la Dirección de Asistencia a Personas bajo Vigilancia Electrónica ante Casos de Violencia en el Ámbito Doméstico\n" +
            "28836|28835|20191127080521008\n" +
            "28837|28836|20191127080521008\n" +
            "28838|28503|Resolución (MP) 56/2003 - Unidad de Emergencias Legales para Ejecuciones\n" +
            "28839|28838|20100922064606935\n" +
            "28840|28839|20100922064606935\n" +
            "28841|28503|Resolución (MTEySS) 84/2003 - Unidad de Emergencias Legales para Ejecuciones\n" +
            "28842|28841|20100922064050377\n" +
            "28843|28842|20100922064050377\n" +
            "28844|28503|Resolución (SC) 48/2015 - Criterios para la Admisión de Reclamos del COPREC\n" +
            "28845|28844|20150330081001678\n" +
            "28846|28845|20150330081001678\n" +
            "28847|28503|Resolución (SC) 50/2015 - Servicio de Patrocinio Jurídico Gratuito para el COPREC\n" +
            "28848|28847|20150407075817461\n" +
            "28849|28848|20150407075817461\n" +
            "28850|28503|Resolución (SC) 90/2016 - Requisitos para la Autorización de Asciaciones de Consumidores Constituidas como Asociaciones Civiles, Cooperativas o Fundaciones\n" +
            "28851|28850|20160510080305652\n" +
            "28852|28851|20160510080305652\n" +
            "28853|28503|Resolución (SC) 65/2018 - Reglamentación del Funcionamiento del Sistema Nacional de Arbitraje de Consumo\n" +
            "28854|28853|20181008074959711\n" +
            "28855|28854|20181008074959711\n" +
            "28856|28503|Resolución (SC) 394/2018 - Creación de la Figura del Defensor del Cliente\n" +
            "28857|28856|20180706080057276\n" +
            "28858|28857|20180706080057276\n" +
            "28859|28503|Resolución (SC) 157-E/2017 - Modificación del Procedimiento de Ejecución de Multas por Incomparecencias Injustificadas a las Audiencias del Servicio de Conciliación Previa en las Relaciones de Consumo (COPREC)\n" +
            "28860|28859|20170309073608061\n" +
            "28861|28860|20170309073608061\n" +
            "28862|28503|Resolución (SICyM) 212/1998 - Arbitraje del Consumo\n" +
            "28863|28862|20100922064012659\n" +
            "28864|28863|20100922064012659\n" +
            "28865|28503|Resolución (ST) 67/2003 - Composición de las Unidades de Emergencia Legales\n" +
            "28866|28865|20100922064048736\n" +
            "28867|28866|20100922064048736\n" +
            "28868|28503|Resolución (DGN) 936/1998 - Reglamento de Organización e Integración del Ministerio Público\n" +
            "28869|28868|20100922064546951\n" +
            "28870|28869|20100922064546951\n" +
            "28871|28503|Resolución (CSJN) 23/1992 - Prueba Hematológica\n" +
            "28872|28871|20100922064611201\n" +
            "28873|28872|20100922064611201\n" +
            "28874|28503|Resolución (CSJN) 213/1995 - Estampillas Judiciales\n" +
            "28875|28874|20100922064604217\n" +
            "28876|28875|20100922064604217\n" +
            "28877|28503|Resolución (CSJN) 1507/1995 - Bonos de Consolidación para el Pago de Tasa de Justicia\n" +
            "28878|28877|20100922064612482\n" +
            "28879|28878|20100922064612482\n" +
            "28880|28503|Resolución (CSJN) 367/1998 - Solicitud de Feriados Judiciales\n" +
            "28881|28880|20100922064541576\n" +
            "28882|28881|20100922064541576\n" +
            "28883|28503|Resolución (CSJN) 1449/1999 - Autorización del Laminado de Seguridad de Documentos del Registro de la Propiedad Inmueble\n" +
            "28884|28883|20100922064631169\n" +
            "28885|28884|20100922064631169\n" +
            "28886|28503|Resolución (CSJN) 255/2000 - Impementación del Laminado de Seguridad de Documentos del Registro de la Propiedad Inmueble\n" +
            "28887|28886|20100922064630123\n" +
            "28888|28887|20100922064630123\n" +
            "28889|28503|Resolución (CSJN) 1687/2012 - Sistema Electrónico de Consulta y Publicación de Edictos\n" +
            "28890|28889|http://ius.errepar.com/sitios/ver/html/20120628085436988.html?k=Resoluci%C3%B3n%20(CSJN)%201687/2012\n" +
            "28891|28890|20120628085436988\n" +
            "28892|28503|Resolución (CSJN) 2028/2015 - Registración en el Sistema de Domicilio Electrónico\n" +
            "28893|28892|20150717080607627\n" +
            "28894|28893|20150717080607627\n" +
            "28895|28503|Acordada (CSJN) S/N/1952 - Reglamento para la Justicia Nacional\n" +
            "28896|28895|20100922064552654\n" +
            "28897|28896|20100922064552654\n" +
            "28898|28503|Acordada (CSJN) S/N/1954 - Cheques Judiciales\n" +
            "28899|28898|20100922063549428\n" +
            "28900|28899|20100922063549428\n" +
            "28901|28503|Acordada (CSJN) S/N/1958 - Edictos Judiciales\n" +
            "28902|28901|20100922064041439\n" +
            "28903|28902|20100922064041439\n" +
            "28904|28503|Acordada (CSJN) S/N/1959 - Reserva de Documentación\n" +
            "28905|28904|20100922064032158\n" +
            "28906|28905|20100922064032158\n" +
            "28907|28503|Acordada (CSJN) S/N/1962 - Declaraciones de Asueto\n" +
            "28908|28907|20100922064529936\n" +
            "28909|28908|20100922064529936\n" +
            "28910|28503|Acordada (CSJN) 35/1967 - Destino de Multas Judiciales\n" +
            "28911|28910|20100922064548029\n" +
            "28912|28911|20100922064548029\n" +
            "28913|28503|Acordada (CSJN) S/N/1968 - Comunicación de Sanciones Disciplinarias a los Magistrados, Funcionarios Titulares de los Ministerios Públicos y Secretarios\n" +
            "28914|28913|20100922064712372\n" +
            "28915|28914|20100922064712372\n" +
            "28916|28503|Acordada (CSJN) 51/1973 - Competencia Originaria de la Corte Suprema de Justicia de la Nación\n" +
            "28917|28916|20100922064537764\n" +
            "28918|28917|20100922064537764\n" +
            "28919|28503|Acordada (CSJN) 87/1973 - Remisión de Actuaciones Judiciales\n" +
            "28920|28919|20100922064612420\n" +
            "28921|28920|20100922064612420\n" +
            "28922|28503|Acordada (CSJN) 4/1974 - Horario de los Tribunales Nacionales con Sede en la Capital Federal\n" +
            "28923|28922|20100922064557451\n" +
            "28924|28923|20100922064557451\n" +
            "28925|28503|Acordada (CSJN) 13/1974 - Copias de Escritos Judiciales\n" +
            "28926|28925|20100922064609013\n" +
            "28927|28926|20100922064609013\n" +
            "28928|28503|Acordada (CSJN) 41/1974 - Texto de Edictos Judiciales\n" +
            "28929|28928|20100922064612466\n" +
            "28930|28929|20100922064612466\n" +
            "28931|28503|Acordada (CSJN) 1/1975 - Regulación de Honorarios en Juicios ante la Corte Suprema de Justicia de la Nación\n" +
            "28932|28931|20100922064207517\n" +
            "28933|28932|20100922064207517\n" +
            "28934|28503|Acordada (CSJN) 25/1976 - Horario de los Tribunales de la Capital Federal\n" +
            "28935|28934|20100922064557467\n" +
            "28936|28935|20100922064557467\n" +
            "28937|28503|Acordada (CSJN) 49/1983 - Integración del Depósito del Recurso de Queja\n" +
            "28938|28937|20100922064626373\n" +
            "28939|28938|20100922064626373\n" +
            "28940|28503|Acordada (CSJN) 25/1985 - Especialidades del Registro de Profesionales para Actuar como Peritos\n" +
            "28941|28940|20100922064610576\n" +
            "28942|28941|20100922064610576\n" +
            "28943|28503|Acordada (CSJN) 63/1985 - Revocación de la Suspensión Provisional en la Matrícula de Abogados de la Capital Federal por Mediar Prisión Preventiva\n" +
            "28944|28943|20100922063406070\n" +
            "28945|28944|20100922063406070\n" +
            "28946|28503|Acordada (CSJN) 54/1986 - Depósito del Recurso de Queja\n" +
            "28947|28946|20100922064626357\n" +
            "28948|28947|20100922064626357\n" +
            "28949|28503|Acordada (CSJN) 13/1987 - Formulario para la Cédula de Notificación\n" +
            "28950|28949|20100922064605295\n" +
            "28951|28950|20100922064605295\n" +
            "28952|28503|Acordada (CSJN) 37/1987 - Registro de Abogados Matriculados\n" +
            "28953|28952|20100922063406132\n" +
            "28954|28953|20100922063406132\n" +
            "28955|28503|Acordada (CSJN) 7/1988 - Desglose de Documentación de Expedientes\n" +
            "28956|28955|20100922064609545\n" +
            "28957|28956|20100922064609545\n" +
            "28958|28503|Acordada (CSJN) 51/1989 - Firma de Escritos y Copias Judiciales\n" +
            "28959|28958|20100922064609029\n" +
            "28960|28959|20100922064609029\n" +
            "28961|28503|Acordada (CSJN) 66/1990 - Suspensión del Pago de la Tasa de Justicia en Juicios contra el Estado\n" +
            "28962|28961|20100922064815199\n" +
            "28963|28962|20100922064815199\n" +
            "28964|28503|Acordada (CSJN) 36/1991 - Plazos del Dictado de Sentencias Judiciales\n" +
            "28965|28964|20100922064612451\n" +
            "28966|28965|20100922064612451\n" +
            "28967|28503|Acordada (CSJN) 47/1991 - Diferimiento de Pago de Tasas Judiciales para el Estado Nacional y Entes Autárquicos\n" +
            "28968|28967|20100922064815184\n" +
            "28969|28968|20100922064815184\n" +
            "28970|28503|Acordada (CSJN) 19/1992 - Certificado de Deuda de Tasas de Justicia\n" +
            "28971|28970|20100922064813809\n" +
            "28972|28971|20100922064813809\n" +
            "28973|28503|Acordada (CSJN) 20/1992 - Monto Imponible de la Tasa de Justicia\n" +
            "28974|28973|20100922064813793\n" +
            "28975|28974|20100922064813793\n" +
            "28976|28503|Acordada (CSJN) 83/1993 - Procedimiento de Pago de la Tasa de Justicia\n" +
            "28977|28976|20100922064815731\n" +
            "28978|28977|20100922064815731\n" +
            "28979|28503|Acordada (CSJN) 29/1995 - Aranceles de Solicitudes Judiciales\n" +
            "28980|28979|20100922064529905\n" +
            "28981|28980|20100922064529905\n" +
            "28982|28503|Acordada (CSJN) 50/1995 - Excepción del Arancelamiento Judicial\n" +
            "28983|28982|20100922064529920\n" +
            "28984|28983|20100922064529920\n" +
            "28985|28503|Acordada (CSJN) 22/1996 - Formulario para la Cédula de Notificación para Mediación\n" +
            "28986|28985|20100922064421890\n" +
            "28987|28986|20100922064421890\n" +
            "28988|28503|Acordada (CSJN) 26/1996 - Arancel de la Cédula de Notificación de Mediación\n" +
            "28989|28988|20100922064422984\n" +
            "28990|28989|20100922064422984\n" +
            "28991|28503|Acordada (CSJN) 27/1996 - Depósitos Judiciales en Concursos y Quiebras\n" +
            "28992|28991|20100922064540936\n" +
            "28993|28992|20100922064540936\n" +
            "28994|28503|Acordada (CSJN) 54/1996 - Integración del Depósito del Recurso de Queja\n" +
            "28995|28994|20100922064612373\n" +
            "28996|28995|20100922064612373\n" +
            "28997|28503|Acordada (CSJN) 73/1996 - Convenio con el Banco Ciudad para la Prestación del Servicio de Percepción de Tasa de Justicia\n" +
            "28998|28997|20100922064813262\n" +
            "28999|28998|20100922064813262\n" +
            "29000|28503|Acordada (CSJN) 11/1999 - Horario de Tribunales Durante las Ferias Judiciales\n" +
            "29001|29000|20100922064148314\n" +
            "29002|29001|20100922064148314\n" +
            "29003|28503|Acordada (CSJN) 21/1999 - Delegación de Facultades Disciplinarias de la Corte Suprema de Justicia de la Nación\n" +
            "29004|29003|20100922064009346\n" +
            "29005|29004|20100922064009346\n" +
            "29006|28503|Acordada (CSJN) 22/2000 - Pago de la Tasa de Justicia en Bonos Emitidos por el Estado Nacional\n" +
            "29007|29006|20100922064815699\n" +
            "29008|29007|20100922064815699\n" +
            "29009|28503|Acordada (CSJN) 24/2000 - Reglamento de la Oficina de Subastas Judiciales\n" +
            "29010|29009|20100922064810481\n" +
            "29011|29010|20100922064810481\n" +
            "29012|28503|Acordada (CSJN) 34/2000 - Aplicación de la Declaración de Emergencia Económico-Financiera del Estado Nacional en los Expedientes en Trámite ante la CSJN\n" +
            "29013|29012|20100922064610060\n" +
            "29014|29013|20100922064610060\n" +
            "29015|28503|Acordada (CSJN) 1/2004 - Página Web de la Corte Suprema de Justicia de la Nación\n" +
            "29016|29015|20100922064538842\n" +
            "29017|29016|20100922064538842\n" +
            "29018|28503|Acordada (CSJN) 2/2004 - Identificación de Intervinientes en Causas que Tramitan ante la CSJN\n" +
            "29019|29018|20100922064537248\n" +
            "29020|29019|20100922064537248\n" +
            "29021|28503|Acordada (CSJN) 44/2009 - Ejercicio de la Docencia de los Magistrados, Funcioarios y Empleados Judiciales\n" +
            "29022|29021|20110408094752759\n" +
            "29023|29022|20110408094752759\n" +
            "29024|28503|Acordada (CSJN) 5/2010 - Recurso de Queja por Denegación. Plazos. Ampliación\n" +
            "29025|29024|20100922083905714\n" +
            "29026|29025|20100922083905714\n" +
            "29027|28503|Acordada (CSJN) 31/2011 - Constitución de Domicilio Electrónico en Expedientes que Tramitan ante la CSJN\n" +
            "29028|29027|20111215104147675\n" +
            "29029|29028|20111215104147675\n" +
            "29030|28503|Acordada (CSJN) 38/2011 - Tamaño de Hoja para Presentaciones ante la CSJN\n" +
            "29031|29030|20120217015251699\n" +
            "29032|29031|20120217015251699\n" +
            "29033|28503|Acordada (CSJN) 8/2012 - Incorporación del Libro de Asistencia de Letrados (Libro de Notas) al Programa Informático de Seguimiento de Causas de la CSJN\n" +
            "29034|29033|20120614113951251\n" +
            "29035|29034|20120614113951251\n" +
            "29036|28503|Acordada (CSJN) 7/2013 - Nuevo Régimen de Amigos del Tribunal\n" +
            "29037|29036|20130424010246528\n" +
            "29038|29037|20130424010246528\n" +
            "29039|28503|Acordada (CSJN) 20/2013 - Reglas de Aplicación de la Videoconferencia para Causas en Tramite\n" +
            "29040|29039|20130703091408337\n" );
    private static String menu4 =new String("29041|29040|20130703091408337\n" +
            "29042|28503|Acordada (CSJN) 35/2013 - Aplicación del Sistema de Notificacines Electrónicas para Recursos y Denuncias por Retardo o Denegación de Justicia\n" +
            "29043|29042|20131002103343987\n" +
            "29044|29043|20131002103343987\n" +
            "29045|28503|Acordada (CSJN) 36/2013 - Obligatoriedad del Uso del Sistema de Notificaciones Electrónicas en Causas en que Intervenga la CSJN\n" +
            "29046|29045|20131002104019988\n" +
            "29047|29046|20131002104019988\n" +
            "29048|28503|Acordada (CSJN) 38/2013 - Extensión de la Aplicación del Sistema de Notificaciones Electrónicas\n" +
            "29049|29048|20131016091539963\n" +
            "29050|29049|20131016091539963\n" +
            "29051|28503|Acordada (CSJN) 2/2014 - Sistema Único de Administración de Peritos y Martilleros de la Justicia Nacional y Federal\n" +
            "29052|29051|20140212093535889\n" +
            "29053|29052|20140212093535889\n" +
            "29054|28503|Acordada (CSJN) 32/2014 - Registro Público de Procesos Colectivos\n" +
            "29055|29054|20141003075523267\n" +
            "29056|29055|0141003075523267\n" +
            "29057|28503|Acordada (CSJN) 3/2015 - Pautas Ordenatorias para la Utilización de los Nuevos Sistemas Informáticos\n" +
            "29058|29057|20150220103417570\n" +
            "29059|29058|20150220103417570\n" +
            "29060|28503|Acordada (CSJN) 16/2016 - Reglamento para el Ingreso de Causas por Medios Electrónicos, Sorteo y Asignación de Expedientes. Reglas para la Interposición de Demandas y Presentaciones en General\n" +
            "29061|29060|20160608081023652\n" +
            "29062|29061|20160608081023652\n" +
            "29063|28503|Acordada (CSJN) 28/2016 - Organización del Cuerpo de Peritos Tasadores de la Justicia Nacional\n" +
            "29064|29063|20160921074523209\n" +
            "29065|29064|20160921074523209\n" +
            "29066|28503|Acordada (CSJN) 4/2017 - Reemplazo del “Libro de Entrada de Causas Judiciales” por el Registro de Información en el Sistema de Gestión Judicial\n" +
            "29067|29066|20170329072543356\n" +
            "29068|29067|20170329072543356\n" +
            "29069|28503|Acordada (CSJN) 22/2017 - Protocolo de Pautas Generales ante Incidencias en la Asignación de Causas en el Sistema de Gestión Judicial\n" +
            "29070|29069|20170809073646443\n" +
            "29071|29070|20170809073646443\n" +
            "29072|28503|Acordada (CSJN) 23/2017 - Reemplazo de Todas las Notificaciones Judiciales en Papel por Notificaciones Electrónicas\n" +
            "29073|29072|20170816073706404\n" +
            "29074|29073|20170816073706404\n" +
            "29075|28503|Acordada (CSJN) 28/2017 - Suspensión de la Implementación del Reglamento para el Ingreso de Causas por Medios Electrónicos, Sorteo y Asignación de Expedientes y Reglas para la Interposición de Demandas y Presentaciones en General\n" +
            "29076|29075|20170901075613835\n" +
            "29077|29076|20170901075613835\n" +
            "29078|28503|Acordada (CSJN) 42/2017 - Reglamentación de la Ley de Acceso a la Información Pública en el Ámbito Judicial\n" +
            "29079|29078|20171228065538652\n" +
            "29080|29079|20171228065538652\n" +
            "29081|28503|Acordada (CSJN) 41/2018 - Adecuación del Monto de la Tasa de Justicia para Juicios sin Valor Pecuniario\n" +
            "29082|29081|20181211160225243\n" +
            "29083|29082|20181211160225243\n" +
            "29084|28503|Acordada (CSJN) 42/2018 - Actualización del Depósito Requerido para la Interposición de Queja por Denegatoria del Recurso Extraordinario\n" +
            "29085|29084|20181211160851141\n" +
            "29086|29085|20181211160851141\n" +
            "29087|28503|Acordada (CSJN) 43/2018 - Determinación del Monto Mínimo del Proceso para la Apelación de Sentencias Judiciales\n" +
            "29088|29087|20181211161122966\n" +
            "29089|29088|20181211161122966\n" +
            "29090|28503|Resolución (JEMN) 26/1999 - Reglamento Procesal del Jurado de Enjuiciamiento de Magistrados\n" +
            "29091|29090|20100922063841316\n" +
            "29092|29091|20100922063841316\n" +
            "29093|28503|Resolución (PTN) 2/2001 - Pautas Procesales de Demandas contra la Nación conforme la Declaración de Emergencia Económico-Financiera del Estado Nacional\n" +
            "29094|29093|20100922063408398\n" +
            "29095|29094|20100922063408398\n" +
            "29096|28503|Resolución (PTN) 40/2001 - Intervención del Procurador del Tesoro de la Nación en Juicios contra el Estado de Elevado Monto\n" +
            "29097|29096|20100922064105486\n" +
            "29098|29097|20100922064105486\n" +
            "29099|28503|Resolución (PTN) 14/2002 - Intervención del Cuerpo de Abogados del Estado en Causas Relacionadas con Normas de Emergencia Económica\n" +
            "29100|29099|20100922063408413\n" +
            "29101|29100|20100922063408413\n" +
            "29102|28503|Resolución (PTN) 86/2002 - Sistema Único Informático para la Gestión Judicial\n" +
            "29103|29102|20100922063409491\n" +
            "29104|29103|20100922063409491\n" +
            "29105|28503|Resolución (PTN) 128/2019 - Comunicación Digital de Juicios contra el Estado a la Procuración del Tesoro de la Nación\n" +
            "29106|29105|20191030071341616\n" +
            "29107|29106|20191030071341616\n" +
            "29108|28503|Disposición (RPI) 7/2002 - Pautas para la Anotación de Documentos Judiciales\n" +
            "29109|29108|20100922064630669\n" +
            "29110|29109|20100922064630669\n" +
            "29111|28503|Disposición (RPI) 9/2002 - Laminado de Seguridad\n" +
            "29112|29111|20100922064632185\n" +
            "29113|29112|20100922064632185\n" +
            "29114|28503|Disposición (RPI) 4/2010 - Intervención Obligatoria del CPACF para la Inscripción Registral de Documentos\n" +
            "29115|29114|20110106084336444\n" +
            "29116|29115|20110106084336444\n" +
            "29117|28503|Disposición (RPI) 3/2011 - Intervención Obligatoria del CPACF para la Sustitución de Facultades de Inscripción Registral de Documentos\n" +
            "29118|29117|20110428085801350\n" +
            "29119|29118|20110428085801350\n" +
            "29120|28503|Disposición (RPI) 2/2014 - Pautas Registrales para la Rúbrica de Libros de Consorcios de Copropietarios\n" +
            "29121|29120|20140425095006318\n" +
            "29122|29121|20140425095006318\n" +
            "29123|28503|Disposición (RPI) 3/2014 - Requisitos para el Requerimiento de Informes de Dominio\n" +
            "29124|29123|20140908100728201\n" +
            "29125|29124|20140908100728201\n" +
            "29126|28503|Disposición (RPI) 4/2014 - Pautas Registrales para la Afectación de Inmuebles al Sistema Turístico de Tiempo Compartido\n" +
            "29127|29126|20141112082103565\n" +
            "29128|29127|20141112082103565\n" +
            "29129|28503|Disposición (RPI) 5/2014 - Reglamento del Sistema de Publicidad en Línea (SIPEL)\n" +
            "29130|29129|20141222082510185\n" +
            "29131|29130|20141222082510185\n" +
            "29132|28503|Disposición (RPI) 1/2015 - Implementación de Inhibiciones Generales de Bienes y/o Cesiones de Acciones y Derechos Hereditarios en el SIPEL\n" +
            "29133|29132|20150629081813134\n" +
            "29134|29133|20150629081813134\n" +
            "29135|28503|Disposición (RPI) 3/2015 - Pautas de Registración del Derecho Real de Superficie\n" +
            "29136|29135|20150731084833480\n" +
            "29137|29136|20150731084833480\n" +
            "29138|28503|Disposición (RPI) 4/2015 - Afectación de Inmuebles al Régimen de Protección de la Vivienda\n" +
            "29139|29138|20150731085159639\n" +
            "29140|29139|20150731085159639\n" +
            "29141|28503|Disposición (RPI) 2/2016 - Nuevas Pautas para la Registración de Reglamentos de Propiedad\n" +
            "29142|29141|20160331084816008\n" +
            "29143|29142|20160331084816008\n" +
            "29144|28503|Disposición (RPI) 4/2016 - Requisitos para la Afectación de Inmuebles al Régimen de Protección de la Vivienda\n" +
            "29145|29144|20160331085651918\n" +
            "29146|29145|20160331085651918\n" +
            "29147|28503|Disposición (RPI) 9/2016 - Tratamiento Especial para Documentos de Transmisión de Nuda Propiedad con Reserva de Usufructo para el Titular o su Cónyuge\n" +
            "29148|29147|20160606080953509\n" +
            "29149|29148|20160606080953509\n" +
            "29150|28503|Disposición (RPI) 10/2016 - Exigencia de CUIT para la Anotación de Inhibición General de Bienes sobre una Persona Jurídica\n" +
            "29151|29150|20160606081242601\n" +
            "29152|29151|20160606081242601\n" +
            "29153|28503|Disposición (RPI) 11/2016 - Exigencia de Título de Inscripción Registral para la Autorización de Escrituras de Transmisión o Renunica del Derecho Real de Usufructo\n" +
            "29154|29153|20160606081719208\n" +
            "29155|29154|20160606081719208\n" +
            "29156|28503|Disposición (RPI) 14/2016 - Requisitos que deben Cumplir las Sociedades Simples para Ser Titulares de Bienes Registrables\n" +
            "29157|29156|20160707082535299\n" +
            "29158|29157|20160707082535299\n" +
            "29159|28503|Disposición (RPI) 18/2016 - Extensión del SIPEL a la Expedición de Certificados de Inhibiciones y Anotaciones Personales\n" +
            "29160|29159|20160915080655185\n" +
            "29161|29160|20160915080655185\n" +
            "29162|28503|Disposición (RPI) 20/2016 - Tratamiento Registral de Documentos Portantes de Derecho Real de Hipoteca, Cuyos Importes se Encuentren Sujetos a la Cláusula de Actualización en Unidades de Vivienda (UVI)\n" +
            "29163|29162|20160927074802389\n" +
            "29164|29163|20160927074802389\n" +
            "29165|28503|Disposición (RPI) 21/2016 - Subsanación Registral de la Omisión de Consignar el Carácter Propio de los Bienes durante el Matrimonio\n" +
            "29166|29165|20161118073747837\n" +
            "29167|29166|20161118073747837\n" +
            "2473|0|Penal\n" +
            "26646|2473|Libro Primero. Disposiciones Generales. Arts. 1 a 78 bis\n" +
            "26647|26646|Título I. Aplicación de la Ley Penal. Arts. 1 a 4\n" +
            "26648|26647|20150703094114969\n" +
            "26649|26646|Título II. De las Penas. Arts. 5 a 25\n" +
            "26650|26649|20150703094213970\n" +
            "26651|26646|Título III. Condenación Condicional. Arts. 26 a 28\n" +
            "26652|26651|20150703094256971\n" +
            "26653|26646|Título IV. Reparación de Perjuicios. Arts. 29 a 33\n" +
            "26654|26653|20150703094340972\n" +
            "26655|26646|Título V. Imputabilidad. Arts. 34 a 41 quinquies\n" +
            "26656|26655|20150703094422973\n" +
            "26657|26646|Título VI. Tentativa. Arts. 42 a 44\n" +
            "26658|26657|20150703094518974\n" +
            "26659|26646|Título VII. Participación Criminal. Arts. 45 a 49\n" +
            "26660|26659|20150703094726975\n" +
            "26661|26646|Título VIII. Reincidencia. Arts. 50 a 53\n" +
            "26662|26661|20150703094803976\n" +
            "26663|26646|Título IX. Concurso de Delitos. Arts. 54 a 58\n" +
            "26664|26663|20150703095645977\n" +
            "26665|26646|Título X. Extinción de Acciones y de Penas. Arts. 59 a 70\n" +
            "26666|26665|20150703095844978\n" +
            "26667|26646|Título XI. Del Ejercicio de las Acciones. Arts. 71 a 75\n" +
            "26668|26667|20150703100157979\n" +
            "26669|26646|Título XII. De la Suspensión del Juicio a Prueba. Arts. 76 a 76 quater\n" +
            "26670|26669|20150703100247980\n" +
            "26671|26646|Título XIII. Significación de Conceptos Empleados en el Código. Arts. 77 a 78 bis\n" +
            "26672|26671|20150703100418981\n" +
            "26673|2473|Libro Segundo. De los Delitos. Arts. 79 a 313\n" +
            "26674|26673|Título I. Delitos contra las Personas. Arts. 79 a 108\n" +
            "26675|26674|20150703100528982\n" +
            "26676|26673|Título II. Delitos contra el honor. Arts. 109 a 117 bis\n" +
            "26677|26676|20150703100622983\n" +
            "26678|26673|Título III. Delitos contra la Integridad Sexual. Arts. 118 a 133\n" +
            "26679|26678|20150703100715984\n" +
            "26680|26673|Título IV. Delitos contra el Estado Civil. Arts. 134 a 139 bis\n" +
            "26681|26680|20150703100815985\n" +
            "26682|26673|Título V. Delitos contra la Libertad. Arts. 140 a 161\n" +
            "26683|26682|20150703100858986\n" +
            "26684|26673|Título VI. Delitos contra la Propiedad. Arts. 162 a 185\n" +
            "26685|26684|20150703101011987\n" +
            "26686|26673|Título VII. Delitos contra la seguridad pública. Arts. 186 a 208\n" +
            "26687|26686|20150703045135011\n" +
            "26688|26673|Título VIII. Delitos contra el Orden Público. Arts. 209 a 213 quáter\n" +
            "26689|26688|20150703101104988\n" +
            "26690|26673|Título IX. Delitos contra la Seguridad de la Nación. Arts. 214 a 225\n" +
            "26691|26690|20150703101158989\n" +
            "26692|26673|Título X. Delitos contra los Poderes Públicos y el Orden Constitucional. Arts. 226 a 236\n" +
            "26693|26692|20150703101433990\n" +
            "26694|26673|Título XI. Delitos contra la Administración Pública. Arts. 237 a 281 bis\n" +
            "26695|26694|20150703101545991\n" +
            "26696|26673|Título XII. Delitos contra la Fe Pública. Arts. 282 a 302\n" +
            "26697|26696|20150703101634992\n" +
            "26698|26673|Título XIII. Delitos contra el Orden Económico y Financiero. Arts. 303 a 313\n" +
            "26699|26698|20150714105353051\n" +
            "26700|2473|Disposiciones Complementarias. Arts. 314 a 317\n" +
            "26701|26700|20150703101740993\n" +
            "26702|2473|Normas Complementarias\n" +
            "26703|26702|Ley  2240. Protección de Cables Submarinos\n" +
            "26704|26703|20100922064450983\n" +
            "26705|26702|Ley  9643. Operaciones de Crédito Mobiliario sobre Frutos o Productos por Medio de Certificado de Depósito y Warrants\n" +
            "26706|26705|20100922064834074\n" +
            "26707|26702|Ley  11683. Procedimiento Tributario\n" +
            "26708|26707|20100922064224532\n" +
            "26709|26702|Ley  11723. Ley de Propiedad Intelectual\n" +
            "26710|26709|20100922064620545\n" +
            "26711|26702|Ley  12331. Organización de la Profilaxis de las Enfermedades Venéreas. Exámenes Médicos Prenupciales. Certificados Obligatorios para los Varones que vayan a Contraer Matrimonio\n" +
            "26712|26711|20100922064421343\n" +
            "26713|26702|Ley  12665. Creación de la Comisión Nacional de Museos y de Monumentos y Lugares Históricos\n" +
            "26714|26713|20100922064032690\n" +
            "26715|26702|Ley  12713. Régimen de Trabajo a Domicilio\n" +
            "26716|26715|20100922063843457\n" +
            "26717|26702|Ley  13944. Sanciones por Incumplimiento de Obligaciones Alimentarias\n" +
            "26718|26717|20100922063528537\n" +
            "26719|26702|Ley  13985. Sanciones por Espionaje y Sabotaje\n" +
            "26720|26719|20100922064137376\n" +
            "26721|26702|Ley  14034. Pena por Propiciar Sanciones Políticas o Económicas contra el Estado\n" +
            "26722|26721|20100922064138501\n" +
            "26723|26702|Ley  14346. Penas por Maltrato o Crueldad contra los Animales\n" +
            "26724|26723|20100922064712388\n" +
            "26725|26702|Ley  17250. Sanciones por Incumplimiento de Obligaciones Previsionales y de la Seguridad Social\n" +
            "26726|26725|20100922064716841\n" +
            "26727|26702|Ley  17285. Código Aeronáutico\n" +
            "26728|26727|20100922063606037\n" +
            "26729|26702|Ley  17671. Organización y Funcionamiento del Registro Nacional de las Personas\n" +
            "26730|26729|20100922064645638\n" +
            "26731|26702|Ley  19359. Cambio. Casas y agencias de cambio. Actuación no autorizada. Sanciones. Texto ordenado\n" +
            "26732|26731|20100922063543225\n" +
            "26733|26702|Ley  19945. Código Electoral\n" +
            "26734|26733|20100922064052502\n" +
            "26735|26702|Ley  20091. Ejercicio de la Actividad de las Entidades Aseguradoras\n" +
            "26736|26735|20100922064728231\n" +
            "26737|26702|Ley  20216. Régimen de los Servicios Postales\n" +
            "26738|26737|20100922064008784\n" +
            "26739|26702|Ley  20318. Servicio Civil de Defensa\n" +
            "26740|26739|20100922064741747\n" +
            "26741|26702|Ley  20429. Régimen Legal de Armas y Explosivos\n" +
            "26742|26741|20100922063514428\n" +
            "26743|26702|Ley  20509. Código Penal. Modificación. Derogación de normas diversas\n" +
            "26744|26743|20100922063344507\n" +
            "26745|26702|Ley  20655. Régimen Nacional del Deporte\n" +
            "26746|26745|20100922064022049\n" +
            "26747|26702|Ley  20680. Ley de Abastecimiento\n" +
            "26748|26747|20100922063405460\n" +
            "26749|26702|Ley  21265. Prestación del Servicio de Seguridad Personal\n" +
            "26750|26749|20100922064713966\n" +
            "26751|26702|Ley  21671. Prohibición de Plantación o Cultivo de Estupefacientes\n" +
            "26752|26751|20100922064138548\n" +
            "26753|26702|Ley  21704. Convenio sobre Sustancias Sicotrópicas. Viena 1971\n" +
            "26754|26753|20100922063923237\n" +
            "26755|26702|Ley  22117. Organización y Funcionamiento del Registro Nacional de Reincidencia\n" +
            "26756|26755|20100922064636466\n" +
            "26757|26702|Ley  22278. Régimen Penal de Menores\n" +
            "26758|26757|20100922064443265\n" +
            "26759|26702|Ley  22362. Régimen Legal de Marcas y Designaciones\n" +
            "26760|26759|20100922064419140\n" +
            "26761|26702|Ley  22415. Código Aduanero\n" +
            "26762|26761|20100922063550334\n" +
            "26763|26702|Ley  22421. Régimen de Protección y Conservación de la Fauna Silvestre\n" +
            "26764|26763|20100922064433858\n" +
            "26765|26702|Ley  22863. Registro Nacional de las Personas. Identificación obligatoria. Infracciones. Amnistía\n" +
            "26766|26765|20100922064645513\n" +
            "26767|26765|20100922064645560\n" +
            "26768|26702|Ley  22990. Régimen Nacional de Actividades Relacionadas con la Sangre Humana, sus Componentes y Derivados\n" +
            "26769|26768|20100922064710231\n" +
            "26770|26702|Ley  23054. Convención Americana sobre Derechos Humanos. Pacto de San José de Costa Rica\n" +
            "26771|26770|20100922063920347\n" +
            "26772|26702|Ley  23157. Cómputo del Trabajo Penitenciario a los Fines Previsionales\n" +
            "26773|26772|20100922064718606\n" +
            "26774|26702|Ley  23184. Responsabilidad Civil Derivada de Hechos de Violencia en Espectáculos Deportivos\n" +
            "26775|26774|20100922064026096\n" +
            "26776|26702|Ley  23338. Convención contra la Tortura y Otros Tratos o Penas Crueles, Inhumanas o Degradantes\n" +
            "26777|26776|20100922063933253\n" +
            "26778|26702|Ley  23474. Condiciones para la Exhibición y Comercialización de Armas de Fuego\n" +
            "26779|26778|20100922063514412\n" +
            "26780|26702|Ley  23511. Creación del Banco Nacional de Datos Genéticos (BNDG)\n" +
            "26781|26780|20100922064150032\n" +
            "26782|26702|Ley  23554. Preparación, Ejecución y Control de la Defensa Nacional\n" +
            "26783|26782|20100922064019752\n" +
            "26784|26702|Ley 23589. Registro Nacional de las Personas Identificación obligatoria. Infracciones. Amnistía\n" +
            "26785|26784|20100922064645560\n" +
            "26786|26785|20100922064645560\n" +
            "26787|26702|Ley  23592. Ley Antidiscriminación\n" +
            "26788|26787|20100922064032127\n" +
            "26789|26702|Ley  23737. Régimen Penal de Estupefacientes\n" +
            "26790|26789|20100922064138564\n" +
            "26791|26702|Ley  23798. Régimen de Prevención, Asistencia, Rehabilitación y Lucha contra el Síndrome de Inmunodeficiencia Adquirida (SIDA)\n" +
            "26792|26791|20100922064711825\n" +
            "26793|26702|Ley  23966. Impuestos. Impuesto sobre los Combustibles Líquidos y el Gas Natural. Impuesto sobre los Bienes Personales. Régimen Nacional de Previsión Social. Financiamiento. Régimen\n" +
            "26794|26793|20100922064208907\n" +
            "26795|26702|Ley  24051. Generación, Manipulación, Transporte, Tratamiento y Disposición Final de Residuos Peligrosos\n" +
            "26796|26795|20100922064438890\n" +
            "26797|26702|Ley  24241. Sistema Integrado de Jubilaciones y Pensiones\n" +
            "26798|26797|20100922064320016\n" +
            "26799|26702|Ley  24270. Régimen Penal de Impedimento u Obstrucción del Contacto de Menores de Edad con sus Progenitores\n" +
            "26800|26799|20100922064441093\n" +
            "26801|26702|Ley  24390. Plazos de la Prisión Preventiva\n" +
            "26802|26801|20100922064600451\n" +
            "26803|26702|Ley  24417. Ley de Protección contra la Violencia Familiar\n" +
            "26804|26803|20100922063531193\n" +
            "26805|26702|Ley  24452. Ley de Cheques\n" +
            "26806|26805|20100922063548318\n" +
            "26807|26702|Ley  24481. Régimen de Patentes de Invención y Modelos de Utilidad\n" +
            "26808|26807|20100922064501014\n" +
            "26809|26702|Ley  24557. Ley de Riesgos del Trabajo\n" +
            "26810|26809|20100922064657310\n" +
            "26811|26702|Ley  24566. Régimen de Producción, Circulación, Fraccionamiento y Comercialización de Alcohol\n" +
            "26812|26811|20100922064832387\n" +
            "26813|26702|Ley  24584. Convenios Internacionales. Imprescriptibilidad de los crímenes de guerra y de los crímenes de lesa humanidad\n" +
            "26814|26813|20100922063926128\n" +
            "26815|26702|Ley  24660. Ley de Ejecución de la Pena Privativa de Libertad\n" +
            "26816|26815|20100922064512405\n" +
            "26817|26702|Ley  24759. Convenios Internacionales. Convención contra la corrupción\n" +
            "26818|26817|20100922063906034\n" +
            "26819|26702|Ley  24766. Ley de Confidencialidad de la Información\n" +
            "26820|26819|20100922064158345\n" +
            "26821|26702|Ley  24767. Régimen de Extradición\n" +
            "26822|26821|20100922064145454\n" +
            "26823|26702|Ley  24788. Ley Nacional de Lucha contra el Alcoholismo\n" +
            "26824|26823|20100922063539475\n" +
            "26825|26702|Ley  25018. Régimen de Gestión de Residuos Radioactivos\n" +
            "26826|26825|20100922064440468\n" +
            "26827|26702|Ley  25086. Armas y Explosivos. Fiscalización. Régimen. Modificación\n" +
            "26828|26827|20100922063515225\n" +
            "26829|26702|Ley  25095. Protocolo de Asistencia Jurídica Mutua en Asuntos Penales para el Mercosur\n" +
            "26830|26829|20100922063850894\n" +
            "26831|26702|Ley  25246. Creación de la Unidad de Información Financiera\n" +
            "26832|26831|20100922063345148\n" +
            "26833|26702|Ley  25319. Convención sobre la Lucha contra el Cohecho de Funcionarios Públicos Extranjeros en las Transacciones Comerciales Internacionales. Paris 1997\n" +
            "26834|26833|20100922063958331\n" +
            "26835|26702|Ley  25326. Ley de Hábeas Data y Protección de Datos Personales\n" +
            "26836|26835|20100922064203829\n" +
            "26837|26702|Ley  25449. Convenios Internacionales. Armas y explosivos. Tráfico ilícito\n" +
            "26838|26837|20100922063849785\n" +
            "26839|26702|Ley  25460. Tratado de Asistencia Mutua Penal entre Argentina y Canadá\n" +
            "26840|26839|20100922063850316\n" +
            "26841|26702|Ley  25506. Régimen de Firma Digital\n" +
            "26842|26841|20100922064152267\n" +
            "26843|26702|Ley  25520. Inteligencia. Sistema de Inteligencia Nacional. Organización y funcionamiento. Régimen\n" +
            "26844|26843|20100922064256422\n" +
            "26845|26702|Ley  25667. Protocolo del Convenio sobre Cooperación en Materia de Prevención del Uso Indebido de Estupefacientes y Sustancias Psicotrópicas\n" +
            "26846|26845|20100922064004909\n" +
            "26847|26702|Ley  25743. Régimen de Protección del Patrimonio Arqueológico y Paleontológico\n" +
            "26848|26847|20100922064502264\n" +
            "26849|26702|Ley  25761. Desarmado de Automotores y Venta de Autopartes\n" +
            "26850|26849|20100922063533412\n" +
            "26851|26702|Ley  25762. Convenio Internacional para la Represión de los Atentados Terroristas Cometidos con Bombas\n" +
            "26852|26851|20100922063950237\n" +
            "26853|26702|Ley  25763. Convenios Internacionales. Derechos del niño. Protocolo relativo a la venta de niños, la prostitución infantil y la utilización de los niños en la pornografía\n" +
            "26854|26853|20100922063918128\n" +
            "26855|26702|Ley  25764. Programa Nacional de Protección a Testigos e Imputados\n" +
            "26856|26855|20100922064027705\n" +
            "26857|26702|Ley  25871. Ley de Migraciones\n" +
            "26858|26857|20100922064444561\n" +
            "26859|26702|Ley  25875. Creación de la Procuración Penitenciaria\n" +
            "26860|26859|20100922064742340\n" +
            "26861|26702|Ley  25886. Armas y Explosivos. Tenencia y portación ilegal. Código Penal. Código Procesal Penal. Modificación\n" +
            "26862|26861|20100922063526319\n" +
            "26863|26702|Ley  25938. Registro Nacional de Armas de Fuego y Materiales Controlados, Secuestrados o Incautados\n" +
            "26864|26863|20100922064649357\n" +
            "26865|26702|Ley  26003. Tratado sobre Traslado de Nacionales Condenados y Cumplimiento de Sentencias Penales entre Argentina y Chile\n" +
            "26866|26865|20100922063951534\n" +
            "26867|26702|Ley  26004. Acuerdo de Asistencia Jurídica Mutua en Asuntos Penales entre los Estados Partes del Mercosur\n" +
            "26868|26867|20100922063951018\n" +
            "26869|26702|Ley  26023. Convención Interamericana contra el Terrorismo\n" +
            "26870|26869|20100922063906878\n" +
            "26871|26702|Ley  26052. Estupefacientes. Penas. Competencia. Modificación\n" +
            "26872|26871|20100922064139970\n" +
            "26873|26702|Ley 26216. Armas y Explosivos. Tenencia, Fabricación, Importación, Exportación, Transporte, Depósito, Almacenamiento, Tránsito Internacional, Registración, Donación, Comodato y Compraventa de Armas de Fuego, Municiones y Explosivos. Emergencia Nacional. Declaración\n" +
            "26874|26873|20100922071043010\n" +
            "26875|26702|Ley  26364. Derechos Humanos. Trata de Personas. Código Penal. Código Procesal Penal de la Nación. Modificaciones\n" +
            "26876|26875|20100922064029330\n" +
            "26877|26702|Ley  26379. Protocolo a la Convención Americana sobre Derechos Humanos relativo a la Abolición de la Pena de Muerte\n" +
            "26878|26877|20100922063947925\n" +
            "26879|26702|Ley  26485. Ley de Prevención, Sanción y Erradicación de la Violencia de Género contra las Mujeres\n" +
            "26880|26879|20100922063530647\n" +
            "26881|26702|Ley  26548. Banco Nacional de Datos Genéticos\n" +
            "26882|26881|20100922064149501\n" +
            "26883|26702|Ley  26588. Declaración de Interés Nacional de la Investigación, Diagnóstico y Tratamiento de la Enfermedad Celíaca\n" +
            "26884|26883|20100922084619988\n" +
            "26885|26702|Ley  26637. Medidas Mínimas de Seguridad para Entidades Financieras\n" +
            "26886|26885|20101221102824187\n" +
            "26887|26702|Ley  26682. Marco Regulatorio de Medicina Prepaga\n" +
            "26888|26887|20110517091023375\n" +
            "26889|26702|Ley  26687. Regulación de la Publicidad, Promoción y Consumo de Productos Elaborados con Tabaco\n" +
            "26890|26889|20110614084158899\n" +
            "26891|26702|Ley  26827. Sistema Nacional de Prevención de la Tortura y Otros Tratos o Penas Crueles, Inhumanos o Degradantes\n" +
            "26892|26891|20130111090227115\n" +
            "26893|26702|Ley  26879. Registro Nacional de Datos Genéticos Vinculados a Delitos contra la Integridad Sexual\n" +
            "26894|26893|20130724081845448\n" +
            "26895|26702|Ley  26912. Régimen Jurídico para la Prevención y el Control del Dopaje en el Deporte\n" +
            "26896|26895|20131226093839661\n" +
            "26897|26702|Ley  26939. Digesto Jurídico Argentino\n" +
            "26898|26897|20140616093736982\n" +
            "26899|26702|Ley  26968. Prohibición de Venta a Menores de Edad de Adhesivos, Pegamentos, o Similares, que Contengan Elementos Susceptibles de Ser Inhalados para Provocar Efecto Psicoactivo o Alteración Mental\n" +
            "26900|26899|20140829100714303\n" +
            "26901|26702|Ley  26979. Acuerdos Internacionales. República de Chile. Tratado sobre Traslado de Nacionales Condenados y Cumplimiento de Sentencias Penales. Protocolo Modificatorio. Aprobación\n" +
            "26902|26901|20140925074753405\n" +
            "26903|26702|Ley  26980. Convención Interamericana para el Cumplimiento de Condenas Penales en el Extranjero\n" +
            "26904|26903|20140926073754015\n" +
            "26905|26702|Ley  27156. Prohibición de Indultos, Amnistías y Conmutación de Penas en Delitos de Lesa Humanidad\n" +
            "26906|26905|20150731081627626\n" +
            "26907|26702|Ley  27304. Ley del Arrepentido. Modificación del Código Penal\n" +
            "26908|26907|20161102074029899\n" +
            "26909|26702|Ley  27319. Herramientas y Facultades para la Investigación, Prevención y Lucha de los Delitos Complejos\n" +
            "26910|26909|20161122073705968\n" +
            "26911|26702|Ley  27330. Prohibición de Carreras de Perros en Todo el Territorio Nacional\n" +
            "26912|26911|20161202074243484\n" +
            "26913|26702|Ley  27350. Investigación Médica y Científica del Uso Medicinal de la Planta de Cannabis y sus Derivados\n" +
            "26914|26913|20170419073927670\n" +
            "26915|26702|Ley  27362. Limitación a la Aplicación del Sistema 2x1 para Delitos de Lesa Humanidad\n" +
            "26916|26915|20170512073637573\n" +
            "26917|26702|Ley  27372. Ley de Derechos y Garantías de las Personas Víctimas de Delitos\n" +
            "26918|26917|20170713061743065\n" +
            "26919|26702|Ley  27401. Régimen de Responsabilidad Penal Empresaria\n" +
            "26920|26919|20171201075436430\n" +
            "26921|26702|Ley  27411. Convenio sobre Ciberdelito del Consejo de Europa\n" +
            "26922|26921|20171215084729580\n" +
            "26923|26702|Ley 27430. Reforma Impositiva. Régimen Penal Tributario\n" +
            "26924|26923|20171229081038775\n" +
            "26925|26702|Ley 27430 (Trascripción parcial). Régimen Penal Tributario\n" +
            "26926|26925|20180228101522811\n" +
            "26927|26702|Ley 27437. Ley de Compre Argentino y Desarrollo de Proveedores. Sanciones por Incumplimiento\n" +
            "26928|26927|20180510062506959\n" +
            "26929|26702|Ley 27442. Nueva Ley de Defensa de la Competencia\n" +
            "26930|26929|20180515065023759\n" +
            "26931|26702|Ley 27447. Ley de Trasplante de Órganos, Tejidos y Células\n" +
            "26932|26931|20180726062943174\n" +
            "26933|26702|Ley 27452. Régimen de Reparación Económica para las Niñas, Niños y Adolescentes\n" +
            "26934|26933|20180726063816497\n" +
            "26935|26702|Ley 27508. Creación del Fondo de Asistencia Directa a Víctimas de Trata - Ley 26364\n" +
            "26936|26935|20190723070121011\n" +
            "26937|26936|20190723070121011\n" +
            "26938|26702|Decreto Ley 15348/1946. Prenda con Registro\n" +
            "26939|26938|20100922064558732\n" +
            "26940|26702|Decreto Ley 6286/1956. Convenios Internacionales. Genocidio. Prevención. Sanción\n" +
            "26941|26940|20100922063925144\n" +
            "26942|26702|Decreto Ley 6618/1957. Prohibición de Juegos de Azar No Autorizados\n" +
            "26943|26942|20100922064337984\n" +
            "26944|26702|Decreto Ley 11925/1957. Convenio para la Represión de la Trata de Personas y de la Explotación de la Prostitución Ajena\n" +
            "26945|26944|20100922064622544\n" +
            "26946|26702|Decreto Ley 6582/1958. Organización y Funcionamiento del Registro de la Propiedad Automotor\n" +
            "26947|26946|20100922064627404\n" +
            "26948|26702|Decreto Ley 6673/1963. Derecho de Propiedad Intelectual sobre Diseños Industriales\n" +
            "26949|26948|20100922064619341\n" +
            "26950|26702|Decreto 395/1975. Reglamentación de la Ley Nacional de Armas y Explosivos\n" +
            "26951|26950|20100922063515287\n" +
            "26952|26702|Decreto 1148/1991. Reglamentación del Artículo 39 del Régimen Penal de Estupefacientes\n" +
            "26953|26952|20100922064138782\n" +
            "26954|26702|Decreto 64/1995. Prohibición de Adquisición y Tenencia de Armas de Uso Militar\n" +
            "26955|26954|20100922063516459\n" +
            "26956|26702|Decreto 235/1996. Centros de Información y Asesoramiento sobre Violencia Familiar\n" +
            "26957|26956|20100922063531209\n" +
            "26958|26702|Decreto 303/1996. Reglamento General de Procesados\n" +
            "26959|26958|20100922064519139\n" +
            "26960|26702|Decreto 821/1996. Armas y Explosivos. Adquisición. Tenencia\n" +
            "26961|26960|20100922063512131\n" +
            "26962|26702|Decreto 18/1997. Reglamento de Disciplina para los Internos\n" +
            "26963|26962|20100922064518592\n" +
            "26964|26702|Decreto 1058/1997. Reglamentación de la Ley de Ejecución de la Pena Privativa de la Libertad\n" +
            "26965|26964|20100922064513077\n" +
            "26966|26702|Decreto 1136/1997. Pena Privativa de la Libertad. Reglamento de comunicaciones de los internos\n" +
            "26967|26966|20100922064517108\n" +
            "26968|26702|Decreto 262/1998. Creación de la Oficina de Protección de Testigos e Imputados\n" +
            "26969|26968|20100922064448749\n" +
            "26970|26702|Decreto 396/1999. Reglamento de Modalidades Básicas de la Ejecución Penal\n" +
            "26971|26970|20100922064513639\n" +
            "26972|26702|Decreto 1139/2000. Pena Privativa de la Libertad. Ejecución. Modalidades Básicas. Modificación\n" +
            "26973|26972|20100922064514498\n" +
            "26974|26702|Decreto 1235/2001. Resolución del Consejo de Seguridad de las Naciones Unidas Prevención y Represión de Actos de Terrorismo\n" +
            "26975|26974|20100922064818590\n" +
            "26976|26702|Decreto 1500/2001. Lavado de Dinero. Unidad de Información Financiera. Organización y funcionamiento. Modificación\n" +
            "26977|26976|20100922064404921\n" +
            "26978|26702|Decreto 1558/2001. Reglamentación de la Ley de Hábeas Data y Protección de Datos Personales\n" +
            "26979|26978|20100922064158923\n" +
            "26980|26702|Decreto 420/2003. Derecho Penal. Cooperación internacional en materia penal y extradición. Modificación\n" +
            "26981|26980|20100922064027190\n" +
            "26982|26702|Decreto 744/2004. Reglamentación del Régimen de Desarmado de Automotores y Venta de Autopartes\n" +
            "26983|26982|20100922063533928\n" +
            "26984|26702|Decreto 807/2004. Reglamento para la Supervisión de la Ley de Ejecución Penal por parte del Patronato de Liberados\n" +
            "26985|26984|20100922064516077\n" +
            "26986|26702|Decreto 1022/2004. Reglamentación del Régimen de Protección del Patrimonio Arqueológico y Paleontológico\n" +
            "26987|26986|20100922064502936\n" +
            "26988|26702|Decreto 1338/2004. Reglamentación del Régimen Nacional de Actividades Relacionadas con la Sangre Humana, sus Componentes y Derivados\n" +
            "26989|26988|20100922064710794\n" +
            "26990|26702|Decreto 290/2007. Reglamentación de la Ley Orgánica de la Unidad de Información Financiera\n" +
            "26991|26990|20100922064403859\n" +
            "26992|26702|Decreto 299/2010. Estupefacientes. Sustancias Químicas. Lista de Estupefacientes. Actualización\n" +
            "26993|26992|20100922080022941\n" +
            "26994|26702|Decreto 1936/2010. Lavado de Dinero. Unidad de Información Financiera. Organización y Funcionamiento. Facultades. Asignación\n" +
            "26995|26994|20101220052153169\n" +
            "26996|26702|Decreto 936/2011. Prohibición de la Prostitución y el Comercio Sexual\n" +
            "26997|26996|20110706084003692\n" +
            "26998|26702|Decreto 103/2017. Creación de la Comisión para la Reforma del Código Penal de la Nación\n" +
            "26999|26998|20170214073311387\n" +
            "27000|26702|Decreto 246/2017. Prevención de la Violencia en el Fútbol\n" +
            "27001|27000|20170411070920495\n" +
            "27002|26702|Decreto 267/2017. Autoridad de Aplicación del Programa Nacional de Entrega Voluntaria de Armas de Fuego\n" +
            "27003|27002|20170419083614408\n" +
            "27004|27003|20170419083614408\n" +
            "27005|26702|Decreto 522/2017. Reglamentación del Registro Nacional de Datos Genéticos Vinculados a Delitos contra la Integridad Sexual\n" +
            "27006|27005|20170718075356184\n" +
            "27007|26702|Decreto 738/2017. Reglamentación del Marco Regulatorio para la Investigación Médica y Científica del Uso Medicinal de la Planta de Cannabis y sus Derivados\n" +
            "27008|27007|20170922073653832\n" +
            "27009|26702|Decreto 277/2018. Pautas para la Reglamentación de la Ley de Responsabilidad Penal Empresaria\n" +
            "27010|27009|20180406082412229\n" +
            "27011|26702|Decreto 421/2018. Reglamentación de la Ley de Derechos y Garantías de las Personas Víctimas de Delitos\n" +
            "27012|27011|20180509074712399\n" +
            "27013|26702|Decreto 480/2018. Reglamentación de la Ley de Defensa de la Competencia\n" +
            "27014|27013|20180524062702050\n" +
            "27015|26702|Decreto 62/2019. Régimen Procesal de la Acción Civil de Extinción de Dominio\n" +
            "27016|27015|20190122061237505\n" +
            "27017|26702|Decreto 182/2019. Reglamentación de la Ley de Firma Digital\n" +
            "27018|27017|20190312061849856\n" +
            "27019|26702|Decreto 242/2019. Reglamentación del Régimen de Marcas y Designaciones\n" +
            "27020|27019|20190403073733567\n" +
            "27021|26702|Decreto 560/2019. Lista de Sustancias Consideradas Estupefacientes\n" +
            "27022|27021|20190815070952608\n" +
            "27023|27022|20190815070952608\n" +
            "27024|26702|Decreto 844/2019. Reglamentación del Régimen del Fondo Fiduciario Público “Fondo de Asistencia Directa a Víctimas de Trata - Ley 26364”\n" +
            "27025|27024|20191209072405205\n" +
            "27026|27025|20191209072405205\n" +
            "27027|26702|Resolución (MI) 1602/1999. Armas y Explosivos. Funcionarios. Uso\n" +
            "27028|27027|20100922063516475\n" +
            "27029|26702|Resolución (MS) 258/2018. Condiciones de Habilitación de los Predios e Instalaciones de Cultivo de Cannabis para la Investigación Médica y Científica del Uso Medicinal\n" +
            "27030|27029|20180405062855494\n" +
            "27031|26702|Resolución (MS) 828/2019. Protocolos de Seguridad para el Resguardo del Anonimato de los Aportantes de Información sobre Delitos\n" +
            "27032|27031|20191001063825500\n" +
            "27033|27032|20191001063825500\n" +
            "27034|26702|Resolución (MS) 977/2019. Plan Federal de Prevención de Delitos Tecnológicos y Ciberdelitos (2019 - 2023)\n" +
            "27035|27034|20191104071455151\n" +
            "27036|27035|20191104071455151\n" +
            "27037|26702|Resolución (MS) 999/2019. Plan Nacional de Seguridad para la Reducción de Femicidios\n" +
            "27038|27037|20191107065626707\n" +
            "27039|27038|20191107065626707\n" +
            "27040|26702|Resolución (SPC) 12/2001. Criminalística. Programa Nacional. Creación\n" +
            "27041|27040|20100922064009362\n" +
            "27042|26702|Resolución (ANMC) 135/2018. Prohibición de la Fabricación, Venta, Comercio e Importación de Armas de Fogueo\n" +
            "27043|27042|20190103065326601\n" +
            "27044|27043|20190103065326601\n" +
            "27045|26702|Resolución (FCA) 6/2000. Ética. Función pública. Régimen. Aplicación\n" +
            "27046|27045|20100922064140532\n" +
            "27047|26702|Resolución (FCA) 1/2002. Ética. Función pública. Régimen. Aplicación. Normas complementarias\n" +
            "27048|27047|20100922064141111\n" +
            "27049|26702|Resolución (RNA) 72/1998. Armas y Explosivos. Credencial de legítimo usuario de armas. Obtención\n" +
            "27050|27049|20100922063514366\n" +
            "27051|26702|Resolución (RNA) 197/2006. Armas y Explosivos. Condición de Legítimo Usuario. Requisitos\n" +
            "27052|27051|20100922063513334\n" +
            "27053|26702|Resolución (SSN) 28608/2002. Lavado de Dinero. Unidad de Información Financiera. Hechos u operaciones sospechosas\n" +
            "27054|27053|20100922064402406\n" +
            "27055|26702|Resolución (SAM) 42/2005. Armas y Explosivos. Legítimo Usuario Rural de Armas de Fuego. Categoría. Creación\n" +
            "27056|27055|20100922063518162\n" +
            "27057|26702|Resolución (UIF) 6/2003. Lavado de Dinero. Encubrimiento de activos de origen delictivo. Guía de transacciones inusuales o sospechosas\n" +
            "27058|27057|20100922064348937\n" +
            "27059|26702|Resolución (UIF) 104/2010. Lavado de Dinero. Deber de Información. Sujetos Obligados. Reglamentación del Procedimiento de Supervisión del Cumplimiento de la Normativa. Aprobación\n" +
            "27060|27059|20100922064345718\n" +
            "27061|26702|Resolución (UIF) 12/2011. Lavado de Dinero. Unidad de Información Financiera. Medidas y Procedimientos Mínimos de Prevención, Detección y Reporte. Banco Central de la República Argentina. Sujeto Obligado\n" +
            "27062|27061|20110117083626768\n" +
            "27063|26702|Resolución (UIF) 19/2011. Lavado de Dinero. Unidad de Información Financiera. Medidas y Procedimientos Mínimos de Prevención, Detección y Reporte. Superintendencia de Seguros de la Nación. Sujeto Obligado\n" +
            "27064|27063|20110120110048024\n" +
            "27065|26702|Resolución (UIF) 21/2011. Lavado de Dinero. Unidad de Información Financiera. Medidas y Procedimientos Mínimos de Prevención, Detección y Reporte. Escribanos Públicos. Sujetos Obligados\n" +
            "27066|27065|20110120110253025\n" +
            "27067|26702|Resolución (UIF) 22/2011. Lavado de Dinero. Unidad de Información Financiera. Medidas y Procedimientos Mínimos de Prevención, Detección y Reporte. Comisión Nacional de Valores. Sujeto Obligado\n" +
            "27068|27067|20110120110451026\n" +
            "27069|26702|Resolución (UIF) 23/2011. Lavado de Dinero. Unidad de Información Financiera. Medidas y Procedimientos de Prevención, Detección y Reporte. Empresas Prestatarias o Concesionarias de Servicios Postales. Sujeto Obligado\n" +
            "27070|27069|20110121085819100\n" +
            "27071|26702|Resolución (UIF) 24/2011. Lavado de Dinero. Unidad de Información Financiera. Medidas y Procedimientos de Prevención, Detección y Reporte. Empresas de Transporte de Caudales. Sujeto Obligado\n" +
            "27072|27071|20110121090026101\n" +
            "27073|26702|Resolución (UIF) 28/2011. Lavado de Dinero. Unidad de Información Financiera. Medidas y Procedimientos de Prevención, Detección y Reporte. Personas Físicas o Jurídicas Dedicadas a la Compraventa de Bienes Suntuarios. Sujetos Obligados\n" +
            "27074|27073|20110126085150315\n" +
            "27075|26702|Resolución (UIF) 29/2011. Lavado de Dinero. Unidad de Información Financiera. Medidas y Procedimientos de Prevención, Detección y Reporte. Registros Públicos de Comercio y Organismos Representativos de Fiscalización y Control de Personas Jurídicas. Sujetos Obligados\n" +
            "27076|27075|20110127084201410\n" +
            "27077|26702|Resolución (UIF) 38/2011. Lavado de Dinero. Unidad de Información Financiera. Medidas y Procedimientos de Prevención, Detección y Reporte. Administración Federal de Ingresos Públicos. Sujeto Obligado\n" +
            "27078|27077|20110214081018344\n" +
            "27079|26702|Resolución (UIF) 41/2011. Lavado de Dinero. Unidad de Información Financiera. Medidas y Procedimientos de Prevención, Detección y Reporte. Registros de la Propiedad Inmueble. Sujetos Obligados\n" +
            "27080|27079|20110215090336381\n" +
            "27081|26702|Resolución (UIF) 50/2011. Lavado de Dinero. Unidad de Información Financiera. Sujetos Obligados. Registración\n" +
            "27082|27081|20110401085643266\n" +
            "27083|26702|Resolución (UIF) 51/2011. Lavado de Dinero. Unidad de Información Financiera. Reporte de Operaciones Sospechosas On Line. Sistema. Aprobación\n" +
            "27084|27083|20110401085826267\n" +
            "27085|26702|Resolución (UIF) 65/2011. Lavado de Dinero. Unidad de Información Financiera. Profesionales Matriculados. Consejos Profesionales de Ciencias Económicas. Sujetos Obligados. Deber de Informar. Reglamentación\n" +
            "27086|27085|20110530084834509\n" +
            "27087|26702|Resolución (UIF) 70/2011. Lavado de Dinero. Unidad de Información Financiera. Operaciones On Line. Sistema de Reporte de Operaciones. Aprobación\n" +
            "27088|27087|20110530085054510\n" +
            "27089|26702|Resolución (UIF) 199/2011. Lavado de Dinero. Unidad de Información Financiera. Delitos. Medidas y Procedimientos de Prevención, Detección y Reporte. Explotación de Juegos de Azar. Sujetos Obligados\n" +
            "27090|27089|20111104085207926\n" +
            "27091|26702|Resolución (UIF) 220/2011. Lavado de Dinero. Unidad de Información Financiera. Deber de Colaboración y Procedimiento de Supervisión del Cumplimiento de la Normativa. Directiva. Administración Federal de Ingresos Públicos. Deber de Colaboración\n" +
            "27092|27091|20111201091333030\n" +
            "27093|26702|Resolución (UIF) 30-E/2017. Lineamientos para la Gestión de Riesgos de  Lavado de Activos y de Financiación del Terrorismo (LA/FT) de Cumplimiento Mínimo para las Entidades Financieras y Cambiarias\n" +
            "27094|27093|20170621073405828\n" +
            "27095|26702|Resolución General (AFIP) 3072. Procedimiento. Contratación de Mano de Obra que Importen Graves Violaciones a las Normas Laborales, Previsionales o Sobre Higiene y Seguridad en el Trabajo. Denuncia Penal. Información a Organismos\n" +
            "27096|27095|20110329090251117\n" +
            "27097|26702|Resolución General (AFIP) 4088-E. Procedimiento Sumarial Abreviado para las Infracciones de Suministro de Informes Aduaneros Falsos o Inexactos y Transgresiones a los Deberes del Código Aduanero\n" +
            "27098|27097|20170710063708023\n" +
            "27099|26702|Disposición (RNR) 11/2018. Creación del Registro de Antecedentes Penales de Personas Jurídicas\n" +
            "27100|27099|20181123080906770\n");

}

