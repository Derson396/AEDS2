
/**
 * TP05 - Questao 5
 * @author Gabriel Oliveira Costa
 * Matrícula: 780119
 */
import java.util.*;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Locale;
import java.text.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.Reader;
import java.io.InputStreamReader;



class GameHash { // CLASSE GAME
	private int app_id, age, dlcs, avg_pt;
	private float price, upvotes;
	private String name, owners, website, developers;
	private String data;
	private String[] languages, genres;
	private java.util.Date release_date;
	private Boolean windows, mac, linux;

	public GameHash(int app_id, int age, int dlcs, int avg_pt, float price, float upvotes, String name, String owners,
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

	public GameHash() { // construtor vazio
		this.app_id = 000;
	}

	public GameHash(String id) { // construtor com apenas app_id(usado na leitura)
		this.app_id = Integer.parseInt(id);
	}

	public GameHash(int id) { // construtor com apenas app_id(usado na leitura)
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

class Hash {
	public static int comp;
	GameHash tabela[];
	int m1, m2, m, reserva;
	final GameHash NULO = new GameHash();;

	public Hash() {
		this(21, 9);
	}

	public Hash(int m1, int m2) {
		this.m1 = m1;
		this.m2 = m2;
		this.m = m1 + m2;
		this.tabela = new GameHash[this.m];
		for (int i = 0; i < m1; i++) {
			tabela[i] = NULO;
		}
		reserva = 0;
	}

	public int h(String elemento) {
		int ascii = 0;
		for (int i = 0; i < elemento.length(); i++) {
			ascii += (int) elemento.charAt(i);
		}
		return ascii % m1;
	}

	public boolean inserir(GameHash elemento) {
		boolean resp = false;
		if (elemento != NULO) {
			int pos = h(elemento.getName());
			if (tabela[pos] == NULO) {
				tabela[pos] = elemento;
				resp = true;
			} else if (reserva < m2) {
				tabela[m1 + reserva] = elemento;
				reserva++;
				resp = true;
			}
		}
		return resp;
	}

	public boolean pesquisar(String elemento) {
		boolean resp = false;
		int pos = h(elemento);
		comp++;
		if (tabela[pos].getName().equals(elemento)) {
			resp = true;
			MyIO.println("=> " + elemento);
			MyIO.println("Posicao: " + pos);
		} else if (tabela[pos] != NULO) {
			for (int i = 0; i < reserva; i++) {
				comp++;
				if (tabela[m1 + i].getName().equals(elemento)) {
					resp = true;
					MyIO.println("=> " + elemento);
					MyIO.println("Posicao: " + pos);
					i = reserva;
				}
			}
		}
		return resp;
	}

	boolean remover(int elemento) {
		boolean resp = false;
		// ...
		return resp;
	}
}

/**
 * Classe para tratar dos objetos games (ler games.csv, guardar em lista, pegar
 * um jogo a partir de seu ID)
 * 
 * @author Gabriel Oliveira Costa
 * @version 1 11/2022
 */
class LerObjetoHash {
	static List<GameHash> games = new ArrayList<GameHash>(); // lista de objetos

	public static void fazerListaGamesCSV() { // metodo para ler games.csv e fazer lista de objetos
		BufferedReader objReader = null;
		try {
			String strCurrentLine;
			objReader = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/games.csv"), "UTF-8"));
			//objReader = new BufferedReader(new FileReader("/tmp/games.csv"));
			//objReader = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/games.csv"), StandardCharsets.UTF_8));			
			while ((strCurrentLine = objReader.readLine()) != null) {
				String[] id = strCurrentLine.split(",", 0);
				GameHash jogo = new GameHash(id[0]);
				jogo.ler(strCurrentLine);
				games.add(jogo); // adiciona jogos a lista de objetos
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static GameHash getFromID(int id) { // metodo para pegar objeto jogo da lista a partir de seu id
		for (int i = 0; i < games.size(); i++) {
			if (games.get(i).getApp_id() == id) {
				return games.get(i);
			}
		}
		return (null);
	}
}

public class Cinco1 {
	public static boolean isFim(String palavra) { // Metodo para verificar se "FIM" foi entrado
		return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I'
				&& palavra.charAt(2) == 'M');
	}

	public static void main(String[] args) throws IOException { // METODO MAIN
		long startTime = System.nanoTime();
		LerObjetoHash.fazerListaGamesCSV();
		Hash hash = new Hash();
		String[] entrada1 = new String[1000];
		int cont1 = -1;
		Scanner sc = new Scanner(System.in);

		// // ler primeira entrada de IDs
		do {
			cont1++;
			entrada1[cont1] = sc.nextLine();
		} while (!isFim(entrada1[cont1]));
		for (int i = 0; i < cont1; i++) {
			try {
				hash.inserir(LerObjetoHash.getFromID(Integer.parseInt(entrada1[i])));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String nomePesq = sc.nextLine();
		while (!isFim(nomePesq)) {
			hash.pesquisar(nomePesq);
			nomePesq = sc.nextLine();
		}
		sc.close();
		long endTime = System.nanoTime();
		long tempoTotal = endTime - startTime;
		try {
			FileWriter fw = new FileWriter("780119_hashReserva.txt");
			fw.write("780119\t" + tempoTotal / 1000000 + "ms\t" + Hash.comp);
			fw.close();
		} catch (IOException e) {
			MyIO.println("");
		}
	}
}
