import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.io.*;

class Game {

    static SimpleDateFormat default_dateFormat = new SimpleDateFormat("MMM/yyyy", Locale.ENGLISH);

    private String name, owners, website, developers;
    private ArrayList<String> languages, genres;
    private Date release_date;
    private int app_id, age, dlcs, avg_playtime;
    private float price, upvotes;
    private boolean windows, mac, linux;
    public Game prox;

    public Game() {
        this.name = this.owners = this.website = this.developers = null;
        this.languages = new ArrayList<String>();
        this.genres = new ArrayList<String>();
        this.release_date = null;
        this.app_id = this.age = this.dlcs = this.avg_playtime = -1;
        this.price = this.upvotes = -1;
        this.windows = this.mac = this.linux = false;
    }

    public Game(String id) {
        this.app_id = Integer.parseInt(id);
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
     * Metodo para ler Games de um arquivo em path a partir do ID de entrada
     */
    public void readClass(String input, String path) {
        String line = "";
        char c_search;
        int index = 0, atr_index = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
            do {
                line = br.readLine();
            } while (line.split(",")[0].compareTo(input) != 0);
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

    public void imprimir(int i) {
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
        System.out.println("[" + i + "] " + this.app_id + " " + this.name + " "
                + default_dateFormat.format(this.release_date) + " "
                + this.owners + " " + this.age + " " + String.format(Locale.US, "%.2f", this.price) + " " + this.dlcs
                + " "
                + this.languages + " " + this.website + " " + this.windows + " " + this.mac + " " + this.linux + " "
                + (Float.isNaN(this.upvotes) ? "0.0% " : df.format(this.upvotes) + "% ") + avg_pt + this.developers
                + " " + this.genres);
    }
}
/*
class Lista {
    public Game primeiro;
    public Game ultimo;

    /*
     * Construtor da classe que cria uma lista sem elementos (somente no cabeca).

    public Lista() {
        primeiro = new Game();
        ultimo = primeiro;
    }

    /**
     * Insere um elemento na primeira posicao da lista.
     * 
     * @param x int elemento a ser inserido.

    public void inserirInicio(Game x) {
        Game tmp = x;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    /**
     * Insere um elemento na ultima posicao da lista.
     * 
     * @param x int elemento a ser inserido.
    
    public void inserirFim(Game x) {
        ultimo.prox = x;
        ultimo = ultimo.prox;
    }

    /**
     * Remove um elemento da primeira posicao da lista.
     * 
     * @return resp int elemento a ser removido.
    
    public String removerInicio() {
        Game tmp = primeiro;
        primeiro = primeiro.prox;
        String resp = primeiro.getName();
        tmp.prox = null;
        tmp = null;
        return resp;
    }

    /**
     * Remove um elemento da ultima posicao da lista.
     * 
     * @return resp int elemento a ser removido.
    
    public String removerFim() {
        Game i;
        for (i = primeiro; i.prox != ultimo; i = i.prox)
            ;

        String resp = ultimo.getName();
        ultimo = i;
        i = ultimo.prox = null;

        return resp;
    }

    /**
     * Insere um elemento em uma posicao especifica considerando que o
     * primeiro elemento valido esta na posicao 0.
     * 
     * @param x   int elemento a ser inserido.
     * @param pos int posicao da insercao.
    
    public void inserir(Game x, int pos) {

        int tamanho = tamanho();

        if (pos < 0 || pos > tamanho) {
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho) {
            inserirFim(x);
        } else {
            // Caminhar ate a posicao anterior a insercao
            Game i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            Game tmp = x;
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;
        }
    }

    /**
     * Remove um elemento de uma posicao especifica da lista
     * considerando que o primeiro elemento valido esta na posicao 0.
     * 
     * @param posicao Meio da remocao.
     * @return resp int elemento a ser removido.
    
    public String remover(int pos) {
        String resp = "aaaaa";
        int tamanho = tamanho();

        if (primeiro == ultimo) {
        } else if (pos < 0 || pos >= tamanho) {
        } else if (pos == 0) {
            resp = removerInicio();
        } else if (pos == tamanho - 1) {
            resp = removerFim();
        } else {
            // Caminhar ate a posicao anterior a insercao
            Game i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;
            Game tmp = i.prox;
            resp = tmp.getName();
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
        }
        return resp;
    }

    /**
     * Calcula e retorna o tamanho, em numero de elementos, da lista.
     * 
     * @return resp int tamanho
    
    public int tamanho() {
        int tamanho = 0;
        for (Game i = primeiro; i != ultimo; i = i.prox, tamanho++)
            ;
        return tamanho;
    }
}*/

class Pilha {
	public Game topo;
	/**
	 * Construtor da classe que cria uma fila sem elementos.
	 */
	public Pilha() {
		topo = null;
	}

	/**
	 * Insere elemento na pilha (politica FILO).
	 * 
	 * @param x int elemento a inserir.
	 */
	public void inserir(Game x) {
		Game tmp = x;
		tmp.prox = topo;
		topo = tmp;
		tmp = null;
	}

	/**
	 * Remove elemento da pilha (politica FILO).
	 * 
	 * @return Elemento removido.
	 * @trhows Exception Se a sequencia nao contiver elementos.
	 */
	public String remover(){
		String resp = topo.getName();
		Game tmp = topo;
		topo = topo.prox;
		tmp.prox = null;
		tmp = null;
		return resp;
	}
    public void mostraPilha() {
		mostraPilha(topo);
	}
    private int j;
	private void mostraPilha(Game i) {
		if (i != null) {
			mostraPilha(i.prox);
			i.imprimir(j++);
		}
	}
}

public class Two {
    public static void main(String args[]) {
        String input01;
        //Lista listinha = new Lista();
        Pilha pilhinha =new Pilha();
        input01 = MyIO.readLine();
        do {
            Game jogo = new Game();
            jogo.readClass(input01, "/tmp/games.csv");
            pilhinha.inserir(jogo);
            input01 = MyIO.readLine();
        } while (!input01.equals("FIM"));
        int count = MyIO.readInt();
        while (count > 0) {
            input01 = MyIO.readString();
            Game jogo = new Game();
            if (input01.equals("I")) {
                input01 = MyIO.readLine();
                jogo.readClass(input01, "/tmp/games.csv");
                pilhinha.inserir(jogo);
            }
            if (input01.equals("R")) {
                System.out.println("(R) " + pilhinha.remover());
            }
            count--;
        }
        pilhinha.mostraPilha();
    }
}
