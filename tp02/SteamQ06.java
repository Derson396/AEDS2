import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.nio.charset.*;
import java.util.Arrays;

/**
 * Classe game do Github.
 */
class Game {

    static SimpleDateFormat default_dateFormat = new SimpleDateFormat("MMM/yyyy", Locale.ENGLISH);

    private String name, owners, website, developers;
    private ArrayList<String> languages, genres;
    private Date release_date;
    private int app_id, age, dlcs, avg_playtime;
    private float price, upvotes;
    private boolean windows, mac, linux;

    public Game() {
        this.name = this.owners = this.website = this.developers = null;
        this.languages = new ArrayList<String>();
        this.genres = new ArrayList<String>();
        this.release_date = null;
        this.app_id = this.age = this.dlcs = this.avg_playtime = -1;
        this.price = this.upvotes = -1;
        this.windows = this.mac = this.linux = false;
    }

    public Game(String name, String owners, String website, String developers, ArrayList<String> languages,
            ArrayList<String> genres, Date release_date, int app_id, int age, int dlcs, int upvotes, int avg_playtime,
            float price, boolean windows, boolean mac, boolean linux) {
        this.name = name;
        this.owners = owners;
        this.website = website;
        this.developers = developers;
        this.languages = languages;
        this.genres = genres;
        this.release_date = release_date;
        this.app_id = app_id;
        this.age = age;
        this.dlcs = dlcs;
        this.upvotes = upvotes;
        this.avg_playtime = avg_playtime;
        this.price = price;
        this.windows = windows;
        this.mac = mac;
        this.linux = linux;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public void setReleaseDate(Date release_date) {
        this.release_date = release_date;
    }

    public void setAppId(int app_id) {
        this.app_id = app_id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDlcs(int dlcs) {
        this.dlcs = dlcs;
    }

    public void setAvgPt(int avg_playtime) {
        this.avg_playtime = avg_playtime;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setUpvotes(float upvotes) {
        this.upvotes = upvotes;
    }

    public void setWindows(boolean windows) {
        this.windows = windows;
    }

    public void setMac(boolean mac) {
        this.mac = mac;
    }

    public void setLinux(boolean linux) {
        this.linux = linux;
    }

    public String getName() {
        return this.name;
    }

    public String getOwners() {
        return this.owners;
    }

    public String getWebsite() {
        return this.website;
    }

    public String getDevelopers() {
        return this.developers;
    }

    public ArrayList<String> getLanguages() {
        return this.languages;
    }

    public ArrayList<String> getGenres() {
        return this.genres;
    }

    public Date getReleaseDate() {
        return this.release_date;
    }

    public int getAppId() {
        return this.app_id;
    }

    public int getAge() {
        return this.age;
    }

    public int getDlcs() {
        return this.dlcs;
    }

    public int getAvgPt() {
        return this.avg_playtime;
    }

    public float getPrice() {
        return this.price;
    }

    public float getUpvotes() {
        return this.upvotes;
    }

    public boolean getWindows() {
        return this.windows;
    }

    public boolean getMac() {
        return this.mac;
    }

    public boolean getLinux() {
        return this.linux;
    }

    public Game clone() {
        Game cloned = new Game();
        cloned.name = this.name;
        cloned.owners = this.owners;
        cloned.website = this.website;
        cloned.developers = this.developers;
        cloned.languages = this.languages;
        cloned.genres = this.genres;
        cloned.release_date = this.release_date;
        cloned.app_id = this.app_id;
        cloned.age = this.age;
        cloned.dlcs = this.dlcs;
        cloned.avg_playtime = this.avg_playtime;
        cloned.price = this.price;
        cloned.upvotes = this.upvotes;
        cloned.windows = this.windows;
        cloned.mac = this.mac;
        cloned.linux = this.linux;
        return cloned;
    }

    public Game clone2(Game atual) {
        this.name = atual.name;
        this.owners = atual.owners;
        this.website = atual.website;
        this.developers = atual.developers;
        this.languages = atual.languages;
        this.genres = atual.genres;
        this.release_date = atual.release_date;
        this.app_id = atual.app_id;
        this.age = atual.age;
        this.dlcs = atual.dlcs;
        this.avg_playtime = atual.avg_playtime;
        this.price = atual.price;
        this.upvotes = atual.upvotes;
        this.windows = atual.windows;
        this.mac = atual.mac;
        this.linux = atual.linux;
        return this;
    }

    /**
     * Metodo parecido com void ler() com pequenas modificações com a finalidade de
     * ler do arquivo se for o id desejado
     */
    public void readClass(String input, String path) {
        float p = 0, s = 0;
        String line = "";
        int i = 0;
        int n = 0;
        int m = 0;
        char c_search;
        int index = 0, atr_index = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {

            do {
                line = br.readLine();
            } while (line.split(",")[0].compareTo(input) != 0);

            String lineGame[] = line.split(",");

            while (true) {
                index++;
                if (line.charAt(index) == ',') {
                    this.app_id = Integer.parseInt(line.substring(atr_index, index));
                    atr_index = ++index;
                    break;
                }
            }

            if (line.charAt(atr_index) != ',') {
                if (line.charAt(atr_index) == '\"') {
                    atr_index++;
                    c_search = '\"';
                } else
                    c_search = ',';
                while (true) {
                    index++;
                    if (line.charAt(index) == c_search) {
                        this.name = line.substring(atr_index, index);
                        if (c_search == ',')
                            index++;
                        else if (c_search == '\"')
                            index += 2;
                        atr_index = index;
                        break;
                    }
                }
            } else
                atr_index = ++index;

            if (line.charAt(atr_index) != ',') {
                SimpleDateFormat df;
                if (line.charAt(atr_index) == '\"') {
                    df = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
                    atr_index++;
                    c_search = '\"';
                } else {
                    df = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
                    c_search = ',';
                }
                while (true) {
                    index++;
                    if (line.charAt(index) == c_search) {
                        try {
                            this.release_date = df.parse(line.substring(atr_index, index));
                        } catch (java.text.ParseException e) {
                            e.printStackTrace();
                        }
                        if (c_search == ',')
                            index++;
                        else if (c_search == '\"')
                            index += 2;
                        atr_index = index;
                        break;
                    }
                }
            } else
                atr_index = ++index;

            while (true) {
                index++;
                if (line.charAt(index) == ',') {
                    this.owners = line.substring(atr_index, index);
                    atr_index = ++index;
                    break;
                }
            }

            while (true) {
                index++;
                if (line.charAt(index) == ',') {
                    this.age = Integer.parseInt(line.substring(atr_index, index));
                    atr_index = ++index;
                    break;
                }
            }

            while (true) {
                index++;
                if (line.charAt(index) == ',') {
                    this.price = Float.parseFloat(line.substring(atr_index, index));
                    atr_index = ++index;
                    break;
                }
            }

            while (true) {
                index++;
                if (line.charAt(index) == ',') {
                    this.dlcs = Integer.parseInt(line.substring(atr_index, index));
                    atr_index = ++index;
                    break;
                }
            }

            while (true) {
                index++;
                if (line.charAt(index) == ']') {
                    index++;
                    if (line.charAt(index) == ',')
                        index++;
                    else if (line.charAt(index) == '\"')
                        index += 2;
                    atr_index = index;
                    break;
                } else if (line.charAt(index) == '\'') {
                    int wordStart = index + 1;
                    while (true) {
                        index++;
                        if (line.charAt(index) == '\'') {
                            this.languages.add(line.substring(wordStart, index));
                            break;
                        }
                    }
                }
            }

            if (line.charAt(atr_index) != ',') {
                if (line.charAt(atr_index) == '\"') {
                    atr_index++;
                    c_search = '\"';
                } else
                    c_search = ',';

                while (true) {
                    index++;
                    if (line.charAt(index) == c_search) {
                        this.website = line.substring(atr_index, index);
                        atr_index = ++index;
                        break;
                    }
                }
            } else
                atr_index = ++index;

            while (true) {
                index++;
                if (line.charAt(index) == ',') {
                    this.windows = Boolean.parseBoolean(line.substring(atr_index, index));
                    atr_index = ++index;
                    break;
                }
            }

            while (true) {
                index++;
                if (line.charAt(index) == ',') {
                    this.mac = Boolean.parseBoolean(line.substring(atr_index, index));
                    atr_index = ++index;
                    break;
                }
            }

            while (true) {
                index++;
                if (line.charAt(index) == ',') {
                    this.linux = Boolean.parseBoolean(line.substring(atr_index, index));
                    atr_index = ++index;
                    break;
                }
            }

            int positives, negatives;
            while (true) {
                index++;
                if (line.charAt(index) == ',') {
                    positives = Integer.parseInt(line.substring(atr_index, index));
                    atr_index = ++index;
                    break;
                }
            }

            while (true) {
                index++;
                if (line.charAt(index) == ',') {
                    negatives = Integer.parseInt(line.substring(atr_index, index));
                    atr_index = ++index;
                    break;
                }
            }
            this.upvotes = (float) (positives * 100) / (float) (positives + negatives);

            while (true) {
                index++;
                if (line.charAt(index) == ',') {
                    this.avg_playtime = Integer.parseInt(line.substring(atr_index, index));
                    atr_index = ++index;
                    break;
                }
            }

            if (line.charAt(atr_index) != ',') {
                if (line.charAt(atr_index) == '\"') {
                    atr_index++;
                    c_search = '\"';
                } else
                    c_search = ',';
                while (true) {
                    index++;
                    if (line.charAt(index) == c_search) {
                        this.developers = line.substring(atr_index, index);
                        atr_index = ++index;
                        break;
                    }
                }
            } else
                atr_index = ++index;

            if (index < line.length() - 1) {
                if (line.charAt(index) == ',')
                    atr_index = ++index;
                if (line.charAt(atr_index) == '\"') {
                    atr_index++;
                    while (true) {
                        index++;
                        if (line.charAt(index) == ',') {
                            this.genres.add(line.substring(atr_index, index));
                            atr_index = ++index;
                        } else if (line.charAt(index) == '\"') {
                            this.genres.add(line.substring(atr_index, line.length() - 1));
                            break;
                        }
                    }
                } else
                    this.genres.add(line.substring(atr_index, line.length()));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File cannot be read");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ler(String line) {
        char c_search;
        int index = 0, atr_index = 0;
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.app_id = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }
        if (line.charAt(atr_index) != ',') {
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';
            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    this.name = line.substring(atr_index, index);
                    if (c_search == ',')
                        index++;
                    else if (c_search == '\"')
                        index += 2;
                    atr_index = index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        if (line.charAt(atr_index) != ',') {
            SimpleDateFormat df;
            if (line.charAt(atr_index) == '\"') {
                df = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
                atr_index++;
                c_search = '\"';
            } else {
                df = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
                c_search = ',';
            }
            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    try {
                        this.release_date = df.parse(line.substring(atr_index, index));
                    } catch (java.text.ParseException e) {
                        e.printStackTrace();
                    }
                    if (c_search == ',')
                        index++;
                    else if (c_search == '\"')
                        index += 2;
                    atr_index = index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.owners = line.substring(atr_index, index);
                atr_index = ++index;
                break;
            }
        }
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.age = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.price = Float.parseFloat(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.dlcs = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }
        while (true) {
            index++;
            if (line.charAt(index) == ']') {
                index++;
                if (line.charAt(index) == ',')
                    index++;
                else if (line.charAt(index) == '\"')
                    index += 2;
                atr_index = index;
                break;
            } else if (line.charAt(index) == '\'') {
                int wordStart = index + 1;
                while (true) {
                    index++;
                    if (line.charAt(index) == '\'') {
                        this.languages.add(line.substring(wordStart, index));
                        break;
                    }
                }
            }
        }

        if (line.charAt(atr_index) != ',') {
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';

            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    this.website = line.substring(atr_index, index);
                    atr_index = ++index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.windows = Boolean.parseBoolean(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.mac = Boolean.parseBoolean(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.linux = Boolean.parseBoolean(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }
        int positives, negatives;
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                positives = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                negatives = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }
        this.upvotes = (float) (positives * 100) / (float) (positives + negatives);
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.avg_playtime = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }
        if (line.charAt(atr_index) != ',') {
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';
            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    this.developers = line.substring(atr_index, index);
                    atr_index = ++index;
                    break;
                }
            }
        } else
            atr_index = ++index;
        if (index < line.length() - 1) {
            if (line.charAt(index) == ',')
                atr_index = ++index;
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                while (true) {
                    index++;
                    if (line.charAt(index) == ',') {
                        this.genres.add(line.substring(atr_index, index));
                        atr_index = ++index;
                    } else if (line.charAt(index) == '\"') {
                        this.genres.add(line.substring(atr_index, line.length() - 1));
                        break;
                    }
                }
            } else
                this.genres.add(line.substring(atr_index, line.length()));
        }
    }

    public void imprimir() {
        String avg_pt = null;
        if (this.avg_playtime == 0)
            avg_pt = "null ";
        else if (this.avg_playtime < 60)
            avg_pt = this.avg_playtime + "m ";
        else {
            if (this.avg_playtime % 60 == 0)
                avg_pt = this.avg_playtime / 60 + "h ";
            else
                avg_pt = (this.avg_playtime / 60) + "h " + (this.avg_playtime % 60) + "m ";
        }

        DecimalFormat df = new DecimalFormat("##");
        System.out.println(this.app_id + " " + this.name + " " + default_dateFormat.format(this.release_date) + " "
                + this.owners + " " + this.age + " " + String.format(Locale.US, "%.2f", this.price) + " " + this.dlcs
                + " "
                + this.languages + " " + this.website + " " + this.windows + " " + this.mac + " " + this.linux + " "
                + (Float.isNaN(this.upvotes) ? "0.0% " : df.format(this.upvotes) + "% ") + avg_pt + this.developers
                + " " + this.genres);
    }

}

/**
 * Lista estatica (author Max do Val Machado) adaptada para a classe Game
 */
class Lista {
    private Game[] array;
    private int n = 0;

    /**
     * Construtor da classe.
     */
    public Lista() {
        this(6);
    }

    /**
     * Construtor da classe.
     */
    public Lista(int tamanho) {
        array = new Game[tamanho];
        n = 0;
    }

    /**
     * Insere um elemento na primeira posicao da lista e move os demais elementos
     * para o fim da lista.
     */
    public void inserirInicio(Game x) throws Exception {

        // validar insercao
        if (n >= array.length) {
            throw new Exception("Erro ao inserir!");
        }

        // levar elementos para o fim do array
        for (int i = n; i > 0; i--) {
            array[i] = array[i - 1].clone();
        }

        array[0] = x.clone();
        n++;
    }

    /**
     * Insere um elemento na ultima posicao da lista.
     */
    public void inserirFim(Game x) throws Exception {

        // validar insercao
        if (n >= array.length) {
            throw new Exception("Erro ao inserir!");
        }

        array[n] = x.clone();
        n++;
    }

    /**
     * Insere um elemento em uma posicao especifica e move os demais elementos para
     * o fim da lista.
     */
    public void inserir(Game x, int pos) throws Exception {

        // validar insercao
        if (n >= array.length || pos < 0 || pos > n) {
            throw new Exception("Erro ao inserir!");
        }

        // levar elementos para o fim do array
        for (int i = n; i > pos; i--) {
            array[i] = array[i - 1].clone();
        }

        array[pos] = x.clone();
        n++;
    }

    /**
     * Remove um elemento da primeira posicao da lista e movimenta os demais
     * elementos para o inicio da mesma.
     */
    public Game removerInicio() throws Exception {

        // validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }

        Game resp = new Game();
        resp = resp.clone2(array[0]);
        n--;

        for (int i = 0; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    /**
     * Remove um elemento da ultima posicao da lista.
     */
    public Game removerFim() throws Exception {

        // validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }

        return array[--n];
    }

    /**
     * Remove um elemento de uma posicao especifica da lista e movimenta os demais
     * elementos para o inicio da mesma.
     */
    public Game remover(int pos) throws Exception {

        // validar remocao
        if (n == 0 || pos < 0 || pos >= n) {
            throw new Exception("Erro ao remover!");
        }

        Game resp = new Game();
        resp = resp.clone2(array[0]);
        n--;

        for (int i = pos; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    public void imprimirLista() {
        for (int i = 0; i < n; i++) {
            array[i].imprimir();
        }
    }

    public void imprimirLista2() {
        for (int i = 0; i < n; i++) {
            System.out.print("[" + i + "] ");
            array[i].imprimir();
        }
    }

    public int getSize() {
        return this.n;
    }

    public Game getGame(int index) {
        return this.array[index];
    }

    /**
     * Procura um elemento e retorna se ele existe.
     * 
     * @param x int elemento a ser pesquisado.
     * @return <code>true</code> se o array existir,
     *         <code>false</code> em caso contrario.
     */
    public boolean pesquisaSequencial(String x) {
        boolean retorno = false;
        for (int i = 0; i < n && retorno == false; i++) {
            retorno = (array[i].getName().equals(x));
        }
        return retorno;
    }

    public boolean pesqSeq(int[] vet, int x) {
        boolean resp = false;
        int n = vet.length;

        for (int i = 0; i < n; i++) {
            if (vet[i] == x) {
                resp = true;
                i = n;
            }
        }
        return resp;
    }

    public boolean pesquisaBinaria(String x) {
        boolean resp = false;
        int dir = (this.n - 1), esq = 0, meio;

        while (esq <= dir) {
            meio = (esq + dir) / 2;
            if (array[meio].getName().equals(x)) {
                resp = true;
                esq = dir + 1;
            } else if (array[meio].getName().compareTo(x) < 0) { // (x > vet[meio])
                esq = meio + 1;
            } else {
                dir = meio - 1;
            }
        }
        return resp;
    }
}
// FIM Classe Lista --------------------------------------------------------

/**
 * Lista estatica (author Max do Val Machado) adaptada para PILHA a classe Game
 * PILHA
 */
class Pilha {
    private Game[] array;
    private int n = 0;

    /**
     * Construtor da classe.
     */
    public Pilha() {
        this(6);
    }

    /**
     * Construtor da classe.
     */
    public Pilha(int tamanho) {
        array = new Game[tamanho];
        n = 0;
    }

    /**
     * Insere um elemento na ultima posicao da Pilha.
     */
    public void empilhar(Game x) throws Exception {

        // validar insercao
        if (n >= array.length) {
            throw new Exception("Erro ao inserir!");
        }

        array[n] = x.clone();
        n++;
    }

    /**
     * Remove um elemento da ultima posicao da Pilha.
     */
    public Game desempilhar() throws Exception {

        // validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }

        return array[--n];
    }

    public void imprimirPilha() {
        for (int i = 0; i < n; i++) {
            array[i].imprimir();
        }
    }

    public void imprimirPilha2() {
        for (int i = 0; i < n; i++) {
            System.out.print("[" + i + "] ");
            array[i].imprimir();
        }
    }

    public int getSize() {
        return this.n;
    }

    public Game getGame(int index) {
        return this.array[index];
    }

    /**
     * Procura um elemento e retorna se ele existe.
     */
    public boolean pesquisaSequencial(String x) {
        boolean retorno = false;
        for (int i = 0; i < n && retorno == false; i++) {
            retorno = (array[i].getName().equals(x));
        }
        return retorno;
    }

    public boolean pesquisaBinaria(String x) {
        boolean resp = false;
        int dir = (this.n - 1), esq = 0, meio;

        while (esq <= dir) {
            meio = (esq + dir) / 2;
            if (array[meio].getName().equals(x)) {
                resp = true;
                esq = dir + 1;
            } else if (array[meio].getName().compareTo(x) < 0) { // (x > vet[meio])
                esq = meio + 1;
            } else {
                dir = meio - 1;
            }
        }
        return resp;
    }
}
// FIM Classe Lista --------------------------------------------------------

// classe principal
public class SteamQ06 {

    static Pilha pilhaGames = new Pilha(5000);

    public static void main(String args[]) throws Exception {
        String[] input01 = new String[1000];
        String[] input02 = new String[1000];
        int lineCount = -1;
        int count01 = -1;
        int count02 = -1;
        int comandsLenght = 0;

        do {
            lineCount++;
            count01++;
            input01[count01] = MyIO.readLine();
        } while (!(input01[count01]).equals("FIM"));
        comandsLenght = Integer.parseInt(MyIO.readLine());
        do {
            lineCount++;
            count02++;
            input02[count02] = MyIO.readLine();
            comandsLenght--;
        } while (comandsLenght > 0);

        for (int i = 0; i < count01; i++) {
            Game joguim = new Game();
            joguim.readClass(input01[i], "/tmp/games.csv");
            pilhaGames.empilhar(joguim);
        }
        for (int i = 0; i < count02 + 1; i++) {
            Game joguim = new Game();

            if (input02[i].split(" ")[0].compareTo("I") == 0) {
                joguim.readClass(input02[i].split(" ")[1], "/tmp/games.csv");
                pilhaGames.empilhar(joguim);

            } else if (input02[i].split(" ")[0].compareTo("R") == 0) {
                joguim = pilhaGames.desempilhar();
                System.out.print("(R) " + joguim.getName() + "\n");

            }
        }

        // mostrar a pilha de Games
        pilhaGames.imprimirPilha2();

    }
}