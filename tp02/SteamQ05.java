import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

class Game { // CLASSE GAME
	private int app_id, age, dlcs, avg_pt;
	private float price, upvotes;
	private String name, owners, website, developers;
	private String data;
	private String[] languages, genres;
	private java.util.Date release_date;
	private Boolean windows, mac, linux;

	public Game(int app_id, int age, int dlcs, int avg_pt, float price, float upvotes, String name, String owners,
			String website, String developers, String[] languages, String[] genres, java.util.Date release_date) { // construtor
		// completo
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

	public Game() { // construtor vazio

	}

	public Game(String id) { // construtor com apenas app_id(usado na leitura)
		this.app_id = Integer.parseInt(id);
	}

	public Game(int id) { // construtor com apenas app_id(usado na leitura)
		this.app_id = id;
	}

	public int getApp_id() {
		return this.app_id;
	}

	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getOwners() {
		return this.owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	public String getWebsite() {
		return this.website;
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

	public String[] getLanguages() {
		return this.languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public String[] getGenres() {
		return this.genres;
	}

	public void setGenres(String[] genres) {
		this.genres = genres;
	}

	public java.util.Date getRelease_date() {
		return this.release_date;
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

	public Boolean getMac() {
		return this.mac;
	}

	public void setMac(Boolean mac) {
		this.mac = mac;
	}

	public Boolean getLinux() {
		return this.linux;
	}

	public void setLinux(Boolean linux) {
		this.linux = linux;
	}

	public String fazerData(String inputData) { // METODO PARA FAZER DATA
		if (inputData.length() > 10) {
			String[] tmpData = inputData.split(",");
			String mes = "" + tmpData[0].charAt(0) + tmpData[0].charAt(1) + tmpData[0].charAt(2);
			String outputData = mes + "/" + tmpData[tmpData.length - 1].substring(1);
			return outputData;
		} else {
			String[] tmpData = inputData.split(" ");
			String outputData = tmpData[0] + "/" + tmpData[tmpData.length - 1];
			return outputData;
		}
	}

	public String calcularHoras() { // metodo para calcular horas e minutos e criar string com formato ideal para a
									// saida
		if (this.avg_pt == 0) {
			return null;
		} else {
			int horas = Math.round((float) (this.avg_pt / 60));
			int minutos = Math.round(this.avg_pt % 60);
			String time = (Integer.toString(horas) + "h " + Integer.toString(minutos) + "m");
			return time;
		}
	}

	public void calcularPorcentagem(float u, float d) { // calcular porcentagem dos upvotes
		this.upvotes = (u / (u + d) * 100);
	}

	public String fazerStringPorcentagem() { // metodo para fazer string ideal para a saída da porcentagem dos upvotes
		int tmp = Math.round(this.upvotes);
		String porcentagem = (Integer.toString(tmp) + "%");
		return porcentagem;
	}

	public void checkIfWebsiteNull() {
		if (this.website == "") {
			this.website = null;
		}
	}

	public void ler(String input) throws IOException { // METODO PARA LER LINHA DE GAMES.CSV E GUARDAR ATRIBUTOS EM SUAS
														// VARIÁVEIS
		DateFormat df = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
		DateFormat df2 = new SimpleDateFormat("MMM yyyy", Locale.US);
		int controle = 0;
		int numVirgulas = 0;
		String tmp = input;
		for (int i = 2; i < input.length(); i++) {
			if (input.charAt(i - 2) == ',') // contar virgulas
			{
				numVirgulas++;
			}
			if (controle == 0 && input.charAt(i - 1) == '\"' && input.charAt(i + 1) != '[') // ler nome com " "
			{
				controle++;
				String tmpName = "";
				for (int cn = 1; tmp.charAt(cn) != '\"'; cn++) {
					if (tmp.charAt(cn) == ',') {
						numVirgulas--;
					}
					tmpName += tmp.charAt(cn);
				}
				this.name = tmpName;
			} else if (controle == 0 && numVirgulas == 1) // ler nome
			{
				controle++;
				this.name = tmp.split(",")[0];
			}
			if (controle == 1 && numVirgulas == 2) // ler data
			{
				controle++;
				String tmpData = "";
				if (tmp.charAt(0) == '\"') {
					tmp = tmp.substring(1);
					tmpData = tmp.split("\"")[0];
				} else {
					tmpData = tmp.split(",")[0];
				}
				if (tmpData.length() > 10) {
					numVirgulas--; // tirar virgula dentro da data da contagem
					try {
						this.release_date = df.parse(tmpData);
						this.data = this.fazerData(tmpData);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				} else {
					try {
						this.release_date = df2.parse(tmpData);
						this.data = this.fazerData(tmpData);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
			if (controle == 2 && numVirgulas == 3) // ler owners
			{
				controle++;
				this.owners = tmp.split(",")[0];
			}
			if (controle == 3 && numVirgulas == 4) { // ler age
				controle++;
				this.age = Integer.parseInt(tmp.split(",")[0]);
			}
			if (controle == 4 && numVirgulas == 5) { // ler preco
				controle++;
				this.price = Float.parseFloat(tmp.split(",")[0]);
			}
			if (controle == 5 && numVirgulas == 6) { // ler dlcs
				controle++;
				this.dlcs = Integer.parseInt(tmp.split(",")[0]);
			}
			if (controle == 6 && numVirgulas == 7 && tmp.charAt(0) == '[') { // ler languages
				controle++;
				String tmpLang;
				tmpLang = tmp.split("']")[0];
				tmpLang += "'";
				tmpLang = tmpLang.replaceAll("\'", "");
				this.languages = tmpLang.split(", ");
				this.languages[0] = this.languages[0].substring(1);
				String strLang = Arrays.toString(this.languages);
				for (int cl = 0; cl < strLang.length(); cl++) // contar virgulas das linguagens
				{
					if (strLang.charAt(cl) == ',') {
						numVirgulas--;
					}
				}
			}
			if (controle == 7 && numVirgulas == 8) { // ler website
				controle++;
				if (tmp.charAt(0) == '\"') {
					tmp = tmp.substring(1);
					this.website = tmp.split("\"")[0];
					for (int cw = 0; cw < this.website.length(); cw++) // contar virgulas do website
					{
						if (this.website.charAt(cw) == ',') {
							numVirgulas--;
						}
					}
				}
				this.website = tmp.split(",")[0];
			}
			if (controle == 8 && numVirgulas == 9) { // ler windows
				controle++;
				this.windows = Boolean.parseBoolean(tmp.split(",")[0]);
			}
			if (controle == 9 && numVirgulas == 10) { // ler mac
				controle++;
				this.mac = Boolean.parseBoolean(tmp.split(",")[0]);
			}
			if (controle == 10 && numVirgulas == 11) { // ler linux
				controle++;
				this.linux = Boolean.parseBoolean(tmp.split(",")[0]);
			}
			if (controle == 11 && numVirgulas == 12) { // ler upvotes
				controle++;
				String[] tmpUpvotes = tmp.split(",", 3);
				float up = Float.parseFloat(tmpUpvotes[0]);
				float down = Float.parseFloat(tmpUpvotes[1]);
				this.calcularPorcentagem(up, down); // calcular porcentagem de upvotes
			}
			if (controle == 12 && numVirgulas == 14) { // ler avg_pt(average play time = minutos)
				controle++;
				this.avg_pt = Integer.parseInt(tmp.split(",")[0]);
			}
			if (controle == 13 && numVirgulas == 15) { // ler developers
				controle++;
				if (tmp.charAt(0) == '\"') {
					tmp = tmp.substring(1);
					this.developers = tmp.split("\"")[0];
					for (int cd = 0; cd < this.developers.length(); cd++) // contar virgulas dos developers
					{
						if (this.developers.charAt(cd) == ',') {
							numVirgulas--;
						}
					}
				} else {
					this.developers = tmp.split(",")[0];
				}
			}
			if (controle == 14 && numVirgulas == 16) { // ler genres
				controle++;
				tmp = tmp.replaceAll("\"", "");
				this.genres = tmp.split(",");
			}
			tmp = input.substring(i); // tirar parte da string que já "passou" pelo for
		}
		this.checkIfWebsiteNull();
	}

	public void imprimir() { // metodo para imprimir saida
		MyIO.println(this.getApp_id() + " " + this.getName() + " " + this.data + " " + this.getOwners() + " "
				+ this.getAge() + " " + this.getPrice() + " " + this.getDlcs() + " "
				+ Arrays.toString(this.getLanguages()) + " " + this.getWebsite() + " " + this.getWindows() + " "
				+ this.getMac() + " " + this.getLinux() + " " + this.fazerStringPorcentagem() + " "
				+ this.calcularHoras() + " " + this.getDevelopers() + " " + Arrays.toString(this.getGenres()));
	}

	public static boolean pesquisaBinaria(String nome, String[] gameNames) { // PESQUISA BINARIA
		int inicio = 0;
		int meio = 0;
		int fim = gameNames.length - 1;
		while (inicio <= fim) {
			meio = (fim + inicio) / 2;
			if (gameNames[meio].equals(nome)) {
				return true;
			} else if (nome.compareTo(gameNames[meio]) > 0) {
				inicio = meio + 1;
			} else {
				fim = meio - 1;
			}
		}
		return false;

	}
}

/**
 * Lista estatica
 * 
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Lista {
	private int[] array;
	private int n;

	/**
	 * Construtor da classe.
	 */
	public Lista() {
		this(6);
	}

	/**
	 * Construtor da classe.
	 * 
	 * @param tamanho Tamanho da lista.
	 */
	public Lista(int tamanho) {
		array = new int[tamanho];
		n = 0;
	}

	/**
	 * Insere um elemento na primeira posicao da lista e move os demais elementos
	 * para o fim da lista.
	 * 
	 * @param x int elemento a ser inserido.
	 * @throws Exception Se a lista estiver cheia.
	 */
	public void inserirInicio(int x) throws Exception {

		// validar insercao
		if (n >= array.length) {
			throw new Exception("Erro ao inserir!");
		}

		// levar elementos para o fim do array
		for (int i = n; i > 0; i--) {
			array[i] = array[i - 1];
		}

		array[0] = x;
		n++;
	}

	/**
	 * Insere um elemento na ultima posicao da lista.
	 * 
	 * @param x int elemento a ser inserido.
	 * @throws Exception Se a lista estiver cheia.
	 */
	public void inserirFim(int x) throws Exception {

		// validar insercao
		if (n >= array.length) {
			throw new Exception("Erro ao inserir!");
		}

		array[n] = x;
		n++;
	}

	/**
	 * Insere um elemento em uma posicao especifica e move os demais elementos para
	 * o fim da lista.
	 * 
	 * @param x   int elemento a ser inserido.
	 * @param pos Posicao de insercao.
	 * @throws Exception Se a lista estiver cheia ou a posicao invalida.
	 */
	public void inserir(int x, int pos) throws Exception {

		// validar insercao
		if (n >= array.length || pos < 0 || pos > n) {
			throw new Exception("Erro ao inserir!");
		}

		// levar elementos para o fim do array
		for (int i = n; i > pos; i--) {
			array[i] = array[i - 1];
		}

		array[pos] = x;
		n++;
	}

	/**
	 * Remove um elemento da primeira posicao da lista e movimenta os demais
	 * elementos para o inicio da mesma.
	 * 
	 * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista estiver vazia.
	 */
	public int removerInicio() throws Exception {

		// validar remocao
		if (n == 0) {
			throw new Exception("Erro ao remover!");
		}

		int resp = array[0];
		n--;

		for (int i = 0; i < n; i++) {
			array[i] = array[i + 1];
		}

		return resp;
	}

	/**
	 * Remove um elemento da ultima posicao da lista.
	 * 
	 * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista estiver vazia.
	 */
	public int removerFim() throws Exception {

		// validar remocao
		if (n == 0) {
			throw new Exception("Erro ao remover!");
		}

		return array[--n];
	}

	/**
	 * Remove um elemento de uma posicao especifica da lista e movimenta os demais
	 * elementos para o inicio da mesma.
	 * 
	 * @param pos Posicao de remocao.
	 * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
	 */
	public int remover(int pos) throws Exception {

		// validar remocao
		if (n == 0 || pos < 0 || pos >= n) {
			throw new Exception("Erro ao remover!");
		}

		int resp = array[pos];
		n--;

		for (int i = pos; i < n; i++) {
			array[i] = array[i + 1];
		}

		return resp;
	}

	public int getN() {
		return n;
	}

	public int getFromPos(int pos) {
		return array[pos];
	}
}

public class SteamQ05 {
	public static boolean isFim(String palavra) { // Metodo para verificar se "FIM" foi entrado
		return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I'
				&& palavra.charAt(2) == 'M');
	}

	public static void main(String[] args) throws IOException { // METODO MAIN
		long startTime = System.nanoTime();
		List<Game> games = new ArrayList<Game>(); // lista de objetos
		BufferedReader objReader = null;
		try {
			String strCurrentLine;
			objReader = new BufferedReader(new FileReader("/tmp/games.csv"));
			while ((strCurrentLine = objReader.readLine()) != null) {
				String[] id = strCurrentLine.split(",", 0);
				Game jogo = new Game(id[0]);
				jogo.ler(strCurrentLine);
				games.add(jogo); // adiciona jogos a lista de objetos
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Lista lista = new Lista(games.size());
        String[] input01 = new String[1000];
        String[] input02 = new String[1000];
        int lineCount = -1;
        int count01 = -1;
        int count02 = -1;
        int comands = 0;
        do {
            lineCount++;
            count01++;
            input01[count01] = MyIO.readLine();
        } while ( !isFim(input01[count01]) );
        comands = Integer.parseInt(MyIO.readLine());
        do {
            lineCount++;
            count02++;
            input02[count02] = MyIO.readLine();
            comands--;
        } while ( comands > 0 );
		for (int i = 0; i < count01; i++) {
			try {
				lista.inserirFim(Integer.parseInt(input01[i]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < count02 + 1; i++) {
			if (input02[i].split(" ")[0].equals("II")) {
				try {
					lista.inserirInicio(Integer.parseInt(input02[i].split(" ")[1]));
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (input02[i].split(" ")[0].equals("IF")) {
				try {
					lista.inserirFim(Integer.parseInt(input02[i].split(" ")[1]));
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (input02[i].split(" ")[0].equals("RI")) {
				try {
					int removido = lista.removerInicio();
					for (int k = 0; k < games.size(); k++) {
						if (games.get(k).getApp_id() == removido) {
							MyIO.println("(R) " + games.get(k).getName());
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (input02[i].split(" ")[0].equals("RF") || input02[i].split(" ")[0].equals("RF*")) {
				try {
					int removido = lista.removerFim();
					for (int k = 0; k < games.size(); k++) {
						if (games.get(k).getApp_id() == removido) {
							MyIO.println("(R) " + games.get(k).getName());
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (input02[i].split(" ")[0].equals("R*")) {
				try {
					int removido = lista.remover(Integer.parseInt(input02[i].split(" ")[1]));
					for (int k = 0; k < games.size(); k++) {
						if (games.get(k).getApp_id() == removido) {
							MyIO.println("(R) " + games.get(k).getName());
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (input02[i].split(" ")[0].equals("I*")) {
				try {
					lista.inserir(Integer.parseInt(input02[i].split(" ")[2]),
							Integer.parseInt(input02[i].split(" ")[1]));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		for (int j = 0; j < lista.getN(); j++) {
			int controle = 0;
			for (int l = 0; l < games.size(); l++) {
				if (lista.getFromPos(j) == games.get(l).getApp_id() && controle == 0) {
					controle++;
					MyIO.print("[" + j + "] ");
					games.get(l).imprimir();
				}
			}
		}
	}
}