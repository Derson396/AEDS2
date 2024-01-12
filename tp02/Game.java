import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.text.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Game {
    private int app_id;
    private int age;
    private int dlcs;
    private int avg_pt;
    private float price;
    private float upvotes;
    private String name;
    private String owners;
    private String website;
    private String developers;
    private String data;
    private String[] languages;
    private String[] genres;
    private java.util.Date release_date;
    private Boolean windows;
    private Boolean mac;
    private Boolean linux;
    private static ArrayList<Game> vai = new ArrayList<Game>();
    private static int elementos;

    public Game(String id) {
        this.app_id = Integer.parseInt(id);
    }

    public int getApp_id() {
        return this.app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public Game(int app_id, int age, int dlcs, int avg_pt, float price, float upvotes, String name, String owners,
            String website, String developers, String[] languages, String[] genres, java.util.Date release_date) {
        this.app_id = app_id;
        this.age = age;
        this.dlcs = dlcs;
        this.avg_pt = avg_pt;
        this.price = price;
        this.upvotes = upvotes;
        this.name = name;
        this.owners = owners;
        this.website = website;
        this.developers = developers;
        this.languages = languages;
        this.genres = genres;
        this.release_date = release_date;
    }

    public Game() {

    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getUpvotes() {
        return this.upvotes;
    }

    public void setUpvotes(float upvotes) {
        this.upvotes = upvotes;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDlcs() {
        return this.dlcs;
    }

    public void setDlcs(int dlcs) {
        this.dlcs = dlcs;
    }

    public int getAvg_pt() {
        return this.avg_pt;
    }

    public void setAvg_pt(int avg_pt) {
        this.avg_pt = avg_pt;
    }

    public float getPrice() {
        return this.price;
    }

    public Boolean getMac() {
        return this.mac;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDevelopers() {
        return this.developers;
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    public java.util.Date getRelease_date() {
        return this.release_date;
    }

    public String getOwners() {
        return this.owners;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setRelease_date(java.util.Date release_date) {
        this.release_date = release_date;
    }

    public Boolean getWindows() {
        return windows;
    }

    public void setWindows(Boolean windows) {
        this.windows = windows;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public void setMac(Boolean mac) {
        this.mac = mac;
    }

    public String[] getLanguages() {
        return this.languages;
    }

    public Boolean getLinux() {
        return this.linux;
    }

    public void setLinux(Boolean linux) {
        this.linux = linux;
    }

    public Game clone(Game clone) {
        return (new Game(clone.age, clone.app_id, clone.avg_pt, clone.dlcs, clone.price, clone.upvotes,
                clone.developers, clone.name, clone.website, clone.owners, clone.genres, clone.languages,
                clone.release_date));
    }

    public String[] getGenres() {
        return this.genres;
    }

    public String fazerData(String entradaData) {
        if (entradaData.length() > 10) {
            String[] tmpData = entradaData.split(",");
            String mes = "" + tmpData[0].charAt(0) + tmpData[0].charAt(1) + tmpData[0].charAt(2);
            String outputData = mes + "/" + tmpData[tmpData.length - 1].substring(1);
            return outputData;
        } else {
            String[] tmpData = entradaData.split(" ");
            String outputData = tmpData[0] + "/" + tmpData[tmpData.length - 1];
            return outputData;
        }
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public void leitura(String entrada) throws IOException {
        DateFormat data1 = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        DateFormat data2 = new SimpleDateFormat("MMM yyyy", Locale.US);
        int control = 0;
        int virgula = 0;
        String temporario = entrada;
        for (int i = 2; i < entrada.length(); i++) {
            if (entrada.charAt(i - 2) == ',') // contar virgulas
            {
                virgula++;
            }
            if (control == 0 && entrada.charAt(i - 1) == '\"' && entrada.charAt(i + 1) != '[') // leitura nome com "
            {
                control++;
                String tmpName = "";
                for (int cn = 1; temporario.charAt(cn) != '\"'; cn++) {
                    if (temporario.charAt(cn) == ',') {
                        virgula--;
                    }
                    tmpName += temporario.charAt(cn);
                }
                this.name = tmpName;
            } else if (control == 0 && virgula == 1) // leitura nome
            {
                control++;
                this.name = temporario.split(",")[0];
            }
            if (control == 1 && virgula == 2) // ler data
            {
                control++;
                String tmpData = "";
                if (temporario.charAt(0) == '\"') {
                    temporario = temporario.substring(1);
                    tmpData = temporario.split("\"")[0];
                } else {
                    tmpData = temporario.split(",")[0];
                }
                if (tmpData.length() > 10) {
                    virgula--; // tirar virgula dentro da data da contagem
                    try {
                        this.release_date = data1.parse(tmpData);
                        this.data = this.fazerData(tmpData);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        this.release_date = data2.parse(tmpData);
                        this.data = this.fazerData(tmpData);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (control == 2 && virgula == 3) // ler owners
            {
                control++;
                this.owners = temporario.split(",")[0];
            }
            if (control == 3 && virgula == 4) {
                control++;
                this.age = Integer.parseInt(temporario.split(",")[0]);
            }
            if (control == 4 && virgula == 5) {
                control++;
                this.price = Float.parseFloat(temporario.split(",")[0]);
            }
            if (control == 5 && virgula == 6) {
                control++;
                this.dlcs = Integer.parseInt(temporario.split(",")[0]);
            }
            if (control == 6 && virgula == 7 && temporario.charAt(0) == '[') {
                control++;
                String tmpLang;
                tmpLang = temporario.split("']")[0];
                tmpLang += "'";
                tmpLang = tmpLang.replaceAll("\'", "");
                this.languages = tmpLang.split(", ");
                this.languages[0] = this.languages[0].substring(1);
                String strLang = Arrays.toString(this.languages);
                for (int cl = 0; cl < strLang.length(); cl++) // contar virgulas das linguagens
                {
                    if (strLang.charAt(cl) == ',') {
                        virgula--;
                    }
                }
            }
            if (control == 7 && virgula == 8) { // ler website
                control++;
                if (temporario.charAt(0) == '\"') {
                    temporario = temporario.substring(1);
                    this.website = temporario.split("\"")[0];
                    for (int cw = 0; cw < this.website.length(); cw++) // contar virgulas do website
                    {
                        if (this.website.charAt(cw) == ',') {
                            virgula--;
                        }
                    }
                }
                this.website = temporario.split(",")[0];
            }
            if (control == 8 && virgula == 9) {
                control++;
                this.windows = Boolean.parseBoolean(temporario.split(",")[0]);
            }
            if (control == 9 && virgula == 10) {
                control++;
                this.mac = Boolean.parseBoolean(temporario.split(",")[0]);
            }
            if (control == 10 && virgula == 11) {
                control++;
                this.linux = Boolean.parseBoolean(temporario.split(",")[0]);
            }
            if (control == 11 && virgula == 12) {
                control++;
                String[] tmpUpvotes = temporario.split(",", 3);
                float up = Float.parseFloat(tmpUpvotes[0]);
                float down = Float.parseFloat(tmpUpvotes[1]);
                this.calcularPorcentagem(up, down); // calcular porcento de upvotes
            }
            if (control == 12 && virgula == 14) {
                control++;
                this.avg_pt = Integer.parseInt(temporario.split(",")[0]);
            }
            if (control == 13 && virgula == 15) {
                control++;
                if (temporario.charAt(0) == '\"') {
                    temporario = temporario.substring(1);
                    this.developers = temporario.split("\"")[0];
                    for (int cd = 0; cd < this.developers.length(); cd++) // contar virgulas dos developers
                    {
                        if (this.developers.charAt(cd) == ',') {
                            virgula--;
                        }
                    }
                } else {
                    this.developers = temporario.split(",")[0];
                }
            }
            if (control == 14 && virgula == 16) {
                control++;
                temporario = temporario.replaceAll("\"", "");
                this.genres = temporario.split(",");
            }
            temporario = entrada.substring(i);
        }
    }

    public String getData() { // temporario pra teste
        return this.data;
    }

    public void setData(String data) { // temporario pra teste
        this.data = data;
    }

    public String parseLanguages() {
        String linguas = "";
        for (int i = 0; i < this.languages.length; i++) {
            linguas += (this.languages[i].substring(1) + ", ");
        }
        linguas = linguas.split("']")[0];
        return linguas;
    }

    public String calcularHoras() {
        if (this.avg_pt == 0) {
            return null;
        } else {
            int horas = Math.round((float) (this.avg_pt / 60));
            int minutos = Math.round(this.avg_pt % 60);
            String time = (Integer.toString(horas) + "h " + Integer.toString(minutos) + "m");
            return time;
        }
    }

    public void calcularPorcentagem(float u, float d) {
        this.upvotes = (u / (u + d) * 100);
    }

    public String fazerStringPorcentagem() {
        int temporario = Math.round(this.upvotes);
        String porcento = (Integer.toString(temporario) + "%");
        return porcento;
    }

    public void printa() {
        System.out.println(this.getApp_id() + " " + this.getName() + " " + this.data + " " + this.getOwners() + " "
                + this.getAge() + " " + this.getPrice() + " " + this.getDlcs() + " "
                + Arrays.toString(this.getLanguages()) + " " + this.getWebsite() + " " + this.getWindows() + " "
                + this.getMac() + " " + this.getLinux() + " " + this.fazerStringPorcentagem() + " "
                + this.calcularHoras() + " " + this.getDevelopers() + " " + Arrays.toString(this.getGenres()));
    }

    static void inserirInicio(Game game){
        if(elementos!=0)
        {
            for(int i=elementos;i>=0;i--)
            {
                vai.set(i+1,vai.get(i));
            }
            vai.set(0, game);
        }else{
        vai.add(game);}
        elementos++;
    }

    static void inserir(Game game, int posição) {
        if (posição != elementos) {
            for (int i = elementos; i >= posição; i--) {
                vai.set(i + 1, vai.get(i));
            }
            vai.set(posição, game);
        } else {
            vai.set(posição, game);
        }
        elementos++;
    }

    static void inserirFim(Game game) {
        vai.add(game);
        elementos++;
    }

    static Game removerInicio() {
        Game a = vai.get(0);
        for (int i = 0; i < elementos; i++) {
            vai.set(i, vai.get(i + 1));
        }
        elementos--;
        return a;
    }

    static Game removerFim() {
        return vai.get(elementos--);
    }

    static Game remover(int posição) {
        Game a = vai.get(posição);
        for (int i = posição; i < elementos; i--) {
            vai.set(i, vai.get(+1));
        }
        elementos--;
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader leitorObj = null;
        Scanner a = new Scanner(System.in);
        String entrada = a.nextLine();
        while (!entrada.equals("FIM")) {
            try {
                String strCurrentLine;
                leitorObj = new BufferedReader(new FileReader("games.csv"));
                while ((strCurrentLine = leitorObj.readLine()) != null) {
                    String[] id = strCurrentLine.split(",", 0);
                    Game joguim = new Game(id[0]);
                    if (id[0].equals(entrada)) {
                        joguim.leitura(strCurrentLine); // chama a funçao pra ler
                        vai.add(joguim);
                        elementos++;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            entrada = a.nextLine();
        }
        int input=a.nextInt();
        int pos;
        while(input>0)
        {
            entrada=a.next();
            if(entrada.equals("II"))
            {
                entrada=a.next();
                try {
                    String strCurrentLine;
                    leitorObj = new BufferedReader(new FileReader("games.csv"));
                    while ((strCurrentLine = leitorObj.readLine()) != null) {
                        String[] id = strCurrentLine.split(",", 0);
                        Game joguim = new Game(id[0]);
                        if (id[0].equals(entrada)) {
                            joguim.leitura(strCurrentLine); // chama a funçao pra ler
                            inserirInicio(joguim);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(entrada.equals("IF"))
            {
                entrada=a.next();
                try {
                    String strCurrentLine;
                    leitorObj = new BufferedReader(new FileReader("games.csv"));
                    while ((strCurrentLine = leitorObj.readLine()) != null) {
                        String[] id = strCurrentLine.split(",", 0);
                        Game joguim = new Game(id[0]);
                        if (id[0].equals(entrada)) {
                            joguim.leitura(strCurrentLine); // chama a funçao pra ler
                            inserirFim(joguim);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(entrada.equals("I*"))
            {
                pos=a.nextInt();
                entrada=a.next();
                try {
                    String strCurrentLine;
                    leitorObj = new BufferedReader(new FileReader("games.csv"));
                    while ((strCurrentLine = leitorObj.readLine()) != null) {
                        String[] id = strCurrentLine.split(",", 0);
                        Game joguim = new Game(id[0]);
                        if (id[0].equals(entrada)) {
                            joguim.leitura(strCurrentLine); // chama a funçao pra ler
                            inserir(joguim,pos);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(entrada.equals("RF"))
            {
                removerFim();
            }if(entrada.equals("RI"))
            {
                removerInicio();
            }if(entrada.equals("R*"))
            {
                pos=a.nextInt();
                remover(pos);
            }
            entrada=a.next();
            input--;
        }
    }
}